package mvc;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ButtonGroup;

import database.BooksAndStuff;
import database.DataParser;
import java.sql.ResultSet;

public class SearchView extends JPanel {
	private JTextField textFieldSearch;
	private JTable tableSearchResults;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String[] columnNames = {"Title", "Author", "Course"};

	/**
	 * Create the panel.
	 */
	public SearchView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JRadioButton rdbtnTitle = new JRadioButton("Title");
		buttonGroup.add(rdbtnTitle);
		GridBagConstraints gbc_rdbtnTitle = new GridBagConstraints();
		gbc_rdbtnTitle.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTitle.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTitle.gridx = 1;
		gbc_rdbtnTitle.gridy = 0;
		add(rdbtnTitle, gbc_rdbtnTitle);
		
		textFieldSearch = new JTextField();
		GridBagConstraints gbc_textFieldSearch = new GridBagConstraints();
		gbc_textFieldSearch.fill = GridBagConstraints.BOTH;
		gbc_textFieldSearch.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSearch.gridx = 4;
		gbc_textFieldSearch.gridy = 0;
		add(textFieldSearch, gbc_textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JRadioButton rdbtnAuthor = new JRadioButton("Author");
		buttonGroup.add(rdbtnAuthor);
		GridBagConstraints gbc_rdbtnAuthor = new GridBagConstraints();
		gbc_rdbtnAuthor.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAuthor.gridx = 1;
		gbc_rdbtnAuthor.gridy = 1;
		add(rdbtnAuthor, gbc_rdbtnAuthor);
		
		JRadioButton rdbtnCourse = new JRadioButton("Course");
		buttonGroup.add(rdbtnCourse);
		GridBagConstraints gbc_rdbtnCourse = new GridBagConstraints();
		gbc_rdbtnCourse.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCourse.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCourse.gridx = 1;
		gbc_rdbtnCourse.gridy = 2;
		add(rdbtnCourse, gbc_rdbtnCourse);
		
		JButton btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 2;
		add(btnSearch, gbc_btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		tableSearchResults = new JTable();
		scrollPane.setViewportView(tableSearchResults);
		
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};

		tableSearchResults = new JTable(tableModel);
		scrollPane.setViewportView(tableSearchResults);
		tableSearchResults.getTableHeader().setResizingAllowed(false);
		tableSearchResults.getTableHeader().setReorderingAllowed(false);
		
		//Initializes with all items showing
		DataParser d = new DataParser();
		ResultSet r = null;
		try {
			r = d.searchBook("author", "");
			while(r.next()) {
				String name = r.getString("name");
				String author = r.getString("author");
				String faculty = r.getString("reservingFaculty");
				Object[] objs = {name, author, faculty};
				tableModel.addRow(objs);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		//Performs search based on input and filter. Defaults to Title search
				btnSearch.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						tableModel.setRowCount(0);
						ResultSet r = null;
						tableSearchResults.revalidate();
						String term = textFieldSearch.getText();
						if(rdbtnCourse.isSelected()) {
							r = d.searchBook("course", term);
						}
						else if(rdbtnAuthor.isSelected()) {
							r = d.searchBook("author", term);
						}
						else {
							r = d.searchBook("name", term);
						}
						
						try {
							while(r.next()) {
								String name = r.getString("name");
								String author = r.getString("author");
								String faculty= r.getString("reservingFaculty");
								Object[] objs = {name, author, faculty};
								tableModel.addRow(objs);
							}
						}
						catch(SQLException ex) {
							ex.printStackTrace();
						}
					}
					
				});

		//Adds functionality to open book view after search
		tableSearchResults.getSelectionModel().addListSelectionListener(
		    new ListSelectionListener() {
		    	@Override
		        public void valueChanged(ListSelectionEvent e) {
		    		if (!e.getValueIsAdjusting()) { 
		        		int i = tableSearchResults.getSelectedRow();
		        		if(i >= 0) {
		        			String item = (String) tableModel.getValueAt(i, 0);
		        			System.out.println(item);
		        			BooksAndStuff book = new BooksAndStuff();
		                            	
		        			if(book.findBook(item)) {
		        				book.getBookData(item);
		        				Book_view b_frame= new Book_view("Borrow");
		        				b_frame.frame.setVisible(true);
		                            		
		        				BookModel b_model = new BookModel();
		                            		
		        				BookController controller = new BookController(book, b_frame, b_model);
		                    }
		        		}
		        	}
		        }
		    });

	}
	
	/**
	 * 
	 * @return table of results from search
	 */
	public JTable getTable() {
		return tableSearchResults;
	}

	/**
	 * 
	 * @return text field of search query
	 */
	public JTextField getTextField() {
		return textFieldSearch;
	}
	
	/**
	 * 
	 * @return buttongroup of the filtering radio buttons
	 */
	public ButtonGroup getRadioButtons() {
		return buttonGroup;
	}
}
