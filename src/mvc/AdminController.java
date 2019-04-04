package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import database.DataParser;


public class AdminController extends CurrentController implements ControllerInterface{
	
	private AdminView view;
	private AdminModel model;
	DataParser data = new DataParser();
	
	/**
	 * Constructor for the AdminController
	 * @param view
	 * @param model
	 */
	public AdminController(AdminView view, AdminModel model) {
		this.view=view;
		this.model=model;
		
		view.addUserListener(new AddListener());
		view.addEditUserListener(new EditListener());
		view.addUserRemoveListener(new RemoveListener());
	}
	
	/* Adds a user to the system */
	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			auth.Store(view.GetUserAdd(), view.GetPwdAdd());
			//data.addUser(view.GetUserAdd(), salt, hash)
			
			
		}
	}
	
	/* Edits the user */
	class EditListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(view.GetRankValue().equals("Student")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 0 WHERE username = '" + view.GetUserRank() + "'");
			}
			if(view.GetRankValue().equals("Librarian")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 1 WHERE username = '" + view.GetUserRank() + "'");
			}
			if(view.GetRankValue().equals("Admin")) {
				data.performUpdate("UPDATE users_and_passwords SET accountType = 2 WHERE username = '" + view.GetUserRank() + "'");
			}

		}
	}
	
	/* Removes a user */
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			data.performDelete("DELETE FROM users_and_passwords WHERE username = '" + view.GetUserDelete() + "'");
		}
	}

}
