package whatisfunctionalprogramming

import utils.{Log, WithLog}

import beer.Beer
import beer.Beers._

object Main06 extends App {
    
  private def traverse[Z, Y](z2my: Z => WithLog[Y]): List[Z] => WithLog[List[Y]] =
    zs => zs.map(z2my).unzip match {
      case (ys, log) =>
        (ys, log.flatten)
    }

  private def log[Z](z: Z): Log =
    List(s"[info] bought $z")
    
  private def show[Z]: WithLog[Z] => Unit = {
    case (z, log) =>
      println(log.mkString("\n"))
      println(s"result $z")
  }
  
  private val buyBeer: Beer => WithLog[Beer] =
    beer => (beer, log(beer))

  private val buyBeers: List[Beer] => WithLog[List[Beer]] =
    traverse(buyBeer)
  
  println("---------------------- begin ------------------------")
  show(buyBeers(beers))
  println("-----------------------  end  -----------------------")  
  
}

/*
 *
 * so far so good, but what's the next challenge?
 * 
 * the next challenge is to find out what is so special about
 * `List[+_]` and `WithLog[+_]` to make all this work
 * 
 * maybe you can already think of some properties of
 * `List[+_]` and `WithLog[+_]` that can be generalized
 * 
 * ideally we would like to write generic template
 * declarations and corresponding definitions that work
 * for more combinations that just `List[+_]` and `WithLog[+_]`
 * 
 * this "special to general" way of thinking
 * is what this study group will be all about
 * 
 */
