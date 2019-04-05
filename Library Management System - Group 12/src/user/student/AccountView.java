package user.student;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class AccountView extends JPanel{

	private JLabel lblFeeVar;
	private JLabel lblFundVar;
	private JButton btnAddFunds;
	private JTextField addFundsTF;
	
	AccountView() {
		setBackground(new Color(255, 255, 255));
		this.setBounds(155, 62, 835, 457);
		
		JLabel lblBorrowed = new JLabel("borrowed items:");
		lblBorrowed.setForeground(new Color(0, 191, 255));
		lblBorrowed.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		
		JLabel lblOutstandingFees = new JLabel("outstanding fees:");
		lblOutstandingFees.setForeground(new Color(0, 191, 255));
		lblOutstandingFees.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		
		JLabel lblFunds = new JLabel("funds:");
		lblFunds.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblFunds.setForeground(new Color(0, 191, 255));
		
		btnAddFunds = new JButton("add funds");
		btnAddFunds.setForeground(new Color(0, 191, 255));
		btnAddFunds.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblFeeVar = new JLabel("you currently do not have any fees.");
		lblFeeVar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		
		lblFundVar = new JLabel("0.00");
		lblFundVar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		
		JLabel lbl$ = new JLabel("$");
		lbl$.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		
		addFundsTF = new JTextField();
		addFundsTF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		addFundsTF.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBorrowed)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOutstandingFees)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFunds)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl$)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFundVar)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addFundsTF, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAddFunds))
								.addComponent(lblFeeVar))))
					.addContainerGap(422, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBorrowed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOutstandingFees)
						.addComponent(lblFeeVar))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFunds)
						.addComponent(lblFundVar)
						.addComponent(lbl$)
						.addComponent(btnAddFunds, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(addFundsTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	
	public int getAddedFunds() {
		return Integer.parseInt(addFundsTF.getText());
	}
	
	void addFundListener(ActionListener listenForFunds) {
		
		btnAddFunds.addActionListener(listenForFunds);
	}
}
