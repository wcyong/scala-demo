package d9

/**
  * @author wcyong
  *         隐式转换是scala中一种特殊的功能，它能将一种数据类型转换成另外一种数据类型,然后这种数据类型将拥有另外一
  *         种数据类型的所有方法，可以看成是对类的一种增强
  *
  *         隐式转换分为两种
  *         1.隐式转换函数
  *
  *         2.隐式转换值
  *
  *         定义隐式转换的关键字是implicit
  *         隐式转换的命名方式是   one2one
  */

class SpecialPerson01(var name: String)

class Older01(var name: String)

class Student01(var name: String)

class Teacher01(var name: String)

object ImplicitDemo_01 {

  def buySpecialTickWindow(p: SpecialPerson01) = {
    if (p != null) {
      println(p.name + ":购买了一张特殊票")
    } else {
      println("您 不是特殊人群,请求正常窗口购票")
    }
  }

  implicit def any2SpecialPerson01(any: Any): SpecialPerson01 = {
    if (any.isInstanceOf[Older01]) {
      val older01 = any.asInstanceOf[Older01]
      new SpecialPerson01(older01.name)
    } else if (any.isInstanceOf[Student01]) {
      val student01 = any.asInstanceOf[Student01]
      new SpecialPerson01(student01.name)
    } else {
      null
    }

  }

  def main(args: Array[String]): Unit = {
    val older = new Older01("老人")
    val student01 = new Student01("学生")
    val teacher01 = new Teacher01("老师")


    buySpecialTickWindow(older)
    buySpecialTickWindow(student01)
    buySpecialTickWindow(teacher01)

  }
}
