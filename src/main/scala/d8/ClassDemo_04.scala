package d8

/**
  * @author wcyong
  */

//
class Master

class Professor extends Master

class Teacher04 extends Professor

//下边界>: 即T只能是Professor及其Professor的父类
class ClassDemo_04[T >: Professor] {
  def say(p: T) = {
    println(p.getClass)
  }
}

object ClassDemo_04 {
  def main(args: Array[String]): Unit = {
    //Master可以作为ClassDemo_04的泛型，因为Master是Professor的父类
    //Professor也可以作为lassDemo_04的泛型，因为Professor就是要求我们作为ClassDemo_04的泛型
    //Teacher04则不可以作为ClassDemo_04的泛型，因为Teacher04不是Professor及其Professor的父类
    val c04 = new ClassDemo_04[Master]
    val m = new Master
    val p = new Professor
    val t = new Teacher04
    c04.say(m)
    c04.say(p)
  }
}
