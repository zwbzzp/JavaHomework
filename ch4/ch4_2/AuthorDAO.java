package ch4.ch4_2;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.sql.*;

/**
 * Created by zwb on 16/3/19.
 */
public class AuthorDAO {
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numOfColumns;
    private boolean connectedToDatabase = false;
    private String url;
    private String userName;
    private String password;

    public AuthorDAO(String url, String username, String password)
    {
        this.url = url;
        this.userName = username;
        this.password = password;

    }

    public void ConnectedToDatabase() throws SQLException
    {
        conn = DriverManager.getConnection(url, userName, password);

        statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
    }

    //query authors
    public void showAuthors()throws SQLException
    {
        String sql = "SELECT * FROM Authors";
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();
            numOfColumns = metaData.getColumnCount();
            for(int i=1; i<=numOfColumns; i++)
            {
                System.out.printf("%-8s\t",metaData.getColumnName(i));
            }
            System.out.println();
            while (resultSet.next())
            {
                for (int i=1; i<=numOfColumns; i++)
                {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            resultSet.close();
        }
    }

    //add an author to database
    public void addAuthor(Authors authors)
    {
        int id = authors.getId();
        String firstName = authors.getFirstName();
        String lastName = authors.getLastName();
        //字符串之间需要加单引号
        String sql = "INSERT INTO Authors(AuthorID,FirstName,LastName) VALUES " +
                "("+id+",'"+firstName+"','"+lastName+"')";
        try {
            statement.execute(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //delete an author by id
    public void deleteAuthorById(int id)
    {
        String sql = "DELETE FROM Authors where AuthorID="+id;
        try {
            statement.execute(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //update an author by id
    public void updateAuthorById(int id,Authors authors)
    {
        String firstname = authors.getFirstName();
        String lastname = authors.getLastName();
        String sql = "UPDATE Authors set FirstName='"+firstname+"',LastName='"+lastname+
                "'where AuthorID="+id;
        try{
            statement.execute(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void disConnectedFromDatabase() throws SQLException{
        statement.close();
        conn.close();
    }


}
