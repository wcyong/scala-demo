package d5

/**
  * @author wcyong
  *         伴生类和伴生对象一定要在同一个scala的类文件中,并且类名要相同
  *         伴生类和伴生对象的特点是可以相互访问被private修饰的关键字段
  */

//伴生类
class MyArray() {
  private var name: String = "xm"

  println(MyArray.name)
}

//伴生对象
object MyArray {
  private var name: String = "xh"

  println(new MyArray().name)

  def apply(nums: Int*): Array[Int] = {
    val arr = new Array[Int](nums.length)
    for (i <- 0 to nums.length) {
      arr(i) = nums(i)
    }
    arr
  }
}

object ObjectDemo_05 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4)
    var arr2 = new Array[Int](5)

    var myarr = MyArray(5)

    var myarr2 = new MyArray()
  }
}
