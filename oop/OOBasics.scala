
object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()
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
// class parameters are NOT FIBLS
