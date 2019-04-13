package mvc;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import mvc.systemController.RegisterScreenListener;

public class LoginView extends JPanel {

	/* Buttons */
	private JButton loginB = new JButton("login");

	/* Text fields */
	private JTextField userTF = new JTextField(10);
	private JPasswordField pwTF = new JPasswordField();

	/* Labels */
	private JLabel userLabel = new JLabel("username: ");
	private JLabel pwLabel = new JLabel("password: ");

	private final JPanel panel = new JPanel();
	private final JLabel lblUNIVERSITY = new JLabel("UNIVERSITY");
	private final JLabel lblOfToronto = new JLabel("OF TORONTO");
	private final JLabel lblRegister = new JLabel("New? Click here to register");

	public LoginView() {

		lblOfToronto.setForeground(new Color(0, 191, 255));
		lblOfToronto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 67));
		panel.setBackground(new Color(112, 128, 144));
		loginB.setBackground(Color.LIGHT_GRAY);
		loginB.setForeground(new Color(0, 0, 0));
		loginB.setFont(new Font("Segoe UI", Font.BOLD, 11));
		pwLabel.setForeground(new Color(0, 191, 255));
		pwLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		userLabel.setForeground(new Color(0, 191, 255));
		userLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		this.setBackground(new Color(255, 255, 255));
		this.setSize(1000, 560);

		lblRegister.setForeground(Color.BLUE);
		lblRegister.setBackground(Color.BLUE);
		GroupLayout gl_display = new GroupLayout(this);
		gl_display.setHorizontalGroup(gl_display.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
				.addGroup(gl_display.createSequentialGroup().addContainerGap(398, Short.MAX_VALUE)
						.addGroup(gl_display
								.createParallelGroup(Alignment.TRAILING).addComponent(pwLabel).addComponent(userLabel))
						.addGap(18)
						.addGroup(gl_display.createParallelGroup(Alignment.LEADING, false).addComponent(userTF)
								.addComponent(pwTF).addComponent(loginB, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(413))
				.addGroup(gl_display.createSequentialGroup().addContainerGap(476, Short.MAX_VALUE)
						.addComponent(lblRegister).addGap(390)));
		gl_display.setVerticalGroup(gl_display.createParallelGroup(Alignment.TRAILING).addGroup(gl_display
				.createSequentialGroup().addContainerGap()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
				.addGroup(gl_display.createParallelGroup(Alignment.BASELINE)
						.addComponent(userTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(userLabel))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_display.createParallelGroup(Alignment.BASELINE).addComponent(pwLabel).addComponent(pwTF,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(loginB).addGap(45).addComponent(lblRegister)
				.addGap(33)));
		lblUNIVERSITY.setForeground(new Color(0, 191, 255));
		lblUNIVERSITY.setFont(new Font("Segoe UI Black", Font.PLAIN, 71));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel
						.createSequentialGroup().addGap(313).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOfToronto).addComponent(lblUNIVERSITY))
						.addContainerGap(251, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(42).addComponent(lblUNIVERSITY)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblOfToronto)
						.addContainerGap(65, Short.MAX_VALUE)));

		panel.setLayout(gl_panel);
		this.setLayout(gl_display);
		this.setVisible(true);
	}

	public String getUser() {
		return userTF.getText();
	}

	public String getPW() {

		return String.valueOf(pwTF.getPassword());
	}

	void addLoginListener(ActionListener listenForLogin) {

		loginB.addActionListener(listenForLogin);
	}

	/**
	 * Changes the screen to the registration screen
	 * 
	 * @param reg
	 */
	void addRegisterScreenListener(RegisterScreenListener reg) {
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reg.SwitchView();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
	}

}
