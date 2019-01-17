package functionprograming

import scala.util.Random


/**
  * Functional Programming in Scala
  *
  * - Options
  *
  * sealed abstract class Option[+A]
  * case class Some[+A](x: A) extends Option[A]
  * case object None extends Option[Nothing]
  */
object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // WORK with unsafe APIs
  def unsafeMethod = null

  //val result = Some(unsafeMethod) // WRONG => 🔴
  val result = Option(unsafeMethod)
  println(result) // => None

  //chained methods
  def backupMethod: String = "A Valid result"
  val chainedResult = Option(unsafeMethod).orElse(Option(backupMethod))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod orElse betterBackupMethod

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE - DO NOT USE

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2)) // Some(8)
  println(myFirstOption.filter(x => x > 10)) // None
  println(myFirstOption.flatMap(x => Option(x * 10))) // Some(40)

  /*
    Exercise.
   */
  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime)

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method
  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)
      return null
   */
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionsStatus = connection.map(c => c.connect)
  // 🔴 if (connectionStatus == null) println(None) else print(Some(connectionStatus.get))

  println(connectionsStatus)
  connectionsStatus.foreach(println)
  //val connection = Connection(config("host"), config("port"))

  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)

}
