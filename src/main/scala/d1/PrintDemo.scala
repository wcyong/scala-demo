package d1

import scala.io.StdIn

/**
  * @author wcyong
  */
object PrintDemo {
  def main(args: Array[String]): Unit = {
    val name = StdIn.readLine("请输入用户名：\n")
    val password = StdIn.readLine("请输入密码：\n")
    if(name.equals("admin") && password.equals("admin")) {
      printf("欢迎您%s登记",name)
    } else {
      println("你输入的用户名或者密码错误，系统自动退出")
    }
  }
}
