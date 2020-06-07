package exercise1
/*This task has no tests. It is an exercise for you to write different class structures.
   a) Создать класс Animal, который имеет следующие поля:
        - name: String (название)
        - species: String (вид)
        - food: String
   Синтаксис: class MyClass(val publicField: Int, privateField: String) { // остальные поля и методы } */
    class Animal (name: String, food: String) {
      def eats (food: String): Boolean = {
        if (name == "cat" && food == "meat")
          true
        else if (name == "parrot" && food == "vegetables")
          true
        else if (name == "goldfish" && food == "plants")
          true
        else false
      }
    }
/*b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
        - cat, mammal, meat
        - parrot, bird, vegetables
        - goldfish, fish, plants
     Синтаксис: object MyClass { // статические поля и методы } */
     object Animal {
       var mammal = ("cat", "meat")
       var bird = ("parrot", "vegetables")
       var fish = ("goldfish", "plants")
        def knownAnimal(name: String): Boolean = {
          if (mammal == "cat" || bird == "parrot" || fish == "goldfish")
            true
          else false
        }
     }
/*c) Добавьте следующие метод в Animals: def eats(food: String): Boolean,
     который проверяет ест ли животное определенную пищу*/
/*d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
     Вам все еще нужно поле `species`?*/
     trait Animal {
       case object Mammal extends Animal
       case object Fish extends Animal
       case object Bird extends Animal
        def knownAnimal(name: String): Boolean = {
          if ((Mammal == "cat") || (Bird == "parrot") || (Fish == "goldfish"))
            true
          else false
        }
        def apply(food: String): Option[Food] =
          return Some.apply(Animal.this)
     }
/*e) Добавьте следующие функции в объект-компаньон Animal: def knownAnimal(name: String): Boolean
     // true если это имя одного из трех животных из (b)
     def apply(name: String): Option[Animal]
     // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже */
/*f) Создайте трейт Food со следующими классами-образцами:
        - Meat
        - Vegetables
        - Plants
      и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply(): def apply(food: String): Option[Food] */
      trait Food {
        case object Meat extends Food
        case object Vegetables extends Food
        case object Plants extends Food
          def apply(food: String): Option[Food] =
            return Some.apply(Food.this)
      }
      sealed trait Option[A] {
        def isEmpty: Boolean
      }
      case class Some[A](a: A) extends Option[A] {
        val isEmpty = false
      }
      case class None[A]() extends Option[A] {
        val isEmpty = true
      }