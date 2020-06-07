package exercise1
/* Напишите отдельные функции, решающие поставленную задачу. Синтаксис:
   // метод def myFunction(param0: Int, param1: String): Double = // тело
   // значение val myFunction: (Int, String) => Double (param0, param1) => // тело */
object Functions {
  /*a) Напишите функцию, которая рассчитывает площадь окружности r^2 * Math.PI */
  val S = (r: Double) => r*r*Math.PI
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = S(r)
  /*b) Напишите каррированную функцию, которая рассчитывает площадь прямоугольника a * b.*/
  def RectangleCurried(a: Double)(b: Double) = a*b
  // примените вашу функцию из пункта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = RectangleCurried(a)(b)
  //c) Напишите не каррированную функцию для расчета площади прямоугольника.
  val Rectangle = (a1: Double, b1: Double) => a1*b1
  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = Rectangle(a, b)
}
