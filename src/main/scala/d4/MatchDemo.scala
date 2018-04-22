package d4

/**
  * @author wcyong
  */
object MatchDemo {

  /**
    * 定义偏函数用PartialFunction来表示
    * PartialFunction[T1,T2]要求传入一个参数T1，T2代表返回值的类型
    * 偏函数体中的case只会执行一个如果匹配到了就不人继续往下匹配
    */
  val func: PartialFunction[String, Int] = {
    case "a" => 1
    case "b" => 2
    case _ => -1
  }

  /**
    * 匹配字符串
    *
    */
  def m1(str: String) = str match {
    case "a" => 1
    case "b" => 2
    case _ => -1
  }

  /**
    * 匹配类型
    *
    * @param args
    */
  def m2(x: Any) = x match {
    //匹配字符串
    case x: String => println(x)
    //带if守卫条件的匹配
    case x: Int if x > 5 => println(x)
    case _ => println("unknow")
  }

  /**
    * 匹配数组
    *
    * @param args
    */
  def m3(arr: Array[Int]) = arr match {
    case Array(1, x, y) => println("匹配以1开头，有三个元素的数组")
    case Array(0) => println("匹配只有0这个元素的数组")
    case Array(0, _*) => println("匹配以0开头，任意多个元素的数组")
    case _ => println("unknow")
  }

  /**
    * 匹配序列list
    */
  def m4(list: List[Int]) = list match {
    case 5 :: Nil => println("匹配只有5这个元素的序列")
    case x :: y :: Nil => println("匹配只有两个元素的序列")
    case x :: tail => println("匹配任意多个元素的序列")
    case _ => println("unknow")
  }

  /**
    * 匹配元组
    *
    * @param args
    */
  def m5(tuple: Any) = tuple match {
    case (x, z, 7) => println("匹配有三个元素的元组，并且以7结尾的元组")
    case (2, x, y) => println("匹配以2开头有三个元素的元组")
    case _ => println("unknow")
  }

  def main(args: Array[String]): Unit = {
    val res = func("c")
    println(res)

    println(m1("a"))

    m2(6)

    m3(Array(1))
    m3(Array(1, 2, 3))
    m3(Array(0))
    m3(Array(0, 1, 2, 3, 4, 5, 6))

    println("******************")
    m4(List(5))
    m4(List(5, 6))
    m4(List(5, 6, 7, 8, 9))

    println("*******************")
    m5((1,2,7))
    m5((2,5,7))
    m5((2,5,2))
  }
}
