package user.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.DataParser;
import database.User;
import mvc.ControllerInterface;

public class UserEditController implements ControllerInterface {

	JPanel message = new JPanel();
	private UserEditView view;
	private String edit_username;
	private AdminView admin_view;
	DataParser data = new DataParser();

	/**
	 * Constructor for the AdminController
	 * 
	 * @param view
	 * @param model
	 */
	public UserEditController(UserEditView view, String name, AdminView admin_view) {
		this.view = view;
		this.edit_username = name;
		this.admin_view = admin_view;

		// view.setUsername(current_user.getCurrentUserName());
		view.addBackListener(new backToSearchListener());

		view.addEditUserListener(new EditListener());
		view.addUserRemoveListener(new RemoveListener());
		// view.addFeeListener(new FeeListener());

	}

	/* Edits the user */
	class EditListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (view.GetRankValue().equals("Student")) {
				data.performUpdate(
						"UPDATE users_and_passwords SET accountType = 0 WHERE username = '" + edit_username + "'");
				JOptionPane.showMessageDialog(message,
						"User account has been updated to Student");

			}
			if (view.GetRankValue().equals("Librarian")) {
				data.performUpdate(
						"UPDATE users_and_passwords SET accountType = 3 WHERE username = '" + edit_username + "'");
				JOptionPane.showMessageDialog(message,
						"User account has been updated to Librarian");

			}
			if (view.GetRankValue().equals("Admin")) {
				data.performUpdate(
						"UPDATE users_and_passwords SET accountType = 2 WHERE username = '" + edit_username + "'");
				JOptionPane.showMessageDialog(message,
						"User account has been updated to Admin");
			}
			if (view.GetRankValue().equals("Faculty")) {
				data.performUpdate(
						"UPDATE users_and_passwords SET accountType = 4 WHERE username = '" + edit_username + "'");
				JOptionPane.showMessageDialog(message,
						"User account has been updated to Faculty");
			}

			if (view.getClearFee().isSelected()) {
				System.out.println("Clears fees for " + edit_username);
				User.setFunds(edit_username, 0);
				User.setFees(edit_username, 0);
				JOptionPane.showMessageDialog(message,
						"Cleared fees for " + edit_username);

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
			JOptionPane.showMessageDialog(message,
					edit_username + " has been deleted");

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
