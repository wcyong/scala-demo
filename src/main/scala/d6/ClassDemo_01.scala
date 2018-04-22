package d6

/**
  * @author wcyong
  */
abstract class ClassDemo_01 {
  //定义一个抽象字段
  val name: String
  //定义具体字段
  val age: Int = 15

  //抽象字段不能使用private修饰，因为抽象字段本身就是需要子类去实现，如果添加private关键字
  //修饰后，意味着子类不能访问，也就意味着不能实现该字段，那么会报错
  //下面一行代码是错误的：
  //private val tel: String

  //定义抽象方法,没有具体的方法体实现，称之为抽象方法
  //抽象方法必须在抽象类中
  def sayHello(content: String)

  //也可以定义具体的方法
  def say = {
    println("say goodbye")
  }

}

class ClassDemo_01_01 extends ClassDemo_01 {

  //子类实现父类的非抽象字段，那么这个抽象字段不能被var修饰，否则异常
  override val age: Int = 11
  //子类现实父类的抽象字段，也可以不加override,这个字段即可以被val修饰，也能被var修饰
  override val name: String = "ws"

  //子类实现父类的抽象方法可以不使用override
  override def sayHello(content: String): Unit = {
    println("hello world")
  }

  //子类重写父类的非抽象方法必须要添加override关键字,如果需要指明调用父类的这个方法需要使用
  //supper.say()方法
  override def say: Unit = {
    super.say
  }
}

object ClassDemo_01_01 {
  def main(args: Array[String]): Unit = {
    val c01 = new ClassDemo_01_01
    println(c01.name)
    c01.sayHello("你好")

    c01.say
  }
}
