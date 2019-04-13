package user.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.DataParser;
import mvc.ControllerInterface;
import mvc.LoginView;
import mvc.MainFrame;
import mvc.systemController;

public class AdminController implements ControllerInterface {

	private AdminView view;
	private AdminModel model;
	private MainFrame frame;
	DataParser data = new DataParser();

	/**
	 * Constructor for the AdminController
	 * 
	 * @param view
	 * @param model
	 */
	public AdminController(AdminView view, AdminModel model, MainFrame frame) {
		this.view = view;
		this.model = model;
		this.frame = frame;

		initTable();
		view.addLogoutListener(new LogoutListener());
	}

	/**
	 * Initalizes the table in the admin view
	 */
	public void initTable() {
		view.initTable();
	}

	/**
	 * 
	 * Returns back to the login screen when logout is pressed
	 *
	 */
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginView log_view = new LoginView();
			systemController log_con = new systemController(log_view, frame);

			setPanel(view, log_view, frame);

		}

	}

}
