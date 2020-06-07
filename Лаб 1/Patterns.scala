package exercise1
/* Напишите решение в виде функции. Синтаксис:
   val a: Int = ???
   a match {
   case 0 => true
   case _ => false
   } */
    object PatternMatching {
      sealed trait Hand
        case object Rock extends Hand
        case object Paper extends Hand
        case object Scissor extends Hand

      sealed trait Result
        case object Win  extends Result
        case object Lose extends Result
        case object Draw extends Result

      sealed trait Food
        case object Meat       extends Food
        case object Vegetables extends Food
        case object Plants     extends Food

      sealed trait Animal {
        val name: String
        val food: Food
      }
      case class Mammal(name: String, food: Food, weight: Int) extends Animal
      case class Fish(name: String, food: Food) extends Animal
      case class Bird(name: String, food: Food) extends Animal
/*a) Напишите функцию, которая ставит в соответствие числу строку следующим образом: Если:
     1 => "it is one"
     2 => "it is two"
     3 => "it is three"
     иначе => "what's that" */
      val IntToString = (a: Int) => {
      var str = ""
        if (a == 1) {
          str = "it is one"
          str
        }
        else if (a == 2) {
          str = "it is two"
          str
        }
        else if (a == 3) {
          str = "it is three"
          str
        }
        else {
          str = "what is that"
          str
        }
      }
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
      def testIntToString(value: Int): String = IntToString(value)
/*b) Напишите функцию, которая возвращает true если переменная `value` принимает значение:
     max" или "Max
     "moritz" или "Moritz" */
      val IsMaxAndMoritz = (a: String) => {
        if (a == "max" || a == "Max" || a == "moritz" || a == "Moritz") {
          true
        }
        else false
      }
  // примените функции из пункта (b) здесь, не изменяя сигнатуру
      def testIsMaxAndMoritz(value: String): Boolean = IsMaxAndMoritz(value)
  //c) Напишите функцию проверки является ли `value` четным
      val IsEven = (a: Int) => {
        if (a % 2 == 0)
          true
        else false
      }
  // примените функции из пункта (c) здесь, не изменяя сигнатуру
      def testIsEven(value: Int): Boolean = IsEven(value)
/*d) Напишите функцию, моделирующую игру в Камень ножницы бумага
     1. Камень побеждает ножницы
     2. Ножницы побеждают бумагу
     3. Бумага побеждает камень
     Выиграет ли игрок `a`?*/
      val KNB = (a: Hand, b: Hand) => {
        a match {
          case Rock => {
            b match {
              case Rock => Draw
              case Paper => Lose
              case Scissor => Lose
            }
          }
          case Paper => {
            b match {
              case Rock => Win
              case Paper => Draw
              case Scissor => Lose
            }
          }
          case Scissor => {
            b match {
              case Rock => Lose
              case Paper => Win
              case Scissor => Draw
            }
          }
        }
      }
  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
      def testWinsA(a: Hand, b: Hand): Result = KNB(a, b)
  // Примечание: используйте определение Animals
  //e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
      def Weight(animal: Animal): Int ={
        animal match {
          case Mammal(name, food, weight)=> weight
          case _ => -1
        }
  }
  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
      def testExtractMammalWeight(animal: Animal): Int = Weight(animal)
  //f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammals оставьте неизмененным.
      def UpdateFood(animal: Animal): Animal = {
        var a = animal
        animal match {
          case Fish(name, food) => a = Fish(name, Plants)
          case Bird(name, food) => a = Bird(name, Plants)
          case Mammal(name, food, weight) => a = Mammal(name, food, weight)
        }
        a
      }
  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
      def testUpdateFood(animal: Animal): Animal = UpdateFood(animal)
}

