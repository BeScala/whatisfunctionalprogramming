package whatisfunctionalprogramming

import beer.Beer
import beer.Beers._

object Main01 extends App {
  
  /*
   * the problem with Main00 is that
   * things `just happen` as a `side effect`
   * 
   * as will be explained in the book, it is better to 
   * `describe what should happen` as an `effect`
   * 
   * doing the `side effect` happens when
   * executing the `description of the effect`
   * 
   * more about this later
   * 
   * one way to describe what should happen is to yield 
   * a description of what should happen as a result
   * 
   * in our case `logging` should happen so its description
   * could be of type, say, `Log` for some type `Log`
   * 
   * in other words: instead of 
   *  just `doing the logging`
   * it is better to
   *  yield `what should be logged` as a value of type `Log` 
   * 
   * one way to realize all this is to go for a signature 
   * `private def buyBeer(beer: Beer): (Beer, Log)` for some type `Log`
   * 
   * 
   * Hint: 
   * to start with, go for the simplest type `Log` you can think of 
   * 
   * private def log[Z](z: Z): Log = ???
   * 
   * private def buyBeer(beer: Log): (Beer, Log) =
   *   (beer, log(beer))
   *
   */

}