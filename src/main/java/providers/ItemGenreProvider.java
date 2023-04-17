package providers;

import db.DBConnection;
import model.Genre;
import model.ItemGenre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemGenreProvider {

    public void createItemGenre(ItemGenre itemGenre) throws SQLException {
        int id;
        String genre_name;
        String sql = "INSERT INTO item_genre(item_id, genre_id) VALUES ($ITEMID,$GENREID)";
        sql = sql.replace("$ITEMID", itemGenre.getItem_id() + "");
        sql = sql.replace("$GENREID", itemGenre.getGenre_id() + "");
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<ItemGenre> getAllGenres() throws SQLException {
        ArrayList<ItemGenre> output = new ArrayList<>();

        String sql = "SELECT * FROM item_genre";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new ItemGenre(
                    resultSet.getInt(1),
                    resultSet.getInt(2)
            ));
        }
        connection.disconnect();
        return output;
    }



    /**
     public void deleteByIdCliente(int id) throws SQLException {
     String sql = "DELETE FROM clientes WHERE id="+id;
     DBConnection connection = new DBConnection();
     connection.connect();
     connection.commandSQL(sql);
     connection.disconnect();
     }
     **/
}
