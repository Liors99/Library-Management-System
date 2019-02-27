package database;
import java.sql.*;

public class DataParser{
    private Connection connect;
    private Statement state;
    private boolean connected;

    /**
    * Constructor for class
    * Attempts to connect with given info
    */
    public DataParser(String db, String user, String pass){
        try{
            connect = DriverManager.getConnection(db, user, pass);
            state = connect.createStatement();
            connected = true;
        }
        catch(SQLException ex) {
           ex.printStackTrace();
           connect = null;
           state = null;
           connected = false;
        }
    }

    /**
    * Performs query based on string from user
    */
    public void performQuery(String query){
        try{
            if(validateQuery(query)){
                System.out.println("Query being performed is " + query);
                ResultSet result = state.executeQuery(query);
                System.out.println("Here are the records");
                while(result.next()){
                    // TODO: Configure this to do the shit it has to idfk
                }
            }
        }
        catch(SQLException ex) {
           ex.printStackTrace();
           connected = false;
        }
    }

    /**
    * Performs update based on string from user
    */
    public void performUpdate(String update){
        try{
            if(validateUpdate(update)){
                System.out.println("Update being performed is " + update);
                int affected = state.executeUpdate(update);
                System.out.println("Records Affected: " + affected);
            }
        }
        catch(SQLException ex) {
           ex.printStackTrace();
           connected = false;
        }
    }

    /**
    * Performs insert based on string from user
    */
    public void performInsert(String insert){
        try{
            if(validateInsert(insert)){
                System.out.println("Insertion being performed is " + insert);
                int affected = state.executeUpdate(insert);
                System.out.println("Records Affected: " + affected);
            }
        }
        catch(SQLException ex) {
           ex.printStackTrace();
           connected = false;
        }
    }

    /**
    * Performs deletion based on string from user
    */
    public void performDelete(String delete){
        try{
            if(validateDelete(delete)){
                System.out.println("Deletion being performed is " + delete);
                int affected = state.executeUpdate(delete);
                System.out.println("Records Affected: " + affected);
            }
        }
        catch(SQLException ex) {
           ex.printStackTrace();
           connected = false;
        }
    }

    /**
    * Validates query request
    */
    public boolean validateQuery(String query_request){
        return true;
        // TODO: Make this not useless trash
    }

    /**
    * Validates update request
    */
    public boolean validateUpdate(String update_request){
        return true;
        // TODO: Make this not useless trash
    }

    /**
    * Validates insert request
    */
    public boolean validateInsert(String insert_request){
        return true;
        // TODO: Make this not useless trash
    }

    /**
    * Validates delete request
    */
    public boolean validateDelete(String delete_request){
        return true;
        // TODO: Make this not useless trash
    }

    /**
    * Checks if program is still connected to the database
    * Should be called prior to any other requests
    */
    public boolean isConnected(){
        return connected;
    }
}