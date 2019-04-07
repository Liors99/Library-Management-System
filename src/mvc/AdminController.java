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
	DataParser data = new DataParser();
	
	/**
	 * Constructor for the AdminController
	 * @param view
	 * @param model
	 */
	public AdminController(AdminView view, AdminModel model) {
		this.view=view;
		this.model=model;
		
		
		model.initTable(view.getTableModel(), model.getAllUsers());
	}
	
	

}
