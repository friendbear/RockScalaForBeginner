package functionprograming

import functionprograming.TuplesAndMaps.Network
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest._
import matchers.should._

class TuplesAndMapsSpec extends AnyFlatSpec with Matchers{

  val empty1: Map[String, Set[String]] = Map()
  val network = Network.add(Network.add(empty1, "Bob"), "Mary")

  // Jim,Bob,Mary Test data
  val people = Network.add(Network.add(Network.add(empty1, "Bob"), "Mary"), "Jim")
  val jimBob = Network.friend(people, "Bob", "Jim")
  val testNet = Network.friend(jimBob, "Bob", "Mary")


  println(s"\n socialConnection Test data is $testNet")
  println(s"\n socialConnection Test data is $network")


  "Network" should "Mix" in {

    // nFriends Spec Test
    Network.nFriends(testNet, "Bob") should be (2)

    // mostFriends Spec Test
    Network.mostFriends(testNet) should be ("Bob")

    // nPeopleWithNoFriends Spec Test
    Network.nPeopleWithNoFriends(testNet) should be (0)

    // socialConnection Spec Test
    Network.socialConnection(testNet, "Mary", "Jim") should be (true)

    // socialConnection Spec Test
    Network.socialConnection(network, "Mary", "Jim") should be (false)
  }
}
