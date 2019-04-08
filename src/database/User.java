package database;
import java.sql.*;

public class User {
	private static DataParser data;
	private static String current_username;
	

	public User(DataParser d) {
		data = d;
	}
	
	public boolean test(String user) {
		
		String q = String.format("SELECT * FROM books_and_others WHERE name = '" + user + "'"); 
		
		ResultSet r = data.performQuery(q);
		try {
			System.out.println("retrieved book " + r.next());
			return r.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return true; //Returns true so we do not try and add user
		}
	}
	
	/**
	 * 
	 * @param user username to search for
	 * @return if user exists. Default to true if error
	 */
	public boolean userExists(String user) {
		String q = String.format("SELECT * FROM users_and_passwords WHERE username = '" + user + "'"); 
		ResultSet r = data.performQuery(q);
		try {
			return r.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return true; //Returns true so we do not try and add user
		}
	}
	
	/**
	 * 
	 * @param user username to get hash for
	 * @return byte[] of hash
	 */
	public byte[] getHash(String user) {
		String q = String.format("SELECT * FROM users_and_passwords WHERE username = '" + user + "'");
		ResultSet r = data.performQuery(q);
		try {
			r.next();
			return (byte[])r.getObject("hash");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return new byte[0];
		}
	}
	
	/**
	 * 
	 * @param user username to get salt for
	 * @return byte[] of salt
	 */
	public byte[] getSalt(String user) {
		String q = String.format("SELECT * FROM users_and_passwords WHERE username = '" + user + "'");
		ResultSet r = data.performQuery(q);
		try {
			r.next();
			return (byte[])r.getObject("salt");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return new byte[0];
		}
	}
	
	public static int getAccountType(String user) {
		String q = String.format("SELECT * FROM users_and_passwords WHERE username = '" + user + "'");
		ResultSet r = data.performQuery(q);
		try {
			 r.next();
			 if(r.getObject("accountType") != null) {
				 return	(int) r.getObject("accountType");
			 }
			 return 0;
			 
		}
		catch(SQLException ex) {
			return -1;
		}
	}
	
	/**
	 * 
	 * @param user username to set hash for
	 * @param h hash to set
	 */
	public void setHash(String user, byte[] h) {
		String q = String.format("UPDATE users_and_passwords hash = " + h +  "WHERE username = '" + user + "'");
		data.performUpdate(q);
	}
	
	/**
	 * 
	 * @param user username to set salt for
	 * @param s salt to set
	 */
	public void setSalt(String user, byte[] s) {
		String q = String.format("UPDATE users_and_passwords salt = " + s +  "WHERE username = '" + user + "'");
		data.performUpdate(q);
	}
	
	
	public String[] getAllRentals(String username){
        String[] lst = new String[5];
		int i = 0;
		
		ResultSet r = User.getData().performQuery("SELECT * FROM rentalObj WHERE userRenter = '" + username + "'");
		
		String[] bookLst = new String[5]; 

		try {
			while(r.next() ) {
				lst[i] = ""; 
			//	System.out.println(lst[i]);
				bookLst[i] = r.getString("itemRented");
				i++;
			}
			int j = 0;
			ResultSet b;// = User.getData().performQuery("SELECT title FROM books_and_others WHERE ID = " + bookLst[i]);
			while(j < i) {
			
				b = User.getData().performQuery("SELECT name FROM books_and_others WHERE ID = " + ( bookLst[j]));
				b.next();
				lst[j] = b.getString("name") + lst[j];
				System.out.println(lst[j]);
				j++;
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return lst;
	}



	public String[] getAllRentalDates(String username){
	    String[] lst = new String[5];
		int i = 0;
		
		ResultSet r = User.getData().performQuery("SELECT * FROM rentalObj WHERE userRenter = '" + username + "'");
		
	
		
		try {
			while(r.next() ) {
				lst[i] = r.getString("dateRented"); 
			//	System.out.println(lst[i]);
				i++;
			}
		}
			catch(SQLException ex) {
			
		}
	
		return lst;
	}
	
	/**
	 * 
	 * @param user username to add
	 * @param s salt for user
	 * @param h hash for user
	 */
	public void createUser(String user, byte[] s, byte[] h) {
		if(!userExists(user)) {
			data.addUser(user, s, h);
		}
	}
	public static DataParser getData(){
		return data;
	}
	public static String getCurrentUserName() {
		return current_username;
	}
	public static void setCurrentUserName(String usernm) {
		current_username = usernm;
	}
	
	//User stuff
		public static int getFunds(String username) {
			ResultSet r = User.getData().performQuery("SELECT balance FROM users_and_passwords WHERE username = '" + username + "'");
				
			int i = 0;
	    	try {
				r.next();
				i = r.getInt("balance");
				
			}
				catch(SQLException ex) {
				
			}
	    	return i;
		}
		public static int getFees(String username) {
			ResultSet r = User.getData().performQuery("SELECT fees FROM users_and_passwords WHERE username = '" + username + "'");
				
	    	int i = 0;
	    	try {
				r.next();
				i = r.getInt("fees");
				
			}
				catch(SQLException ex) {
				
			}
	    	return i;
		}
		
		public static String getFaculty(String username) {
			ResultSet r = User.getData().performQuery("SELECT faculty FROM users_and_passwords WHERE username = '" + username + "'");
				
	    	//int i = 0;
			String i = "";
	    	try {
				r.next();
				i = r.getString("faculty");
				
			}
				catch(SQLException ex) {
				
			}
	    	return i;
		}
		
		public static void setFees(String username, int value) {
			ResultSet r = User.getData().performQuery("SELECT fees FROM users_and_passwords WHERE username = '" + username + "'");
			data.performInsert("UPDATE users_and_passwords SET fees = " + value + " WHERE username = '" + username + "'");

		}
		
		public static void setFunds(String username, int value) {
			//ResultSet r = User.getData().performQuery("SELECT fees FROM users_and_passwords WHERE username = '" + username + "'");
			data.performInsert("UPDATE users_and_passwords SET balance = " + value + " WHERE username = '" + username + "'");	

		}
		
		public static void setFaculty(String username, String faculty) {
			//ResultSet r = User.getData().performQuery("SELECT fees FROM users_and_passwords WHERE username = '" + username + "'");
			data.performInsert("UPDATE users_and_passwords SET faculty = '" + faculty + "' WHERE username = '" + username + "'");	

		}
		
		public static void setName(String username, String name) {
			//ResultSet r = User.getData().performQuery("SELECT fees FROM users_and_passwords WHERE username = '" + username + "'");
			data.performInsert("UPDATE users_and_passwords SET name = '" + name + "' WHERE username = '" + username + "'");	


		}
		
	    
	    public static String getName(String username) {
			ResultSet r = User.getData().performQuery("SELECT name FROM users_and_passwords WHERE username = '" + username + "'");
			String i = "";
	    	try {
				r.next();
				i = r.getString("name");
				
			}
				catch(SQLException ex) {
				
			}
	    	return i;
		}
		
	    public static void setID(String username, String value) {
			//ResultSet r = User.getData().performQuery("SELECT fees FROM users_and_passwords WHERE username = '" + username + "'");
			data.performInsert("UPDATE users_and_passwords SET ID = " + value + " WHERE username = '" + username + "'");	


		}
		
	    
	   
		public static String getID(String username) {
			ResultSet r = User.getData().performQuery("SELECT ID FROM users_and_passwords WHERE username = '" + username + "'");
				
	    	String i = "";
	    	try {
				r.next();
				i = r.getString("ID");
				
			}
				catch(SQLException ex) {
				
			}
	    	return i;
		}
	
	
}
