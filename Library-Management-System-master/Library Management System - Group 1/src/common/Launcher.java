package common;

import java.awt.EventQueue;

import database.DataParser;
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
					DataParser data = new DataParser("test", "1", "2");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
