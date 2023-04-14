package providers;

import db.DBConnection;
import model.Info;
import model.Occupation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OccupationProvider {

    public void createOccupation(Occupation occupation) throws SQLException {
        String occupations;
        String sql = "INSERT INTO occupation(occupation_name) VALUES ('$OCCUPATIONNAME')";
        sql = sql.replace("$OCCUPATIONNAME", occupation.getOccupation());
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Occupation> getAllOccupations() throws SQLException {
        ArrayList<Occupation> output = new ArrayList<>();

        String sql = "SELECT * FROM occupation";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Occupation(
                    resultSet.getString(1)
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
