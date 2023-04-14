package providers;

import db.DBConnection;
import model.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DataProvider {

    public void createData(Data data) throws SQLException {
        int userid;
        int itemid;
        int rating;
        Timestamp timestamp;
        String sql = "INSERT INTO datos(userid, itemid, rating, timestamp) VALUES ($USERID,$ITEMID,$RATING,'$TIMESTAMP')";
        sql = sql.replace("$USERID", data.getUserid() + "");
        sql = sql.replace("$ITEMID", data.getItemid() + "");
        sql = sql.replace("$RATING", data.getRating() + "");
        sql = sql.replace("$TIMESTAMP", data.getTimestamp().toString());
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Data> getAllData() throws SQLException {
        ArrayList<Data> output = new ArrayList<>();

        String sql = "SELECT * FROM datos";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Data(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getTimestamp(4)
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
