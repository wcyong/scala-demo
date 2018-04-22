package d5

/**
  * @author wcyong
  */
object MyEnum extends Enumeration {
  //val WOLF, DOG, CAT = Value
  val WOLF = Value(0, "wolf")
  val DOG = Value(1, "dog")
  val CAT = Value(2, "cat")
}

object ObjectDemo_07 {
  def main(args: Array[String]): Unit = {
    println(MyEnum.WOLF)

    //通过枚举名称获取枚举值
    println(MyEnum.withName("wolf"))

    //获取所有的枚举值
    val values = MyEnum.values
    values.foreach(println(_))

    //通过枚举角标获取枚举值
    println(MyEnum(0))
  }
}
