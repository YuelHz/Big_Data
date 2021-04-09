package elong;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ElongDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration config = new Configuration();
        Job job = Job.getInstance(config);

        //设置jar包
        job.setJarByClass(ElongDriver.class);


        //关联 mapper华人reduce
        job.setMapperClass(ElongMapper.class);
        job.setReducerClass(ElongReduce.class);

        //设置mapper喝reduce的输出
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Elong.class);

        //设置路劲
        FileInputFormat.setInputPaths(job,new Path("D:\\Input\\elong\\elong\\guiyang_hotel.json"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoop\\elong"));

        //提交job
        boolean result = job.waitForCompletion(true);
        System.out.println(result);

    }
}
