package d1

/**
  * @author wcyong
  *         在scala中定义变量有两个关键字：val和var
  *         val:他是不可变的，即不可以再次给其赋值，类似于java中被final修饰的常量
  *         var:他是可变的，即可以再次给其赋值
  *
  *         声明变量的通用格式
  *         关键字  变量名: 变量的类型=变量值
  */
object VariableDemo {

  def main(args: Array[String]): Unit = {
    val name: String = "wwss"
    var name2: String = "tom"
    val age: Int = 500

    //声明变量可以将变量类型省略，scala会根据变量的值自动推断也出变量的类型
    val sex = "男"

    //也可以使用Any作为变量的类型，Any类似于java中的Object
    val color: Any = "red"

    //可以一次声明多个变量
    val name1, name5, name3, name4: String = "旺财"
  }

}
