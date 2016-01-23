package beer

case class Beer(brand: String)

object Beers {
  val stella = Beer("Stella")
  
  val duvel = Beer("Duvel")
  val orval = Beer("Orval")
  val leffe = Beer("Leffe")

  val beers = List(duvel, orval, leffe)

}