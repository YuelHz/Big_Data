package combineTextInputForamt;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * KEYIN, VALUEIN, KEYOUT, VALUEOUT
 */

public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    private  Text outk = new Text();
    private IntWritable outv = new IntWritable(1);
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //获取一行
        String line = value.toString();
        //对这行数据进行处理
        String[] words = line.split(" ");

        //循环写出
        for (String word : words) {
            outk.set(word);
            context.write(outk,outv);
        }
    }
}
