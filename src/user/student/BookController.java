package user.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import database.BooksAndStuff;
import database.User;
import mvc.ControllerInterface;

public class BookController implements ControllerInterface {
	// @Override
	public BooksAndStuff book;
	public Book_view view;

	/**
	 * Constructor for the controller
	 * 
	 * @param book  - current book being assessed
	 * @param view  - the view for the book
	 * @param model - the model for the book
	 */
	public BookController(BooksAndStuff book, Book_view view) {
		this.book = book;
		this.view = view;

		view.name_label.setText(book.getName());
		view.author_label.setText(book.getAuthor());

		switch (view.getButtonType()) {
		case "Borrow":
			view.addOrderListener(new orderListener());
			break;
		case "Return":
			view.addOrderListener(new returnListener());
			break;
		default:
			break;

		}
	}

	/**
	 * 
	 * Adds the functionality to borrow a book
	 *
	 */
	public class orderListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			int total = book.getTotal();
			int numCheckedOut = book.getCheckedOut();

			int rentCount = 0;

			int numReservedOut = book.getReservedOut(book.getFaculty(book.getName()));

			int reservedNum = book.getReservedTotal(book.getName());

			String userFaculty = User.getFaculty(current_user.getCurrentUserName());
			String reserveFaculty = book.getFaculty(book.getName());

			try {
				ResultSet rents = book.getDataParser()
						.performQuery("SELECT userRenter FROM rentalObj WHERE userRenter = '"
								+ current_user.getCurrentUserName() + "'");// .getObject();

				while (rents.next()) {
					rentCount++;
				}

			} catch (SQLException ex) {

			}

			if (numCheckedOut >= total) {
				System.out.println("All copies are currently unavailable");
				JOptionPane.showMessageDialog(null, "All copies are currently unavailable");
			} else if (rentCount >= 5) {
				System.out.println("You have exceeded your rental capacity");
				JOptionPane.showMessageDialog(null, "You have exceeded your rental capacity");
			} else if (!(userFaculty.equals(reserveFaculty))
					&& (total - numCheckedOut) <= (reservedNum - numReservedOut) && !reserveFaculty.equals("")) {
				System.out.println("All remaining copies are reserved");
				JOptionPane.showMessageDialog(null, "All remaining copies are reserved");
			}

			else {

				boolean isBook = false;
				boolean isItem = false;
				boolean isRenter = false;
				boolean isLibrary = false;
				boolean isPayment = false;

				// book.getDataParser().createTable();

				DateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String dateStr = dateForm.format(date);
				System.out.println(dateStr);

				book.getDataParser()
						.performInsert("INSERT INTO rentalObj (userRenter, itemRented, dateRented) VALUES ('"
								+ current_user.getCurrentUserName() + "', " + book.getId() + ", DATE '" + dateStr
								+ "')");
				System.out.println("Book has been reserved!");
				JOptionPane.showMessageDialog(null, "Book has been reserved!");
				book.getDataParser().performUpdate("UPDATE books_and_others SET qCheckedOut = " + (numCheckedOut + 1)
						+ " WHERE name = '" + book.getName() + "'");
				if (userFaculty.equals(reserveFaculty)) {
					book.setReservedOut(book.getName(), numReservedOut + 1);

				}

			}

		}

	}

	/**
	 * 
	 * Adds the functionality to return a book
	 *
	 */
	public class returnListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
			Date return_date = new Date();

			d.executeReturn(date_format.format(return_date), book.getId(), current_user.getCurrentUserName());

			JOptionPane.showMessageDialog(null, "Book has been returned, awaiting librarian confirmation");
			view.frame.dispose();
		}

	}
}
