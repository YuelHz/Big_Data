package douban;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MovDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration config = new Configuration();
        Job job = Job.getInstance(config);
        //设置jar包
        job.setJarByClass(MovDriver.class);

        //关联mapper和reduce
        job.setMapperClass(MovMapper.class);
        job.setReducerClass(MovReduce.class);

        //设置mapper和reduce的输出
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Jso.class);

        //设置最终的输出的key和value
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Jso.class);

        //设置路劲
        FileInputFormat.setInputPaths(job,new Path("D:\\Input\\movie\\douban.json"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoop\\doubanout2"));

        //提交job
        boolean result = job.waitForCompletion(true);
        System.out.println(result?0:1);

    }
}
