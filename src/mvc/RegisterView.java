package mvc;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
	private JPasswordField textPW = new JPasswordField();
	
	/* Labels */
	private JLabel userLabel = new JLabel("username: ");
	private JLabel pwLabel = new JLabel("password: ");
	
	private ArrayList<JTextField> all_fields;
	
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
	private JComboBox Faculty_comboBox;
	private final JPasswordField textConfirmPass = new JPasswordField();
	
	
	public RegisterView() {
	
		
		this.setSize(1041, 536);
		lblLoginHere.setBounds(491, 500, 93, 14);
		lblLoginHere.setForeground(Color.BLUE);
		lblConfirmPassword.setBounds(382, 407, 139, 22);
		lblConfirmPassword.setForeground(new Color(0, 191, 255));
		lblConfirmPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblUtid.setBounds(382, 254, 139, 22);
		lblUtid.setForeground(new Color(0, 191, 255));
		lblUtid.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblLastName.setBounds(382, 316, 139, 22);
		lblLastName.setForeground(new Color(0, 191, 255));
		lblLastName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblFirstName.setBounds(382, 285, 139, 22);
		lblFirstName.setForeground(new Color(0, 191, 255));
		lblFirstName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnRegister.setBounds(481, 471, 93, 23);
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblOfToronto.setForeground(new Color(0, 191, 255));
		lblOfToronto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 67));
		panel.setBounds(0, 5, 1028, 242);
		panel.setBackground(new Color(112, 128, 144));
		pwLabel.setBounds(382, 378, 139, 22);
		pwLabel.setForeground(new Color(0, 191, 255));
		pwLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		userLabel.setBounds(382, 349, 139, 22);
		userLabel.setForeground(new Color(0, 191, 255));
		userLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		
		textName = new JTextField(10);
		textName.setBounds(544, 285, 156, 20);
		
		textLastName = new JTextField(10);
		textLastName.setBounds(544, 316, 156, 20);
		
		textID = new JTextField(10);
		textID.setBounds(544, 254, 156, 20);
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
		textUsername.setBounds(544, 349, 156, 20);
		add(textUsername);
		add(pwLabel);
		textPW.setBounds(544, 380, 156, 20);
		add(textPW);
		add(lblConfirmPassword);
		textConfirmPass.setBounds(544, 411, 156, 20);
		add(textConfirmPass);
		add(btnRegister);
		add(lblLoginHere);
		add(lblUtid);
		add(textID);
		add(lblFirstName);
		add(textName);
		add(lblLastName);
		add(textLastName);
		
		
		all_fields= new ArrayList<JTextField>();
		all_fields.add(textUsername);
		all_fields.add(textName);
		all_fields.add(textLastName);
		all_fields.add(textID);
		all_fields.add(textPW);
		all_fields.add(textConfirmPass);
		
		String[] Faculty_Strings = {"Science", "Arts", "Engineering", "Business"};
		Faculty_comboBox = new JComboBox(Faculty_Strings);
		Faculty_comboBox.setBounds(544, 442, 156, 20);
		add(Faculty_comboBox);
		
		JLabel lblFaculty = new JLabel("Faculty:");
		lblFaculty.setForeground(new Color(0, 191, 255));
		lblFaculty.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblFaculty.setBounds(382, 438, 139, 22);
		add(lblFaculty);
		
		this.setVisible(true);
	}
	
	/* Getters and setters for various fields */
	public ArrayList<JTextField> getTextField(){
		return this.all_fields;
	}
	
	public String getUser() {
		return textUsername.getText();
	}
	
	public String getPW() {

		return String.valueOf(textPW.getPassword());
	}
	
	public String getPWconfirm() {
		return String.valueOf(textConfirmPass.getPassword());
	}
	
	
	void addRegisterListener(ActionListener listenForReg) {
		btnRegister.addActionListener(listenForReg);
	}
	
	
	public void setFalse() {
		this.setVisible(false);
	}
	
	public String GetFaculty() {
		return (String) Faculty_comboBox.getSelectedItem();
	}
	
	public String getID() {
		return this.textID.getText();
	}
	
	public String getFullName() {
		return this.textName.getText()+" "+this.textLastName.getText();
	}
	
	/*
	 * Adds a listener to the blue text so that the user can switch back to login
	 */
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
