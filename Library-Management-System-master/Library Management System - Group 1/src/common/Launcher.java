package common;

import java.awt.EventQueue;

//import database.DataParser;
//import database.User;
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
					
				//	testData.performInsert("INSERT INTO 'books_and_others' (1,'How to get lit 101',NULL,20,10,NULL,NULL,NULL,NULL,NULL,20.69);");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
