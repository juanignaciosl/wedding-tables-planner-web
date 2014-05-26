package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

/** Application controller, handles authentication */
object Application extends Controller {

  /** Serves the index page, see views/index.scala.html */
  def index = Action {
    Ok(views.html.index())
  }

  /**
   * Returns the JavaScript router that the client can use for "type-safe" routes.
   * @param varName The name of the global variable, defaults to `jsRoutes`
   */
  def jsRoutes(varName: String = "jsRoutes") = Action { implicit request =>
    Ok(
      Routes.javascriptRouter(varName)(
        routes.javascript.PlannerController.plan)).as(JAVASCRIPT)
  }

}
