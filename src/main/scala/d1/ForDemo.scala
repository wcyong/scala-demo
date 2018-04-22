package d1

import scala.util.control.Breaks._

/**
  * @author wcyong
  */
object ForDemo {

  def main(args: Array[String]): Unit = {
    //使用to方法会产生一个连续不断的区间范围，[0,10]左右两边都包含
    for (i <- 0 to 10)
      println(i)

    //使用until方法会产生一个连续不断的区间范围，但是不包含最后一个数字[0,10)
    for (a <- 0 until (10))
      println(a)

    //遍历字符串
    for (s <- "abcdfeg")
      println(s)

    //多重for循环
    for (i <- 1 to 9; j <- 1 to 9) {
      if (j == 9) {
        println(i + "*" + j + "=" + i * j + "   ")
      } else {
        print(i + "*" + j + "=" + i * j)
      }
    }

    //带有if守卫条件的for循环
    for (i <- 0 to 10 if (i % 2 == 0))
      println(i)

    //推导式for循环
    val arr = for (i <- 0 to 5) yield i * 2
    for (a <- arr) {
      println(a)
    }

    //遍历数组
    val arr2 = Array(1, true, "string")
    for (a <- arr2) {
      println(a)
    }

    //中断跳出for循环
    breakable({
      for (i <- 0 to 10) {
        println(i)
        if (i >= 5) {
          break()
        }
      }
    })

  }
}
