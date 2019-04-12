package mvc;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.BooksAndStuff;
import user.student.BookController;
import user.student.Book_view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class AccountView extends JPanel {

	private JLabel lblFeeVar;
	private JButton btnAddFunds;
	private JTextField addFundsTF;
	private JTable tableItems;
	private JLabel lblName;
	private DefaultTableModel tableModel;
	private String[] columnNames = { "Book", "Date borrowed" };
	private JLabel lblFaculty;
	private JLabel label;
	private JLabel lblName_insert;
	private JLabel lblFaculty_insert;
	private JLabel lblId;
	private JLabel lblFullName;
	private JLabel lblID_insert;
	private JLabel lblFullName_insert;

	AccountView() {
		setBackground(new Color(255, 255, 255));
		this.setBounds(155, 62, 835, 457);

		JLabel lblBorrowed = new JLabel("borrowed items:");
		lblBorrowed.setForeground(new Color(0, 191, 255));
		lblBorrowed.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		JLabel lblOutstandingFees = new JLabel("outstanding fees:");
		lblOutstandingFees.setForeground(new Color(0, 191, 255));
		lblOutstandingFees.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		btnAddFunds = new JButton("add funds");
		btnAddFunds.setForeground(new Color(0, 191, 255));
		btnAddFunds.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JScrollPane scrollPane = new JScrollPane();

		lblFeeVar = new JLabel("you currently do not have any fees.");
		lblFeeVar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		addFundsTF = new JTextField();
		addFundsTF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		addFundsTF.setColumns(10);

		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblName.setForeground(new Color(0, 191, 255));

		lblFaculty = new JLabel("Faculty:");
		lblFaculty.setForeground(new Color(0, 191, 255));
		lblFaculty.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		label = new JLabel("");

		lblName_insert = new JLabel("");
		lblName_insert.setForeground(Color.BLACK);
		lblName_insert.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		lblFaculty_insert = new JLabel("");
		lblFaculty_insert.setForeground(Color.BLACK);
		lblFaculty_insert.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		lblId = new JLabel("ID:");
		lblId.setForeground(new Color(0, 191, 255));
		lblId.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		lblFullName = new JLabel("Full name:");
		lblFullName.setForeground(new Color(0, 191, 255));
		lblFullName.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		lblID_insert = new JLabel("");
		lblID_insert.setForeground(Color.BLACK);
		lblID_insert.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		lblFullName_insert = new JLabel("");
		lblFullName_insert.setForeground(Color.BLACK);
		lblFullName_insert.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
								.addGap(38)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblFaculty, GroupLayout.PREFERRED_SIZE, 64,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 64,
																GroupLayout.PREFERRED_SIZE))
												.addGap(44))
										.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE))
								.addGap(54)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFaculty_insert, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
										.addComponent(lblID_insert, GroupLayout.PREFERRED_SIZE, 229,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup().addGap(2)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblName_insert, GroupLayout.DEFAULT_SIZE, 237,
																Short.MAX_VALUE)
														.addComponent(label))))
										.addComponent(lblFullName_insert, GroupLayout.PREFERRED_SIZE, 229,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblBorrowed)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblOutstandingFees)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(addFundsTF, GroupLayout.PREFERRED_SIZE, 35,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAddFunds))
										.addComponent(lblFeeVar))))
				.addContainerGap(37, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblBorrowed)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblOutstandingFees).addComponent(lblFeeVar))
								.addGap(47)
								.addGroup(groupLayout
										.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAddFunds, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(
												addFundsTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(53)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblName).addComponent(label))
										.addComponent(lblName_insert, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblFaculty, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFaculty_insert, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblID_insert, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFullName_insert, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(109, Short.MAX_VALUE)));

		tableModel = new DefaultTableModel(columnNames, 0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		// Create a new table
		tableItems = new JTable(tableModel);
		scrollPane.setViewportView(tableItems);
		tableItems.getTableHeader().setResizingAllowed(false);
		tableItems.getTableHeader().setReorderingAllowed(false);

		// make any row on the table clickable and redirect the user to the correct next
		// screen
		tableItems.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int i = tableItems.getSelectedRow();
					if (i >= 0) {
						String item = (String) tableModel.getValueAt(i, 0);
						System.out.println(item);
						BooksAndStuff book = new BooksAndStuff();

						if (book.findBook(item)) {
							book.getBookData(item);
							Book_view b_frame = new Book_view("Return");
							b_frame.frame.setVisible(true);

							BookController controller = new BookController(book, b_frame);
						}

					}
				}
			}
		});

		setLayout(groupLayout);

	}

	public void setFeesDisplay(int fees) {
		this.lblFeeVar.setText(Integer.toString(fees) + "$");
	}

	public JTable getTable() {
		return this.tableItems;
	}

	public void initTable(String[] books, String[] dates) {
		clearTable();
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null)
				tableModel.addRow(new Object[] { books[i], dates[i] });
		}

	}

	public void clearTable() {
		tableModel.setRowCount(0);
	}

	public int getAddedFunds() {
		return Integer.parseInt(addFundsTF.getText());
	}

	void addFundListener(ActionListener listenForFunds) {

		btnAddFunds.addActionListener(listenForFunds);
	}

	public void setName(String name) {
		this.lblName_insert.setText(name);
	}

	public void setID(String ID) {
		this.lblID_insert.setText(ID);
	}

	public void setFullName(String name) {
		this.lblFullName_insert.setText(name);
	}

	public void setFaculty(String fac) {
		this.lblFaculty_insert.setText(fac);
	}
}
