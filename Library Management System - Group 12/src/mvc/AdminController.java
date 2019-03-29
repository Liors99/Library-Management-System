package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AdminController extends CurrentController implements ControllerInterface{
	
	private AdminView view;
	private AdminModel model;
	
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
		}
	}
	
	/* Edits the user */
	class EditListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}
	
	/* Removes a user */
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}

}
