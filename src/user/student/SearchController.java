package user.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DataParser;
import mvc.ControllerInterface;
import mvc.MainFrame;

public class SearchController implements ControllerInterface {

	private SearchView view;
	private MainFrame frame;

	/**
	 * Constructor for the controller
	 * 
	 * @param view  - the Search view
	 * @param model - the Search model
	 */
	public SearchController(SearchView view, MainFrame frame) {
		this.frame = frame;
		this.view = view;
	}

	/**
	 * 
	 * Allows the user to search for a book to borrow
	 *
	 */
	class SearchListener implements ActionListener {
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
			if (filter == null) {
				r = d.searchBook("name", term);
			} else {
				r = d.searchBook(filter, term);
			}

			try {
				while (r.next()) {
					String name = r.getString("name");
					String author = r.getString("author");
					String course = r.getString("course");
					Object[] objs = { name, author, course };
					tableModel.addRow(objs);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/*
	 * Gets the currently selected button
	 */
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
