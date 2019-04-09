package user.librarian;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.DataParser;

public class BorrowedView extends JPanel {
	
	JPanel borrowedBacklog = new JPanel();
	DataParser db = new DataParser();
	JTable borrowedTable;
	private String[] columnNames = {"Name", "ISBN", "Date Borrowed", "Date Returned"};

	DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {

	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	
	public BorrowedView() {

		GroupLayout gl_borrowedBacklog = new GroupLayout(borrowedBacklog);
		gl_borrowedBacklog.setHorizontalGroup(
			gl_borrowedBacklog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_borrowedBacklog.createSequentialGroup()
					.addContainerGap()
					.addContainerGap())
		);
		gl_borrowedBacklog.setVerticalGroup(
			gl_borrowedBacklog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_borrowedBacklog.createSequentialGroup()
					.addContainerGap()
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		this.setLayout(new GridLayout(0, 1, 0, 0));
		this.add(scrollPane);
		borrowedBacklog.setLayout(gl_borrowedBacklog);
		borrowedTable = new JTable(tableModel);
		scrollPane.setViewportView(borrowedTable);

		ResultSet listOfBorrowedItems= null;
		try {
			listOfBorrowedItems = db.queryBorrowed();
			while(listOfBorrowedItems.next()) {
				String name = listOfBorrowedItems.getString("userRenter");
				String ISBN	= listOfBorrowedItems.getString("itemRented");
				String dRented = listOfBorrowedItems.getString("dateRented");
				String dReturned = listOfBorrowedItems.getString("dateReturned");
				
				Object[] objs = {name, ISBN, dRented, dReturned};
				tableModel.addRow(objs);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		/* Adds functionality to charge user upon click */


		//Adds functionality to open book view after search
		borrowedTable.getSelectionModel().addListSelectionListener(
		    new ListSelectionListener() {
		    	@Override
		        public void valueChanged(ListSelectionEvent e) {
		    		if (!e.getValueIsAdjusting()) { 
		        		int selectedRow = borrowedTable.getSelectedRow();
		        		if(selectedRow >= 0) {


		        			String userBorrowing = (String) tableModel.getValueAt(selectedRow, 0);
		        			System.out.println(userBorrowing);
		        			
		        			JOptionPane pane = new JOptionPane();
		        			JDialog confirmation = new JDialog();
		        			confirmation.setContentPane(pane);
		        			confirmation.setSize(300, 150);
		        			/* Plan for my logic ->
		        			 * 1) Dialog box confirming if you want to charge the user a fee
		        			 * 2) No closes the box
		        			 * 3) Yes charges the user
		        			 * 4) When you click yes, you go to another function where I do my join and i grab the price of the book (
		        			 * 			select price 
										from books_and_others 
										right join borrowed 
										on borrowed.isbn = books_and_others.id and books_and_others.id = "VARIABLE OF ISBN";

		        			 * 5) Then I update user fee's in the sql database
		        			 * 6) ez pz lemon squeezy 
		        			 */

		        			int value =  JOptionPane.showConfirmDialog(null, "Charge user with damage fees?", userBorrowing, JOptionPane.YES_NO_OPTION);
	                    	/* Retrieves the ISBN */
	                    	int borrowedISBN = Integer.parseInt((String) tableModel.getValueAt(selectedRow, 1));
	                   
	                    	/* Retrieves the returned date */
	                    	String returnedDate = ((String) tableModel.getValueAt(selectedRow, 3));
	                    	
		                    if (value == JOptionPane.YES_OPTION) {
		                    	chargeUser(getFee(borrowedISBN), userBorrowing, returnedDate, borrowedISBN);
		                    	JOptionPane.showMessageDialog(borrowedBacklog, "User charged with damages, book has been returned");
		                    	System.out.println("charging user " + userBorrowing);
		                    	tableModel.removeRow(selectedRow);
		                    	db.updateCheckedOut(borrowedISBN);
		                    	
		                    } else if (value == JOptionPane.NO_OPTION) {
		                    	System.out.println("no i will not charge users");
		                    	JOptionPane.showMessageDialog(borrowedBacklog, "Book has been returned");
		                    	tableModel.removeRow(selectedRow);
		                    	db.updateCheckedOut(borrowedISBN);

		                    	pane.setVisible(false);
		                    }
		        		}
		    		}
		    	}
		    });
	}
	
	/*
	 * Grabs the price of the book and charges a given user 1/2 the price
	 */
	private double getFee(int ISBN) {
		/* Query to get the fee */
		double price = db.findPrice(ISBN);
		System.out.println("price that you're charging: " + price / 2);
		return (price / 2);
	}

	/* Function will do the following:
	 * 1) Add fees onto the user
	 * 2) Delete the borrowedObj entry from the table, since return has been completed
	 */
	private void chargeUser(double fee, String user, String returnDate, int ISBN) {
		db.executeAddFee(fee, user);
		db.validateReturn(user, ISBN, returnDate);
	}
	
}
