package user.faculty;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.BooksAndStuff;
import database.User;
import mvc.ControllerInterface;
import mvc.LoginModel;
import mvc.LoginView;
import mvc.MainFrame;
import mvc.systemController;
import user.student.ReserveController;
import user.student.ReserveView;

public class FacultyView extends JPanel implements ControllerInterface {
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPanel faculty_view;

	public FacultyView(MainFrame frame) {
		faculty_view = this;

		setBackground(new Color(255, 255, 255));

		this.setBounds(155, 62, 835, 457);

		JLabel lblNewLabel = new JLabel("FACULTY: " + User.getFaculty(User.getCurrentUserName()) + "    search:");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		textField = new JTextField();
		textField.setColumns(10);

		JButton searchBtn = new JButton("Search");

		JLabel notFound = new JLabel("");

		lblNewLabel_1 = new JLabel(User.getFaculty("FACULTY: " + User.getCurrentUserName()));
		lblNewLabel_1.setVisible(true);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginView log_view = new LoginView();
				LoginModel log_model = new LoginModel();
				systemController log_con = new systemController(log_view, log_model, frame);

				setPanel(faculty_view, log_view, frame);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(notFound)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(18).addComponent(searchBtn))
						.addGroup(groupLayout.createSequentialGroup().addGap(85).addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnLogout,
								GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(411, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchBtn))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1).addGap(10)
						.addComponent(notFound).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLogout)
						.addContainerGap(356, Short.MAX_VALUE)));

		// searchButton.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {

		notFound.setVisible(false);

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BooksAndStuff book = new BooksAndStuff();

				if (book.findBook(textField.getText())) {
					// frame.dispose();
					book.findBook(textField.getText());
					book.getBookData(textField.getText());
					ReserveView b_frame = new ReserveView("Reserve");
					b_frame.frame.setVisible(true);

					ReserveController controller = new ReserveController(book, b_frame);
				} else {
					notFound.setVisible(true);
					notFound.setText("Sorry, that book could not be found in our records");
					// System.out.println("PROBLEM");
				}

				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		});

		setLayout(groupLayout);

	}
}
