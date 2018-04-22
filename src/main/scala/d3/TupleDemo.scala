package d3

/**
  * @author wcyong
  *         scala中元组是用括号来表示，获取元组中的值是用下划线表示，角标是从1开始
  */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    //定义一个元组
    val t1 = ("小明", "男", 25)
    //元组的下标是从1开始
    println(t1._1 + "=" + t1._2 + "=" + t1._3)

    //只有两个元素的元组被称之为对偶元组(key-value)
    val tuple2 = ("id", "123")
    println(tuple2._1 + "-" + tuple2._2)

    //可以将元组中的元素单独赋值给对应的变量
    val tuple3, (name, age, sex) = ("ximing", 12, "男")
    println(tuple3)
    println(name)
    println(age)
    println(sex)

    //数组的拉链操作转换成元组,如果数组中有多余的就会被舍弃掉
    val arr1 = Array("a", "b", "c", "d","e")
    val arr2 = Array("A", "B", "C", "D")

    val arr3: Array[(String, String)] = arr1.zip(arr2)
    println(arr3.toBuffer)
  }
}
