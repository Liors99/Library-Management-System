package mvc;

//package view;

import java.awt.Color;


import common.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.BooksAndStuff;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class UserEditView {
	
	
	private JPanel contentPane;
	public JFrame frame;
	public JLabel lblNewlbl2;
	public JLabel lblNewLabel_2; 
	public JButton edit_button;
	public JButton btnBackToSearch;
	private JComboBox rankComboBox;
	private JButton btnDeleteUser;
	
	private String username;
	private JLabel lblName;
	private JLabel lbl_ID;
	private JLabel lblPriv;
	private JLabel lbl_books;

	

	public UserEditView() {
		
		frame= new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 959, 617);
		frame.setTitle("UofT Library");

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		
		btnBackToSearch = new JButton("Back");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addComponent(btnBackToSearch)
					.addGap(24))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(41)
					.addComponent(btnBackToSearch)
					.addContainerGap(552, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(227, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(111, 23, 72, 13);
		
		lblNewlbl2 = new JLabel("ID:");
		lblNewlbl2.setBounds(10, 96, 53, 13);
		
		JLabel lblNewLabel_1 = new JLabel("Privilege:");
		lblNewLabel_1.setBounds(10, 119, 78, 13);
		
		lblNewLabel_2 = new JLabel("Books borrowed:");
		lblNewLabel_2.setBounds(10, 142, 114, 13);
		
		 edit_button = new JButton("Apply changes");
		 edit_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		 edit_button.setBounds(129, 344, 114, 54);
		 edit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(gl_contentPane);

		String[] rankStrings = {"Student", "Librarian", "Admin", "Staff", "Faculty"};
		panel.setLayout(null);
		rankComboBox = new JComboBox(rankStrings);
		rankComboBox.setBounds(99, 297, 163, 20);
		panel.add(rankComboBox);
		panel.add(edit_button);
		panel.add(lblNewLabel_1);
		panel.add(lblNewlbl2);
		panel.add(lblNewLabel_2);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnClearFee = new JRadioButton("");
		rdbtnClearFee.setBounds(162, 251, 21, 21);
		panel.add(rdbtnClearFee);
		
		btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBackground(Color.RED);
		btnDeleteUser.setBounds(129, 436, 114, 54);
		panel.add(btnDeleteUser);
		
		JLabel lblClearFees = new JLabel("Clear fees:");
		lblClearFees.setBounds(95, 251, 61, 21);
		panel.add(lblClearFees);
		
		lblName = new JLabel("");
		lblName.setBounds(181, 23, 46, 13);
		panel.add(lblName);
		
		lbl_ID = new JLabel("");
		lbl_ID.setBounds(99, 96, 46, 13);
		panel.add(lbl_ID);
		
		lblPriv = new JLabel("");
		lblPriv.setBounds(99, 119, 46, 13);
		panel.add(lblPriv);
		
		lbl_books = new JLabel("");
		lbl_books.setBounds(95, 142, 46, 13);
		panel.add(lbl_books);
		
		
	}
	
	
	public void setNameDisplay(String name) {
		this.lblName.setText(name);
	}
	public void setUsername(String name) {
		this.username=name;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String GetRankValue() {
		return (String) rankComboBox.getSelectedItem();
	}
	
	public void addUserRemoveListener(ActionListener listenRemove) {
		btnDeleteUser.addActionListener(listenRemove);
	}
	
	public void addEditUserListener(ActionListener e) {
		edit_button.addActionListener(e);
	}
	public void addBackListener(ActionListener e) {
		btnBackToSearch.addActionListener(e);
	}
}