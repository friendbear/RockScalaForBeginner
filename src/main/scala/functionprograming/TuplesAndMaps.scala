package functionprograming


/**
  * Functional Programming in Scala
  *
  * - Tuples and Maps(Exercises)
  *
  */
object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, " hello, Scala") // Tuple2[Int, String = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> Values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1) //syntax sugar

  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim")) // => Boolean
  println(phoneBook("Jim")) // => Boolean
  println(phoneBook("Mary")) // => Boolean key not hit

  // add a paring
  val newParing = "Mary" -> 678
  val newPhoneBook = phoneBook + newParing
  println(newPhoneBook)

  // functional on maps
  // map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))
  // filterKeys
  println(phoneBook.filterKeys(_.startsWith("J")))
  // mapValues
  println(phoneBook.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(phoneBook.toList) // List(Tuple2, Tuple2)
  println(List(("Danie", 555)).toMap) // List(Tuple2, Tuple2)

  val names = List("kumagai", "take", "nakajima", "くま", "くま")
  println(names.groupBy(name => name.charAt(0))) // => Map(Char -

  /*
  2
(2,goodbye Java)
( hello, Scala,2)
Map(Jim -> 555, Daniel -> 789)
true
555
-1
Map(Jim -> 555, Daniel -> 789, Mary -> 678)
Map(jim -> 555, daniel -> 789)
Map(Jim -> 555)
Map(Jim -> 0245-555, Daniel -> 0245-789)
List((Jim,555), (Daniel,789))
Map(Danie -> 555)
Map(n -> List(nakajima), t -> List(take), k -> List(kumagai), く -> List(くま, くま))
   */

  // Exereisse
  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 999
   */
  val phoneBook2 = Map(("Jim", 555), "Daniel" -> 789, "JIM" -> 900).withDefaultValue(-1) //syntax sugar

  /*
    2. Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unFriend

   */
  object Network {
    def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
      network + (person -> Set())

    def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
      val friendsA = network(a)
      val friendsB = network(b)
      network + (a -> (friendsA + b)) + (b -> (friendsB + a))

    }

    def unFriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
      val friendsA = network(a)
      val friendsB = network(a)
      network + (a -> (friendsA - b)) + (b -> (friendsB - a))
    }

    def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
      def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
        if (friends.isEmpty) networkAcc
        else removeAux(friends.tail, unFriend(networkAcc, person, friends.head))
      }
      val unfriended = removeAux(network(person), network) // network removed
      unfriended - person  // remove map
    }

    // number of friends of a person
    def nFriends(network: Map[String, Set[String]], person: String): Int = {
      if (!network.contains(person)) 0
      else network(person).size
    }

    // person with most friends
    def mostFriends(network: Map[String, Set[String]]): String = {
      network.maxBy(pair => pair._2.size)._1
    }

    // how many people have NO friends
    def nPeopleWithNoFriends(network: Map[String, Set[String]]) = {
      //network.filterKeys(k => network(k).isEmpty).size
      //network.filter(pair => pair._2.isEmpty).size
      //network.count(pair => pair._2.isEmpty)
      network.count(_._2.isEmpty)
    }

    // If there is social connection between two people (direct or not)
    def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
      @annotation.tailrec
      def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
        if (discoveredPeople.isEmpty) false
        else {
          val person = discoveredPeople.head
          if (person == target) true
          else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
          else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
        }
      }
      bfs(b, Set(), network(a) + a) // a not contains myself
    }
  }

  {

    // TODO: No test code
    import Network._
    println("\nnetwork test started.")

    val empty: Map[String, Set[String]] = Map()
    val network = add(add(empty, "Bob"), "Mary")
    println(network)
    println(friend(network, "Bob", "Mary"))
    println(unFriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))

    // Jim,Bob,Mary Test data
    val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
    val jimBob = friend(people, "Bob", "Jim")
    val testNet = friend(jimBob, "Bob", "Mary")


    // nFriends Spec Test
    println(nFriends(testNet, "Bob"))

    // mostFriends Spec Test
    println(mostFriends(testNet))

    // nPeopleWithNoFriends Spec Test
    println(nPeopleWithNoFriends(testNet))

    // socialConnection Spec Test
    println(s"\n socialConnection Test data is $testNet")
    println(socialConnection(testNet, "Mary", "Jim")) // => true

    println(s"\n socialConnection Test data is $network")
    println(socialConnection(network, "Mary", "Bob")) // => false

  }
}
