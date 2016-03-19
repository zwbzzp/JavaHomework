package ch4.ch4_2;

import java.sql.*;

/**
 * Created by zwb on 16/3/19.
 */
public class DatabaseConnection {
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private String url;
    private String userName;
    private String password;
    public DatabaseConnection(String url, String username, String password) throws SQLException
    {
        this.url = url;
        this.userName = username;
        this.password = password;
    }

    public void ConnectedToDatabase() throws SQLException
    {
        conn = DriverManager.getConnection(url,userName,password);
        statement = conn.createStatement();
    }

    public void disConnectedFromDatabase() throws SQLException{
        resultSet.close();
        statement.close();
        conn.close();
    }
}
