package mvc;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import mvc.RegisterController.LoginScreenListener;
import mvc.systemController.RegisterScreenListener;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;


public class RegisterView extends JPanel {
	
	/* Text fields */
	private JTextField textUsername = new JTextField(10);
	private JPasswordField textPW = new JPasswordField(10);
	
	/* Labels */
	private JLabel userLabel = new JLabel("username: ");
	private JLabel pwLabel = new JLabel("password: ");
	
	private final JPanel panel = new JPanel();
	private final JLabel lblUNIVERSITY = new JLabel("UNIVERSITY");
	private final JLabel lblOfToronto = new JLabel("OF TORONTO");
	private final JButton btnRegister = new JButton("register");
	private final JLabel lblFirstName = new JLabel("first name: ");
	private final JLabel lblLastName = new JLabel("last name: ");
	private final JLabel lblUtid = new JLabel("UTID: ");
	private final JLabel lblConfirmPassword = new JLabel("confirm password: ");
	private final JLabel lblLoginHere = new JLabel("or login here");
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textID;
	private final JPasswordField textConfirmPass = new JPasswordField(10);
	
	
	public RegisterView() {
	
		
		this.setSize(1041, 536);
		lblLoginHere.setBounds(502, 499, 93, 14);
		lblLoginHere.setForeground(Color.BLUE);
		lblConfirmPassword.setBounds(382, 432, 139, 22);
		lblConfirmPassword.setForeground(new Color(0, 191, 255));
		lblConfirmPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblUtid.setBounds(382, 267, 44, 22);
		lblUtid.setForeground(new Color(0, 191, 255));
		lblUtid.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblLastName.setBounds(382, 333, 77, 22);
		lblLastName.setForeground(new Color(0, 191, 255));
		lblLastName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblFirstName.setBounds(382, 300, 81, 22);
		lblFirstName.setForeground(new Color(0, 191, 255));
		lblFirstName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnRegister.setBounds(490, 465, 93, 23);
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblOfToronto.setForeground(new Color(0, 191, 255));
		lblOfToronto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 67));
		panel.setBounds(0, 5, 1028, 242);
		panel.setBackground(new Color(112, 128, 144));
		pwLabel.setBounds(382, 399, 78, 22);
		pwLabel.setForeground(new Color(0, 191, 255));
		pwLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		userLabel.setBounds(382, 366, 79, 22);
		userLabel.setForeground(new Color(0, 191, 255));
		userLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		
		textName = new JTextField(10);
		textName.setBounds(544, 304, 156, 20);
		
		textLastName = new JTextField(10);
		textLastName.setBounds(544, 335, 156, 20);
		
		textID = new JTextField(10);
		textID.setBounds(544, 271, 156, 20);
		setLayout(null);
		lblUNIVERSITY.setForeground(new Color(0, 191, 255));
		lblUNIVERSITY.setFont(new Font("Segoe UI Black", Font.PLAIN, 71));
		add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(313)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUNIVERSITY)
						.addComponent(lblOfToronto)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(lblUNIVERSITY)
					.addGap(6)
					.addComponent(lblOfToronto))
		);
		panel.setLayout(gl_panel);
		add(userLabel);
		textUsername.setBounds(544, 370, 156, 20);
		add(textUsername);
		add(pwLabel);
		textPW.setBounds(544, 401, 156, 20);
		add(textPW);
		add(lblConfirmPassword);
		textConfirmPass.setBounds(544, 432, 156, 20);
		add(textConfirmPass);
		add(btnRegister);
		add(lblLoginHere);
		add(lblUtid);
		add(textID);
		add(lblFirstName);
		add(textName);
		add(lblLastName);
		add(textLastName);
		this.setVisible(true);
	}
	
	public String getUser() {
		return textUsername.getText();
	}
	
	public String getPW() {

		return textPW.getText();
	}
	
	public String getPWconfirm() {
		return textConfirmPass.getText();
	}
	
	
	void addRegisterListener(ActionListener listenForReg) {
		btnRegister.addActionListener(listenForReg);
	}
	
	
	public void setFalse() {
		this.setVisible(false);
	}
	
	
	void addLoginScreenListener(LoginScreenListener log) {
		lblLoginHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.SwitchView();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLoginHere.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
	}
}
