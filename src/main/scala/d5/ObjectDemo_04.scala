package d5

/**
  * @author wcyong
  */
object ObjectDemo_04 {
  println("hello world")

  def apply(): String = {
    "hello"
  }

  def apply(num: Int, nums: Int*): Array[Int] = {
    val arr = new Array[Int](nums.length)
    for (i <- 0 to nums.length - 1) {
      arr(i) = nums(i)
    }
    return arr;
  }
}

object ObjectDemo_04_04 {
  def main(args: Array[String]): Unit = {
    //val obj = ObjectDemo_04
    //创建了一个ObjectDemo_04的实例对象，并且调用了这个对象的无参数的apply()方法
    val obj2 = ObjectDemo_04()

    println(obj2)

    //不会再去创建对象了，因为上面一句代码已经创建了对象，这里只是调用了它的带有可变参数的apply方法
    val obj3 = ObjectDemo_04(1, 2, 3, 4)
    obj3.foreach(println(_))
    //显示调用apply方法, ObjectDemo_04(1, 2, 3, 4)====ObjectDemo_04.apply(1, 2, 3, 4)
    ObjectDemo_04.apply(1, 2, 3, 4);


    val arr = Array(1, 2, 3)

  }
}
