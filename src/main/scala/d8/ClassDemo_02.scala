package d8

/**
  * @author wcyong
  *         泛型函数，与泛型类型类似，可以给某个函数在声明时指定泛型类型，然后在函数体内，
  *         多个变量或者返回值之间，就可以使用泛型类型进行声明，从而对某个特殊的变量，或者多个变量，进行强制性的类型限制。
  *         与泛型类一样，你可以通过给使用了泛型类型的变量传递值来让scala自动推断泛型的实际类型，也可以在调用函数时，手动指定泛型类型。
  */
class ClassDemo_02 {

  def say[T1, T2, B1](name: T1, age: T2): B1 = {
    (name + "=" + age).asInstanceOf[B1]
  }
}

object ClassDemo_02 {
  def main(args: Array[String]): Unit = {
    val c02 = new ClassDemo_02
    val str = c02.say[String, Int, String]("wwss", 22)
    println(str)

  }
}