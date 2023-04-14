package model;

import java.sql.Timestamp;

public class Data {

    private int userid;
    private int itemid;
    private int rating;
    private Timestamp timestamp;

    public Data(int userid, int itemid, int rating, Timestamp timestamp) {
        this.userid = userid;
        this.itemid = itemid;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
