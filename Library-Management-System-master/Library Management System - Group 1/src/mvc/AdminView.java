package mvc;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class AdminView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AdminView() {
		
		JPanel topBar = new JPanel();
		topBar.setBackground(new Color(0, 191, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(topBar, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(243, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
					.addGap(241))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(topBar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel lblAddUser = new JLabel("add user");
		lblAddUser.setBounds(10, 11, 67, 23);
		lblAddUser.setForeground(new Color(60, 179, 113));
		lblAddUser.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(17, 52, 60, 20);
		lblUsername.setForeground(new Color(0, 191, 255));
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setBounds(17, 86, 59, 20);
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(115, 54, 163, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 88, 163, 20);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.setBounds(296, 85, 105, 25);
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("remove users");
		lblNewLabel_1.setBounds(10, 371, 105, 23);
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("user to remove");
		lblNewLabel_2.setBounds(18, 412, 93, 20);
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 414, 157, 20);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("remove");
		btnNewButton_1.setBounds(296, 412, 105, 23);
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		
		JLabel lblEditUser = new JLabel("edit user");
		lblEditUser.setBounds(10, 154, 69, 23);
		lblEditUser.setForeground(new Color(255, 165, 0));
		lblEditUser.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("user to edit");
		lblNewLabel_3.setBounds(18, 195, 71, 20);
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setBounds(115, 197, 163, 20);
		textField_3.setColumns(10);
		
		JLabel lblSetUserRank = new JLabel("set user rank");
		lblSetUserRank.setBounds(17, 250, 79, 20);
		lblSetUserRank.setForeground(new Color(0, 191, 255));
		lblSetUserRank.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		String[] rankStrings = {"Student", "Libraian", "Admin", "Staff", "Faculty"};
		JComboBox rankComboBox = new JComboBox(rankStrings);
		rankComboBox.setBounds(115, 252, 163, 20);
		
		JLabel lblNewLabel_4 = new JLabel("clear fees");
		lblNewLabel_4.setBounds(18, 302, 59, 20);
		lblNewLabel_4.setForeground(new Color(0, 191, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		JRadioButton rdbtnClearFee = new JRadioButton("");
		rdbtnClearFee.setBounds(117, 302, 21, 21);
		
		JButton btnNewButton_2 = new JButton("apply changes");
		btnNewButton_2.setBounds(296, 302, 105, 23);
		btnNewButton_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		panel.setLayout(null);
		panel.add(lblAddUser);
		panel.add(lblNewLabel);
		panel.add(lblUsername);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(btnNewButton);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel_2);
		panel.add(textField_2);
		panel.add(btnNewButton_1);
		panel.add(lblEditUser);
		panel.add(lblNewLabel_4);
		panel.add(rdbtnClearFee);
		panel.add(btnNewButton_2);
		panel.add(lblSetUserRank);
		panel.add(rankComboBox);
		panel.add(lblNewLabel_3);
		panel.add(textField_3);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setForeground(new Color(165, 42, 42));
		lblAdmin.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		topBar.add(lblAdmin);
		setLayout(groupLayout);

	}
}
