/**
* Include JDBC Driver on Build Path
*/

package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataParser{
    private Connection connect;
    private Statement state;
    private boolean connected;

    /**
    * Constructor for class
    */
    public DataParser(){
        try{
        	
        	String hostname = "localhost";
        	String port = "3306";
        	String dbname = "library";
        	String username = "root";
        	String pw = "Library1";
        	
        	
        	//String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname + "?user=" + username + "&password=" + pw;
        	String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;

        	connect = DriverManager.getConnection(jdbcUrl, username, pw);
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
    
    /*
     * Creates a table for the rental object
     */
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
                //System.out.println("Query being performed is " + query);
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
     * Searches a book through the database
     * @param type
     * @param query
     * @return - returns a ResultSet
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
    * Searches a user through the database
    * @param type
    * @param query
    * @return
    */
   public ResultSet searchUser(String term) {
       try{
           String query  = "";
           query = "select * from users_and_passwords where username like \"%" + term + "%\";";
           //System.out.println("Query being performed is " + query);
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
    
    /**
     * Query which will return the ResultSet for all the objects that have been returned. 
     * This function is used by the librarian to display returned objects so they can validate returns
     * @return the results of the query, which should be formatted userRenter, itemRented, dateRented, and dateReturned from rentalObj
     */
    public ResultSet queryBorrowed() {

    	try {
    		String query = "select userRenter, itemRented, dateRented, dateReturned from rentalObj where dateReturned is not null";
    		System.out.println("Query being performed is " + query);
    		return state.executeQuery(query);
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}

    	return null;

    }
    
    /**
     * Performs a right join with borrowed and books_and_others. What this will return is the price of a book, which is in the books_and_others table
     * This price is used in the librarian packages, where they find the price of the book to charge a damage fee
     * @param isbn This is the ISBN of the book borrowed
     */
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
    
    /**
     * Updates the users_and_passwords table with the a users updated balance, after adding fees to it
     * @param fee double which is the price of the damaged book / 2
     * @param user the user in which we're updating
     */
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
    
    /**
     * Updates the users_and_passwords table, this function is used by a student to add funds into their account
     * @param funds amount of $ they want to add into their account
     * @param user the account that will have updated funds
     */
    public void executeUpdateFunds(double funds, String user) {
    	try {
    		String query = "update users_and_passwords set funds = funds + " + funds + " where username ='"+user+"'";
    		System.out.println("Query being performed is " + query);
    		state.executeUpdate(query);
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
    }

    /**
     * Used to get the amount of funds thats that a student has. Used by the student class
     * @param user the user that we're trying to get the funds of
     * @return the amount the user has
     */
    public double queryGetFunds(String user) {
    	try {
    		String query = "select funds from users_and_passwords where username ='"+user+"'";
    		System.out.println("Query being performed is " + query);
    		ResultSet extractedFunds = state.executeQuery(query);
    		extractedFunds.next();
    		return extractedFunds.getDouble("funds");
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
		return 0;
    }

    /**
     * Used to get the number of fees that a student has accumulated. This could be either from damage or late fees
     * @param user
     * @return $ amount in fees that is attached to the user account
     */
    public double queryGetFees(String user) {
    	try {
    		String query = "select fees from users_and_passwords where username ='"+user+"'";
    		System.out.println("Query being performed is " + query);
    		ResultSet extractedFees = state.executeQuery(query);
    		extractedFees.next();
    		return extractedFees.getDouble("fees");
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
		return 0;
    }
    
    /**
     * Performs a rental return, to be used by someone who borrows an object. Updates the given rental object with the dateReturned
     * @param returnDate the date that the object was returned
     * @param isbn object thats being returned
     * @param name person returning the object
     */
    public void executeReturn(String returnDate, int isbn, String name) {
        try {
            String query = "update rentalObj set datereturned='"+returnDate+"' where userRenter ='"+name+"' and itemRented='"+isbn+"'" ;
            System.out.println("Query being performed is " + query);
            state.executeUpdate(query);            
        } catch (SQLException ex) {
            ex.printStackTrace();
            connected = false;
        }
    }
    
    /**
     * Part of the validation process by a librarian to validate returns. 
     * Deletes the object from the rentalObj table
     * @param user user thats returning
     * @param isbn object they're returning
     * @param returnDate their return date
     */
    public void validateReturn(String user, int isbn, String returnDate) {
    	try {
    		String query = "delete from rentalObj where userRenter='"+user+"' and itemRented='"+isbn+"' and dateReturned='"+returnDate+"'";
    		System.out.println("Query being performed is " + query);
    		state.executeUpdate(query);    		
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
    }

    
    /**
     * When a librarian validates the return, this updates the amount of books that are checked out so it gets decremented by one
     * @param isbn the object being returned
     */
    public void updateCheckedOut(int isbn) {
    	try {
    		String query = "update books_and_others set qCheckedOut = qCheckedOut-1 where ID='"+isbn+"'";
    		System.out.println("Query being performed is " + query);
    		state.executeUpdate(query);    		
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		connected = false;
    	}
    }
}

