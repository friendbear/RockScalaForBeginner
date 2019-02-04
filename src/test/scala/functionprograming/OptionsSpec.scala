package functionprograming

import functionprograming.Options.Connection
import org.scalatest.FlatSpec

class OptionsSpec extends FlatSpec {

  behavior of "OptionsTest"
  lazy val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  it should "Option connection" in {
    val host = config.get("host")
    val port = config.get("port")
    val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
    val connectionsStatus = connection.map(c => c.connect)

    println(connectionsStatus)
    connectionsStatus.foreach(println)
  }
  it should "Option connection2 " in {
    config.get("host")
      .flatMap(host => config.get("port")
        .flatMap(port => Connection(host, port))
        .map(connection => connection.connect))
      .foreach(println)
  }

  it should "Option connection3" in {

    // for-comprehensions
    val forConnectionStatus = for {
      host <- config.get("host")
      port <- config.get("port")
      connection <- Connection(host, port)
    } yield connection.connect
    forConnectionStatus.foreach(println)
  }

}
