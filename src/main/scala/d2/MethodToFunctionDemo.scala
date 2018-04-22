package d2

/**
  * @author wcyong
  *         在scala中方法可以转换成函数，有两种转换的方法
  *         1.下划线，方法名 _
  *         2.scala会隐式的进行转换，不需要我们手动去转换
  */
object MethodToFunctionDemo {

  def m1(x: Int, y: Int) = {
    x + y
  }

  //
  /**
    * m2接收三个参数，
    *
    * @param f 它是一个函数，接收两个参数，返回值是Int类型,在传入这个参数时，
    *          传入进来的参数必须符合函数的签名
    * @param y 普通参数
    * @param x 普通参数
    * @return
    */
  def m2(f: (Int, Int) => Int, y: Int, x: Int) = {
    f(x, y)
  }

  def main(args: Array[String]): Unit = {
    //通过下划线将方法转换成函数
    val f1 = m1 _
    println(f1)

    //scala会自动进行转换
    val v2 = m2(m1, 1, 2)
    println(v2)


    val foreachFunction = (x: Int) => {
      println(x)
    }

    val arr = Array(1, 2, 3, 4, 5)
    arr.foreach(foreachFunction)

    arr.foreach((x: Int) => {
      println(x)
    })

    arr.foreach((x) => println(x))

    arr.foreach(println(_))

    println("********************")
    val filterFunction = (x: Int) => {
      x > 3
    }
    arr.filter(filterFunction).foreach((x: Int) => println(x))



  }
}
