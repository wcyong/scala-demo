package d9

/**
  * @author wcyong
  *         我可以将隐式转换函数或者隐式转换值定义在object对象中来扩大隐式转换的作用域
  *         以后多个地方会使用到的话，我们直接可以使用import将对应的隐式转换函数或值导入即可
  *
  *         注意：隐式转换函数或者值只能定义在object对象中
  */
object MyPredef {
  implicit val boyToOrdering = new Ordering[Boy] {
    override def compare(x: Boy, y: Boy): Int = {
      if (x.age - y.age != 0) x.age - y.age
      else if (x.faceValue - y.faceValue != 0) x.faceValue - y.faceValue
      else x.name.compareTo(y.name)
    }
  }
}
