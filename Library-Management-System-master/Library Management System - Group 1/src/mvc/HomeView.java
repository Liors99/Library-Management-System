package mvc;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class HomeView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JButton btnBorrow;
	private JButton btnShop;
	private JPanel cards;
	private CardLayout cl;
	private BorrowView borrow;
	private ShopView shop;
	private JPanel defaultcard;
	private JLabel lblName;
	private JLabel nameVar;
	
	public HomeView() {
		
		JPanel menuBar = new JPanel();
		menuBar.setBounds(10, 62, 140, 457);
		menuBar.setBackground(Color.LIGHT_GRAY);
		
		JPanel topBar = new JPanel();
		topBar.setBounds(10, 11, 980, 45);
		topBar.setBackground(new Color(0, 191, 255));
		
		cards = new JPanel(new CardLayout());
		cards.setBounds(156, 62, 834, 457);
		cards.setBackground(new Color(255, 255, 255));
		
		JLabel lblUniversityOfToronto = new JLabel("UNIVERSITY OF TORONTO");
		lblUniversityOfToronto.setForeground(new Color(255, 255, 255));
		lblUniversityOfToronto.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		topBar.add(lblUniversityOfToronto);
		
		btnBorrow = new JButton("borrow");
		
		btnShop = new JButton("shop");
		GroupLayout gl_menuBar = new GroupLayout(menuBar);
		gl_menuBar.setHorizontalGroup(
			gl_menuBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuBar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menuBar.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBorrow, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(btnShop, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_menuBar.setVerticalGroup(
			gl_menuBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuBar.createSequentialGroup()
					.addGap(30)
					.addComponent(btnBorrow)
					.addGap(18)
					.addComponent(btnShop)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		menuBar.setLayout(gl_menuBar);
		setLayout(null);
		add(cards);
		add(menuBar);
		add(topBar);
		
		
		/* Manual code */
				
		borrow = new BorrowView();
		shop = new ShopView();
		
		defaultcard = new JPanel();
		cards.add(defaultcard, "name_93905002767489");
		
		lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblName.setForeground(new Color(0, 191, 255));
		
		nameVar = new JLabel("");
		nameVar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_defaultcard = new GroupLayout(defaultcard);
		gl_defaultcard.setHorizontalGroup(
			gl_defaultcard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_defaultcard.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameVar)
					.addContainerGap(717, Short.MAX_VALUE))
		);
		gl_defaultcard.setVerticalGroup(
			gl_defaultcard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_defaultcard.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_defaultcard.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameVar))
					.addContainerGap(432, Short.MAX_VALUE))
		);
		defaultcard.setLayout(gl_defaultcard);
		
		cards.add(borrow, "Borrow");
		cards.add(shop, "Shop");
		cl = (CardLayout)(cards.getLayout());

	}
	
	
	/* Adding listener for buttons */
	void addBorrowListener(ActionListener listenForBorrow) {
		
		btnBorrow.addActionListener(listenForBorrow);
	}
	
	void addShopListener(ActionListener listenForShop) {
		
		btnShop.addActionListener(listenForShop);
	}
	
	public void switchToBorrow() {
		cl.show(borrow, "Borrow");
	}
	
	public void switchToShop() {
		cl.show(shop,  "Shop");
	}
	
	public void setName(String name) {
		nameVar.setText(name);
	}
}
