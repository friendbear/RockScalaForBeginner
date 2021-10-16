package oop

import scala.language.postfixOps

/**
  * Object-Oriented Programing in Scala
  *
  * - MethodNotations
  *
  */
object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String,val age: Int = 1) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(time: Int): String = s"$name watched Inception $time times"


    def learns(thing: String): String = s"$name learns $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // equivalent
  println(mary likes "Inception")   // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")

  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATIONS ARE METHODS.
  // Akka actors have ~ ?

  // prefix notation
  val x = -1    // equivalent with 1.unary_
  val y = 1.unary_-
  // unary_ prefix only

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())  // equivalent

  /*
   * 1. Overload the + operator
   * mery + "the rockstar" => new Person "Mary (the rockstar)"
   */
  println((mary + "the rockstar").apply())
  println(mary.+("the rockstar"))

  /*
   * 2. Add an age to Person class
   *    Add a unary + operator => new Person with the age + 1
   *    +mary => marry with the age incrementer
   */
  println((+mary).age)

  /*
   * 3 Add a "learns" method in the Person class => "Mary learns Scala"
   *   Add a learnsScala method, calls learns method with "Scala"
   *   Use it in postfix notation
   */
  println(mary learns "Scala")

  /*
   * Overload the apply method
   * marry.apply(2) => "Mary watched Inception 2 times"
   */
  println(mary(2))

}

