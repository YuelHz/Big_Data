package elong;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ElongReduce extends Reducer<LongWritable,Elong,LongWritable,Elong> {
    private Elong outV = new Elong();


    protected void reduce(LongWritable key,Iterable<Elong> value,Context context) throws IOException, InterruptedException {
        for (Elong elong:value){
            //处理评分
            String score = elong.getHotelScore();
            int i = score.indexOf(">");
            String score0 = score.substring(i);
            int i1 = score0.indexOf("<");
            String score1=score0.substring(1,i1);



            String alter  =elong.getCommentNum();

            /*
            <span class=\"c555 block mt5\" data-score=\"4.5\"
            共<b
            1473</b
            条点评</span

             */
            String[] num = alter.split(">");
            String word1 = num[1].substring(0,num[1].indexOf("<"));
            String word2 = num[2].substring(0,num[2].indexOf("<"));
            String word3 = num[3].substring(0,num[3].indexOf("<"));
            String comm = word1+word2+word3;

            outV.setHotelName(elong.getHotelName());
            outV.setHotelPos(elong.getHotelPos());
            outV.setHotelScore(score1);
            outV.setCommentNum(comm);
        }
        context.write(key,outV);
    }

}
