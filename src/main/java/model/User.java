package model;

public class User {
    private int id;
    private int age;
    private String genre;
    private String occupation;
    private long zipcode;

    public User(int id, int age, String genre, String occupation, long zipcode) {
        this.id = id;
        this.age = age;
        this.genre = genre;
        this.occupation = occupation;
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }
}
