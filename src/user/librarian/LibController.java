package user.librarian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.DataParser;
import mvc.ControllerInterface;
import mvc.LoginModel;
import mvc.LoginView;
import mvc.MainFrame;
import mvc.systemController;

public class LibController implements ControllerInterface {

	LibView view;
	private MainFrame frame;
	/* Used for queries */
	DataParser data = new DataParser();

	/**
	 * Constructor the controller
	 * 
	 * @param libView  - the librarian's view
	 * @param libModel - the librarian's model
	 * @param frame    - the main frame of the program
	 */
	public LibController(LibView libView, MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.view = libView;
		this.frame = frame;
		view.addLogoutListener(new LogoutListener());
	}

	/* Logout */
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginView log_view = new LoginView();
			LoginModel log_model = new LoginModel();
			systemController log_con = new systemController(log_view, log_model, frame);

			setPanel(view, log_view, frame);

		}

	}

}
