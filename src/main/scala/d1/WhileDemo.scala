package d1

/**
  * @author wcyong
  */

import scala.util.control.Breaks._

object WhileDemo {
  def main(args: Array[String]): Unit = {
    var num = 0;
    do {
      println(num)
      num += 1
    } while (num <= 5)

    //使用break()方法跳出while循环
    var num2 = 0
    breakable({
      while (true) {
        num2 += 1
        if (num2 > 5) {
          break()
        }
        println(num2)
      }
    })

    var flag = true
    var num3 = 0
    while (flag) {
      num3 += 1
      if (num3 > 10) {
        flag = false
      }
      println(num3)
    }

  }
}
