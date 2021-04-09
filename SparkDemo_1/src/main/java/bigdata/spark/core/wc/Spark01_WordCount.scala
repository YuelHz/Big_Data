package bigdata.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {
  def main (args:Array[String]):Unit = {

    // 建立和Spark框架的连接
    //类似jdbc的connection
    val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
     val sc = new SparkContext(sparConf)
    //执行业务操作
    //1读取文件  获取一行一行
    val line: RDD[String] =sc.textFile("datas")
    //2将一行数据进行拆分
    //扁平化：将整体拆分为个体
    val words:RDD[String] = line.flatMap(_.split(" "))

    //3 将数据根据单词进行分组  便于统计
    val wordGroup:RDD[(String,Iterable[String])] = words.groupBy(word => word)

    //4  对分组后的数据进行转化
    val wordToCount = wordGroup.map{
      case (word,list)=>{
        (word,list.size)
      }
    }


    // 5 将转换的结果打印控制台
    val array:Array[(String,Int)] = wordToCount.collect()
    array.foreach(println)

    //关闭连接
    sc.stop()
  }
}
