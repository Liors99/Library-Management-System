package mvc;

import database.DataParser;
import mvc.ControllerInterface;

public class LibController implements ControllerInterface {
	
	LibView view;
	LibModel model;
	
	/* Used for queries */
	DataParser data = new DataParser();

	public LibController(LibView libView, LibModel libModel) {
		// TODO Auto-generated constructor stub
		this.view = libView;
		this.model = libModel;
	}

	
}
