package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Borrow_frame extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Borrow_frame() {
		frame= new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 959, 617);
		frame.setTitle("UofT Library");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		JPanel topbar_panel = new JPanel();
		topbar_panel.setBackground(new Color(135, 206, 235));
		
		JPanel sidebar_panel = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(topbar_panel, GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(sidebar_panel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(topbar_panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sidebar_panel, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("search:");
		lblSearch.setForeground(new Color(0, 191, 255));
		lblSearch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("test book");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 762, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblSearch)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearch)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(lblNewLabel)
					.addGap(329)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		panel.setLayout(gl_panel);
		
		JButton room_button = new JButton("book room");

		JButton borrow_button = new JButton("borrow");
		
		JButton order_button = new JButton("order");

		GroupLayout gl_sidebar_panel = new GroupLayout(sidebar_panel);
		gl_sidebar_panel.setHorizontalGroup(
			gl_sidebar_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_sidebar_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_sidebar_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(borrow_button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(order_button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
				.addGroup(Alignment.LEADING, gl_sidebar_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(room_button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_sidebar_panel.setVerticalGroup(
			gl_sidebar_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidebar_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(borrow_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(order_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(room_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(336))
		);
		sidebar_panel.setLayout(gl_sidebar_panel);
		
		JLabel lblUniversityOfToronto = new JLabel("UNIVERSITY OF TORONTO");
		lblUniversityOfToronto.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUniversityOfToronto.setForeground(new Color(255, 255, 255));
		GroupLayout gl_topbar_panel = new GroupLayout(topbar_panel);
		gl_topbar_panel.setHorizontalGroup(
			gl_topbar_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_topbar_panel.createSequentialGroup()
					.addContainerGap(377, Short.MAX_VALUE)
					.addComponent(lblUniversityOfToronto)
					.addGap(368))
		);
		gl_topbar_panel.setVerticalGroup(
			gl_topbar_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_topbar_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblUniversityOfToronto)
					.addContainerGap())
		);
		topbar_panel.setLayout(gl_topbar_panel);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
