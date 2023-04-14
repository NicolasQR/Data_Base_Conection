package main;

import db.DBConnection;
import model.*;
import providers.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        DBConnection dbConnection = new DBConnection();
        DataProvider dataProvider = new DataProvider();
        GenreProvider genreProvider = new GenreProvider();
        ItemProvider itemProvider = new ItemProvider();
        InfoProvider infoProvider = new InfoProvider();
        OccupationProvider occupationProvider = new OccupationProvider();
        UserProvider userProvider = new UserProvider();

        //Parte de lectura de archivos
        Data data = new Data(1,1,1, new Timestamp(System.currentTimeMillis()));
        Genre genre = new Genre(1, "Romance");
        Info info = new Info(1,1,1);
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(genre);
        Item item = new Item(1,"Title", "Releasedate", "Videorelease", genres);
        Occupation occupation = new Occupation("idk");
        User user = new User(1,1,"M", "idk", 2929);
        //
        try {
            infoProvider.createInfo(info);
            genreProvider.createGenre(genre);
            occupationProvider.createOccupation(occupation);
            itemProvider.createItem(item);
            userProvider.createUser(user);
            dataProvider.createData(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
