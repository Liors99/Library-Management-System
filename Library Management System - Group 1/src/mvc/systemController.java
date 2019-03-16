package mvc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import common.LoginVerifier;

public class systemController {
	
	private LoginView view;
	private LoginModel model;

	/* Constructor */
	public systemController(LoginView view, LoginModel model) {
		this.view = view;
		this.model = model;
		
		this.view.addLoginListener(new LoginListener());
		this.view.addRegisterListener(new RegisterListener());
	}
	
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("button");
			String user = view.getUser();
			String pw = view.getPW();
			model.checkAuthentication(user, pw);
			
			if (model.getAuthentication()) {
				
				// Check if current user is the admin, if he is then switch to admin window
				if(user.equals("admin")) {
					AdminView authView = new AdminView();
					AdminModel authModel = new AdminModel();
					AdminController authCont = new AdminController(authView, authModel);
					
					view.setFalse();
					view.setFrame(authView);
					
					authView.setName(user);
				}
				else {
					HomeView authView = new HomeView();
					HomeModel authModel = new HomeModel();
					HomeController authCont= new HomeController(authView, authModel);
					
					view.setFalse();
					view.setFrame(authView);
					
					authView.setName(user);
					
				}
				
				/* Here we set up if it's authenticated */
				/*
				view.setFalse();
				view.setFrame(authView);
				
				authView.setName(user);
				*/
				
				/* AuthView functions here */
				
				/*
				
				*/
				
				
			} else {
				JOptionPane.showMessageDialog(view, "Login unsuccessful");
			}
		}
	}
	
	/*
	 * ####################################################################################################
	 * ################################## STUDENT VIEW ###################################################
	 * ##################################################################################################
	 */
	
	
	/* Associated with registration button, will give a popup based on if the registration was successful or not */
	class RegisterListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String user = view.getUser();
				String pw = view.getPW();
				if (LoginVerifier.Store(user, pw)) {
					JOptionPane.showMessageDialog(view, "User successfully registered");
				} else {
					JOptionPane.showMessageDialog(view, "Username already taken");

				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * ####################################################################################################
	 * #################################### ADMIN VIEW ###################################################
	 * ##################################################################################################
	 */
	

}
