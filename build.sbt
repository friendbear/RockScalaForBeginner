name := "rock-beginner"


scalaVersion := "2.12.8"


lazy val root = (project in file(".")).
  settings(
    name := "sbt-sample",
    version := "1.0",
    scalaVersion := "2.12.8"
    //libraryDependencies ++= ...以下略
    )
