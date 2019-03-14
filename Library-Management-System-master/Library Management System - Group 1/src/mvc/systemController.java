package mvc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import common.LoginVerifier;
import view.Login_frame;

public class systemController {
	
	private LoginView view;
	private LoginModel model;

	HomeView authView = new HomeView();
	HomeModel authModel = new HomeModel();
	
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
			
			if (model.getAuthentication() == true) {
				
				/* Here we set up if it's authenticated */
				view.setFalse();
				view.setFrame(authView);
				
				authView.setName(user);
				/* AuthView functions here */
				authView.addBorrowListener(new BorrowListener());
				authView.addShopListener(new ShopListener());
				
			}
		}
	}
	
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
	
	class BorrowListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			authView.switchToBorrow();
		}
	}
	
	class ShopListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			authView.switchToShop();
		}
	}

}
