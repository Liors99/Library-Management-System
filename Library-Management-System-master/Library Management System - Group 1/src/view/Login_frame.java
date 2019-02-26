package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.LoginVerifier;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.Map;

public class Login_frame extends JFrame {

	private JPanel bgPane;
	//private final Action action = new SwingAction();
	private JTextField password_textfield;
	private JTextField username_textfield;
	public JFrame frame;
	
	
	
	/**
	 * Create the frame.
	 */
	public Login_frame() {
		initialize();
		
	}
	
	private void initialize() {
		frame= new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 959, 617);
		bgPane = new JPanel();
		bgPane.setBackground(Color.DARK_GRAY);
		bgPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(bgPane);
		
		JPanel whitePane = new JPanel();
		
		JLabel uniof_label = new JLabel("UNIVERSITY OF");
		uniof_label.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		uniof_label.setForeground(new Color(0, 191, 255));
		uniof_label.setBackground(new Color(0, 191, 255));
		
		JLabel toronto_label = new JLabel("TORONTO");
		toronto_label.setFont(new Font("Segoe UI", Font.BOLD, 46));
		toronto_label.setForeground(new Color(0, 191, 255));
		GroupLayout gl_bgPane = new GroupLayout(bgPane);
		gl_bgPane.setHorizontalGroup(
			gl_bgPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bgPane.createSequentialGroup()
					.addContainerGap(179, Short.MAX_VALUE)
					.addGroup(gl_bgPane.createParallelGroup(Alignment.LEADING)
						.addComponent(toronto_label, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
						.addComponent(uniof_label, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addComponent(whitePane, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE))
		);
		gl_bgPane.setVerticalGroup(
			gl_bgPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bgPane.createSequentialGroup()
					.addGap(233)
					.addComponent(uniof_label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toronto_label, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(261))
				.addGroup(Alignment.LEADING, gl_bgPane.createSequentialGroup()
					.addComponent(whitePane, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
					.addGap(26))
		);
		
		password_textfield = new JTextField();
		password_textfield.setText("password");
		password_textfield.setForeground(Color.LIGHT_GRAY);
		password_textfield.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		password_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		password_textfield.setColumns(10);
		
		username_textfield = new JTextField();
		username_textfield.setToolTipText("");
		username_textfield.setForeground(Color.LIGHT_GRAY);
		username_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		username_textfield.setText("UTID");
		username_textfield.setColumns(10);
		
		JButton login_button = new JButton("login");
		login_button.setBackground(new Color(240, 128, 128));
		
		JLabel ClickToRegister_btn = new JLabel("<html><u> New? Click here to register </u></html>");
		
		ClickToRegister_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ClickToRegister_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Register_frame reg = new Register_frame();
				reg.frame.setVisible(true);
			}
		});
		ClickToRegister_btn.setForeground(Color.BLUE);
		ClickToRegister_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_whitePane = new GroupLayout(whitePane);
		gl_whitePane.setHorizontalGroup(
			gl_whitePane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_whitePane.createSequentialGroup()
					.addGroup(gl_whitePane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_whitePane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_whitePane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(login_button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(password_textfield, Alignment.LEADING)
								.addComponent(username_textfield, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)))
						.addGroup(gl_whitePane.createSequentialGroup()
							.addGap(150)
							.addComponent(ClickToRegister_btn)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_whitePane.setVerticalGroup(
			gl_whitePane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_whitePane.createSequentialGroup()
					.addContainerGap(271, Short.MAX_VALUE)
					.addComponent(username_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(password_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(login_button, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ClickToRegister_btn)
					.addGap(196))
		);
		whitePane.setLayout(gl_whitePane);
		bgPane.setLayout(gl_bgPane);
		
		
		
		/* --------------------------------------------------------------------------
		 * --------------------------- MANUAL CODE ----------------------------------
		 */
		
		login_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
					if(LoginVerifier.VerifyLogin(username_textfield.getText(), password_textfield.getText())) {
						frame.dispose();
						Authenticated_frame auth = new Authenticated_frame();
						auth.frame.setVisible(true);
					}
					else {
						System.out.println("PROBLEM");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
	}
}
