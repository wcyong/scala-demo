package d8

/**
  * @author wcyong
  */
package d8

/**
  * @author wcyong
  */
class Person03 {}

class Teacher03 extends Person03 {}

class Student03 extends Person03 {}

class Animal {}

class Dog extends Animal {}

class Cat extends Animal {}

//上边界：<:  即泛型T只能是Person03或者Person03的子类
class ClassDemo_03[T <: Person03] {
  def say(p: T) = {
    println(p.getClass)
  }
}

object ClassDemo_03 {
  def main(args: Array[String]): Unit = {
    val c03 = new ClassDemo_03[Person03]()
    val t03 = new Teacher03
    val s03 = new Student03

    c03.say(t03)
    c03.say(s03)

    val t003 = new ClassDemo_03[Teacher03]
    t003.say(t03)

    val s003 = new ClassDemo_03[Student03]
    s003.say(s03)

    //以下代码错误，因为Animal不属于Person03或者其子类,不能作为ClassDemo_03这个类的泛型
    // val a003 = new ClassDemo_03[Animal]

  }
}



