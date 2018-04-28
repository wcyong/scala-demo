package d7

/**
  * @author wcyong
  */

//trait也有主构造代码块，不包含在任何方法中的代码就是trait主构造器的代码
trait TraitDemo_04 {
  println("TraitDemo_04的主构造代码块")
}

trait TraitDemo_04_01 extends TraitDemo_04 {
  println("TraitDemo_04_01的主构造代码块")
}

trait TraitDemo_04_02 extends TraitDemo_04 {
  println("TraitDemo_04_02的主构造代码块")
}

class Person04 {
  println("Person04的主构造代码块")
}

class Student04 extends Person04 with TraitDemo_04_01 with TraitDemo_04_02 {
  println("Student的主构造代码块")

}

object Student04 {
  def main(args: Array[String]): Unit = {
    //
    /** 继承了类和trait的构造机制如下：
      * 1.执行父类的构造代码块
      * 2.执行trait的构造代码块，继承多个trait，那么从左往右执行trait的构造代码块
      * 如果多个trait继承了同一个trait，那么先执行父trait的构造代码块,然后再执行子
      * trait的构造代码块,父trait的构造代码块只会执行一次
      * 3.最后执行自己的构造代码块，即子类 的构造代码块最后执行
      */
    val st = new Student04
  }
}
