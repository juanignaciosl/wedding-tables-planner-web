package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import com.juanignaciosl.weddingtablesplanner.DiningConfiguration
import com.juanignaciosl.weddingtablesplanner.Guest
import com.juanignaciosl.weddingtablesplanner.Table
import com.juanignaciosl.weddingtablesplanner.WeddingTablesPlanner
import collection.JavaConversions._
import scala.collection.mutable.HashSet

object PlannerController extends Controller {

  case class AJSSimpleGuest(val name: String)
  case class AJSGuest(val name: String, val loves: List[AJSSimpleGuest] = List(), val hates: List[AJSSimpleGuest] = List(), val knows: List[AJSSimpleGuest])
  case class AJSGuestsAtTable(val capacity: Int, val guests: List[String])

  implicit val simpleGuestReads = Json.reads[AJSSimpleGuest]
  implicit val guestReads = Json.reads[AJSGuest]

  implicit val guestAtTableWrites = Json.writes[AJSGuestsAtTable]

  def plan = Action(parse.json) { request =>

    val guestsData = (request.body \ "guests").validate[List[AJSGuest]].get
    val tableSizes = (request.body \ "tables").validate[List[Int]].get

    Logger.debug(s"Plan this: $guestsData at $tableSizes")

    var guestByName = guestsData map { g => (g.name, new Guest(g.name)) } toMap

    guestsData.map { g => g.loves.map { l => guestByName(g.name).addLoved(guestByName(l.name)) } }
    guestsData.map { g => g.hates.map { l => guestByName(g.name).addHated(guestByName(l.name)) } }
    guestsData.map { g => g.knows.map { l => guestByName(g.name).addKnown(guestByName(l.name)) } }

    val nextTableId = { var i = 0; () => { i += 1; i } }
    val tables = tableSizes.map(new Table(nextTableId(), _))

    val sourceProblem = new DiningConfiguration(HashSet(tables.toArray: _*), HashSet(guestByName.values.toArray: _*))

    val solution = new WeddingTablesPlanner().planTables(sourceProblem)

    val guestsPerTable = solution.guestsPerTable()
    val score = solution.getScore
    Logger.debug(s"Solution (scored $score): $solution")

    val tableCompositions = guestsPerTable.map { case (table, guests) => new AJSGuestsAtTable(table.getCapacity, guests.map(_.getId()).toList) }

    Logger.debug(s"Sending $tableCompositions")

    Ok(Json.toJson(tableCompositions))
  }

}