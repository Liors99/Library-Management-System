package common;

import java.awt.EventQueue;

import database.DataParser;
import mvc.LoginModel;
import mvc.LoginView;
import mvc.systemController;

public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginView view = new LoginView();
		LoginModel model = new LoginModel();
		systemController Controller = new systemController(view, model);
		DataParser testData = new DataParser();

		
	}

}
