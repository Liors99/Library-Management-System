package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.DataParser;
import database.User;

public class UserEditController implements ControllerInterface{
	
	private UserEditView view;
	private UserEditModel model;
	private String edit_username;
	private AdminView admin_view;
	DataParser data = new DataParser();
	
	/**
	 * Constructor for the AdminController
	 * @param view
	 * @param model
	 */
	public UserEditController(UserEditView view, UserEditModel model, String name, AdminView admin_view) {
		this.view=view;
		this.model=model;
		this.edit_username=name;
		this.admin_view=admin_view;
		
		//view.setUsername(current_user.getCurrentUserName());
		view.addBackListener(new backToSearchListener());
		
		view.addEditUserListener(new EditListener());
		view.addUserRemoveListener(new RemoveListener());
		view.addFeeListener(new FeeListener());
		
	}
	
	
	
	/* Edits the user */
	class EditListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(view.GetRankValue().equals("Student")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 0 WHERE username = '" + edit_username + "'");
			}
			if(view.GetRankValue().equals("Librarian")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 3 WHERE username = '" + edit_username + "'");
			}
			if(view.GetRankValue().equals("Admin")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 2 WHERE username = '" + edit_username+ "'");
			}

			admin_view.initTable();
		}
	}
	
	/* Removes a user */
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			data.performDelete("DELETE FROM users_and_passwords WHERE username = '" + edit_username + "'");
			admin_view.initTable();
			view.frame.dispose();
		}
	}

	/*
	 * Disposes the frame on when pressing back
	 */
	public class backToSearchListener implements ActionListener {	
		public void actionPerformed(ActionEvent arg0) {
			view.frame.dispose();
		}
	
	}
	
	/* Removes a user */
	class FeeListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(edit_username);
			User.setFunds(edit_username, 0);
		}
	}
	
	

}
