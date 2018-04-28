package d7

/**
  * @author wcyong
  *         在scala中trait是一种特殊的概念，trait的用途很多，可以作为类似 于java中的
  *         interface接口使用
  *         类可以支持对trait的多重继承,继承的时候统一使用extends关键字，没有implement
  *         关键字，统一使用extends关键字
  *
  *         scala的类对类只能单继承，但是对trait可以多继承
  */
trait TraitDemo_01 {
  //抽象方法
  def say(context: String): Unit
}

trait TraitDemo_001 {
  //抽象方法
  def sayHello(context: String): Unit
}

//在这里trait是作为接口使用，那么就必须实现trait的抽象方法
class TraitDemo_01_01 extends TraitDemo_01 with TraitDemo_001 {
  //类实现trait的抽象方法，可以不使用override关键字
  override def say(context: String): Unit = {
    println(context)
  }

  override def sayHello(context: String): Unit = {
    println(s"hello $context")
  }
}

object TraitDemo01_01 {
  def main(args: Array[String]): Unit = {
    val c01 = new TraitDemo_01_01
    c01.say("world")
    c01.sayHello("world")
  }
}
