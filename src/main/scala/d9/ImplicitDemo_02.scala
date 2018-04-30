package d9

import java.io.File

import scala.io.Source

/**
  * @author wcyong
  *         在这里将file转换成RichFile，相当于对类的增强
  */
class RichFile(var file: File) {
  def read() = {
    val content = Source.fromFile(file).mkString
    println(content)
  }
}


object ImplicitDemo_02 {
  implicit def fileToRichFile(file: File): RichFile = {
    new RichFile(file)
  }

  def main(args: Array[String]): Unit = {
    val file = new File("G:\\word.txt");
    file.read();
  }
}
