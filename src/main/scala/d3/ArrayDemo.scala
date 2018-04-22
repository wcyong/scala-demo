package d3

import scala.collection.mutable.ArrayBuffer

/**
  * @author wcyong
  *         在scala中，数组分为不可变长数(在immutable包下)组和可变长数组(nutable包下)
  *         不可变长数组指的是长度不可变，但是数组中角标元素的值是可变的
  *         可变长数组指的是长度和角标对应的元素的值都是可变的
  */
object ArrayDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 不可变数组（一旦初始化了，数组的长度是不可变的）
      */
    val arr = Array[Int](1, 2, 3, 4, 5)

    //如果一个数组中，有不同类型的元素，那么这个数组的类型是这些元素的公共类型Any
    val arr2: Array[Any] = Array("true", 1, true, "aaa")

    //创建一个数组，给数组初始化了长度为5，每个角标的初始值和泛型的初始值一致,也就是0
    val arr3 = new Array[Int](5)
    //创建一个数组，数组的长度是1，这个元素的值是5
    val arr4 = Array(5)

    //++运算符是将两个数组添加到新的数组中去，原来的数组并没有改变，只是形成了一个新的数组
    val arr5 = arr ++ arr4


    /**
      * 可变长数组
      */
    val buffer1 = ArrayBuffer[Int]()
    //如果是+=符号，那么后面只能跟单个元素
    buffer1 += 1
    buffer1 += 2
    //++=后面不能添加单个元素，只能添加数组集合
    buffer1 ++= Array(7, 8, 9)
    buffer1 ++= ArrayBuffer(1, 2, 3, 4, 5, 6)
    //这种添加方式是错误，
    //buffer1(12) = 10   //这种方式是修改角标元素的值，不是添加值

    buffer1.append(10, 11, 12)

    buffer1 -= 1
    buffer1 -= 2
    buffer1 --= Array(1, 2, 3, 4)

    //移除下标为5的对应的元素
    buffer1.remove(5)
    //从指定角标开始,移除指定个数的元素
    buffer1.remove(1, 2)

    println(buffer1)


    /**
      * 数组的常用方法
      */
    val array = Array(1, 2, 3, 4, 5)

    //最大值
    println(array.max)
    //最小值
    println(array.min)
    //mkString 拼接
    println(array.mkString)

    println(array.mkString(","))

    println(array.mkString("[", ",", "]"))

    //reverse相当于将数组反转
    println(array.reverse.toBuffer)




    /**
      * 数组的转换操作
      */
    val intArr = Array(1, 2, 3, 4, 5, 6)

    intArr
      .map((x: Int) => x * 2)
      .sortBy((x: Int) => x) //从小到大排序，即升序
      .reverse //将数组反转
      .foreach((x: Int) => println(x))

    println("************")
    intArr.map(_ * 2).sortBy(x => x).reverse.foreach(println(_))

    val strArr = Array("hello you", "hello me")

    strArr
      //Array(Array("hello","you"),Array("hello","me"))-->Array(hello,you,hello,me)
      .map(x => {
      val fields = x.split(" ")
      fields
    })
      //Array(hello,you,hello,me)
      .flatten
      .foreach(println(_))

    println("***************")
    strArr.flatMap((x: String) => x.split(" ")).foreach(println(_))

  }
}
