package elong;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ElongMapper extends Mapper<LongWritable, Text,LongWritable,Elong> {
    ObjectMapper obj = new ObjectMapper();

    protected void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.indexOf("[")==0||line.indexOf("]")==0||line.trim().isEmpty()){
            return;
        }else {
            Elong elong = obj.readValue(line, Elong.class);
            System.out.println(elong);
            context.write(key,elong);
        }

    }
}
