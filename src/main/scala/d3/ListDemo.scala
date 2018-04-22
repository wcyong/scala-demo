package d3

import scala.collection.mutable.ListBuffer

/**
  * @author wcyong
  *         序列分为可变长的和不可变长的，序列其实就是List,底层是链表结构
  *         特点：插入有序，可重复，增加和移除元素很快，查询慢
  *         不可变长序列，List
  *         可变长序列：ListBuffer
  */
object ListDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 不可变长序列List,长度不可变，角标元素也不可变
      */
    val list0 = List(1, 2, 3, 4, 5)

    //++并没有改变原有的list，只是将两个list序列进行合并形成一个新的list
    val list1 = list0 ++ List(6, 7, 8, 9)
    println(list1.toBuffer)
    println(list0.toBuffer)

    println("#####################")

    /**
      * 定义可变长度序列
      */
    val lb0 = ListBuffer(1, 2)
    //+=或-=后面只能跟一个单个的元素
    lb0 += 3
    lb0 -= 3
    //++=或--=后面只能跟一个序列list或者listbuffer
    lb0 ++= List(4, 5, 6)
    lb0 --= List(4, 5)
    lb0 ++= ListBuffer(8, 9, 10)
    lb0.append(11, 12)

    //移除指定角标的元素
    lb0.remove(0)
    //从指定角标开始，移除指定个数的元素
    lb0.remove(1, 2)

    println(lb0)


    println("****************ccccc************")
    /**
      * 给list头部添加元素
      */
    val list01 = List(4, 5, 6);
    //注意，这里并不是将元素添加到list01里面，而是将list01和后面的元素（1，2，3）进行合并 ，然后形成一个新的list
    //newList,需要注意的是后面的(1,2,3)是作为一个整体和list01进行合并
    var newList = list01.::(1, 2, 3)
    println(newList)
    println(list01)
    newList = list01.+:(1, 2, 3)
    println(newList)

    newList = (1, 2, 3) :: list0
    println(newList)

    newList = (1, 2, 3) +: list01
    println(newList)

    //这里是将1,2,3进行拆分开同list01进行合并
    newList = List(1, 2, 3) ++ list01
    println(newList)

    println("$$$$$$$$$$$$$$$$$$$$$$")

    /**
      * 给list尾部添加元素
      */
    val list02 = List(4, 5, 6)
    //这里也是将(7,8,9)作为整体同list02进行合并 添加到尾部,形成一个新的list
    var newList02 = list02.:+(7, 8, 9)
    println(newList02)

    //将7,8,9进行拆分同list02进行合并插入到list02后面去，形成一个新的list,原来的list并没有改变
    newList02 = list02 ++ List(7, 8, 9)
    println(newList02)


    /**
      * 序列的常用操作方法
      */
    val lt = List(1, 2, 3, 4, 5)
    //求和
    println(lt.sum)
    //最大值
    println(lt.max)
    //最小值
    println(lt.min)
    //第一人元素
    println(lt.head)
    //最后一个元素
    println(lt.last)
    //反转序列形成一个新的list,原来的list不会被改变
    println(lt.reverse)
    //拼接
    println(lt.mkString)
    println(lt.mkString(","))
    println(lt.mkString("[", ",", "]"))


    /**
      * 序列的转换操作
      */
    val lit = List(1, 2, 3, 4, 5, 6, 6,7,7, 8)
    lit.map(_ * 2).filter(x => x > 10).distinct.reverse.foreach(println(_))

  }
}
