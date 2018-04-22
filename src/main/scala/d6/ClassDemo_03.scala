package d6

/**
  * @author wcyong
  */

class Person03

class Student03 extends Person03

class Teacher03 extends Person03

object ClassDemo_03 {
  def main(args: Array[String]): Unit = {
    //用isInstanceOf不能做精确判断，如果要做精确判断可以使用getClass和classOf配合起来用
    val s = new Student03
    println(s.getClass == classOf[Student03])
    println(s.getClass == classOf[Person03])
  }
}
