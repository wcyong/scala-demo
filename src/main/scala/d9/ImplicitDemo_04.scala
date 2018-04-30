package d9

/**
  * @author wcyong
  */

/**
  * 一个对象需要进行比较大小，那么就应该具备比较大小的功能，
  * 具备比较大小的功能可以有两种方法
  * 1.继承：继承Comparable接口，实现compareTo方法，但是这种有一定的局限性
  * 这种局限性就是将比较规则写死了，以后不好调整，并且调整之后会影响之前的比较方式
  * 2.隐式转换
  * 可以很好的解决继承这种局限性，它可以将比较规则不写在类中，而是以隐式转换的形式存在
  */
class Girl(var name: String, var age: Int, var faceValue: Int) extends Comparable[Girl] {
  override def compareTo(that: Girl): Int = {
    if (this.age - that.age != 0) this.age - that.age
    else if (this.faceValue - that.faceValue != 0) this.faceValue - that.faceValue
    else this.name.compareTo(that.name)
  }
}

class Boy(var name: String, var age: Int, var faceValue: Int) {
  override def toString = s"Boy($name, $age, $faceValue)"
}

/**
  * 定义一个比较器
  */
class Chooser[T] {
  //第二个方法的参数是一个隐式参数，只不过这个隐式参数是一个隐式转换函数
  def choose(b1: T, b2: T)(implicit x: T => Ordered[T]): T = {
    if (b1 > b2) b1 else b2
  }

  //第二个方法的参数是一个隐式参数，只不过这个隐式参数是一个隐式转换值
  def choose2(b1: T, b2: T)(implicit ord: Ordering[T]): T = {
    if (ord.gt(b1, b2)) b1 else b2
  }
}

object ImplicitDemo_04 {

  def main(args: Array[String]): Unit = {
    val boyArray = Array[Boy](
      new Boy("b1", 18, 100),
      new Boy("b2", 18, 90),
      new Boy("b3", 18, 104),
      new Boy("b4", 18, 101),
      new Boy("b5", 17, 100)
    )
    //boyArray.sortBy(x => x).foreach(x => println(x.toString))

    /*    implicit def boyToOrdered(boy: Boy) = new Ordered[Boy] {
          override def compare(that: Boy): Int = {
            if (boy.age - that.age != 0) boy.age - that.age
            else if (boy.faceValue - that.faceValue != 0) boy.faceValue - that.faceValue
            else boy.name.compareTo(that.name)
          }
        }*/


    val b1 = new Boy("b1", 18, 100)
    val b2 = new Boy("b2", 18, 99)
    val chooser = new Chooser[Boy]
    /*
    val bigBoy = chooser.choose(b1, b2)
    println(bigBoy.toString)*/

    /*    implicit val boyToOrdering = new Ordering[Boy] {
          override def compare(x: Boy, y: Boy): Int = {
            if (x.age - y.age != 0) x.age - y.age
            else if (x.faceValue - y.faceValue != 0) x.faceValue - y.faceValue
            else x.name.compareTo(y.name)
          }
        }*/

    import MyPredef.boyToOrdering

    val boyBoy = chooser.choose2(b1, b2)
    println(boyBoy.toString)
  }
}
