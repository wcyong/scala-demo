package d2

/**
  * @author wcyong
  *         定义函数的关键字是:val
  *         定义函数的通用格式是:val 函数名=（参数列表）=>｛函数体｝
  */
object FunctionDemo {

  //通用的定义格式
  val f1 = (x: Int, y: Int) => {
    x + y
  }

  //先定义函数的参数列表类型，具体的函数参数在函数体中定义
  val f2: (Int, Int, Int) => Int = {
    (x, y, z) => {
      x + y + z
    }
  }


  def main(args: Array[String]): Unit = {
    val v1 = f1(1, 2)
    println(v1)

    val v2 = f2(1, 2, 3)
    println(v2)
  }
}
