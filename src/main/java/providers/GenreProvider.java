package providers;

import db.DBConnection;
import model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreProvider {

    public void createGenre(Genre genre) throws SQLException {
        int id;
        String genre_name;
        String sql = "INSERT INTO genre(id, genre) VALUES ($ID,'$GENRE')";
        sql = sql.replace("$ID", genre.getId() + "");
        sql = sql.replace("$GENRE", genre.getGenre());
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Genre> getAllGenres() throws SQLException {
        ArrayList<Genre> output = new ArrayList<>();

        String sql = "SELECT * FROM genre";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Genre(
                    resultSet.getInt(1),
                    resultSet.getString(2)
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
