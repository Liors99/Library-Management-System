package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.User;

public class RegisterController implements ControllerInterface {

	private RegisterView view;
	private MainFrame frame;

	/*
	 * The constructor
	 */
	public RegisterController(RegisterView view, MainFrame frame) {
		this.view = view;
		this.frame = frame;

		this.view.addRegisterListener(new RegisterListener());
		this.view.addLoginScreenListener(new LoginScreenListener());
	}

	/*
	 * Associated with registration button, will give a popup based on if the
	 * registration was successful or not
	 */
	class RegisterListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			String user = view.getUser();
			String pw = view.getPW();
			String pw_confirm = view.getPWconfirm();
			String user_faculty = view.GetFaculty();

			if (user.equals("")) {
				JOptionPane.showMessageDialog(view, "Please enter a username");
				return;
			}

			JTextField[] all_fields = view.getTextField().toArray(new JTextField[view.getTextField().size()]);

			for (int i = 0; i < all_fields.length; i++) {
				if (all_fields[i].getText().equals("")) {
					JOptionPane.showMessageDialog(view, "All fields must be filled in");
					return;
				}
			}

			if (pw.equals(pw_confirm)) {
				if (auth.Store(user, pw)) {
					JOptionPane.showMessageDialog(view, "User successfully registered");

					User.setFaculty(user, user_faculty);
					User.setID(user, view.getID());
					User.setName(user, view.getFullName());

					LoginView log_view = new LoginView();
					LoginModel log_mod = new LoginModel();
					systemController log_con = new systemController(log_view, log_mod, frame);

					setPanel(view, log_view, frame);

				} else {
					JOptionPane.showMessageDialog(view, "Username already taken");

				}
			} else {
				JOptionPane.showMessageDialog(view, "Password confirmation failed");
			}

		}

	}

	/*
	 * Associates with switching to the login screen, when the label is clicked,
	 * will switch to login screen
	 */
	class LoginScreenListener {
		public void SwitchView() {
			LoginView log_view = new LoginView();
			LoginModel log_mod = new LoginModel();
			systemController log_con = new systemController(log_view, log_mod, frame);

			setPanel(view, log_view, frame);

		}
	}

}
