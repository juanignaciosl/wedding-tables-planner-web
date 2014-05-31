//import play.Project._
import RjsKeys._
import WebJs._

name := """wedding-tables-planner"""

version := "0.3.1"

lazy val root = (project in file(".")).enablePlugins(SbtWeb).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.webjars" % "requirejs" % "2.1.11-1",
  // WebJars infrastructure
  "org.webjars" % "webjars-locator" % "0.13",
  "org.webjars" %% "webjars-play" % "2.3.0-RC1-1",
  "org.drools" % "drools-core" % "6.0.1.Final",
  "org.optaplanner" % "optaplanner-core" % "6.0.1.Final",
  "com.google.guava" % "guava" % "17.0",
  // WebJars dependencies
  "org.webjars" % "underscorejs" % "1.6.0-3",
  "org.webjars" % "jquery" % "2.1.1",
  "org.webjars" % "bootstrap" % "3.1.1-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "angularjs" % "1.2.16-2" exclude("org.webjars", "jquery")
)

pipelineStages := Seq(rjs, digest, gzip)

RjsKeys.optimize := "none"

LessKeys.compress := true

// The main config file
// See http://requirejs.org/docs/optimization.html#mainConfigFile
//requireJsShim := "build.js"

// To completely override the optimization process, use this config option:
//requireNativePath := Some("node r.js -o name=main out=javascript-min/main.min.js")
