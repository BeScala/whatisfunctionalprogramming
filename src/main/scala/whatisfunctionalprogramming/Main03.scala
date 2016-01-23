package whatisfunctionalprogramming

import beer.Beer
import beer.Beers._

object Main03 extends App {
    
  private def log[Z](z: Z): List[String] =
    List(s"[info] bought $z")
    
  private def buyBeer(beer: Beer): (Beer, List[String]) =
    (beer, log(beer))
    
  private def buyBeers(beers: List[Beer]): (List[Beer], List[List[String]]) =
    beers.map { beer =>
      buyBeer(beer)
    }.unzip
  
  /*
   * 
   * the problem with `buyBeers` is that it's return type is 
   * `(List[Beer], List[List[String]])` 
   * instead of 
   * `(List[Beer], List[String])`
   * 
   * Hint:
   * `List[Z]` has a method `flatten` that transforms 
   * a list of lists `List[List[Z]]` into 
   * a flattened list `List[Z]`
   * 
   */
  
}