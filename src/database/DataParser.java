/**
* Include JDBC Driver on Build Path
*/

package database;
import java.sql.*;


public class DataParser{
    private Connection connect;
    private Statement state;
    private boolean connected;

    /**
    * Constructor for class
    */
    public DataParser(){
        try{
        	
        	String hostname = "library.cmpuah4ctyme.us-east-1.rds.amazonaws.com";
        	String port = "3306";
        	String dbname = "library";
        	String username = "lib";
        	String pw = "Library1";
        	
        	
        	String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?user=" + username + "&password=" + pw;
        	
        	connect = DriverManager.getConnection(jdbcUrl);
            //connect = DriverManager.getConnection(db, user, pass);
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
    
    public void createTable() {
    	try {
    	state.executeUpdate("CREATE TABLE IF NOT EXISTS `rentalObj` ( `userRenter` VARCHAR(255) NOT NULL, `itemRented` INT(11) NOT NULL, `dateRented` DATE NOT NULL) ENGINE = InnoDB");
    	}catch(SQLException ex) {
    		System.out.println(ex.getMessage());
    	//	ex.getMessage()
    	}
    }

    /**
    * Performs query based on string from user
    */
    public ResultSet performQuery(String query){
        try{
            if(validateQuery(query)){
                System.out.println("Query being performed is " + query);
                ResultSet result = state.executeQuery(query);
                return result;
            }
        }
        catch(SQLException ex) {
           ex.printStackTrace();
           connected = false;
        }
        return null;
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
     * 
     * @param type
     * @param query
     * @return
     */
    public ResultSet searchBook(String type, String term) {
    	try{
    		String query  = "";
    		if(type == "name" || type == "author" || type == "course") {
    			query = "select * from books_and_others where " + type + " like \"%" + term + "%\";";
    			System.out.println("Query being performed is " + query);
    			return state.executeQuery(query);
    		}
    		else {
    			return null;
    		}
    	}
        catch(SQLException ex) {
           ex.printStackTrace();
           connected = false;
        }
        return null;
    }
    
    /**
    *
    * @param type
    * @param query
    * @return
    */
   public ResultSet searchUser(String term) {
       try{
           String query  = "";
           query = "select * from users_and_passwords where username like \"%" + term + "%\";";
           System.out.println("Query being performed is " + query);
           return state.executeQuery(query);
       }
       catch(SQLException ex) {
          ex.printStackTrace();
          connected = false;
       }
       return null;
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
    
    /**
     * 
     * @param user username to add
     * @param salt salt of user 
     * @param hash hash of user
     * @return if user was added
     */
    public boolean addUser(String user, byte[] salt, byte[] hash) {
    	try {
    		String sql = "INSERT INTO users_and_passwords (username, salt, hash) VALUES(?, ?, ?)";
    	    PreparedStatement pstmt = connect.prepareStatement(sql);
    	    pstmt.setString(1, user);
    	    pstmt.setBytes(2, salt);
    	    pstmt.setBytes(3, hash);
    	    pstmt.executeUpdate();
    	    pstmt.close();
    	    return true;
    	}
    	catch(SQLException ex) {
    		ex.printStackTrace();
            connected = false;
            return false;
    	}
    }
    
    
    public ResultSet queryBorrowed() {
    	try {
    		String query = "select username, borrowed_id, date_borrowed, isbn from borrowed";
    		System.out.println("Query being performed is " + query);
    		return state.executeQuery(query);
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
    	return null;
    }
    
    public double findPrice(int ISBN) {
    	try {
    		String query = "select price from books_and_others right join borrowed on borrowed.isbn = books_and_others.id and books_and_others.id = " + ISBN;
    		System.out.println("Query being performed is " + query);
    		ResultSet price = state.executeQuery(query);
    		if (price.next()) {
        		return price.getDouble(1);
    		}
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
		return 0.00;
    }
    
    public void executeAddFee(double fee, String user) {
    	try {
    		String query = "update users_and_passwords set balance = balance + " + fee + " where username ='"+user+"'";
    		System.out.println("Query being performed is " + query);
    		state.executeUpdate(query);
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
    }
}

