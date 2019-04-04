package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import database.User;

public class AccountController implements ControllerInterface{

	private AccountView view;
	private AccountModel model;
	
	public AccountController(AccountView view, AccountModel model) {
	
		view.addFundListener(new FundListener());
		this.view = view;
		this.model = model;
	
		
		String[] book_dates= current_user.getAllRentalDates(current_user.getCurrentUserName());
		int charge=model.calcTotalCharge(book_dates);
		
		System.out.println("Total user charge: " + charge);
		view.setFeesDisplay(charge);
		view.clearTable();
		view.initTable(current_user.getAllRentals(current_user.getCurrentUserName()), book_dates);
		
		
		
	}
	
	/* Adding fees into an account */
	class FundListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//view.get
			//System.out.println("testing funds");
			model.addFunds(view.getAddedFunds());
			//System.out.printf("Adding $%d into your account", view.getAddedFunds());
			JOptionPane.showMessageDialog(view, "Added $" + view.getAddedFunds() + " to your account");

		}
	}
	

	
}
