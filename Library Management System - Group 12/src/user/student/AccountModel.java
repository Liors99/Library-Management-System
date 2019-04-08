package user.student;

import database.DataParser;
import mvc.CurrentModel;

public class AccountModel extends CurrentModel{

	public void addFunds(int amount, String user) {
		/* Implement */
		DataParser db = new DataParser();
		System.out.printf("Added $%d into your account\n", amount);
		
	}
}
