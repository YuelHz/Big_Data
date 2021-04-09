package scalademo

import java.io.{File, PrintWriter}

import scala.io.Source

object FileDemo {
  def main(args:Array[String]): Unit = {
    //读取
    Source.fromFile("D:\\gitSource\\Big_Data\\SparkDemo_1\\src\\main\\resources\\text.txt").foreach(print)

    //写入
    val write = new PrintWriter( new File("D:\\gitSource\\Big_Data\\SparkDemo_1\\src\\main\\resources\\output.txt"))
    write.write("hello scala from java writer")
    write.close()
  }

}
