package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.DataParser;
import user.admin.AdminController;
import user.admin.AdminModel;
import user.admin.AdminView;
import user.faculty.FacultyView;
import user.librarian.LibController;
import user.librarian.LibView;

public class systemController implements ControllerInterface {

	private LoginView view;
	private LoginModel model;
	private MainFrame frame;
	private DataParser d;

	/* Constructor */
	public systemController(LoginView view, LoginModel model, MainFrame frame) {
		this.view = view;
		this.model = model;

		this.frame = frame;

		this.view.addLoginListener(new LoginListener());
		this.view.addRegisterScreenListener(new RegisterScreenListener());
	}

	public systemController(LoginView view, MainFrame frame) {
		this.view = view;
		this.frame = frame;

		this.view.addLoginListener(new LoginListener());
		this.view.addRegisterScreenListener(new RegisterScreenListener());
	}

	/**
	 * 
	 * Switches screens to the registration page
	 *
	 */
	class RegisterScreenListener {
		public void SwitchView() {
			RegisterView newView = new RegisterView();
			RegisterController regCont = new RegisterController(newView, frame);

			setPanel(view, newView, frame);

		}

	}

	/**
	 * 
	 * Verifies the user when he presses the login button
	 *
	 */
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("button");
			String user = view.getUser();

			String pw = view.getPW();
			model.checkAuthentication(user, pw, auth);

			if (model.getAuthentication()) {

				// Check if current user is the admin, if he is then switch to admin window
				if (user.equals("admin") || model.checkAdmin(user, pw, auth)) {
					AdminView authView = new AdminView();
					AdminModel authModel = new AdminModel();
					AdminController authCont = new AdminController(authView, authModel, frame);

					setPanel(view, authView, frame);

					authView.setName(user);
					current_user.setCurrentUserName(user);
					/*
					 * ResultSet ID = d.performQuery("SELECT ID FROM users_and_passwords"); int id;
					 * try { ID.next(); id = (int) ID.getObject("ID"); //
					 * current_user.setUserID(id); // return (byte[])r.getObject("salt"); } catch
					 * (SQLException e) {
					 * 
					 * }
					 */
				} else if (user.equals("lib") || model.checkLib(user, pw, auth)) {
					LibView libView = new LibView();
					LibController libController = new LibController(libView, frame);

					setPanel(view, libView, frame);
				} else if (user.equals("faculty") || model.checkFaculty(user, pw, auth)) {
					current_user.setCurrentUserName(user);
					FacultyView authView = new FacultyView(frame);
					setPanel(view, authView, frame);

				} else {
					current_user.setCurrentUserName(user);
					HomeView authView = new HomeView();
					HomeController authCont = new HomeController(authView, frame);

					authView.setName(user);
					setPanel(view, authView, frame);
				}

			} else {
				JOptionPane.showMessageDialog(view, "Login unsuccessful");
			}
		}
	}

}