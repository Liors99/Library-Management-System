package mvc;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.BooksAndStuff;

public class FacultyView extends JPanel {
	private JTextField textField;
	
	public FacultyView() {
		setBackground(new Color(255, 255, 255));
		
		this.setBounds(155, 62, 835, 457);
		
		JLabel lblNewLabel = new JLabel("search:");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		
		JLabel notFound = new JLabel("");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(notFound)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(searchBtn)
					.addContainerGap(502, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBtn))
					.addGap(32)
					.addComponent(notFound)
					.addContainerGap(374, Short.MAX_VALUE))
		);
		
		//	searchButton.addActionListener(new ActionListener() {
	//		public void actionPerformed(ActionEvent e) {
//			}
//		});
		notFound.setVisible(false);
		
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BooksAndStuff book = new BooksAndStuff();
				
					if(book.findBook(textField.getText())) {
						//frame.dispose();
						book.findBook(textField.getText());
						book.getBookData(textField.getText());
						ReserveView b_frame = new ReserveView("Reserve");
						b_frame.frame.setVisible(true);
						
						BookModel model = new BookModel();
						
						ReserveController controller = new ReserveController(book, b_frame, model);
					}
					else {
						notFound.setVisible(true);
						notFound.setText("Sorry, that book could not be found in our records");
						//System.out.println("PROBLEM");
					}
				 
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
			
			
		});
	
		
		setLayout(groupLayout);
		
	}
}
