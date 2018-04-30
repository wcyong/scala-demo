package d8

/**
  * @author wcyong
  *         在scala中逆变也是一种比较特殊的
  *         它也完美的解决了在java中泛型的一大缺憾
  *         比如：Professor06是Master06的子类，那么，Card[Professor06]是不是Card[Master06]的子类？
  *         这个在java中不是的，但是在scala中因为逆变，协变这种特色功能存在，它就是其子类
  *
  *         scala的逆变其实就是泛型类的下边界的加强版
  */

class Master06

class Professor06 extends Master06

class Teacher06 extends Professor06

//这个是逆变，只能是Card06[T]及Card06[T]的父类
class Card06[-T]


class ClassDemo_06 {
  //在这里传入进去的参数，只能是Card06[Professor06]及Card06[Professor06]父类Card06[Master06]
  def enterMeet(card: Card06[Professor06]) = {
    println(card.getClass)
  }
}

object ClassDemo_06 {
  def main(args: Array[String]): Unit = {
    val c06 = new ClassDemo_06
    c06.enterMeet(new Card06[Professor06])
    c06.enterMeet(new Card06[Master06])
    //报错
    //c06.enterMeet(new Card06[Teacher06])

  }
}
