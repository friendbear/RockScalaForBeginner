package oop


/**
  * Object-Oriented Programing in Scala
  *
  * - Generics
  *
  */

// about Me
trait Programmer {
  def programming(lang: Seq[String])
}
trait Engineer {
  //  def doSomething() = ???
}
trait Manager {
  //  def doSomething() = ???
}

object Me extends App with Programmer with Engineer with Manager {
  val weightScale =  55 to 70
  val likeLocations = Map(
    "神社" -> ("出雲大社", "皆さんで行きたいですね")
  )
  val lang = Seq("VC++", "Java", "C", "Shell", "Perl", "VB.NET", "C#", "COBOL", "Scala", "Go(見習い)", "Python",
    " Rust(何じゃこりゃ)")
  val logic = (like: String) => like
  match {
    case "oop"|"functional" => true
    case _ => true
  }
  override def programming(lang: Seq[String]) = lang.filter(logic).foreach(println)

  lazy val run = programming(lang)
}

object Generics extends App {


  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???

    /*
     * A = Cat
     * B = Animal
     */

  }

  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {

    def empty[A]: MyList[A] = ???

  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // yes List[Cat] extends List[Animal] = COVARIANCE
  class ContravariantList[+A]

  val animal: Animal = new Cat
  val animalList: ContravariantList[Animal] = new ContravariantList[Cat]

  // animalList.add(new Dog) ??? HARD QUESTION. =>
 
  // 2. NO = INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no ! CONTRAVARIANCE
  class NoContravariantList[-A]
  val noContravariantList: NoContravariantList[Cat] = new NoContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A >: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  val newCage = new Cage(new Car)

}
