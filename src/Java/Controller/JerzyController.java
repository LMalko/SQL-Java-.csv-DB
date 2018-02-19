package Java.Controller;

import Java.DBProcessor.*;
import Java.View.*;
import Java.DAO.BookDAO;
import Java.Model.*;
import Java.Iterator.*;
import Java.View.*;

public class JerzyController{

    private View view = new View();
    private DBStatementProcessor dbStatementProcessor;

    private BookDAO booksDao = new BookDAO();

    private ItemCollection<Book> booksCollection = booksDao.getBooks();

    private CollectionIterator<Book> bookIterator = booksCollection.getIterator();


    public void startApp(){
        view.displayUserMenu("txt/Menu.txt");
        dbStatementProcessor = new DBStatementProcessor("jdbc:sqlite:database/database.db");
        dbStatementProcessor.connectToDatabase();
        // getUsersChoice();
    }
}