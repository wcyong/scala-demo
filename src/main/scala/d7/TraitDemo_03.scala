package d7

/**
  * @author wcyong
  */
trait TraitDemo_03 {
  def say = {
    println("hello world")
  }
}

//一个类继承了一个父类或trait，那么这个类拥有该类或者trait的所有非私有的方法
class Baby(var name: String, var age: Int) /*extends TraitDemo_03*/ {

}

object Baby {
  def main(args: Array[String]): Unit = {
    val b1 = new Baby("xm", 1)

    //为实例对象混入trait,那么该实例对象就拥有trait的所有非私有的方法
    val b2 = new Baby("xg", 3) with TraitDemo_03
    b2.say
  }
}
