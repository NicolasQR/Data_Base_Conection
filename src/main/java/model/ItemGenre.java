package model;

public class ItemGenre {

    int item_id;
    int genre_id;

    public ItemGenre(int item_id, int genre_id) {
        this.item_id = item_id;
        this.genre_id = genre_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
}
