package user.student;

import mvc.CurrentModel;

public class AccountModel extends CurrentModel{

	public void addFunds(int amount) {
		/* Implement */
		System.out.printf("Added $%d into your account\n", amount);
		
	}
}
