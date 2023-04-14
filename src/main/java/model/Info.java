package model;

public class Info {

    private int users;
    private int items;
    private int ratings;

    public Info(int users, int items, int ratings) {
        this.users = users;
        this.items = items;
        this.ratings = ratings;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
