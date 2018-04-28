package d7

/**
  * @author wcyong
  */

//在trait中可以定义具体方法 和具体的字段
trait TraitDemo_02 {

  //非抽象字段
  //使用var修饰的非抽象字段，不能被重写
  var name: String = "小强"
  //使用val修饰的非抽象字段，可以被重写
  val name2: String = "wwss"

  //抽象字段,不管是使用var或者val修饰的抽象字段都可以被重写
  val age: Int

  //非抽象方法
  def say = {
    println("say hello world")
  }
}

class TraitDemo002 {
  var name3: String = "zs"
}

//如果是继承class获取的field，实际是定义在父类中的，而继承trait获取的field，就直接被添加到了类中
class TraitDemo_002 extends TraitDemo002 with TraitDemo_02 {
  override val age: Int = 12
}

object TraitDemo_002{
  def main(args: Array[String]): Unit = {
    val t02 = new TraitDemo_002
    t02.age
  }
}





