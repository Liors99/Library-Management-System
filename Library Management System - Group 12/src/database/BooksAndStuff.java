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

	
}
