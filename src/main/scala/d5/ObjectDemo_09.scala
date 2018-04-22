package d5

/**
  * @author wcyong
  */

//在scala中被case修饰的类称之为样例类
//样例类和普通类基本一致，只是可以不使用new关键字来创建对象
case class Student09(var name: String, var age: Int)


object ObjectDemo_09 {
  def main(args: Array[String]): Unit = {
    val s1 = Student09("zs", 22)

    val s2 = new Student09("ls", 22)
  }
}
