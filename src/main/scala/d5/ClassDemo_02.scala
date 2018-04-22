package d5

/**
  * @author wcyong
  *         在scala中类的构造器分为两种
  *         1.主构造器:与类名交织在一块，一个类只能定义一个主构造器
  *         注意：不包含在任何方法中的代码，就是主构造器的代码
  *         2.辅助构造器:辅助构造器可以定义多具，但是辅助构造器的第一行代码必须调用主构造器
  *
  *         创建对象代码执行顺序一定是主构造器代码先执行
  */
//主构造器的参数会成功类的字段属性
//注意：在主构造器的参数中，没有被任何关键字修饰的参数，会被标注为private[this]
//如：class ClassDemo_02(var name: String, var age: Int , tel: String) {  tel这个字段就会被标注为private[this]，
// 只能在本类中访问，其他任何地方都不能访问
class ClassDemo_02(var name: String, var age: Int /*, tel: String*/) {

  println("这是主构造器的代码")

  var sex: String = null
  var address: String = null;

  //定义一个辅助构造器
  def this(name: String, age: Int, sex: String) {
    //辅助构造器的第一行代码必须调用主构造器
    this(name, age)
    this.sex = sex
    println(s"sex=$sex")
  }

  //可以定义多个辅助构造器
  def this(name: String, age: Int, sex: String, address: String) {
    this(name, age, sex)
    this.address = address
    println(s"address=$address")
  }


  println(s"ClassDemo_02($sex, $address, $name, $age)")

}

object ClassDemo_02 {
  def main(args: Array[String]): Unit = {
    val c02 = new ClassDemo_02("zs", 15, "男", address = "xxx")
    println("***********************")
    val c03 = new ClassDemo_02("zs", 22)
  }
}
