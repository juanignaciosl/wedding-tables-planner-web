
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
    <title data-ng-bind="pageTitle"></title>
    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*5.55*/routes/*5.61*/.Assets.at("images/favicon.png"))),format.raw/*5.93*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.50*/CdnWebJarAssets/*6.65*/.getUrl(CdnWebJarAssets.locate("bootstrap.min.css")))),format.raw/*6.117*/("""" />
    """),format.raw/*7.33*/("""
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.50*/routes/*8.56*/.Assets.at("stylesheets/main.css"))),format.raw/*8.90*/("""">
    """),format.raw/*10.1*/("""    <script>
     """),_display_(Seq[Any](/*11.7*/Html(org.webjars.RequireJS.getSetupJavaScript(routes.CdnWebJarAssets.at("").url, current.configuration.getString("contentUrl").orNull)))),format.raw/*11.142*/("""
    </script>
    <script data-main=""""),_display_(Seq[Any](/*13.25*/routes/*13.31*/.Assets.at(helper.mainScriptSrc(scriptName = "main")))),format.raw/*13.84*/("""" src=""""),_display_(Seq[Any](/*13.92*/CdnWebJarAssets/*13.107*/.getUrl(CdnWebJarAssets.locate("require.js")))),format.raw/*13.152*/(""""></script>
  </head>
  <body>
    """),format.raw/*16.29*/("""
    <div class="container" data-ng-cloak>
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
                    DATE: Tue May 27 18:41:57 CEST 2014
                    SOURCE: /Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/app/views/index.scala.html
                    HASH: 4517496ec5131b27c24b9d55c942f745caf6376d
                    MATRIX: 549->1|673->3|839->134|853->140|906->172|993->224|1016->239|1090->291|1126->328|1211->378|1225->384|1280->418|1314->455|1368->474|1526->609|1601->648|1616->654|1691->707|1735->715|1760->730|1828->775|1891->834
                    LINES: 19->1|23->1|27->5|27->5|27->5|28->6|28->6|28->6|29->7|30->8|30->8|30->8|31->10|32->11|32->11|34->13|34->13|34->13|34->13|34->13|34->13|37->16
                    -- GENERATED --
                */
            