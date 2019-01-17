package oop


/**
  * Object-Oriented Programing in Scala
  *
  * - Scala Objects
  *
  */
object Objects {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
 
  object Person { // type + its only instance
    // "static"/"class" = level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobble")
  } 

  class Person(val name: String) {
    // instance-level functionally
  }
  //COMPANIONS

  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john) // => false

    val person1 = Person
    val person2 = Person
    println(person1 == person2) // => true

    val boble = Person(mary, john)
  }
}

