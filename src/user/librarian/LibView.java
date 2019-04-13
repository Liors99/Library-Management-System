package user.librarian;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import database.DataParser;
import user.student.ShopView;

public class LibView extends JPanel {

	DataParser db = new DataParser();
	JTable borrowedTable;
	private String[] columnNames = { "Name", "ID", "Date Returned", "ISBN" };
	private JButton btnLogout;

	/*
	 * Constructor for LibView, creates the panels that is used when you login to
	 * librarian
	 */
	public LibView() {
		JPanel topBar = new JPanel();
		topBar.setBackground(new Color(0, 191, 255));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(topBar, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(10)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE).addContainerGap()));

		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(topBar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panel.add(tabbedPane);
		topBar.setLayout(null);

		/* Logout buttons */

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

		/* Here we have the panels for the tabbed panes */
		//JPanel stationaryShop = new JPanel();
		//JPanel publisherShop = new JPanel();
		BorrowedView borrowView = new BorrowedView();
		ShopView shop = new ShopView();
		/* Adding each panel to the tab */

		//tabbedPane.add("Order Stationary", stationaryShop);
		//tabbedPane.add("Order Books", publisherShop);
		tabbedPane.add("Order items", shop);
		tabbedPane.add("Validate Returns", borrowView);

		/**********************************
		 ******** 
		 * BORROWED BACKLOG ********
		 * 
		 **********************************/

	}

	void addLogoutListener(ActionListener listenForLogout) {
		btnLogout.addActionListener(listenForLogout);
	}
}