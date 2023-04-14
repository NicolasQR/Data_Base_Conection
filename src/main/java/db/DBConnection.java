package db;

import java.sql.*;

public class DBConnection {

    private Connection connection;

    public DBConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //SELECT
    public ResultSet getDataBySQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    //DELET; EDIT; INSERT
    public void commandSQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }


    //Comandos conexión
    public void connect() throws SQLException {

        //Universidad
        //String url = "jdbc:oracle:thin:@172.16.0.103:1522:ESTUD";
        String url = "jdbc:oracle:thin:@200.3.193.24:1522:ESTUD";
        String username = "P09551_1_4";
        String password = "P09551_1_4_20231";
        connection = DriverManager.getConnection(url, username, password);
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
