package mvc;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ItemView extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	JButton btnOrder = new JButton("Order");
	String name;
	String price;
	JPanel message = new JPanel();
	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemView frame = new ItemView("Name", "$00.00");
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
	public ItemView(String name, String price) {
		this.name = name;
		this.price = price;
		frame= new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 959, 617);
		frame.setTitle("UofT Library");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName_1 = new JLabel("Name");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_1.gridx = 2;
		gbc_lblName_1.gridy = 2;
		panel.add(lblName_1, gbc_lblName_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		GridBagConstraints gbc_lblPrice_1 = new GridBagConstraints();
		gbc_lblPrice_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrice_1.gridx = 9;
		gbc_lblPrice_1.gridy = 2;
		panel.add(lblPrice_1, gbc_lblPrice_1);
		
		JLabel lblName = new JLabel(name);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 3;
		panel.add(lblName, gbc_lblName);
		
		JLabel lblPrice = new JLabel(price);
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrice.gridx = 9;
		gbc_lblPrice.gridy = 3;
		panel.add(lblPrice, gbc_lblPrice);
		
		GridBagConstraints gbc_btnOrder = new GridBagConstraints();
		gbc_btnOrder.insets = new Insets(0, 0, 0, 5);
		gbc_btnOrder.gridx = 2;
		gbc_btnOrder.gridy = 8;
		panel.add(btnOrder, gbc_btnOrder);
		addOrderListener(new ShopListener());

	}

	/**
	 * Listener for ordering
	 * @param listenForOrder
	 */
	void addOrderListener(ActionListener listenForOrder) {

		btnOrder.addActionListener(listenForOrder);
	}
	
	/** 
	 * Action taken after button press, dialog pops up
	 */
	class ShopListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(message,
					name + " purchased for " + price);
			frame.setVisible(false);		}
	}
}
