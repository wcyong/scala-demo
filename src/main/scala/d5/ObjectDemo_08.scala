package d5


import scala.collection.mutable.ListBuffer

/**
  * @author wcyong
  *         每个外部类的实例对象所持有的内部类都是不同的类
  */

class Person08 {
  class Student08

  //val listBuffer = ListBuffer[Student08]()

  /**
    * 通过外部类的类型投影，扩大内部类的影响范围
    */
  val listBuffer = ListBuffer[Person08#Student08]()

  def getStudent08: Student08 = {
    new Student08
  }

}

/**
  * 通过外部类的伴生对象扩大内部类的影响范围
  */
/*object Person08 {

  class Student08


}*/

object ObjectDemo_08 {
  def main(args: Array[String]): Unit = {
    val p1 = new Person08
    val s1: p1.Student08 = p1.getStudent08
    p1.listBuffer += s1


    val p2 = new Person08
    val s2: p2.Student08 = p2.getStudent08
    p2.listBuffer += s2
  }
}
