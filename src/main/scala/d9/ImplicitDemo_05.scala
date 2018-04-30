package d9

/**
  * @author wcyong
  *         视图界定: T <% Person
  *         T只能是Person的子类或者T能隐式转换成Person
  */

class Person05(var name: String) {
  def sayHello = {
    println(s"hello i am $name")
  }

  def makeFriends(p: Person05): Unit = {
    sayHello
    p.sayHello
  }
}

class Student05(name: String) extends Person05(name)

class Cat(var name: String) {
  def sayHello = println("miao miao i am $name")
}

//泛型T只能是Person05及其子类或者T能够隐式转换成Person05的类型
class Party[T <% Person05](p1: T, p2: T) {
  p1.makeFriends(p2)
}

object ImplicitDemo_05 {
  def main(args: Array[String]): Unit = {
    val p1 = new Person05("xm")
    val p2 = new Person05("xz")
    val pty = new Party[Person05](p1, p2)

    val s1 = new Student05("xm")
    val s2 = new Student05("xz")
    val pty2 = new Party[Student05](s1, s2)

    implicit def catToPerson05(cat: Cat): Person05 = new Person05(cat.name)

    val c1 = new Cat("xm")
    val c2 = new Cat("xz")
    val pty3 = new Party[Cat](c1, c2)

  }
}
