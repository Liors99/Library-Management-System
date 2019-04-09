package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.BooksAndStuff;
import database.User;

public class BookController implements ControllerInterface{
	//	@Override
	public BooksAndStuff book;
	public Book_view view;
	public BookModel model;
	
	
	
	public BookController(BooksAndStuff book, Book_view view, BookModel model){
		this.book = book;
		this.view = view;
		this.model = model;
		
		view.name_label.setText(book.getName());
		view.author_label.setText(book.getAuthor());
		
		switch(view.getButtonType()) {
			case "Borrow":
				view.addOrderListener(new orderListener());
				break;
			case "Return":
				break;
			default:
				break;
		
		}
			
		
		
		view.addBackListener(new backToSearchListener());
	}
	
	public class orderListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
			int total = book.getTotal();
			int numCheckedOut = book.getCheckedOut();
			
			int rentCount = 0;
			
			try {
			 ResultSet rents = book.getDataParser().performQuery("SELECT userRenter FROM rentalObj WHERE userRenter = '" + current_user.getCurrentUserName() + "'");//.getObject();
			
			 while(rents.next()) {
				 rentCount++;
			 }
			
			}catch(SQLException ex) {
				
			}
			
			if(numCheckedOut >= total) {
				System.out.println("All copies are currently unavailable");
			}else if(rentCount >= 5){
				System.out.println("You have exceeded your rental capacity");
			}
			
			else{
				
				boolean isBook = false;
				boolean isItem = false;
				boolean isRenter = false;
				boolean isLibrary = false;
				boolean isPayment = false;
				
				
				book.getDataParser().createTable();

				DateFormat dateForm = new  SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String dateStr = dateForm.format(date);
				System.out.println(dateStr);
				
				
				book.getDataParser().performInsert("INSERT INTO rentalObj (userRenter, itemRented, dateRented) VALUES ('" + current_user.getCurrentUserName() + "', " + book.getId() + ", DATE '" + dateStr + "')");
				System.out.println("Book has been reserved!");
				book.getDataParser().performUpdate("UPDATE books_and_others SET qCheckedOut = " + (numCheckedOut + 1) + " WHERE name = '" + book.getName() + "'" );

			}
			
	}
	
	
	

}
	
	public class backToSearchListener implements ActionListener {
	
		public void actionPerformed(ActionEvent arg0) {
			view.frame.dispose();
		}
	
	}
}
