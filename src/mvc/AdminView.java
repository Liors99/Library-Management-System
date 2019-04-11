package mvc;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.BooksAndStuff;
import database.DataParser;
import database.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminView extends JPanel {
	
	private JTable tableUsers;
	
	private DefaultTableModel tableModel;
	
	private String[] columnNames = {"Username", "ID","Name","Rank"};
	private JTextField textFieldSearch;
	
	private AdminView view;

	
	private JButton btnLogout;

	/**
	 * Create the panel.
	 */
	public AdminView() {
		
		view=this;
		
		JPanel topBar = new JPanel();
		topBar.setBackground(new Color(0, 191, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(topBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(153)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(topBar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		
		String[] rankStrings = {"Student", "Librarian", "Admin", "Staff", "Faculty"};
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 100, 662, 280);
		panel.add(scrollPane);
		
		
		tableModel = new DefaultTableModel(columnNames, 0) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		
		tableUsers = new JTable(tableModel);
		scrollPane.setViewportView(tableUsers);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(315, 37, 85, 21);
		panel.add(btnSearch);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(102, 37, 179, 19);
		panel.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		tableUsers.getTableHeader().setResizingAllowed(false);
		tableUsers.getTableHeader().setReorderingAllowed(false);
		
		
		//Adds functionality to open book view after search
		tableUsers.getSelectionModel().addListSelectionListener(
				    new ListSelectionListener() {
				    	@Override
				        public void valueChanged(ListSelectionEvent e) {
				    		if (!e.getValueIsAdjusting()) { 
				        		int i = tableUsers.getSelectedRow();
				        		if(i >= 0) {
				        			
				        			String name = (String) tableModel.getValueAt(i, 0);
				        			
				        			UserEditView user_frame= new UserEditView();
				        			user_frame.setNameDisplay(name);
				        			user_frame.setID((String) tableModel.getValueAt(i, 1));
				        			UserEditModel user_model = new UserEditModel();
				        			UserEditController user_cont= new UserEditController(user_frame, user_model, name, view);
				        			user_frame.frame.setVisible(true);
				        		}
				        	}
				        }
				    });
		
		
		//Initializes with all items showing
		DataParser d = new DataParser();
		ResultSet r = null;
		
		//Performs search based on input and filter. Defaults to Title search
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				initTable();
			}
			
		});
		
		
		topBar.setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setBounds(452, 11, 92, 35);
		lblAdmin.setForeground(new Color(165, 42, 42));
		lblAdmin.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		topBar.add(lblAdmin);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBounds(25, 23, 89, 23);
		topBar.add(btnLogout);
		setLayout(groupLayout);
		

	}

	public DefaultTableModel getTableModel() {
		return this.tableModel;
	}
	
	void addLogoutListener(ActionListener listenForLogout) {
		btnLogout.addActionListener(listenForLogout);
	}
	
	
	public void initTable() {
		tableModel.setRowCount(0);
		DataParser d = new DataParser();
		ResultSet r = null;
		tableUsers.revalidate();
		String term = textFieldSearch.getText();
		r= d.searchUser(textFieldSearch.getText());
		try {
			while(r.next()) {
				String username = r.getString("username");
				String ID=User.getID(username);
				String name= User.getName(username);
				String Rank="";
				switch(User.getAccountType(username)) {
					case 0:
						Rank = "Student";
					case 1:
						Rank= "Student";
						break;
					case 2:
						Rank="Admin";
						break;
					case 3:
						Rank="Librarian";
						break;
					case 4:
						Rank="Faculty";
						break;
					default:
						break;
				}
				Object[] objs = {username,ID,name,Rank};
				tableModel.addRow(objs);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
