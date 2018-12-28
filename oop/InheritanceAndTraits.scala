
object InheritanceAndTraits extends App {

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")

  }

  class Cat extends Animal {
    def crunch {
      eat
      println("crunch crunch")

    }
  }

  val cat = new Cat
  cat.crunch

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, Int, idCard: String) extends Person(name, age)

  class Doc(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("Crunch, Crunch")
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

}
