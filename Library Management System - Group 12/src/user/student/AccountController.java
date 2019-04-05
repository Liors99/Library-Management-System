package user.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mvc.CurrentController;

public class AccountController extends CurrentController{

	private AccountView view;
	private AccountModel model;
	
	public AccountController(AccountView view, AccountModel model) {
	
		view.addFundListener(new FundListener());
		this.view = view;
		this.model = model;
	}
	
	/* Adding fees into an account */
	class FundListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("testing funds");
			model.addFunds(view.getAddedFunds());
			//System.out.printf("Adding $%d into your account", view.getAddedFunds());
			JOptionPane.showMessageDialog(view, "Added $" + view.getAddedFunds() + " to your account");

		}
	}
	
	
}
