package providers;

import db.DBConnection;
import model.Genre;
import model.Info;
import model.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemProvider {

    public void createItem(Item item) throws SQLException {
        int id;
        String title;
        String releasedate;
        String videorelease;

        String sql = "INSERT INTO item(id, title, releasedate, videorelease) VALUES ($ID,'$TITLE', '$RELEASEDATE', '$VIDEORELEASE')";
        sql = sql.replace("$ID", item.getId() + "");
        sql = sql.replace("$TITLE", item.getTitle());
        sql = sql.replace("$RELEASEDATE", item.getReleasedate());
        sql = sql.replace("$VIDEORELEASE", item.getVideorelease());
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
        addGenre(item);
    }

    public void addGenre(Item item) throws SQLException {
        String sql = "INSERT INTO item_genre(item_id, genre_id) VALUES ('$ITEMID','$GENREID')";
        DBConnection connection = new DBConnection();
        connection.connect();
        for(int i = 0; i < item.getGenre().size(); i++) {
            sql = sql.replace("$ITEMID", item.getId() + "");
            sql = sql.replace("$GENREID", item.getGenre().get(i).getId() + "");
            connection.commandSQL(sql);
        }
        connection.disconnect();
    }

    public ArrayList<Item> getAllItems() throws SQLException {
        ArrayList<Item> output = new ArrayList<>();

        String sql = "SELECT * FROM item";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Item(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    (ArrayList<Genre>) resultSet.getArray(5)
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
