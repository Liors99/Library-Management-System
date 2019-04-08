package database;

//import  database;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksAndStuff {
	private int ID;
	private String name;
	private String author;
	//private int id;
	
	
	int numCheckedOut;
	int total;

	DataParser data = new DataParser();
	
	
	
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
	
//  Book Stuff
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
	
	public static void setReservedTotal(String name, int value) {
		
			//ResultSet r = User.getData().performQuery("SELECT reservedTotal FROM books_and_others WHERE name = '" + name + "'");
			User.getData().performInsert("UPDATE books_and_others SET reservedTotal = " + value + " WHERE name = '" + name + "'");	
	}
	
	public static void setReservedOut(String name, int value) {
		
		//ResultSet r = User.getData().performQuery("SELECT reservedTotal FROM books_and_others WHERE name = '" + name + "'");
		User.getData().performInsert("UPDATE books_and_others SET reservedBorrowed = " + value + " WHERE name = '" + name + "'");	
	}
	
	public static void setFaculty(String name, String faculty) {
		//ResultSet r = User.getData().performQuery("SELECT reservedTotal FROM books_and_others WHERE name = '" + name + "'");
		User.getData().performInsert("UPDATE books_and_others SET reservingFaculty = /" + faculty + "' WHERE name = '" + name + "'");	
	}
	
	
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
