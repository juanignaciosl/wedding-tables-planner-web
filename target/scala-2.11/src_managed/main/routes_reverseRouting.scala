// @SOURCE:/Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/conf/routes
// @HASH:05e5043d208d83f2538c39224e2668c24c77d7e0
// @DATE:Wed Jun 18 20:18:05 CEST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:24
// @LINE:22
// @LINE:14
// @LINE:9
// @LINE:6
package controllers {

// @LINE:14
class ReversePlannerController {
    

// @LINE:14
def plan(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "plan")
}
                        
    
}
                          

// @LINE:22
class ReverseCdnWebJarAssets {
    

// @LINE:22
def at(file:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        
    
}
                          

// @LINE:24
class ReverseAssets {
    

// @LINE:24
def versioned(file:Asset): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
}
                        
    
}
                          

// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:9
def jsRoutes(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "jsroutes.js")
}
                        
    
}
                          
}
                  


// @LINE:24
// @LINE:22
// @LINE:14
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:14
class ReversePlannerController {
    

// @LINE:14
def plan : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PlannerController.plan",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "plan"})
      }
   """
)
                        
    
}
              

// @LINE:22
class ReverseCdnWebJarAssets {
    

// @LINE:22
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CdnWebJarAssets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:24
class ReverseAssets {
    

// @LINE:24
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:9
def jsRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jsroutes.js"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:24
// @LINE:22
// @LINE:14
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:14
class ReversePlannerController {
    

// @LINE:14
def plan(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PlannerController.plan(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PlannerController", "plan", Seq(), "POST", """""", _prefix + """plan""")
)
                      
    
}
                          

// @LINE:22
class ReverseCdnWebJarAssets {
    

// @LINE:22
def at(file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CdnWebJarAssets.at(file), HandlerDef(this.getClass.getClassLoader, "", "controllers.CdnWebJarAssets", "at", Seq(classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path
GET     /lib/require.js         controllers.WebJarAssets.requirejs
## Enable www.WebJars.org based resources to be returned""", _prefix + """webjars/$file<.+>""")
)
                      
    
}
                          

// @LINE:24
class ReverseAssets {
    

// @LINE:24
def versioned(path:String, file:Asset): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:9
def jsRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsRoutes(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsRoutes", Seq(), "GET", """ JavaScript routes object""", _prefix + """jsroutes.js""")
)
                      
    
}
                          
}
        
    