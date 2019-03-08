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
					
					/* Testing search bar */
					DataParser testData = new DataParser();
					User testStudent = new User(testData);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
