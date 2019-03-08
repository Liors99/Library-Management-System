package common;

import java.awt.EventQueue;

import database.DataParser;
import database.User;
import view.Login_frame;

public class Launcher {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login_frame window= new Login_frame();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frame.setVisible(true);
					DataParser data = new DataParser();
					User test = new User(data);
					test.test("Chris and his kicks");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
