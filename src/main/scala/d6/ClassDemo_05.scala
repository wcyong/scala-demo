package d6

/**
  * @author wcyong
  */
abstract class Person05 {
  def sayHello() = {
    println("hello world")
  }
}

class Person05_01 extends Person05 {

}

class Animal05(var name: String, var age: Int) {
  def say = {
    println(s"hello $name $age")
  }
}


object ClassDemo_05 {
  def main(args: Array[String]): Unit = {
    //这里并不是直接new Person05，而是创建Person05的匿名子类的实例对象
    //匿名类即是没有名字的类
    val p5 = new Person05 {
      override def sayHello(): Unit = {
        println("hello 我是Person05的匿名子类的实例")
      }
    }
    p5.sayHello()

    //这里创建的是Animal05的匿名子类的实例对象
    val a = new Animal05("狗", 22) {
      override def say: Unit = {
        println(s"hello 大家好，我是$name, $age")
      }
    }
    a.say

    val a2 = new Animal05("动物", 18)
    println(a.getClass)
    println(a2.getClass)

  }
}
