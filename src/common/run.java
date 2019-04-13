package common;

import mvc.LoginModel;
import mvc.LoginView;
import mvc.MainFrame;
import mvc.systemController;

public class run {

	/**
	 * Main function from where the program starts
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame= new MainFrame();
		LoginView view = new LoginView();
		frame.setPanel(view);
		LoginModel model = new LoginModel();
		systemController Controller = new systemController(view, model, frame);
		
	}

}
