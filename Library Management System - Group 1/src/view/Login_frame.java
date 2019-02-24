package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login_frame extends JFrame {

	private JPanel bgPane;
	//private final Action action = new SwingAction();
	private JTextField username_textfield;
	private JTextField password_textfield;
	
	/* Setup login frame */
	
	static Login_frame frame = new Login_frame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 617);
		bgPane = new JPanel();
		bgPane.setBackground(Color.DARK_GRAY);
		bgPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bgPane);
		
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
		
		username_textfield = new JTextField();
		username_textfield.setText("password");
		username_textfield.setForeground(Color.LIGHT_GRAY);
		username_textfield.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		username_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		username_textfield.setColumns(10);
		
		password_textfield = new JTextField();
		password_textfield.setToolTipText("");
		password_textfield.setForeground(Color.LIGHT_GRAY);
		password_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		password_textfield.setText("UTID");
		password_textfield.setColumns(10);
		
		JButton login_button = new JButton("login");
		login_button.setBackground(new Color(240, 128, 128));
		GroupLayout gl_whitePane = new GroupLayout(whitePane);
		gl_whitePane.setHorizontalGroup(
			gl_whitePane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_whitePane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_whitePane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(login_button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(username_textfield, Alignment.LEADING)
						.addComponent(password_textfield, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_whitePane.setVerticalGroup(
			gl_whitePane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_whitePane.createSequentialGroup()
					.addContainerGap(263, Short.MAX_VALUE)
					.addComponent(password_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(username_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(login_button, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(227))
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
				System.out.println("btn pressed");

				frame.dispose();
				Authenticated_frame auth_frame = new Authenticated_frame();
				auth_frame.setVisible(true);
			}
			
		});
	}
}
