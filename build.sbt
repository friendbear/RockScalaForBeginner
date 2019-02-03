ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "friendbear.github.com"


lazy val commonSettings = Seq(
  version := "0.1.0"
)


lazy val root = (project in file(".")).
  settings(
    name := "scala-beginner",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.0.5",
      "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
    )


    //libraryDependencies ++= ...以下略
  )


resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")
