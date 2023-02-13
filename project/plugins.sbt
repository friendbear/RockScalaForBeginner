
// Codecov
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

// https://github.com/sbt/sbt-native-packager
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.1")

// https://github.com/marcuslonnberg/sbt-docker
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.9.0")

libraryDependencies += "com.spotify" % "docker-client" % "8.16.0"

lazy val app = (project in file(".")).dependsOn(assemblyPlugin)

lazy val assemblyPlugin = RootProject(uri("git://github.com/sbt/sbt-assembly"))
