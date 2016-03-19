package ch4.ch4_2;

import java.sql.*;

/**
 * Created by zwb on 16/3/18.
 */
public class DisplayAuthors {
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    public static final String name = "com.mysql.jdbc.Driver";

    public static void main(String[] args)
    {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(name);
            //establish connection to database;
            conn = DriverManager.getConnection(DATABASE_URL, "zwb", "syily");

            //create statement for querying database
            statement = conn.createStatement();

            //query database;
            resultSet = statement.executeQuery("SELECT AuthorID, FirstName, LastName FROM Authors");

            //process query results
            ResultSetMetaData metaData = resultSet.getMetaData();

            int numOfColumns = metaData.getColumnCount();

            System.out.println("Authors Table of Books Database:\n");
            for(int i=1; i<=numOfColumns; i++)
            {
                System.out.printf("%-8s\t",metaData.getColumnName(i));
                System.out.println();
            }
            while (resultSet.next())
            {
                for (int i=1; i<=numOfColumns; i++)
                {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                    System.out.println();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
