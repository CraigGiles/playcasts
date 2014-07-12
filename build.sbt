name := """playcasts"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

libraryDependencies += "org.scalatestplus" %% "play" % "1.1.0" % "test"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.31"

libraryDependencies += "joda-time" % "joda-time" % "2.0"

libraryDependencies += "org.mockito" % "mockito-core" % "1.9.5"

