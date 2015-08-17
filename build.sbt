//import play.Project._
import RjsKeys._
import WebJs._

name := """wedding-tables-planner"""

version := "0.3.3"

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

resolvers ++= Seq(
  "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Twitter4J Repository" at "http://twitter4j.org/maven2/",
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
  "Twitter Maven Repo" at "http://maven.twttr.com/",
  "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  "Mesosphere Public Repository" at "http://downloads.mesosphere.io/maven",
  "DefaultMavenRepository" at "https://repo1.maven.org/maven2",
  Resolver.sonatypeRepo("public")
)

RjsKeys.mainConfig := "build.js"

pipelineStages := Seq(rjs, digest, gzip)

// To completely override the optimization process, use this config option:
//requireNativePath := Some("node r.js -o name=main out=javascript-min/main.min.js")
