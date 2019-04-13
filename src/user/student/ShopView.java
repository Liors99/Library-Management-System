package user.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class ShopView extends JPanel {

	public ShopView() {
		setBackground(Color.LIGHT_GRAY);

		this.setBounds(155, 62, 835, 457);
										setLayout(new GridLayout(0, 3, 0, 0));
										
										JLabel label = new JLabel("");
										add(label);
										
										JLabel label_1 = new JLabel("");
										add(label_1);
										
										JLabel label_2 = new JLabel("");
										add(label_2);
										
										JLabel label_4 = new JLabel("");
										add(label_4);
										
												JButton btnNewButton = new JButton("OFFICE SUPPLIES");
												btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
												btnNewButton.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
													}
												});
												add(btnNewButton);
										
										JLabel label_5 = new JLabel("");
										add(label_5);
										
										JLabel label_6 = new JLabel("");
										add(label_6);
										
										JLabel label_7 = new JLabel("");
										add(label_7);
										
										JLabel label_8 = new JLabel("");
										add(label_8);
										
										JLabel label_9 = new JLabel("");
										add(label_9);
										
										JLabel label_10 = new JLabel("");
										add(label_10);
										
										JLabel label_11 = new JLabel("");
										add(label_11);
										
										JLabel label_12 = new JLabel("");
										add(label_12);
										
												JButton btnBooks = new JButton("BOOKS");
												btnBooks.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
												btnBooks.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
													}
												});
												add(btnBooks);
										
										JLabel label_13 = new JLabel("");
										add(label_13);
										
										JLabel label_14 = new JLabel("");
										add(label_14);
										
										JLabel label_15 = new JLabel("");
										add(label_15);
										
										JLabel label_16 = new JLabel("");
										add(label_16);
										
										JLabel label_17 = new JLabel("");
										add(label_17);
										
										JLabel label_18 = new JLabel("");
										add(label_18);
										
										JLabel label_19 = new JLabel("");
										add(label_19);
										
										JLabel label_20 = new JLabel("");
										add(label_20);
										
												JButton btnClothing = new JButton("CLOTHING");
												btnClothing.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
												add(btnClothing);
										
										JLabel label_21 = new JLabel("");
										add(label_21);
										
										JLabel label_22 = new JLabel("");
										add(label_22);
										
										JLabel label_23 = new JLabel("");
										add(label_23);
										
										JLabel label_24 = new JLabel("");
										add(label_24);

	}
}
