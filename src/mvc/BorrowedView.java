package mvc;

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
	private String[] columnNames = {"Name", "ID", "Date Borrowed", "ISBN"};

	
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

		
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};

		borrowedTable = new JTable(tableModel);
		scrollPane.setViewportView(borrowedTable);

		ResultSet listOfBorrowedItems= null;
		try {
			listOfBorrowedItems = db.queryBorrowed();
			while(listOfBorrowedItems.next()) {
				String name = listOfBorrowedItems.getString("username");
				String ID	= listOfBorrowedItems.getString("borrowed_id");
				String date = listOfBorrowedItems.getString("date_borrowed");
				String isbn = listOfBorrowedItems.getString("ISBN");
				
				Object[] objs = {name, ID, date, isbn};
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
		                    if (value == JOptionPane.YES_OPTION) {
		                    	int borrowedISBN = Integer.parseInt((String) tableModel.getValueAt(selectedRow, 3));
		                    	chargeUser(getFee(borrowedISBN), userBorrowing);
		                    	System.out.println("charging user " + userBorrowing);
		                    	
		                    } else if (value == JOptionPane.NO_OPTION) {
		                    	System.out.println("no i will not charge users");
		                    	pane.setVisible(false);
		                    }
		        		}
		    		}
		    	}
		    });
	}
	
	private double getFee(int ISBN) {
		/* Query to get the fee */
		double price = db.findPrice(ISBN);
		System.out.println(price / 2);
		return (price / 2);
	}
	
	private void chargeUser(double fee, String user) {
		db.executeAddFee(fee, user);
	}
	
}
