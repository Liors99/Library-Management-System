package mvc;

//package view;

import java.awt.Color;


import common.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class Book_view {
	private JPanel contentPane;
	public JFrame frame;
//	public BooksAndStuff book;
	public JLabel name_label;
	public JLabel author_label; 
	public JButton order_button;
	public JButton btnBackToSearch;
	//name_label.setText(book.getName());
	//author_label.setText(book.getAuthor());
	

	public Book_view() {
	//	this.book = book;
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
		
		btnBackToSearch = new JButton("Back to Search");
		
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
		
		JLabel lblNewLabel = new JLabel("Name:");
		
		 name_label = new JLabel("Name:");
		
		JLabel lblNewLabel_1 = new JLabel("Author:");
		
		 author_label = new JLabel("New label");
		
		order_button = new JButton("Reserve");
		//System.out.println("author: " + book.getAuthor());
		
		
		
	/*	order_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int total = book.getTotal();
				int numCheckedOut = book.getCheckedOut();
				if(numCheckedOut >= total) {
					System.out.println("All copies are currently unavailable");
				}else {
					book.getDataParser().performUpdate("UPDATE books_and_others SET qCheckedOut = " + (numCheckedOut + 10) + " WHERE name = '" + book.getName() + "'" );;
				}
			} }); */
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(154, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(name_label)
						.addComponent(order_button, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(author_label))
					.addGap(124))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(name_label)
					.addGap(27)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(author_label)
					.addGap(72)
					.addComponent(order_button, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(350, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	//	name_label.setText(book.getName());
	//	author_label.setText(book.getAuthor());
		
	/*	btnBackToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//Borrow_frame borrow = new Borrow_frame();
				//borrow.frame.setVisible(true);
			}
			
		}); */
		//back_
		
		
	}
	
	public void addOrderListener(ActionListener e) {
		order_button.addActionListener(e);
	}
	public void addBackListener(ActionListener e) {
		btnBackToSearch.addActionListener(e);
	}
	
}