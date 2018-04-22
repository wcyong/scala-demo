package d5

/**
  * @author wcyong
  *         在scala中被object关键字修饰的类有以下特征
  *         1.它是单例的
  *         2.不需要通过关键字new创建对象，直接通过类名创建对象
  *         3.没有有参数的主构造器，但是有主构造代码块(就是不包含中任何方法 中的代码块，就是object的主构造代码)
  *         4.通常用于封装一些常量 ，工具类，枚举和隐式转换函数
  *         5.主构造代码块只会执行一次，因为它是单例的
  */
object ObjectDemo_03 {
  println("ObjectDemo_03的主构造代码块1")

  def sayHello = println("hello world")

  println("ObjectDemo_03的主构造代码块2")

}

object ObjectDemo_03_03 {
  def main(args: Array[String]): Unit = {
    val obj = ObjectDemo_03
    val obj2 = ObjectDemo_03
    println(obj.hashCode() == obj2.hashCode())
    //obj.sayHello

  }
}
