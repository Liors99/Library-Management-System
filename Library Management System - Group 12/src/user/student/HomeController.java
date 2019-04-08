package user.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.ControllerInterface;
import mvc.LoginModel;
import mvc.LoginView;
import mvc.MainFrame;
import mvc.systemController;

public class HomeController implements ControllerInterface{
	
	private HomeView view;
	private HomeModel model;
	private MainFrame frame;
	private String user;
	/**
	 * Constructor for the controller
	 * @param view - the Home view (studen't view)
	 * @param model - the model (student's model)
	 */
	public HomeController(HomeView view, HomeModel model, MainFrame frame, String user) {
		this.frame=frame;
		this.view=view;
		this.model=model;
		this.user = user;
		view.addBorrowListener(new BorrowListener());
		view.addShopListener(new ShopListener());
		view.addAccountListener(new AccountListener());
		view.addLogoutListener(new LogoutListener());
		
		
	}

	/* Switches cards in view to borrow */
	class BorrowListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			view.switchToBorrow();
		}
	}
	
	/* Switches cards in view to shop */
	class ShopListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			view.switchToShop();
		}
	}
	
	/* Switches cards in view to shop */
	class AccountListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			view.switchToAccount();
			AccountView accView = view.getView();
			AccountModel accModel = new AccountModel();
			AccountController accCtrl = new AccountController(accView, accModel, user);
			
		}
	}
	
	/**
	 * 
	 * Switches back to the login screen when the user clicks logout
	 *
	 */
	class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LoginView log_view= new LoginView();
			LoginModel log_model= new LoginModel();
			systemController log_con= new systemController(log_view, log_model,frame);
			
			setPanel(view, log_view, frame);
			
		}
		
	}
	
}
