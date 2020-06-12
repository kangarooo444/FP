package Lab_ex4
object Typeclasses {
  //a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.
  trait Reversable[T] {
    def reverse(a: T): T
  }
  //b) Реализуйте функцию Reverse для String.
  implicit object ReversableString extends Reversable[String] {
    def reverse(a: String): String = a.reverse
  }
  // примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(str: String): String = ReversableString.reverse(str)
  /*c) Определите тайп-класс Smash таким образом, чтобы в нем была функция smash,
    которая выполняет операцию со значениями одного типа.*/
  trait Smash[T]{
    def smash(a: T, b: T): T
  }
  /*d) Реализуйте  функции Smash для типа Int и Double.
    Используйте сложение для типа Int умножение для типа Double.*/
  implicit object SmashInt extends Smash[Int] {
    def smash(a: Int, b: Int): Int = a + b
  }
  implicit object SmashDouble extends Smash[Double] {
    def smash(a: Double, b: Double): Double = a*b
  }
  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = SmashInt.smash(a,b)
  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = SmashDouble.smash(a,b)
  /*e) Реализуйте функцию Smash для типа String.
    Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра.*/
  implicit object SmashString extends Smash[String] {
    def smash(a: String, b: String): String = a.concat(b)
  }
  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashString(a: String, b: String): String = SmashString.smash(a,b)
  // Реализуйте тестовые функции с выводом на экран проверки разработанных функций.
  def main(args: Array[String]): Unit = {
    println("Игра престолов наоборот " + testReversableString("Игра престолов"))
    println("10 + 8 = " + testSmashInt(10,8))
    println("6.2*4.0 = " + testSmashDouble(6.2,4.0))
    println("Конкатенация строк (Завтра,к) = " + testSmashString("Завтра", "к"))
  }
}