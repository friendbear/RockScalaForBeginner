addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.12")

// Codecov
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

// https://github.com/sbt/sbt-native-packager
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.1")

// https://github.com/marcuslonnberg/sbt-docker
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.8.2")

libraryDependencies += "com.spotify" % "docker-client" % "8.9.0"

lazy val app = (project in file(".")).dependsOn(assemblyPlugin)

lazy val assemblyPlugin = RootProject(uri("git://github.com/sbt/sbt-assembly"))

resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"
addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.12")
