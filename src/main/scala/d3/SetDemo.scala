package d3

import scala.collection.mutable

;

/**
  * @author wcyong
  *         在scala中Set集合也分为不可变长(inmutable)和可变长(mutable)集合
  *         set集合特点：无序不重复
  *
  */
object SetDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 不可变长set集合
      */
    val set0 = Set(1, 2, 3, 4, 5)
    //++并没改变原有的set集合，只是将两个set进行合并形成新的set集合
    val newSet0 = set0 ++ Set(6, 7, 8, 9)
    println(newSet0)


    /**
      * 可变长set集合
      */
    val set1 = mutable.Set(1, 3)
    //+=或-=后面只能是半单个元素
    set1 += 1
    set1 += 2
    //++=或者 --=后面只能添加set集合
    set1 ++= mutable.Set(5, 6, 7)
    set1.add(12)
    println(set1)

    set1 -= 1
    set1 --= mutable.Set(1, 2, 3)
    println(set1)


    /**
      * set常用操作方法
      */
    println(set1.mkString(","))
    println(set1.size)
    println(set1.head)
    println(set1.last)
    println(set1.max)
    println(set1.min)
    println(set1.sum)


    /**
      * set的转换操作
      */
    set1.map(_ * 2).filter(x => x > 2).foreach(println(_))
  }
}
