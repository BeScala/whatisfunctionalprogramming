package whatisfunctionalprogramming

import beer.Beer
import beer.Beers._

object Main04 extends App {
  
  private def log[Z](z: Z): List[String] =
    List(s"[info] bought $z")

  private def buyBeer(beer: Beer): (Beer, List[String]) =
    (beer, log(beer))

  private def buyBeers(beers: List[Beer]): (List[Beer], List[String]) =
    beers.map { beer =>
      buyBeer(beer)
    }.unzip match {
      case (boughtBeers, strings) =>
        (boughtBeers, strings.flatten)
    }
  
  /*
   * 
   * now that `buyBeers` yields a result of type `(List[Beer], List[String])` 
   * all that is left to do is to show this result in an appropriate way
   * in other words: to actually *do* the *described* logging
   * 
   * Hint:
   * `List[Z]` has a method `mkString` to show a list of strings in an appropriate way
   * 
   */
  
}