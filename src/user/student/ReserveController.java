package user.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.BooksAndStuff;
import database.User;
import mvc.ControllerInterface;

public class ReserveController implements ControllerInterface {
	// @Override
	public BooksAndStuff book;
	public ReserveView view;

	public ReserveController(BooksAndStuff book, ReserveView view) {
		this.book = book;
		this.view = view;

		view.name_label.setText(book.getName());
		view.author_label.setText(book.getAuthor());

		view.addOrderListener(new orderListener());

		view.addBackListener(new backToSearchListener());
	}

	public class orderListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String faculty = User.getFaculty(User.getCurrentUserName());
			int total = book.getTotal();
			int numCheckedOut = book.getCheckedOut();
			// System.out.println("HERE");
			int rentCount = 0;

			if (numCheckedOut >= total) {
				System.out.println("All copies are currently unavailable");
			}

			else {

				boolean isBook = false;
				boolean isItem = false;
				boolean isRenter = false;
				boolean isLibrary = false;
				boolean isPayment = false;

				int num = view.getNumberReserved();
				// book.getDataParser().createTable();

				DateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String dateStr = dateForm.format(date);
				System.out.println(dateStr);

				if (true) {
					book.setFaculty(book.getName(), faculty);
					// book.getDataParser().performUpdate("UPDATE books_and_others SET
					// reservingFaculty = '" + + "' WHERE name = '\" + book.getName() + \"'\" );
					System.out.println("Book has been reserved for the faculty!" + num);
					book.setReservedTotal(book.getName(), num);
					// book.getDataParser().performUpdate("UPDATE books_and_others SET
					// reservedBorrowed = " + 0 + " WHERE name = '" + book.getName() + "'");
					System.out
							.println("beep" + book.getFaculty(book.getName()) + book.getReservedTotal(book.getName()));
					// book.getDataParser().performUpdate("UPDATE books_and_others SET reservedTotal
					// = " + (num) + " WHERE name = '" + book.getName() + "'" );

				}
			}

		}

	}

	/* Adds a listener to the back button */
	public class backToSearchListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			view.frame.dispose();
		}

	}

}