// Codecov
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

// https://github.com/sbt/sbt-native-packager
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.16")

// https://github.com/marcuslonnberg/sbt-docker
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.5.0")
libraryDependencies += "com.spotify" % "docker-client" % "8.9.0"
