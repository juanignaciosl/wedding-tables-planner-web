// @SOURCE:/Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/conf/routes
// @HASH:05e5043d208d83f2538c39224e2668c24c77d7e0
// @DATE:Sat May 31 11:11:08 CEST 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

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
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Application_jsRoutes1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jsroutes.js"))))
private[this] lazy val controllers_Application_jsRoutes1_invoker = createInvoker(
controllers.Application.jsRoutes(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsRoutes", Nil,"GET", """ JavaScript routes object""", Routes.prefix + """jsroutes.js"""))
        

// @LINE:14
private[this] lazy val controllers_PlannerController_plan2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("plan"))))
private[this] lazy val controllers_PlannerController_plan2_invoker = createInvoker(
controllers.PlannerController.plan,
HandlerDef(this.getClass.getClassLoader, "", "controllers.PlannerController", "plan", Nil,"POST", """""", Routes.prefix + """plan"""))
        

// @LINE:22
private[this] lazy val controllers_CdnWebJarAssets_at3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("webjars/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_CdnWebJarAssets_at3_invoker = createInvoker(
controllers.CdnWebJarAssets.at(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.CdnWebJarAssets", "at", Seq(classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path
GET     /lib/require.js         controllers.WebJarAssets.requirejs
## Enable www.WebJars.org based resources to be returned""", Routes.prefix + """webjars/$file<.+>"""))
        

// @LINE:24
private[this] lazy val controllers_Assets_versioned4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[Asset]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jsroutes.js""","""controllers.Application.jsRoutes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """plan""","""controllers.PlannerController.plan"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""","""controllers.CdnWebJarAssets.at(file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:Asset)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:9
case controllers_Application_jsRoutes1_route(params) => {
   call { 
        controllers_Application_jsRoutes1_invoker.call(controllers.Application.jsRoutes())
   }
}
        

// @LINE:14
case controllers_PlannerController_plan2_route(params) => {
   call { 
        controllers_PlannerController_plan2_invoker.call(controllers.PlannerController.plan)
   }
}
        

// @LINE:22
case controllers_CdnWebJarAssets_at3_route(params) => {
   call(params.fromPath[String]("file", None)) { (file) =>
        controllers_CdnWebJarAssets_at3_invoker.call(controllers.CdnWebJarAssets.at(file))
   }
}
        

// @LINE:24
case controllers_Assets_versioned4_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        
}

}
     