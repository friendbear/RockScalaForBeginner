package oop

import playground.{PrinceCharming, Cinderella => Prince}
import java.sql.{Date => SqlDate}
import java.util.Date


/**
  * Object-Oriented Programing in Scala
  *
  * - Packaging and Imports
  *
  */
// default imports
// java.lang - String, Object, Exception
// scala - Int, Nothing, Function
// scala.Predef = println, ???
object PackagingAndImports extends App {

  val writer = new Writer("Daniel", "RockeJVM", 2018)

  // import the package

  val princess = new Prince

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use FQ names
  val date = new Date
  // 2. use aliasing
  val sqlDate = new SqlDate(2018, 5, 4)


}
