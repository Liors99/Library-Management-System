package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataParser;
import database.User;


public class AdminController implements ControllerInterface{
	
	private AdminView view;
	private AdminModel model;
	private MainFrame frame;
	DataParser data = new DataParser();
	
	/**
	 * Constructor for the AdminController
	 * @param view
	 * @param model
	 */
	public AdminController(AdminView view, AdminModel model, MainFrame frame) {
		this.view=view;
		this.model=model;
		this.frame=frame;
		
		initTable();
		view.addLogoutListener(new LogoutListener());
	}
	
	
	public void initTable() {
		view.initTable();
	}
	
	class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LoginView log_view= new LoginView();
			LoginModel log_model= new LoginModel();
			systemController log_con= new systemController(log_view, log_model,frame);
			
			setPanel(view, log_view, frame);
			
		}
		
	}
	

}
