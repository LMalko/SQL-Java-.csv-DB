package DBProcessor;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.sql.*;


public class DBStatementProcessor{
    
    private String filename;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet result;

    public DBStatementProcessor(String filename){
        this.filename = filename;
    }

    public void connectToDatabase() {
        
        try {
            // Register JDBC driver.
            Class.forName("org.sqlite.JDBC");
            // Open a connection to database.
            connection = DriverManager.getConnection(filename);
        }catch ( Exception exception ) {
            System.err.println( exception.getClass().getName() + ": " + exception.getMessage());
        }
    }

    public void executeUpdateAgainstDatabase(String update){
        try{
            statement = connection.createStatement();
            statement.executeUpdate(update);

        }catch (Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.out.println("\n\n\nUpdate was NOT performed successfully");
        } 
    }

    private ResultSet executeQueryAgainstDatabase(String query){
        ResultSet result = null;
        try{

            statement = connection.createStatement();
            result = statement.executeQuery(query);

        }catch(SQLException exception){

            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.out.println("\n\n\nQuery was NOT performed successfully");

        }
        return result;
    }

    private List<String> getColumnNamesFromQueryResult(ResultSet result){
        List<String> columnNames = new LinkedList<>();
        try{
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            for (int row = 1; row <= columnCount; row++) {
                String columnName = metaData.getColumnName(row);
                columnNames.add(columnName);
            }
        }catch(Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.out.println("\n\n\nColumn names were NOT received successfully");
        }
        return columnNames;
    }

    public void printQueryResult(String query){
        try{
            ResultSet result = executeQueryAgainstDatabase(query);
            List<String> columnNames = getColumnNamesFromQueryResult(result);

            while (result.next()) {
                String row = "";

                for (int i = 0; i < columnNames.size(); i++) {
                    row += columnNames.get(i) + ": " + result.getString(columnNames.get(i));
                    row += "  ";
                }
                System.out.println(row);
            }
        }catch(Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.out.println("\n\n\nQuery was not printed successfully");
        }
    }

    public String getStringDataFromQuery(String query){
        String receivedData = null;

        try{ 

            ResultSet result = executeQueryAgainstDatabase(query);
            String columnName = getColumnNamesFromQueryResult(result).get(0);

            while (result.next()) {
                receivedData = result.getString(columnName);
            }
        }catch(Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.out.println("\n\n\nString was not received.");
        }
        return receivedData;
    }

    public int getIntegerDataFromQuery(String query){
        int receivedData = 0;

        try{

            ResultSet result = executeQueryAgainstDatabase(query);
            String columnName = getColumnNamesFromQueryResult(result).get(0);

            while (result.next()) {
                receivedData = result.getInt(columnName);
            }
        }catch(Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.out.println("\n\n\nInteger was not received.");
        }
        return receivedData;
    }

    public List<List> getListFromQuery(String query){
        List<List> arrayResult = new ArrayList<>();

        try{
            ResultSet result = executeQueryAgainstDatabase(query);
            List<String> columnNames = getColumnNamesFromQueryResult(result);

            while(result.next()){
                List<String> rowResult = new LinkedList<>();
                for (int i = 0; i < columnNames.size(); i++){        
                        rowResult.add(result.getString(columnNames.get(i)));
                    }
                arrayResult.add(rowResult);
                }
        }catch(Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.out.println("\n\n\nList was not received.");
        }
        return arrayResult;
    }

    public void closeDatabase(){
        try{
            if (result != null){
                result.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
            
        }catch(Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage() );
            System.exit(0);
        }
    }
}