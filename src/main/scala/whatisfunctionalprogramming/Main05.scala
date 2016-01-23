package whatisfunctionalprogramming

import beer.Beer
import beer.Beers._

object Main05 extends App {
  
  private def log[Z](z: Z): List[String] =
    List(s"[info] bought $z")

  private def show[Z]: ((Z, List[String])) => Unit = {
    case (z, strings) =>
      println(strings.mkString("\n"))
      println(s"result $z")
  }
  
  private def buyBeer(beer: Beer): (Beer, List[String]) =
    (beer, log(beer))

  private def buyBeers(beers: List[Beer]): (List[Beer], List[String]) =
    beers.map { beer =>
      buyBeer(beer)
    }.unzip match {
      case (boughtBeers, strings) =>
        (boughtBeers, strings.flatten)
    }
  
  println("---------------------- begin ------------------------")
  show(buyBeers(beers))
  println("-----------------------  end  -----------------------")  
  
  /*
   * 
   * the definition of `buyBeers` looks very specific
   * 
   * `buyBeers` can be seen as a specific instance of a more generic
   *  template definition `traverse`: `buyBeers = traverse(buyBeer)`
   * 
   * Hint:
   * 
   * define 
   * 
   *  - type Log = List[String]`
   *  - `type WithLog[Z] = (Z, Log)`
   *  - a function `private def traverse[Z, Y](z2my: Z => WithLog[Y]): List[Z] => WithLog[List[Y]]`
   * 
   * in fact `Log` and `WithLog` have already been defined for you
   * and you can simply import `them as `import utils.{Log, WithLog}`
   * 
   * change `def buyBeer` and `def buyBeers` to `val buyBeer` and `val buyBeers`
   * in order to make use of `traverse`
   * 
   */
  
}