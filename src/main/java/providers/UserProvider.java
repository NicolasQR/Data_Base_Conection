package providers;

import db.DBConnection;
import model.Info;
import model.Occupation;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProvider {

    public void createUser(User user) throws SQLException {
        int id;
        int age;
        char gender;
        String occupation;
        long zipcode;
        String sql = "INSERT INTO users(id, age, gender, occupation_name, zipcode) VALUES ('$ID','$AGE', '$GENDER', '$OCCUPATION_NAME', '$ZIPCODE')";
        sql = sql.replace("$ID", user.getId() + "");
        sql = sql.replace("$AGE", user.getAge() + "");
        sql = sql.replace("$GENDER", user.getGenre());
        sql = sql.replace("$OCCUPATION_NAME", user.getOccupation());
        sql = sql.replace("$ZIPCODE", user.getZipcode() + "");
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> output = new ArrayList<>();

        String sql = "SELECT * FROM users";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new User(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getLong(5)
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
