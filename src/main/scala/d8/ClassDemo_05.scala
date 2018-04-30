package d8

/**
  * @author wcyong
  *         协变：是scala中比较有特色的功能，它完美的解决了java中泛型的一些缺陷
  *         比如：Professor05是Master05的子类，那么，Card[Professor05]是不是Card[Master05]的子类呢？
  *         在java中很遗憾不是，这给我们编码带来很多局限性，scala的协变完美
  *         的解决了这一问题，其实这个协变就是泛型的上边界的一种加强版
  */
class Master05

class Professor05 extends Master05

//这个是协变，我们知道Professor05是Master05的子类，那么此时在这里Card[Professor05]也会是Card[Master05]的子类
class Card[+T]

class ClassDemo_05 {
  //只有Card[Master05]及其子类Card[Professor05]
  def enterMeet(car: Card[Master05]) = {
    println("只有Master05及其下级别的人才能进入会场")
  }
}

object ClassDemo_05 {
  def main(args: Array[String]): Unit = {
    val cm = new Card[Master05]
    val cp = new Card[Professor05]

    val c05 = new ClassDemo_05
    c05.enterMeet(cm)

    c05.enterMeet(cp)
  }
}
