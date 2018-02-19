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
        getUsersChoice();
    }

    private void getUsersChoice(){
        while(true){
            view.displayUserMenu("txt/Menu.txt");
            String userChoice = view.getUserInput("\n\n\nChoose option: ");
            view.clearScreen();
            executeOptionByChoice(userChoice);
            String pressAnyKey = view.getUserInput("Press ANY");
        }
    }

    private void executeOptionByChoice(String userChoice){
        switch(userChoice){
            case "0":   dbStatementProcessor.closeDatabase();
                        System.exit(0);
                        break;
            case "1":    
                        break;
            case "2":    
                        break;      
            case "3":    
                        break;  
            case "4":    
                        break;  
            case "5":    

                        break;
            case "6":   
                        break;    
            case "7":   
                        break;  
            case "8":   

                        break;    
            case "9":   

                        break;
            case "10":  
                        break;

            case "11":  returnAllBooks();
                        break;  
            default:    System.out.println("No such choice");
                        break;    
        }
    }
    private void returnAllBooks(){
        this.bookIterator = booksCollection.getIterator();
        System.out.println("Books:");
        while(bookIterator.hasNext()){
            System.out.println(bookIterator.next());
        }
        this.bookIterator = booksCollection.getIterator();
    }
}