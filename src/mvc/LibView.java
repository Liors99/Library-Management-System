package mvc;


import java.awt.Color;

import java.awt.Font;



import javax.swing.GroupLayout;

import javax.swing.JButton;

import javax.swing.JComponent;

import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.GroupLayout.Alignment;

import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.event.ListSelectionEvent;

import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;



import database.BooksAndStuff;

import database.DataParser;




import javax.swing.SwingConstants;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import java.awt.CardLayout;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.sql.SQLException;



import javax.swing.JTabbedPane;

import javax.swing.JTable;



import java.awt.GridLayout;

import java.awt.LayoutManager;



import javax.swing.JScrollPane;

import javax.swing.ScrollPaneConstants;



public class LibView extends JPanel {

	



	DataParser db = new DataParser();

	JTable borrowedTable;

	private String[] columnNames = {"Name", "ID", "Date Returned", "ISBN"};
	
	private JButton btnLogout;


	public LibView() {



		JPanel topBar = new JPanel();

		topBar.setBackground(new Color(0, 191, 255));

		

		JPanel panel = new JPanel();

		panel.setBackground(new Color(255, 255, 255));

		GroupLayout groupLayout = new GroupLayout(this);

		groupLayout.setHorizontalGroup(

			groupLayout.createParallelGroup(Alignment.TRAILING)

				.addComponent(topBar, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)

				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()

					.addGap(10)

					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)

					.addContainerGap())

		);

		groupLayout.setVerticalGroup(

			groupLayout.createParallelGroup(Alignment.LEADING)

				.addGroup(groupLayout.createSequentialGroup()

					.addComponent(topBar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)

					.addPreferredGap(ComponentPlacement.RELATED)

					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)

					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		panel.setLayout(new GridLayout(0, 1, 0, 0));

		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		panel.add(tabbedPane);
		topBar.setLayout(null);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(24, 17, 101, 23);
		topBar.add(btnLogout);

		

		

		JLabel lblAdmin = new JLabel("LIBRARIAN");
		lblAdmin.setBounds(442, 5, 141, 35);

		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);

		lblAdmin.setForeground(Color.WHITE);

		lblAdmin.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));

		topBar.add(lblAdmin);

		setLayout(groupLayout);

		

		

		/* Trying manual code for tabbed pane */

		

		/* Here we have the panels for the tabbed panes */

		JPanel stationaryShop = new JPanel();

		JPanel publisherShop = new JPanel();

		BorrowedView borrowView = new BorrowedView();

		

		
		/* Adding each panel to the tab */

		tabbedPane.add("Order Stationary", stationaryShop);

		tabbedPane.add("Order Books", publisherShop);

		tabbedPane.add("Validate Returns", borrowView);

		

		/**********************************

		 ******** BORROWED BACKLOG ********

		 **********************************/

	}
	
	void addLogoutListener(ActionListener listenForLogout) {
		btnLogout.addActionListener(listenForLogout);
	}
}