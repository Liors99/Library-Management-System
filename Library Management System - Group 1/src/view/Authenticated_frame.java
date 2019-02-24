package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Authenticated_frame extends JFrame {

	private JPanel contentPane;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_frame frame = new Login_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public Authenticated_frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		
		JLabel name_descriptor = new JLabel("Name:");
		name_descriptor.setForeground(new Color(0, 191, 255));
		name_descriptor.setFont(new Font("Segoe UI", Font.BOLD, 19));
		
		JLabel varName_label = new JLabel("student var");
		varName_label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel id_descriptor = new JLabel("ID:");
		id_descriptor.setFont(new Font("Segoe UI", Font.BOLD, 19));
		id_descriptor.setForeground(new Color(0, 191, 255));
		
		JLabel varID_label = new JLabel("id var");
		varID_label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(name_descriptor)
							.addGap(7)
							.addComponent(varName_label))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(id_descriptor))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(varID_label)))
					.addContainerGap(651, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(26, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 762, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(name_descriptor)
						.addComponent(varName_label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(id_descriptor)
						.addComponent(varID_label))
					.addGap(28)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		panel.setLayout(gl_panel);
		
		JButton order_button = new JButton("book room");
		order_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton room_button = new JButton("borrow");
		
		JButton borrow_button = new JButton("order");
		borrow_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_sidebar_panel = new GroupLayout(sidebar_panel);
		gl_sidebar_panel.setHorizontalGroup(
			gl_sidebar_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidebar_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_sidebar_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_sidebar_panel.createSequentialGroup()
							.addComponent(borrow_button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_sidebar_panel.createSequentialGroup()
							.addComponent(order_button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(Alignment.TRAILING, gl_sidebar_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(room_button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
					.addGap(334))
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
