package elong;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Elong implements Writable {
    private String hotelName;
    private String hotelPos;
    private String hotelScore;
    private String commentNum;


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(hotelName);
        dataOutput.writeUTF(hotelPos);
        dataOutput.writeUTF(hotelScore);
        dataOutput.writeUTF(commentNum);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.hotelName = dataInput.readUTF();
        this.hotelPos = dataInput.readUTF();
        this.hotelScore = dataInput.readUTF();
        this.commentNum = dataInput.readUTF();
    }

    @Override
    public String toString() {
        return  hotelName + "\t" + hotelPos  + "\t" + hotelScore + "\t" + commentNum;
    }

    public Elong() {
    }

    public Elong(String hotelName, String hotelPos, String hotelScore, String commentNum) {
        this.hotelName = hotelName;
        this.hotelPos = hotelPos;
        this.hotelScore = hotelScore;
        this.commentNum = commentNum;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPos() {
        return hotelPos;
    }

    public void setHotelPos(String hotelPos) {
        this.hotelPos = hotelPos;
    }

    public String getHotelScore() {
        return hotelScore;
    }

    public void setHotelScore(String hotelScore) {
        this.hotelScore = hotelScore;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }


}
