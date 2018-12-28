
object AnnomousClasses extends App {

  abstract class  Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahaa")
  }


  /*
   * equivaient with 
   *
   * class AnonymousClasses
   *
   */
  println(funnyAnimal.getClass)

  class Person(val name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I Help?")
  }

  val jim = new Person("Jim") {

    override def sayHi: Unit = println(s"Hi, my name is $name, how can I Help?")
  }
} 
