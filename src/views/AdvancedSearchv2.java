package views;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Color;

public class AdvancedSearchv2 extends JFrame {

	static JPanel contentPane;
	private JTextField SearchBar;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvancedSearchv2 frame = new AdvancedSearchv2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdvancedSearchv2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdvancedSearchv2.class.getResource("/resources/3d_library32x32.png")));
		setTitle("Advanced Search");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 950, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		JPanel panelAdvancedSearch = new JPanel();
		panelAdvancedSearch.setForeground(Color.BLACK);
		panelAdvancedSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelAdvancedSearch, "AdvancedSearch");
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryMenu librarymenu = new LibraryMenu();
			    
			}
		});
		btnBackButton.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/return.png")));
		
		SearchBar = new JTextField();
		SearchBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchBar.setText("");
			}
		});
		SearchBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		SearchBar.setText("Search by title, author or book ID...");
		SearchBar.setColumns(10);
		
		
		JButton btnSearchButton = new JButton("Search");
		btnSearchButton.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/search.png")));
		
		JList list = new JList();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNext = new JButton("Next");
		btnNext.setPreferredSize(new Dimension(127, 23));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c=(CardLayout)(contentPane.getLayout());
				c.show(contentPane, "ReturnBook");
			}
		});
		btnNext.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/right-arrow.png")));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JButton btnAddButton = new JButton("Add");
		btnAddButton.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/plus2.png")));
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/remove.png")));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panelAdvancedSearch = new GroupLayout(panelAdvancedSearch);
		gl_panelAdvancedSearch.setHorizontalGroup(
			gl_panelAdvancedSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdvancedSearch.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBackButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.LEADING)
						.addComponent(SearchBar, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
						.addComponent(scrollPane)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAdvancedSearch.createSequentialGroup()
							.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(btnAddButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(btnRemove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
							.addGap(12))
						.addGroup(gl_panelAdvancedSearch.createSequentialGroup()
							.addComponent(btnSearchButton, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panelAdvancedSearch.setVerticalGroup(
			gl_panelAdvancedSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdvancedSearch.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnBackButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(SearchBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearchButton))
					.addGap(22)
					.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane)
							.addGroup(gl_panelAdvancedSearch.createSequentialGroup()
								.addGap(1)
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnAddButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addGap(30)
					.addGroup(gl_panelAdvancedSearch.createParallelGroup(Alignment.TRAILING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		
		JTree tree = new JTree();
		scrollPane_3.setViewportView(tree);
		
		table_2 = new JTable();
		table_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Selected books"
			}
		));
		scrollPane_2.setViewportView(table_2);		
		table_2.setShowHorizontalLines(false);
		table_2.setDefaultEditor(Object.class, null);

		table_2.setShowVerticalLines(false);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				{
					  if (arg0.getClickCount() == 2) {
						  int row = table.rowAtPoint(arg0.getPoint());
	                        if (row > -1) {
	                            DefaultTableModel topModel = ((DefaultTableModel)table.getModel());
	                            DefaultTableModel bottomModel = ((DefaultTableModel)table_2.getModel());
	                            bottomModel.setRowCount(1);
	                            for (int col = 0; col < topModel.getColumnCount(); col++) {
	                                bottomModel.setValueAt(topModel.getValueAt(row, col), 0, col);
	                            }
	                        }
					  }
			}
			}});
		table.setDefaultEditor(Object.class, null);
		table.setAutoCreateRowSorter(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"dsasd", "dasds", "dasds", "sadas", "sdaasd", null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Title", "Genre", "Author", "ISBN", "Available", "Book year"
			}
		));
		scrollPane.setViewportView(table);
		table.setShowGrid(false);
		panelAdvancedSearch.setLayout(gl_panelAdvancedSearch);
		
		
		
		JPanel ReturnBook = new JPanel();
		ReturnBook.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(ReturnBook, "ReturnBook");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c=(CardLayout)(contentPane.getLayout());
				c.show(contentPane, "AdvancedSearch");
			}
		});
		button.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/return.png")));
		
		JButton btnNewButton = new JButton("Return Books");
		btnNewButton.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/icons8-return-book-30.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		JOptionPane.showConfirmDialog(null, "Sure you wanna return this book/these books?");
		
			}
		});
		
		JButton btnExtendLoan = new JButton("Extend Loan");
		btnExtendLoan.setPreferredSize(new Dimension(97, 23));
		btnExtendLoan.setMinimumSize(new Dimension(97, 23));
		btnExtendLoan.setMaximumSize(new Dimension(97, 23));
		btnExtendLoan.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/two-extend-arrows.png")));
		
		JTextPane txtpn = new JTextPane();
		txtpn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtpn.setText("Sleeping Beauties: A Novel\r\nISBN-13: 9781501163401\r\nISBN-10: 150116340X\r\nAuthors: Stephen King; Owen King\r\nEdition: First Edition\r\nBinding: Hardcover\r\nPublisher: Scribner\r\nPublished: September 2017\r\nList Price: $32.50\r\n\r\nBorrowed date: 17/10-17\r\nReturn date: 17/11-18 ");
		
		JButton btnLoanHistory = new JButton("Check-out");
		btnLoanHistory.setPreferredSize(new Dimension(97, 23));
		btnLoanHistory.setMinimumSize(new Dimension(97, 23));
		btnLoanHistory.setMaximumSize(new Dimension(97, 23));
		btnLoanHistory.setIcon(new ImageIcon(AdvancedSearchv2.class.getResource("/resources/bookicon32x32.png")));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblBooksToCheckout = new JLabel("Books to check-out");
		
		JLabel lblPreviousBorrowedBooks = new JLabel("Previous borrowed books");
		GroupLayout gl_ReturnBook = new GroupLayout(ReturnBook);
		gl_ReturnBook.setHorizontalGroup(
			gl_ReturnBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ReturnBook.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_ReturnBook.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_ReturnBook.createSequentialGroup()
							.addComponent(txtpn, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
							.addGap(43)
							.addGroup(gl_ReturnBook.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ReturnBook.createSequentialGroup()
									.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
									.addGap(180))
								.addComponent(lblBooksToCheckout)
								.addGroup(gl_ReturnBook.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_ReturnBook.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPreviousBorrowedBooks)
										.addGroup(gl_ReturnBook.createSequentialGroup()
											.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_ReturnBook.createParallelGroup(Alignment.LEADING)
												.addComponent(btnExtendLoan, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
												.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
												.addComponent(btnLoanHistory, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))))))
					.addContainerGap())
		);
		gl_ReturnBook.setVerticalGroup(
			gl_ReturnBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ReturnBook.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_ReturnBook.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ReturnBook.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(27))
						.addGroup(gl_ReturnBook.createSequentialGroup()
							.addComponent(lblBooksToCheckout)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_ReturnBook.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpn, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
						.addGroup(gl_ReturnBook.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPreviousBorrowedBooks)
							.addGap(7)
							.addGroup(gl_ReturnBook.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ReturnBook.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnExtendLoan, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(btnLoanHistory, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))))
					.addGap(91))
		);
		
		table_3 = new JTable();
		table_3.setDefaultEditor(Object.class, null);

		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Title", "Genre", "Author", "ISBN", "Loan date", "Return date"
			}
		));
		table_3.setShowGrid(false);
		table_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_3.setAutoCreateRowSorter(true);
		scrollPane_4.setViewportView(table_3);
		
		table_1 = new JTable();
		table_1.setDefaultEditor(Object.class, null);

		table_1.setAutoCreateRowSorter(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Title", "Genre", "Author", "ISBN", "Loan date", "Return date"
			}
		));
		table_1.getColumnModel().getColumn(4).setPreferredWidth(91);
		table_1.setShowGrid(false);
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setViewportView(table_1);
		ReturnBook.setLayout(gl_ReturnBook);
		
	}
}

