import shapeless._

case class Person(name: String, id: Int)

object addOne extends Poly1 {
  implicit def caseString = {
    at[String] { s =>
      s + "one"
    }
  }

  implicit def caseInt = {
    at[Int] { i =>
      i + 1
    }
  }

  implicit def casePerson = {
    at[Person] { p =>
      p.copy(id = p.id + 1)
    }
  }
}

val l = "I am the chosen " :: 41 :: Person("Kevin", 9000) :: HNil
val nl = l.map(addOne) :+ List('a', 'b', 'c')
