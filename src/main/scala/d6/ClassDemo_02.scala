package d6

/**
  * @author wcyong
  */

class Animal {
  def say = {
    println("hello")
  }
}

class Dog extends Animal {
  override def say: Unit = {
    println("hello 汪汪叫")
  }
}

class Cat extends Animal {
  override def say: Unit = {
    println("hello 喵喵叫")
  }
}

object ClassDemo_02 {
  def main(args: Array[String]): Unit = {
    val dog: Any = new Dog
    //isInstanceOf它是用来判断实例对象是否是指定的类及其子类，那么意味着isInstanceOf不能做精确判断
    //asInstanceOf用来 将对象转换成其他类型，在用asInstanceOf之前，应该使用isInstanceOf先做判断
    if (dog.isInstanceOf[Animal]) {
      val d: Animal = dog.asInstanceOf[Animal]
      d.say
    }
    if (dog.isInstanceOf[Dog]) {
      val d: Animal = dog.asInstanceOf[Animal]
      d.say
    }
  }
}
