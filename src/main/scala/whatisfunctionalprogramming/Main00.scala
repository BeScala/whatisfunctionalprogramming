package whatisfunctionalprogramming

import beer.Beer
import beer.Beers._

object Main00 extends App {

  private def buyBeer(beer: Beer): Beer = {
    println(s"[info] bought $beer")
    beer
  }

  println("----------------------- begin -----------------------")
  println(s"result ${buyBeer(stella)}")
  println("-----------------------  end  -----------------------")

}

/*
 *
 * we have written `buyBeer` such that
 * running a program using it produces the following output
 * 
 * ----------------------- begin -----------------------
 * [info] bought Beer(Stella)
 * result Beer(Stella)
 * -----------------------  end  -----------------------
 * 
 * the goal is to write `buyBeers` such that
 * running a program using it produces the following output
 * 
 * ---------------------- begin ------------------------
 * [info] bought Beer(Duvel)
 * [info] bought Beer(Orval)
 * [info] bought Beer(Leffe)
 * result List(Beer(Duvel), Beer(Orval), Beer(Leffe))
 * -----------------------  end  -----------------------
 * 
 */