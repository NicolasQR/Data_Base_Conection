package model;

import java.util.ArrayList;

public class Item {

    private int id;
    private String title;
    private String releasedate;
    private String videorelease;
    private String url;
    private ArrayList<Genre> genre;

    public Item(int id, String title, String releasedate, String videorelease, String url, ArrayList<Genre> genre) {
        this.id = id;
        this.title = title;
        this.releasedate = releasedate;
        this.url = url;
        this.videorelease = videorelease;
        this.genre = genre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getVideorelease() {
        return videorelease;
    }

    public void setVideorelease(String videorelease) {
        this.videorelease = videorelease;
    }

    public ArrayList<Genre> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }
}
