name := "magc"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += "org.scala-graph" %% "graph-core" % "1.13.0"

libraryDependencies += "org.scala-graph" %% "graph-dot" % "1.13.0"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"

val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)