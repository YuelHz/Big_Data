package douban;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class MovMapper extends Mapper<LongWritable, Text,Text,Jso> {

    ObjectMapper obj = new ObjectMapper();
    private Text outK = new Text();


    protected void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {

        String line = value.toString();
        System.out.println(line);
        Jso jso = obj.readValue(line,Jso.class);
        System.out.println(jso);
        String id = String.valueOf(jso.getRanking());
        outK.set(id);

        context.write(outK,jso);
    }
}
