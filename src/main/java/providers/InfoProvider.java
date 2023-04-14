package providers;

import db.DBConnection;
import model.Data;
import model.Info;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class InfoProvider {

    public void createInfo(Info info) throws SQLException {
        int users;
        int items;
        int ratings;
        String sql = "INSERT INTO INFO(users, items, ratings) VALUES ($USERS,$ITEMS,$RATINGS)";
        sql = sql.replace("$USERS", info.getUsers() + "");
        sql = sql.replace("$ITEMS", info.getItems() + "");
        sql = sql.replace("$RATINGS", info.getRatings() + "");
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Info> getAllInfo() throws SQLException {
        ArrayList<Info> output = new ArrayList<>();

        String sql = "SELECT * FROM info";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Info(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3)
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
