package ch4.ch4_2;

import java.sql.*;

/**
 * Created by zwb on 16/3/19.
 */
public class AuthorsOperation {
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    static final String USERNAME = "zwb";
    static final String PASSWORD = "syily";

    public static void main(String[] args)
    {
        try {

            Authors author = new Authors(6,"zhu","wen");
            AuthorDAO dao = new AuthorDAO(DATABASE_URL,USERNAME,PASSWORD);
            dao.ConnectedToDatabase();
//            dao.addAuthor(author);
//            dao.showAuthors();
//            dao.deleteAuthorById(2);
            dao.updateAuthorById(3,author);
            dao.showAuthors();
            dao.disConnectedFromDatabase();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
