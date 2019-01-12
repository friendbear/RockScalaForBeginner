package oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  // Novel Test Code
  val author = new Writer("Charies", "Disckons", 1812)
  val inposter = new Writer("Charies", "Disckons", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(inposter))


  // Counter Test Code
  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

// constructor
class Person(name: String,val age: Int = 0) {
  // body
  val x = 2
  println( 1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructor
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

}


/* 
  Novel and a Writer
  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
  - authorAge
  - inWrittenBy(author)
  - copy (new year of relase) = new instance of Novel

*/
class Writer(firstName: String, surname: String, val year: Int) {
  def fullname: String = firstName + " " + surname
}

class Novel(val name: String, val year: Int, val author: Writer) {
  def authorAge = year -  author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


/*
  Counter class
    - receive an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
  */

 class Counter(val count: Int = 0) {
  def inc = {
    println("Incrimenting")
    new Counter(count + 1) /// immutibility
  }
  def dec = {
    println("decrimenting")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter =  {
     if (n <= 0) this
     else inc.inc(n - 1)
  }
 
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(this)

}

