import scala.sys.process._
name := "magc"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += "org.scala-graph" %% "graph-core" % "1.13.0"

libraryDependencies += "org.scala-graph" %% "graph-dot" % "1.13.0"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"
libraryDependencies += "org.antlr" % "antlr4" %"4.7.2"

val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
//addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "1.5.0")
//lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

//enablePlugins(SbtTwirl)
lazy val execScript = taskKey[Unit]("Execute the shell script")

execScript := {
  "./genparser.sh" !
}