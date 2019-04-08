package user.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.DataParser;
import mvc.CurrentController;

public class AccountController extends CurrentController{

	private AccountView view;
	private AccountModel model;
	private String user;
	
	DataParser db = new DataParser();
	
	public AccountController(AccountView view, AccountModel model, String user) {
	
		view.addFundListener(new FundListener());
		this.view = view;
		this.model = model;
		this.user = user;
		
	
	}
	
	/* Adding fees into an account */
	class FundListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("testing funds");

			DataParser db = new DataParser();
			db.executeUpdateFunds(view.getAddedFunds(), user);
			//System.out.printf("Adding $%d into your account", view.getAddedFunds());
			view.setFundLabel();
			JOptionPane.showMessageDialog(view, "Added $" + view.getAddedFunds() + " to your account");

		}
	}
	
	
}
