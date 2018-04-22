package d3

import scala.collection.mutable

/**
  * @author wcyong
  *         在scala中Map映射分为可变长(mutable)和不可变长(inmutable)
  */
object MapDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 不可变长Map映射,长度和值一旦初始化后不能再次被改变
      */

    //通过对偶元组的方法创建映射
    val map0 = Map(("a", "A"), ("b", "B"), ("c", "C"))
    // 通过箭头方式创建Map映射
    val map1 = Map("a" -> "A", "b" -> "B", "c" -> "C")
    //两者进行混合创建Map映射
    val map3 = Map("a" -> "A", ("b", "B"), ("c", "C"))

    //++只是将两个映射合并形成新的map映射，原有的map映射并没有改变
    val newMap = map0 ++ map1
    println(newMap)


    /**
      * 可变长map映射,mutable包下
      */

    val map4 = mutable.Map("a" -> "A")
    map4.put("b", "B")
    map4 += ("c" -> "C", "d" -> "D")
    map4 += (("e", "E"), ("f", "F"))
    map4 ++= mutable.Map("j" -> "J", "h" -> "H", ("i", "I"))
    println(map4)

    /**
      * 移除map中的key
      */
    map4 -= "i"
    println(map4)
    map4 --= Set("i", "j", "f")
    println(map4)
    map4.remove("h")
    println(map4)


    /**
      * Map映射常用操作方法
      */
    //判断一个key是否存在，存在返回true,否则返回false
    println(map4.contains("a"))
    //获取key对应的值,注意如果通过map("Key")获取对应的值，应该进行key是否存在判断
    if (map4.contains("e")) {
      println(map4("e"))
    }

    //映射的get方法也是用来获取key对应的值，但是这个方法返回的是一个option对象，这个option对象有两个
    //子类，如果有key则返回Some（some对象中封装了key对应的值,可以通过Some的get方法获取值）对象,没有key则返回None对象
    println(map4.get("e").get)
    val value: Option[String] = map4.get("e")
    //isEmpty方法可以用来判断是Some对象还是None
    if (!value.isEmpty) {
      println(value.get)
    } else {
      println(value)
    }


    //如果key存在，则返回key对应的value，否则返回给定的默认值
    val v = map4.getOrElse("e", "EE")
    println(v)



    println("********************************")
    /**
      * LinkedHashMap 插入有序，会按照我们的插入顺序排序，因为底层是链表结构
      */
    val map5 = mutable.LinkedHashMap[String, String]()
    map5 += ("d" -> "D")
    map5 += (("a", "A"))
    map5("c") = "C"
    map5("b") = "B"
    println(map5)

    /**
      * SortedMap可以自动对Map的key进行排序
      */
    val map6 = mutable.SortedMap[String, String]()
    map6("c") = "C"
    map6("b") = "B"
    map6("a") = "A"
    println(map6)

  }
}
