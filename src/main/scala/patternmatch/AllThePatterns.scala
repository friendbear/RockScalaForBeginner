package patternmatch

import oop.{Cons, Empty, MyList}

/**
  * Pattern Matching
  *
  * - All the Patterns!
  *
  */
object AllThePatterns {

  // 1 - constants
  def constants(x: Any) = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard
  def matchAnything(x: Any) = x match {
    case _ => "Anything"
  }

  // 2.2 variable
  def matchAVariable(x: Any) = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  def matchATupleMatch(aTuple: (Any, Any)) = aTuple match {
    case (1, 1) => Some("Match a tuple")
    case (something, 2) => Some(s"I've found $something")
    case _ => None
  }

  // PMs can be NESTED!
  def matchNestedTupleMatch(nestedTuple: (Any, (Any, Any))) = nestedTuple match {
    case (_, (2, v)) => Some("Nested tuple")
    case _ => None
  }

  def matchAList(aList: MyList[Int]) = aList match {
    case Empty => "Nested match"
    case Cons(head, Cons(subhead, subtail)) => "Nested match"
  }

  // 5 - list patterns
  def standardListMatch(aStandardList: List[Any]) = aStandardList match  {
    case List(1, _, _, _) => Some("matched") // extractor - advanced
    case List(1, _*) => Some("matched") // list of arbitrary length - advanced
    case 1 :: List(_) => Some("matched") // infix pattern
    case List(1,2,3) :+ 42 => Some("matched") // infix pattern
    case _ => None
  }

  // 6 - type specifiers
  def unknownMatch(unknown: Any)= unknown match {
    case x: Int => Some("unknown matched") // explicit type specifier
    case _ => None
  }

  // 7 - name binding
  def nameBindingMatch(aList: MyList[Any]) = aList match {
    case nonEmptyList @ Cons(_, _) => Some("Name binding matched") // name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _)) => Some("Name binding matched") // name binding inside nested patterns
    case _ => None
  }

  // 8 - multi-patterns
  def multiPattern(aList: MyList[Any]) = aList match {
    case Empty | Cons(1, _) => Some("Multi patterns") // compound pattern (multi-pattern)
    case _ => None
  }

  // 9 - if guards
  def secondElementSpecial(aList: MyList[Int]) = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => Some("if guards")
    case _ => None
  }

  // type parameter not match on JVM
  def numbersMatch (numbers: List[Any]) = numbers match {
    case listOfStrings: List[String] => Some("a list of strings") //🔴 Compile waring
    case listOfNumbers: List[Int] => Some("a list of numbers")
    case _ => None
  }
}
