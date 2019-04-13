package user.student;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.DataParser;
import mvc.ItemView;

public class ShopView extends JPanel {
	private JTextField textFieldSearch;
	private JTable tableSearchResults;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String[] columnNames = {"Name", "Type", "Price"};
	JPanel message = new JPanel();

	/**
	 * Create the panel.
	 */
	public ShopView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JRadioButton rdbtnSupplies = new JRadioButton("Supplies");
		buttonGroup.add(rdbtnSupplies);
		GridBagConstraints gbc_rdbtnSupplies = new GridBagConstraints();
		gbc_rdbtnSupplies.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSupplies.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSupplies.gridx = 1;
		gbc_rdbtnSupplies.gridy = 0;
		add(rdbtnSupplies, gbc_rdbtnSupplies);
		
		textFieldSearch = new JTextField();
		GridBagConstraints gbc_textFieldSearch = new GridBagConstraints();
		gbc_textFieldSearch.fill = GridBagConstraints.BOTH;
		gbc_textFieldSearch.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSearch.gridx = 4;
		gbc_textFieldSearch.gridy = 0;
		add(textFieldSearch, gbc_textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JRadioButton rdbtnClothing = new JRadioButton("Clothing");
		buttonGroup.add(rdbtnClothing);
		GridBagConstraints gbc_rdbtnClothing = new GridBagConstraints();
		gbc_rdbtnClothing.anchor = GridBagConstraints.WEST;
		gbc_rdbtnClothing.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnClothing.gridx = 1;
		gbc_rdbtnClothing.gridy = 1;
		add(rdbtnClothing, gbc_rdbtnClothing);
		
		JRadioButton rdbtnBooks = new JRadioButton("Books");
		buttonGroup.add(rdbtnBooks);
		GridBagConstraints gbc_rdbtnBooks = new GridBagConstraints();
		gbc_rdbtnBooks.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBooks.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBooks.gridx = 1;
		gbc_rdbtnBooks.gridy = 2;
		add(rdbtnBooks, gbc_rdbtnBooks);
		
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
			r = d.searchShop(null, "");
			while(r.next()) {
				String name = r.getString("name");
				String type = r.getString("type");
				float price = r.getFloat("price");
				Object[] objs = {name, type, price};
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
						if(rdbtnBooks.isSelected()) {
							r = d.searchShop("books", term);
						}
						else if(rdbtnClothing.isSelected()) {
							r = d.searchShop("clothing", term);
		
						}
						else {
							r = d.searchShop("supplies", term);
						}
						
						try {
							while(r.next()) {
								String name = r.getString("name");
								String type = r.getString("type");
								float price = r.getFloat("price");
								Object[] objs = {name, type, price};
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
		        			String name = (String) tableModel.getValueAt(i, 0);
		        			System.out.println(name);
		        			String price = String.valueOf(tableModel.getValueAt(i, 2));
		        			ItemView item = new ItemView(name, price);
		        			item.frame.setSize(300,130);
		        			item.frame.setVisible(true);

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
