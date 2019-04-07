package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.DataParser;

public class UserEditController implements ControllerInterface{
	
	private UserEditView view;
	private UserEditModel model;
	DataParser data = new DataParser();
	
	/**
	 * Constructor for the AdminController
	 * @param view
	 * @param model
	 */
	public UserEditController(UserEditView view, UserEditModel model, String username) {
		this.view=view;
		this.model=model;
		
		view.setUsername(username);
		view.addBackListener(new backToSearchListener());
		
		view.addEditUserListener(new EditListener());
		view.addUserRemoveListener(new RemoveListener());
		
	}
	
	
	
	/* Edits the user */
	class EditListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(view.GetRankValue().equals("Student")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 0 WHERE username = '" + view.getUsername() + "'");
			}
			if(view.GetRankValue().equals("Librarian")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 1 WHERE username = '" + view.getUsername() + "'");
			}
			if(view.GetRankValue().equals("Admin")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 2 WHERE username = '" + view.getUsername() + "'");
			}

		}
	}
	
	/* Removes a user */
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			data.performDelete("DELETE FROM users_and_passwords WHERE username = '" + view.getUsername() + "'");
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

}
