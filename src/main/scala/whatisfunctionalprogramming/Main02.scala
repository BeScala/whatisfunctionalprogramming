package whatisfunctionalprogramming

import beer.Beer
import beer.Beers._

object Main02 extends App {
    
  private def log[Z](z: Z): List[String] =
    List(s"[info] bought $z")

  private def buyBeer(beer: Beer): (Beer, List[String]) =
    (beer, log(beer))
  
  /*
   * 
   * I have chosen `List[String]` for `Log` 
   *
   * maybe you have chosen `String` (which is a simpler choice)
   * 
   * I have good reasons to have chosen `List[String]`
   * since there exists a method `mkString`
   * that transforms a `List[Z]` into a `String` in a flexible way
   * 
   * Note that `log` does not *do* any logging, it *describes* logging
   * 
   * it would be great if you could now define a function 
   * `private def buyBeers(beers: List[Beer]): (List[Beer], List[String])`
   * that makes use of the function `private def buyBeer(beer: Beer): (Beer, List[String])`
   * 
   * Hint: 
   * `List[Z]` has a method `def map[Y](z2y: Z => Y): List[Y]`
   * unfortunately, combining `buyBeer` and `map` 
   * yields a result of type `List[(Beer, List[String])]` instead of `(List[Beer], List[String])`
   * 
   * Hint:
   * `List[Z]` has a method `unzip` that turns 
   * a list of pairs `List[(Z, Y)]` into
   * a pair of lists `(List[Z], List[Y])`
   * 
   */
  
}