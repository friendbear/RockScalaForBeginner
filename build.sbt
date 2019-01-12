
lazy val root = (project in file(".")).
  settings(
    name := "rock-beginner",
    version := "1.0",
    scalaVersion := "2.12.8",
    libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
    //libraryDependencies ++= ...以下略
    )
