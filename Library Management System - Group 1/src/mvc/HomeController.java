package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController extends CurrentController{
	
	private HomeView view;
	private HomeModel model;
	/**
	 * Constructor for the controller
	 * @param view - the Home view (studen't view)
	 * @param model - the model (student's model)
	 */
	public HomeController(HomeView view, HomeModel model) {
		this.view=view;
		this.model=model;
		view.addBorrowListener(new BorrowListener());
		view.addShopListener(new ShopListener());
		view.addAccountListener(new AccountListener());
		
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
			AccountController accCtrl = new AccountController(accView, accModel);
			
		}
	}	
	
}
