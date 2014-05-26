package views.html.helper

import play.api.templates.Html
import play.api.mvc.{Call}
import play.api.{Play, Mode}
import controllers.routes

/** Make the app explicit for testing */
trait RequiresApp {
  implicit val app = play.api.Play.current
}

/**
 * Resolves the path to a script depending on the current environment.
 * Uses uglified file (-min) in production.
 */
object mainScriptSrc extends RequiresApp {
  def apply(folder: String = "javascripts", scriptName: String): String = app.mode match {
    case Mode.Dev => s"${folder}/${scriptName}"
    case Mode.Test => s"${folder}/${scriptName}"
    case Mode.Prod => s"${folder}-min/${scriptName}"
  }
}
