ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "friendbear.github.io"
ThisBuild / homepage := Some(url("https://github.com/friendbear/RockScalaForBeginner"))

val javaVersion = 11

lazy val commonSettings = Seq(
  version := "0.1.1"
)

lazy val app = (project in file("."))
  .settings(
    assembly / mainClass := Some("filesystem.filesystem.Main"),
    assembly / assemblyJarName := "filesystem.jar"
  )


lazy val root = (project in file(".")).
  settings(
    name := "scala-beginner",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.2.9",
      "org.scalatest" %% "scalatest" % "3.2.9" % "test"
    )
    //libraryDependencies ++= ...以下略
  )




// ref: https://sbt-native-packager.readthedocs.io/en/stable/formats/docker.html
//      https://github.com/marcuslonnberg/sbt-docker
enablePlugins(sbtdocker.DockerPlugin, JavaAppPackaging)

docker / dockerfile := {
  val appDir: File = stage.value
  val targetDir = "/app"

  new Dockerfile {
    from("openjdk:11.0.11-jre")
    workDir("/app")
    entryPoint(s"$targetDir/bin/${executableScriptName.value}")
    copy(appDir, targetDir, chown = "app:app")
    cmd("java -jar filesystem.jar")
  }
}
