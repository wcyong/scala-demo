package d8

/**
  * @author wcyong
  *         泛型类，顾名思义，其实就是在类的声明中，定义一些泛型类型，然后在类内部，比如field或者
  *         methed，就可以使用这些泛型类型，
  *         使用泛型类，通常是需要对类中的某些成员，比如某些field和method中的参数或变量，进行统一的类型限制，
  *         这样可以保证程序更好的健壮性和稳定性。
  *         如果不使用泛型进行统一的限制，那么在后期程序运行过程中，难免会出现问题，比如传入了不希望的类型，导致程序出问题。
  *         在使用类的时候，比如创建类的对象，将类型参数替换为实际的类型，即可。
  *         scala自动推断泛型类型特性，直接给使用了泛型类型的field赋值时，scala会自动进行类型推断
  *
  */
class ClassDemo_01[T, T2, T3](var name: T) {
  def say() = println(name)

  var age: T2 = _
  var sex: T3 = _
}

object ClassDemo_01 {
  def main(args: Array[String]): Unit = {
    val c01 = new ClassDemo_01[String, Int, String]("zhangsan")
    c01.say()
    c01.age = 20
    c01.sex = "男"

    println(c01.name + "-" + c01.age + "-" + c01.sex)
  }
}
