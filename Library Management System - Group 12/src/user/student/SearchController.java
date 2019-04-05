package user.student;

import mvc.ControllerInterface;
import mvc.MainFrame;
import user.student.HomeController.AccountListener;
import user.student.HomeController.BorrowListener;
import user.student.HomeController.LogoutListener;
import user.student.HomeController.ShopListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.util.Enumeration;
import javax.swing.AbstractButton;

import database.BooksAndStuff;
import database.DataParser;

public class SearchController implements ControllerInterface{

	private SearchView view;
	private SearchModel model;
	private MainFrame frame;
	
	/**
	 * Constructor for the controller
	 * @param view - the Search view
	 * @param model - the Search model
	 */
	public SearchController(SearchView view, SearchModel model, MainFrame frame) {
		this.frame=frame;
		this.view=view;
		this.model=model;
	}
	
	class SearchListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JTable table = view.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			JTextField txtSearch = view.getTextField();
			ButtonGroup bGroup = view.getRadioButtons();
			String filter = getSelectedButtonText(bGroup);
			DataParser d = new DataParser();
			ResultSet r = null;
			tableModel.setRowCount(0);
			table.revalidate();
			String term = txtSearch.getText();
			if(filter == null) {
				r = d.search("name", term);
			}
			else {
				r = d.search(filter, term);
			}
			
			try {
				while(r.next()) {
					String name = r.getString("name");
					String author = r.getString("author");
					String course = r.getString("course");
					Object[] objs = {name, author, course};
					tableModel.addRow(objs);
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	
	
}
