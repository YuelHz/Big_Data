package douban;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Jso implements Writable {
    private long ranking;
    private String movie_name;
    private float score;
    private long score_num;

    public Jso() {
    }

    public long getRanking() {
        return ranking;
    }

    public void setRanking(long ranking) {
        this.ranking = ranking;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public long getScore_num() {
        return score_num;
    }

    public void setScore_num(long score_num) {
        this.score_num = score_num;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(ranking);
        dataOutput.writeUTF(movie_name);
        dataOutput.writeFloat(score);
        dataOutput.writeLong(score_num);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.ranking = dataInput.readLong();
        this.movie_name = dataInput.readUTF();
        this.score = dataInput.readFloat();
        this.score_num = dataInput.readLong();
    }

    @Override
    public String toString() {
        return ranking + "\t" + movie_name  + "\t" + score + "\t" + score_num;
    }
}
