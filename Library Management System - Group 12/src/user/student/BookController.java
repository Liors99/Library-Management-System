package user.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import database.BooksAndStuff;
import database.User;

public class BookController {
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
		
		
		view.addOrderListener(new orderListener());
		view.addBackListener(new backToSearchListener());
	}
	
	public class orderListener implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		
		int total = book.getTotal();
		int numCheckedOut = book.getCheckedOut();
		if(numCheckedOut >= total) {
			System.out.println("All copies are currently unavailable");
		}else {
			System.out.println("Book has been reserved!");
			
			//User.getData().performQuery("SELECT id");
			//book.getDataParser().performInsert("INSERT INTO rentals (idrental, rental_Date, iditem, idrenter, lastupdate) VALUES (" + User.name )
			book.getDataParser().performUpdate("UPDATE books_and_others SET qCheckedOut = " + (numCheckedOut + 1) + " WHERE name = '" + book.getName() + "'" );;
		}
	}
	
	
	

}
	
public class backToSearchListener implements ActionListener {

public void actionPerformed(ActionEvent arg0) {
	view.frame.dispose();
	//frame.dispose();
//	Borrow_frame borrow = new Borrow_frame();
//	borrow.frame.setVisible(true);
}

}
}
