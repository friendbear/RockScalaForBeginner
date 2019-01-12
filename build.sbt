
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

lazy val root = (project in file(".")).
  settings(
    name := "rock-beginner",
    version := "1.0",
    scalaVersion := "2.12.8",
    libraryDependencies ++= Seq(
        "org.scalactic" %% "scalactic" % "3.0.5",
        "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
    )


    //libraryDependencies ++= ...以下略
    )

addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")