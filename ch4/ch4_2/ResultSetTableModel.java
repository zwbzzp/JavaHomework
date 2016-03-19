package ch4.ch4_2;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.IllegalFormatCodePointException;

/**
 * Created by zwb on 16/3/18.
 */
public class ResultSetTableModel extends AbstractTableModel
{
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase = false;

    public ResultSetTableModel(String url, String username, String password, String query) throws SQLException
    {
        conn = DriverManager.getConnection(url, username, password);

        statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        connectedToDatabase = true;
        setQuery(query);
    }

    public Class getColumnClass(int column) throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to Database.");

        try {
            String className = metaData.getColumnClassName(column+1);
            return Class.forName(className);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Object.class;
    }

    public int getColumnCount() throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database.");

        try {
            return metaData.getColumnCount();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public String getColumnName(int column) throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database.");

        try {
            return metaData.getColumnName(column+1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public int getRowCount() throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database.");

        return numberOfRows;
    }

    public Object getValueAt(int row, int column) throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database.");

        try {
            resultSet.absolute(row+1);
            return resultSet.getObject(column+1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public void setQuery(String query) throws SQLException, IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not Connected to Database.");

        resultSet = statement.executeQuery(query);
        metaData = resultSet.getMetaData();
        resultSet.last();//move to last row
        numberOfRows = resultSet.getRow();//get row number

        //notify JTable that model has changed
        fireTableStructureChanged();
    }

    public void disconnectFromDatabase()
    {
        if(connectedToDatabase)
        {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            finally {
                connectedToDatabase = false;
            }
        }
    }

}
