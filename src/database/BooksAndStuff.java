package database;

//import  database;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksAndStuff {
	private int ID;
	private String name;
	private String author;
	
	
	int numCheckedOut;
	int total;

	DataParser data = new DataParser();
	
	
	/*
	 * Finds a book given the name
	 */
	public  boolean findBook(String name) {
		String q = String.format("SELECT * FROM books_and_others WHERE name = '" + name + "'"); 
		//return true;
		
		
		ResultSet r = data.performQuery(q);
		try {
		
			 r.next();
			 r.getString("name");
			 return true;
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false; 
		}

	}
	
	/**
	 * Gets a book details from the database
	 * @param name - name of book
	 */
	public void getBookData(String name) {
		String q = String.format("SELECT * FROM books_and_others WHERE name = '" + name + "'"); 
		
		ResultSet r = data.performQuery(q);
		
		
		
		try {
		
			 r.next();
			 this.name = name;
			 

			 
			 ID = r.getInt("ID");
			 
			 author = r.getString("author");
			 
			 numCheckedOut = r.getInt("qCheckedOut");
			 
			 total = r.getInt("qTotal");
			 
			 
			 
			 

			
		}
		catch(SQLException ex) {
			ex.printStackTrace();

		}
		
	}
	
	/**
	 * Gets the total number of books reserved
	 * @param name - name of book
	 * @return - number of books reserved
	 */
	public static int getReservedTotal(String name) {
		ResultSet r = User.getData().performQuery("SELECT reservedTotal FROM books_and_others WHERE name = '" + name + "'");
			
  	int i = 0;
  	try {
			r.next();
			i = r.getInt("reservedTotal");
			
		}
			catch(SQLException ex) {
			
		}
  	return i;
	}
	
	
	/**
	 * Gets the total number of reserved book that have been checked out 
	 * @param name - name of book
	 * @return - quantity of book checked out
	 */
	public static int getReservedOut(String name) {
		ResultSet r = User.getData().performQuery("SELECT reservedBorrowed FROM books_and_others WHERE name = '" + name + "'");
			
  	int i = 0;
  	try {
			r.next();
			i = r.getInt("reservedBorrowed");
			
		}
			catch(SQLException ex) {
			
		}
  	return i;
	}
	
	/**
	 * Gets the faculty of a book
	 * @param name - name of book
	 * @return - faculty that the book is reserved to
	 */
	public static String getFaculty(String name) {
		ResultSet r = User.getData().performQuery("SELECT reservingFaculty FROM books_and_others WHERE name = '" + name + "'");
		
  	String i = "";
  	try {
			r.next();
			i = r.getString("reservingFaculty");
			
			
		}
			catch(SQLException ex) {
			
		}
  	return i;
	}
	
	/**
	 * Sets the number of books to be reserved
	 * @param name - name of book
	 * @param value - quantity
	 */
	public static void setReservedTotal(String name, int value) {
		
			//ResultSet r = User.getData().performQuery("SELECT reservedTotal FROM books_and_others WHERE name = '" + name + "'");
			User.getData().performInsert("UPDATE books_and_others SET reservedTotal = " + value + " WHERE name = '" + name + "'");	
	}
	
	/**
	 * Sets the number of reserved books that have been checked out
	 * @param name - name of book
	 * @param value - number of book that have been checked out
	 */
	public static void setReservedOut(String name, int value) {
		
		//ResultSet r = User.getData().performQuery("SELECT reservedTotal FROM books_and_others WHERE name = '" + name + "'");
		User.getData().performInsert("UPDATE books_and_others SET reservedBorrowed = " + value + " WHERE name = '" + name + "'");	
	}
	
	/**
	 * Sets the faculty of the book
	 * @param name - name of the book
	 * @param faculty - faculty name
	 */
	public static void setFaculty(String name, String faculty) {
		//ResultSet r = User.getData().performQuery("SELECT reservedTotal FROM books_and_others WHERE name = '" + name + "'");
		User.getData().performInsert("UPDATE books_and_others SET reservingFaculty = '" + faculty + "' WHERE name = '" + name + "'");	
	}
	
	
	/* getters and setters for the book object */
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getCheckedOut() {
		return numCheckedOut;
	}
	
	public DataParser getDataParser() {
		return data;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return ID;
	}
	
}
