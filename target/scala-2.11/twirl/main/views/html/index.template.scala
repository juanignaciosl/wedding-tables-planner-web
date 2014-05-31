
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.api.Play.current

Seq[Any](format.raw/*1.4*/("""<!DOCTYPE html>
<html>
  <head>
    <title data-ng-bind="pageTitle">Wedding Tables Planner</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*6.55*/routes/*6.61*/.Assets.versioned("images/favicon.png")),format.raw/*6.100*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*7.50*/CdnWebJarAssets/*7.65*/.getUrl(CdnWebJarAssets.locate("bootstrap.min.css"))),format.raw/*7.117*/("""" />
    """),format.raw/*8.33*/("""
    """),format.raw/*9.5*/("""<link rel="stylesheet" media="screen" href=""""),_display_(/*9.50*/routes/*9.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*9.97*/("""">
    """),format.raw/*11.1*/("""    """),format.raw/*11.5*/("""<script>
     """),_display_(/*12.7*/Html(org.webjars.RequireJS.getSetupJavaScript(routes.CdnWebJarAssets.at("").url, current.configuration.getString("contentUrl").orNull))),format.raw/*12.142*/("""
    """),format.raw/*13.5*/("""</script>
    <script data-main=""""),_display_(/*14.25*/routes/*14.31*/.Assets.versioned(helper.mainScriptSrc(scriptName = "main"))),format.raw/*14.91*/("""" src=""""),_display_(/*14.99*/CdnWebJarAssets/*14.114*/.getUrl(CdnWebJarAssets.locate("require.js"))),format.raw/*14.159*/(""""></script>
  </head>
  <body>
    """),format.raw/*17.29*/("""
    """),format.raw/*18.5*/("""<div>
      <div data-ng-view></div>
    </div>
  </body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat May 31 09:49:01 CEST 2014
                  SOURCE: /Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/app/views/index.scala.html
                  HASH: 2bb963ec87de7f50d4b312a73a41a04eee27125a
                  MATRIX: 498->1|615->3|871->233|885->239|945->278|1023->330|1046->345|1119->397|1155->434|1186->439|1257->484|1271->490|1332->531|1366->568|1397->572|1438->587|1595->722|1627->727|1688->761|1703->767|1784->827|1819->835|1844->850|1911->895|1974->954|2006->959
                  LINES: 19->1|22->1|27->6|27->6|27->6|28->7|28->7|28->7|29->8|30->9|30->9|30->9|30->9|31->11|31->11|32->12|32->12|33->13|34->14|34->14|34->14|34->14|34->14|34->14|37->17|38->18
                  -- GENERATED --
              */
          