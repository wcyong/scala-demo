package d1

/**
  * @author wcyong
  */
object IfDemo {

  def main(args: Array[String]): Unit = {
    //在scala中不需要添加分号作为语句块的结束符
    val num = 20

    //在scala中if else语句是有返回值的，
    //返回值就是最后一条语句的返回值
    if (num > 20) "zs" else "ls"
    //因为if else 语句是有返回值的，所以可以直接将
    //if else语句赋值给一个变量

    //在scala中无论是方法或函数以及条件判断等都只要是有返回值都不需要加return关键字
    val name = if (num > 20) "zs" else "ls"
    println(name)

    //如果在if else语句中返回的值类型不一样，scala会自动推断出两者
    //的公共类型，作为变量的类型,any
    val name2 = if (num == 20) "zs" else 100
    println(name2)

    //如果if else语句缺省了else语句块，那么其实默认是没有返回值Unit,Unit用"()"表示,
    //类似于java中void
    val name3 = if (num > 20) "zs"
    //和上面的等价
    val name4 = if (num > 20) "zs" else ()
    println(name3)
  }
}
