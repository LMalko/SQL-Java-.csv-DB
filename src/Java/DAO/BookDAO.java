package Java.DAO;

import Java.Iterator.*;
import Java.Model.Book;
import Java.Model.ItemCollection;
import Java.DBProcessor.*;

import java.util.ArrayList;
import java.util.List;

public class BookDAO{

    private static ItemCollection<Book> booksCollection = new ItemCollection<Book>("Books");
    private DBStatementProcessor databaseProcessor = new DBStatementProcessor("jdbc:sqlite:database/database.db");
    private static final int bookISBN = 0;
    private static final int bookAuthor = 1;
    private static final int bookTitle = 2;
    private static final int bookPublisher = 3;
    private static final int bookPublicationYear = 4;
    private static final int bookPrice = 5;
    private static final int bookType = 6;

    public void importBooks(){
        booksCollection.clear();
        databaseProcessor.connectToDatabase();

        ArrayList<ArrayList<String>> books = databaseProcessor.getArrayListFromQuery("SELECT * FROM books");

        for(int i=0; i < books.size(); i++) {
            int isbn = Integer.parseInt(books.get(i).get(bookISBN));
            String author = books.get(i).get(bookAuthor);
            String title = books.get(i).get(bookTitle);
            String publisher = books.get(i).get(bookPublisher);
            int publication_year = Integer.parseInt(books.get(i).get(bookPublicationYear));
            int price = Integer.parseInt(books.get(i).get(bookPrice));
            int type = Integer.parseInt(books.get(i).get(bookType));
            

            Book book = new Book(isbn, author, title, publisher, publication_year, price, type);
            addBookToBooksCollection(book);
        }
    }

    public ItemCollection<Book> getBooks(){
        return booksCollection;
    }

    private void addBookToBooksCollection(Book book){
        booksCollection.add(book);
    }

    public void addBookToDatabase(Book book){

    }
}


