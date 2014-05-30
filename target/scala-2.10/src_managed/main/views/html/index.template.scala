
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.api.Play.current


Seq[Any](format.raw/*1.4*/("""<!DOCTYPE html>
<html>
  <head>
    <title data-ng-bind="pageTitle">Wedding Tables Planner</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.55*/routes/*6.61*/.Assets.at("images/favicon.png"))),format.raw/*6.93*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.50*/CdnWebJarAssets/*7.65*/.getUrl(CdnWebJarAssets.locate("bootstrap.min.css")))),format.raw/*7.117*/("""" />
    """),format.raw/*8.33*/("""
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.50*/routes/*9.56*/.Assets.at("stylesheets/main.css"))),format.raw/*9.90*/("""">
    """),format.raw/*11.1*/("""    <script>
     """),_display_(Seq[Any](/*12.7*/Html(org.webjars.RequireJS.getSetupJavaScript(routes.CdnWebJarAssets.at("").url, current.configuration.getString("contentUrl").orNull)))),format.raw/*12.142*/("""
    </script>
    <script data-main=""""),_display_(Seq[Any](/*14.25*/routes/*14.31*/.Assets.at(helper.mainScriptSrc(scriptName = "main")))),format.raw/*14.84*/("""" src=""""),_display_(Seq[Any](/*14.92*/CdnWebJarAssets/*14.107*/.getUrl(CdnWebJarAssets.locate("require.js")))),format.raw/*14.152*/(""""></script>
  </head>
  <body>
    """),format.raw/*17.29*/("""
    <div>
      <div data-ng-view></div>
    </div>
  </body>
</html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri May 30 19:37:43 CEST 2014
                    SOURCE: /Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/app/views/index.scala.html
                    HASH: 488393def00ff9d003c3e6b49250ec468e81baa3
                    MATRIX: 549->1|673->3|938->233|952->239|1005->271|1092->323|1115->338|1189->390|1225->427|1310->477|1324->483|1379->517|1413->554|1467->573|1625->708|1700->747|1715->753|1790->806|1834->814|1859->829|1927->874|1990->933
                    LINES: 19->1|23->1|28->6|28->6|28->6|29->7|29->7|29->7|30->8|31->9|31->9|31->9|32->11|33->12|33->12|35->14|35->14|35->14|35->14|35->14|35->14|38->17
                    -- GENERATED --
                */
            