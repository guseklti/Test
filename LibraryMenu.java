package MP.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;



public class LibraryMenu {

	private JFrame frmLibrary;
	private JPanel pnlMenu;
	private JPanel pnlBorrowed;
	private JTextArea txtAreaSearch;
	private JLabel lblSearch;
	private JButton btnBorrowed;
	private JButton btnAdvanced;
	private JButton btnRequest;
	private JButton btnCheckOut;
	private JButton btnAdminLogin;
	private JLabel lblLibrary;
	private JSeparator separator;
	private JLabel lblBorrowedBooks;
	private JSeparator separator_1;
	private JPanel pnlAdminlogin;
	private JLabel lblAdminLogin;
	private JSeparator separator_2;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField UsernameField;
	private JPasswordField passwordField;
	private JButton btnAdminBack;
	private JPanel pnlAdminInterface;
	private JLabel lblUserID;
	private JLabel lblName;
	private JLabel lblTelNum;
	private JLabel lblAdress;
	private JTextArea textArea;
	private JScrollPane scrUserID;
	private JTextArea txtAreaUserID;
	private JScrollPane scrTelNum;
	private JTextArea txtAreaTelNum;
	private JScrollPane scrAddress;
	private JTextArea txtAreaAdress;
	private JButton btnAddUser;
	private JPanel pnlUserStatus;
	private JButton btnBookStatus;
	private JPanel pnlBookStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryMenu window = new LibraryMenu();
					window.frmLibrary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibrary = new JFrame();
		frmLibrary.setTitle("Library");
		frmLibrary.setBounds(100, 100, 864, 463);
		frmLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibrary.getContentPane().setLayout(new CardLayout(0, 0));
		
		pnlMenu = new JPanel();
		frmLibrary.getContentPane().add(pnlMenu, "name_70701897066204");
		
		lblLibrary = new JLabel("Team 3's Library");
		lblLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrary.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		separator = new JSeparator();
		
		btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlMenu.setVisible(false);
				pnlAdminlogin.setVisible(true);
			}
		});
		btnAdminLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		btnAdvanced = new JButton("Advanced Search");
		btnAdvanced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdvanced.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		btnBorrowed = new JButton("My Borrowed Books");
		btnBorrowed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlMenu.setVisible(false);
				pnlBorrowed.setVisible(true);
			}
		});
		btnBorrowed.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		btnRequest = new JButton("Request Book");
		btnRequest.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		btnCheckOut = new JButton("Check out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = JOptionPane.showConfirmDialog(null, " Are you sure you want to check out? ");
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnCheckOut.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JScrollPane scrSearch = new JScrollPane();
		
		lblSearch = new JLabel("Search...");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setIcon(new ImageIcon(LibraryMenu.class.getResource("/MP/resources/find (1).png")));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_pnlMenu = new GroupLayout(pnlMenu);
		gl_pnlMenu.setHorizontalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addGroup(gl_pnlMenu.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
						.addGroup(gl_pnlMenu.createSequentialGroup()
							.addGap(181)
							.addComponent(lblLibrary, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
							.addGap(85)
							.addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAdvanced, GroupLayout.PREFERRED_SIZE, 142, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBorrowed, GroupLayout.PREFERRED_SIZE, 155, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRequest, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCheckOut, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_pnlMenu.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_pnlMenu.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
								.addComponent(scrSearch, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(14)))
					.addContainerGap())
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addGap(209)
					.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
					.addGap(219))
		);
		gl_pnlMenu.setVerticalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlMenu.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLibrary)
						.addComponent(btnAdminLogin))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnlMenu.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdvanced, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBorrowed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRequest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCheckOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(71)
					.addGroup(gl_pnlMenu.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlMenu.createSequentialGroup()
							.addComponent(lblSearch)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrSearch, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSearch))
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		
		txtAreaSearch = new JTextArea();
		scrSearch.setViewportView(txtAreaSearch);
		pnlMenu.setLayout(gl_pnlMenu);
		
		pnlBorrowed = new JPanel();
		frmLibrary.getContentPane().add(pnlBorrowed, "name_70722986228003");
		
		lblBorrowedBooks = new JLabel("Borrowed Books");
		lblBorrowedBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowedBooks.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		separator_1 = new JSeparator();
		
		JButton btnBorrowedBack = new JButton("Back");
		btnBorrowedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlBorrowed.setVisible(false);
				pnlMenu.setVisible(true);
			}
		});
		btnBorrowedBack.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Borrowed Books", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_pnlBorrowed = new GroupLayout(pnlBorrowed);
		gl_pnlBorrowed.setHorizontalGroup(
			gl_pnlBorrowed.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlBorrowed.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlBorrowed.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBorrowed.createSequentialGroup()
							.addComponent(btnBorrowedBack, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(240)
							.addComponent(lblBorrowedBooks, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addGap(312))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnlBorrowed.setVerticalGroup(
			gl_pnlBorrowed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBorrowed.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlBorrowed.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrowedBack)
						.addComponent(lblBorrowedBooks))
					.addGap(9)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnReturnBook.setIcon(new ImageIcon(LibraryMenu.class.getResource("/MP/resources/arrow_undo.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReturnBook)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(276, Short.MAX_VALUE)
					.addComponent(btnReturnBook)
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		pnlBorrowed.setLayout(gl_pnlBorrowed);
		
		pnlAdminlogin = new JPanel();
		frmLibrary.getContentPane().add(pnlAdminlogin, "name_13905332363449");
		
		lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		separator_2 = new JSeparator();
		
		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		UsernameField = new JTextField();
		UsernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAdminlogin.setVisible(false);
				pnlAdminInterface.setVisible(true);
			}
		});
		
		btnAdminBack = new JButton("Back");
		btnAdminBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAdminlogin.setVisible(false);
				pnlMenu.setVisible(true);
			}
		});
		btnAdminBack.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GroupLayout gl_pnlAdminlogin = new GroupLayout(pnlAdminlogin);
		gl_pnlAdminlogin.setHorizontalGroup(
			gl_pnlAdminlogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdminlogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAdminlogin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAdminlogin.createSequentialGroup()
							.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_pnlAdminlogin.createSequentialGroup()
							.addGroup(gl_pnlAdminlogin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdminBack, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnlAdminlogin.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlAdminlogin.createSequentialGroup()
									.addGap(83)
									.addComponent(lblAdminLogin, GroupLayout.PREFERRED_SIZE, 415, Short.MAX_VALUE)
									.addGap(182))
								.addGroup(gl_pnlAdminlogin.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_pnlAdminlogin.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlAdminlogin.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLogin)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addGap(547))))
		);
		gl_pnlAdminlogin.setVerticalGroup(
			gl_pnlAdminlogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdminlogin.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_pnlAdminlogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdminBack)
						.addComponent(lblAdminLogin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_pnlAdminlogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_pnlAdminlogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addComponent(btnLogin)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		pnlAdminlogin.setLayout(gl_pnlAdminlogin);
		
		pnlAdminInterface = new JPanel();
		frmLibrary.getContentPane().add(pnlAdminInterface, "name_1093316362517");
		
		JLabel lblDashbord = new JLabel("DASHBORD");
		lblDashbord.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashbord.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JSeparator separator_4 = new JSeparator();
		
		JPanel pnlAddUser = new JPanel();
		pnlAddUser.setBorder(new TitledBorder(null, "Add a user", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel pnlAddBook = new JPanel();
		pnlAddBook.setBorder(new TitledBorder(null, "Add a book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAdminInterface.setVisible(false);
				pnlMenu.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(LibraryMenu.class.getResource("/MP/resources/home.png")));
		
		JButton btnUserStatus = new JButton("User Status");
		btnUserStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAdminInterface.setVisible(false);
				pnlUserStatus.setVisible(true);
			}
		});
		
		btnBookStatus = new JButton("Book Status");
		btnBookStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAdminInterface.setVisible(false);
				pnlBookStatus.setVisible(true);
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		GroupLayout gl_pnlAdminInterface = new GroupLayout(pnlAdminInterface);
		gl_pnlAdminInterface.setHorizontalGroup(
			gl_pnlAdminInterface.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlAdminInterface.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_4, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
						.addGroup(gl_pnlAdminInterface.createSequentialGroup()
							.addComponent(lblDashbord, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 635, Short.MAX_VALUE)
							.addComponent(btnHome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLogout))
						.addGroup(gl_pnlAdminInterface.createSequentialGroup()
							.addComponent(pnlAddUser, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(pnlAddBook, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btnUserStatus)
							.addGap(41)
							.addComponent(btnBookStatus)))
					.addContainerGap())
		);
		gl_pnlAdminInterface.setVerticalGroup(
			gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdminInterface.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDashbord)
						.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
							.addComponent(btnHome)
							.addComponent(btnLogout)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.BASELINE, false)
							.addComponent(pnlAddUser, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
							.addComponent(pnlAddBook, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnUserStatus)
							.addComponent(btnBookStatus)))
					.addContainerGap())
		);
		
		JLabel lblBooksId = new JLabel("Book's ID:");
		lblBooksId.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Author:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("Genre:");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_6 = new JScrollPane();
		
		JLabel lblPages = new JLabel("Pages:");
		lblPages.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_8 = new JScrollPane();
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrollPane_9 = new JScrollPane();
		
		JButton btnAdd = new JButton("Add");
		GroupLayout gl_pnlAddBook = new GroupLayout(pnlAddBook);
		gl_pnlAddBook.setHorizontalGroup(
			gl_pnlAddBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAddBook.createSequentialGroup()
					.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAddBook.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2)
								.addComponent(lblBooksId)
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(scrollPane_5)
								.addComponent(scrollPane_4)
								.addComponent(scrollPane_3))
							.addGap(27)
							.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane_6)
								.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblPages)
										.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
										.addComponent(lblIsbn)
										.addComponent(scrollPane_8)
										.addComponent(lblQuantity)
										.addComponent(scrollPane_9))
									.addComponent(lblPublisher))))
						.addGroup(gl_pnlAddBook.createSequentialGroup()
							.addGap(99)
							.addComponent(btnAdd)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_pnlAddBook.setVerticalGroup(
			gl_pnlAddBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAddBook.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBooksId)
						.addComponent(lblPages))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAddBook.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel))
						.addGroup(gl_pnlAddBook.createSequentialGroup()
							.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblIsbn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblQuantity)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAddBook.createSequentialGroup()
							.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_pnlAddBook.createSequentialGroup()
							.addComponent(scrollPane_9, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPublisher)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlAddBook.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAdd)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		
		JTextArea textArea_6 = new JTextArea();
		scrollPane_8.setViewportView(textArea_6);
		
		JTextArea textArea_5 = new JTextArea();
		scrollPane_7.setViewportView(textArea_5);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_4.setViewportView(textArea_3);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_3.setViewportView(textArea_2);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		pnlAddBook.setLayout(gl_pnlAddBook);
		
		lblUserID = new JLabel("UserID:");
		
		lblName = new JLabel("Name:");
		
		lblTelNum = new JLabel("Phone number:");
		
		lblAdress = new JLabel("Address:");
		
		JScrollPane scrName = new JScrollPane();
		
		scrUserID = new JScrollPane();
		
		scrTelNum = new JScrollPane();
		
		scrAddress = new JScrollPane();
		
		btnAddUser = new JButton("Add");
		GroupLayout gl_pnlAddUser = new GroupLayout(pnlAddUser);
		gl_pnlAddUser.setHorizontalGroup(
			gl_pnlAddUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAddUser.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAddUser.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblName, Alignment.LEADING)
						.addComponent(lblUserID, Alignment.LEADING)
						.addComponent(scrName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(lblTelNum, Alignment.LEADING)
						.addComponent(scrUserID, Alignment.LEADING)
						.addComponent(scrTelNum, Alignment.LEADING))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_pnlAddUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrAddress)
					.addGap(25))
				.addGroup(gl_pnlAddUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdress)
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(gl_pnlAddUser.createSequentialGroup()
					.addComponent(btnAddUser)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_pnlAddUser.setVerticalGroup(
			gl_pnlAddUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAddUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUserID, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrUserID, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTelNum)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrTelNum, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAdress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrAddress, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnAddUser)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		txtAreaAdress = new JTextArea();
		scrAddress.setViewportView(txtAreaAdress);
		
		txtAreaTelNum = new JTextArea();
		scrTelNum.setViewportView(txtAreaTelNum);
		
		txtAreaUserID = new JTextArea();
		scrUserID.setViewportView(txtAreaUserID);
		
		textArea = new JTextArea();
		scrName.setViewportView(textArea);
		pnlAddUser.setLayout(gl_pnlAddUser);
		pnlAdminInterface.setLayout(gl_pnlAdminInterface);
		
		pnlUserStatus = new JPanel();
		frmLibrary.getContentPane().add(pnlUserStatus, "name_23594220472237");
		
		JLabel lblUserStatus = new JLabel("User Status");
		lblUserStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserStatus.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JSeparator separator_3 = new JSeparator();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlUserStatus.setVisible(false);
				pnlAdminInterface.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		JPanel pnlSearchUser = new JPanel();
		pnlSearchUser.setBorder(new TitledBorder(null, "Search a user", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnlUserStatus = new GroupLayout(pnlUserStatus);
		gl_pnlUserStatus.setHorizontalGroup(
			gl_pnlUserStatus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUserStatus.createSequentialGroup()
					.addGap(15)
					.addComponent(btnBack)
					.addGap(269)
					.addComponent(lblUserStatus, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(375))
				.addGroup(gl_pnlUserStatus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlUserStatus.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlUserStatus.createSequentialGroup()
							.addGap(6)
							.addComponent(pnlSearchUser, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_3, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlUserStatus.setVerticalGroup(
			gl_pnlUserStatus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUserStatus.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_pnlUserStatus.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBack)
						.addComponent(lblUserStatus))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlSearchUser, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JLabel lblUsersID = new JLabel("User's ID:");
		lblUsersID.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrUsersID = new JScrollPane();
		
		JLabel lblUsersName = new JLabel("User's name:");
		lblUsersName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrUsersName = new JScrollPane();
		
		JScrollPane scrollPane_12 = new JScrollPane();
		GroupLayout gl_pnlSearchUser = new GroupLayout(pnlSearchUser);
		gl_pnlSearchUser.setHorizontalGroup(
			gl_pnlSearchUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSearchUser.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSearchUser.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUsersID)
						.addComponent(lblUsersName)
						.addComponent(scrUsersID, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(scrUsersName))
					.addGap(18)
					.addComponent(scrollPane_12, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_pnlSearchUser.setVerticalGroup(
			gl_pnlSearchUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSearchUser.createSequentialGroup()
					.addGap(28)
					.addComponent(lblUsersID)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrUsersID, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblUsersName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrUsersName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_pnlSearchUser.createSequentialGroup()
					.addComponent(scrollPane_12, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
					.addGap(12))
		);
		
		JTextArea txtAreaUsersName = new JTextArea();
		scrUsersName.setViewportView(txtAreaUsersName);
		
		JTextArea txtAreaUsersID = new JTextArea();
		scrUsersID.setViewportView(txtAreaUsersID);
		pnlSearchUser.setLayout(gl_pnlSearchUser);
		pnlUserStatus.setLayout(gl_pnlUserStatus);
		
		pnlBookStatus = new JPanel();
		frmLibrary.getContentPane().add(pnlBookStatus, "name_25596092158410");
		
		JLabel lblBookStatus = new JLabel("Book Status");
		lblBookStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookStatus.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JSeparator separator_5 = new JSeparator();
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlBookStatus.setVisible(false);
				pnlAdminInterface.setVisible(true);
			}
		});
		
		JPanel pnlSearchBook = new JPanel();
		pnlSearchBook.setBorder(new TitledBorder(null, "Search a book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnlBookStatus = new GroupLayout(pnlBookStatus);
		gl_pnlBookStatus.setHorizontalGroup(
			gl_pnlBookStatus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBookStatus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlBookStatus.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBookStatus.createSequentialGroup()
							.addComponent(btnBack_1)
							.addGap(309)
							.addComponent(lblBookStatus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(377))
						.addComponent(separator_5, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
						.addComponent(pnlSearchBook, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnlBookStatus.setVerticalGroup(
			gl_pnlBookStatus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBookStatus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlBookStatus.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack_1)
						.addComponent(lblBookStatus))
					.addGap(18)
					.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlSearchBook, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		JLabel lblBooksTitle = new JLabel("Book's Title:");
		lblBooksTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JScrollPane scrBookTitle = new JScrollPane();
		
		JScrollPane scrBookAuthor = new JScrollPane();
		
		JScrollPane scrollPane_13 = new JScrollPane();
		
		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.setIcon(new ImageIcon(LibraryMenu.class.getResource("/MP/resources/remove.png")));
		btnRemoveBook.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JButton btnEditQuantity = new JButton("Change Quantity");
		
		JButton btnDelayedBooks = new JButton("Delayed Books");
		btnDelayedBooks.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("Reserve Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JComboBox cbSearchBy = new JComboBox();
		cbSearchBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (cbSearchBy.getSelectedItem().equals("2. Author"))
				scrBookAuthor.setVisible(true);
			else
				scrBookAuthor.setVisible(false);
			}
		});
		cbSearchBy.setModel(new DefaultComboBoxModel(new String[] {"Search by…", "1.Title", "2. Author", "3. Genre ", "4.Publisher"}));
		GroupLayout gl_pnlSearchBook = new GroupLayout(pnlSearchBook);
		gl_pnlSearchBook.setHorizontalGroup(
			gl_pnlSearchBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSearchBook.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSearchBook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlSearchBook.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblBooksTitle)
							.addComponent(lblAuthor)
							.addComponent(scrBookTitle, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addComponent(scrBookAuthor))
						.addComponent(cbSearchBy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addComponent(scrollPane_13, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlSearchBook.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDelayedBooks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton)
						.addComponent(btnEditQuantity, 0, 0, Short.MAX_VALUE)
						.addComponent(btnRemoveBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_pnlSearchBook.setVerticalGroup(
			gl_pnlSearchBook.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlSearchBook.createSequentialGroup()
					.addGroup(gl_pnlSearchBook.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pnlSearchBook.createSequentialGroup()
							.addGap(35)
							.addComponent(lblBooksTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrBookTitle, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(lblAuthor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrBookAuthor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlSearchBook.createSequentialGroup()
							.addGap(117)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnDelayedBooks)
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlSearchBook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlSearchBook.createSequentialGroup()
							.addComponent(btnEditQuantity)
							.addGap(18)
							.addComponent(btnRemoveBook))
						.addComponent(cbSearchBy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41))
				.addGroup(gl_pnlSearchBook.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(scrollPane_13, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JTextArea txtAreaBookTitle = new JTextArea();
		scrBookTitle.setViewportView(txtAreaBookTitle);
		
		JTextArea txtAreaBookAuthor = new JTextArea();
		scrBookAuthor.setViewportView(txtAreaBookAuthor);
		pnlSearchBook.setLayout(gl_pnlSearchBook);
		pnlBookStatus.setLayout(gl_pnlBookStatus);
	}
}
