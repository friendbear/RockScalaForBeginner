package oop

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
  val listOfIntegeres = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {

    def empty[A]: MyList[A] = ???

  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  //
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // yes List[Cat] extends List[Animal] = COVARIANCE
  class ConvariantList[+A]

  val animal: Animal = new Cat
  val animalList: ConvariantList[Animal] = new ConvariantList[Cat]

  // animalList.add(new Dog) ??? HARD QUESTION. =>
 
  // 2. NO = INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no ! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A >: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  val newCage = new Cage(new Car)



}
