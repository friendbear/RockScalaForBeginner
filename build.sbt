ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "friendbear.github.io"


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


// ref: https://sbt-native-packager.readthedocs.io/en/stable/formats/docker.html
//      https://github.com/marcuslonnberg/sbt-docker
enablePlugins(sbtdocker.DockerPlugin, JavaAppPackaging)
enablePlugins(DockerSpotifyClientPlugin)


dockerfile in docker := {
  val appDir: File = stage.value
  val targetDir = "/app"

  new Dockerfile {
    from("openjdk:8-jre")
    entryPoint(s"$targetDir/bin/${executableScriptName.value}")
    copy(appDir, targetDir, chown = "daemon:daemon")
  }
}