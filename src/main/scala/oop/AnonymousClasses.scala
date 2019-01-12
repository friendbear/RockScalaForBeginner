package oop

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

  /*
   * 1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
   * 2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
   * 3 MyList:
   * - map(transformer) => MyList
   * - filter(predicate => MyList
   * - flatMap(transformer from A to MyList[B]) => MyList[B]
   *
   *   class EvenPredicate extends MyPredicate[Int]
   *
   *   class StringToIntTransformer extends MyTransformer[String, Int]
   *
   *   [1, 2, 3,].map(n * 2) = [2,4,5]
   *   [1,2,3,4].filter(n %2 = [2,4]
   *   [1,2,3].flatMap(n => [n, n+1]) => [1, 2,2, 3,3, 4]
   */

  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform[A, B](from: A): B
  }

  /**
  class MyList {
    def map[A](transformer: MyTransformer): MyList[A] = ???
    def filter(predicate: => Boolean): MyList = ???
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] 
    def filter(predicate: MyPredicate[A]): MyList[A]
  }

  class EvenPredicate extends MyPredicate[Int]
  class StringToIntTransformer extends MyTransformer[String, Int]

  val evenPredicate = new EvenPredicate {
    override def test(v: T): 
  }

    */

} 
