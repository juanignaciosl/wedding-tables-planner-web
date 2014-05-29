// @SOURCE:/Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/conf/routes
// @HASH:3390e5314f024afc5c2dfacf935a1366f4a0b38e
// @DATE:Thu May 29 20:34:43 CEST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Application_jsRoutes1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jsroutes.js"))))
        

// @LINE:14
private[this] lazy val controllers_PlannerController_plan2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("plan"))))
        

// @LINE:22
private[this] lazy val controllers_CdnWebJarAssets_at3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("webjars/"),DynamicPart("file", """.+""",false))))
        

// @LINE:24
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jsroutes.js""","""controllers.Application.jsRoutes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """plan""","""controllers.PlannerController.plan"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""","""controllers.CdnWebJarAssets.at(file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Application_jsRoutes1(params) => {
   call { 
        invokeHandler(controllers.Application.jsRoutes(), HandlerDef(this, "controllers.Application", "jsRoutes", Nil,"GET", """ JavaScript routes object""", Routes.prefix + """jsroutes.js"""))
   }
}
        

// @LINE:14
case controllers_PlannerController_plan2(params) => {
   call { 
        invokeHandler(controllers.PlannerController.plan, HandlerDef(this, "controllers.PlannerController", "plan", Nil,"POST", """""", Routes.prefix + """plan"""))
   }
}
        

// @LINE:22
case controllers_CdnWebJarAssets_at3(params) => {
   call(params.fromPath[String]("file", None)) { (file) =>
        invokeHandler(controllers.CdnWebJarAssets.at(file), HandlerDef(this, "controllers.CdnWebJarAssets", "at", Seq(classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path
GET     /lib/require.js         controllers.WebJarAssets.requirejs
## Enable www.WebJars.org based resources to be returned""", Routes.prefix + """webjars/$file<.+>"""))
   }
}
        

// @LINE:24
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     