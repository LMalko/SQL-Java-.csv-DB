package Java.Controller;

import Java.DBProcessor.*;
import Java.View.*;

public class JerzyController{

    private View view = new View();
    private DBStatementProcessor dbStatementProcessor;

    public void startApp(){
        view.displayUserMenu("txt/Menu.txt");
        dbStatementProcessor = new DBStatementProcessor("jdbc:sqlite:database/database.db");
        dbStatementProcessor.connectToDatabase();
        // getUsersChoice();
    }
}