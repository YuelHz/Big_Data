package douban;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MovReduce extends Reducer<Text,Jso,Text,Jso> {
    private Jso outV = new Jso();
    @Override
    protected void reduce(Text key, Iterable<Jso> values, Context context) throws IOException, InterruptedException {
        System.out.println("reduce"+key);
        Jso j1=new Jso();
        for (Jso j:values){
            System.out.println("reduce"+j);
            j1 = j;
        }
        outV = j1;

        context.write(key,outV);

    }
}
