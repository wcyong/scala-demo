package d6

/**
  * @author wcyong
  *         [注意]：子类继承父类时，在创建子类的实例对象，一定是先初始化父类的构造函数，然后再是执行子类自己的构造函数
  *         父亲的构造函数--->子类的构造函数
  *         如果子类的构造函数和父类的构造函数接收的参数名字一样，那么子类的相同的参数名字就不能添加任何关键字进行修饰，
  *         否则scala会认为子类要重写父类的field
  */
class Person04(var name: String, var age: Int) {
  println("这是person的主构造代码")
  println(name + "=" + age)
}

class Student04(name: String, age: Int, var sex: String) extends Person04("xm", 12) {
  println("这是student的主构造代码块")
  println(name + "=" + age + "=" + sex)
}

object ClassDemo_04 {
  def main(args: Array[String]): Unit = {
    new Student04("xiaoming", 12, "main")
  }
}
