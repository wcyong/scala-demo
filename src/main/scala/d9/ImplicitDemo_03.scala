package d9

/**
  * @author wcyong
  */

class SingPen {
  def write(content: String) = println(content)
}

object ImplicitDemo_03 {
  //在方法中被implicit修饰的参数，称之为隐式参数
  //隐式参数分为两种：
  //1.隐式转换函数
  //2.隐式转换值
  def singForExam(name: String)(implicit singPen: SingPen) = {
    singPen.write(name)
  }

  def main(args: Array[String]): Unit = {
    implicit val pen = new SingPen
    singForExam("wwss")
    singForExam("李四")
  }
}
