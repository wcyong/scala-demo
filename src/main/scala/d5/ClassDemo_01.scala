package d5

/**
  * @author wcyong
  *         在scala类中定义字段有两个关键字，val和var
  *         伴生对象和伴生类
  *         在同一个class的类文件中如果有一个class和object名称一样的类，那么我们称class是object的伴生类，object是class的伴生对象
  */
//private[d5] class代表只能在d5这个包下面访问到该类
private[d5] class ClassDemo_01 {
  //class ClassDemo_01 {
  //使用val修饰的字段，只有gettter方法(name())，没有setter方法
  val name: String = "旺财"
  //使用var修饰的字段，既有getter(age())方法也有setter(age_$eq(int x$1))方法
  var age: Int = 15

  //被private修饰的字段只能在本类及其伴生对象中访问
  private var sex: String = "公"
  //被private[this]修饰的字段只能在本类中访问，连伴生对象都不能访问
  private[this] var tel: String = "1333333333"

  //暴露get和set方法供外面进行取值和赋值
  def getTel() = {
    this.tel
  }

  def setTel(tel: String) = {
    if (tel.length == 11) {
      this.tel = tel
    } else {
      println("电话号码错误")
    }
  }

}

//伴生对象
object ClassDemo_01 {
  val cd = new ClassDemo_01
  cd.sex
  //cd.tel //不能访问
}

object cls {
  val cd = new ClassDemo_01
  //cd.sex  //不能访问
}
