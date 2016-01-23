package whatisfunctionalprogramming.solution

import utils._
import flatmapthatshit._
import flatmapthatshitInstances._

import beer.Beer
import beer.Beers._

object Main extends App {

  private def applicative() {

    import ApplicativeObject.loggerApplicative
    import loggerApplicative._
    import listTraversable._

    def example01() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          (log(beer) and result(beer)) map {
            case (_, beer) =>
              beer
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example02() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          (result(beer) and log(beer)) map {
            case (beer, _) =>
              beer
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example03() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          log(beer) app {
            result(beer) app {
              result {
                beer =>
                  _ =>
                    beer
              }
            }
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example04() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          result(beer) app {
            log(beer) app {
              result {
                _ =>
                  beer =>
                    beer
              }
            }
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    println("--------------------------- example01() ---------------------------")
    example01()
    println("--------------------------- example02() ---------------------------")
    example02()
    println("--------------------------- example03() ---------------------------")
    example03()
    println("--------------------------- example04() ---------------------------")
    example04()
    println("-------------------------------------------------------------------")

  }

  def monad() {

    import MonadObject.loggerMonad
    import loggerMonad._
    import listTraversable._

    def example01() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          log(beer) flatMap { _ =>
            result(beer)
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example02() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          log(beer) map { _ =>
            beer
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example03() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          result(beer) flatMap { beer =>
            log(beer) map { _ =>
              beer
            }
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example04() {

      val buyBeer: Beer => WithLog[Beer] =
        beer =>
          result(beer) flatMap { beer =>
            log(beer) flatMap { _ =>
              result(beer)
            }
          }

      val buyBeers: List[Beer] => WithLog[List[Beer]] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    println("--------------------------- example01() ---------------------------")
    example01()
    println("--------------------------- example02() ---------------------------")
    example02()
    println("--------------------------- example03() ---------------------------")
    example03()
    println("--------------------------- example04() ---------------------------")
    example04()
    println("-------------------------------------------------------------------")

  }

  private def kleisliarrow() {

    import KleisliArrowObject.loggerKleisliArrow
    import loggerKleisliArrow._
    import listTraversable._
    
    val logBeer: Beer ==> Unit =
      beer => log(beer)

    def example01() {

      val buyBeer: Beer ==> Beer =
        flatDefine(logBeer) {
          arrow {
            case (beer, _) =>
              beer
          }
        }

      val buyBeers: List[Beer] ==> List[Beer] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example02() {

      val buyBeer: Beer ==> Beer =
        logBeer flatDefine {
          arrow {
            case (beer, _) =>
              beer
          }
        }

      val buyBeers: List[Beer] ==> List[Beer] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example03() {

      val buyBeer: Beer ==> Beer =
        flatDef(logBeer) {
          arrow { _ =>
            beer =>
              beer
          }
        }

      val buyBeers: List[Beer] ==> List[Beer] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    def example04() {

      val buyBeer: Beer ==> Beer =
        logBeer flatDef {
          arrow { _ =>
            beer =>
              beer
          }
        }

      val buyBeers: List[Beer] ==> List[Beer] =
        traverse(buyBeer)

      printAll(buyBeers(beers))

    }

    println("--------------------------- example01() ---------------------------")
    example01()
    println("--------------------------- example02() ---------------------------")
    example02()
    println("--------------------------- example03() ---------------------------")
    example03()
    println("--------------------------- example04() ---------------------------")
    example04()
    println("-------------------------------------------------------------------")

  }

  println("===================================================================")
  println("=========================== applicative() =========================")
  println("===================================================================")
  println()
  applicative()
  println()
  println("===================================================================")
  println("=========================== monad() ===============================")
  println("===================================================================")
  println()
  monad()
  println()
  println("===================================================================")
  println("=========================== kleisliarrow() ========================")
  println("===================================================================")
  println()
  kleisliarrow()

}