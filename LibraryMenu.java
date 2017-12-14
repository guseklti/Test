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
	private JPanel pnlAddBook_1;
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
	private JPanel pnlSearchBook;
	private JLabel lblAdminSearch;
	private JLabel lblUsersID;
	private JScrollPane scrUsersID;
	private JTextArea txtAreaUsersID;
	private JLabel UsersName;
	private JScrollPane scrUsersName;
	private JTextArea txtAreaUsersName;
	private JLabel lblSearchTitle;
	private JScrollPane scrSearchTitle;
	private JTextArea txtAreaSearchTitle;
	private JLabel lblSearchAuthor;
	private JScrollPane scrSearchAuthor;
	private JTextArea txtAreaSearchAuthor;
	private JButton btnAddUser;

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
		panel.setBorder(new TitledBorder(null, "Books", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnlBorrowed = new GroupLayout(pnlBorrowed);
		gl_pnlBorrowed.setHorizontalGroup(
			gl_pnlBorrowed.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlBorrowed.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlBorrowed.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBorrowed.createSequentialGroup()
							.addComponent(btnBorrowedBack, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(240)
							.addComponent(lblBorrowedBooks, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(312))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addContainerGap())
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
		
		JLabel lblAddUser = new JLabel("Add a user");
		
		JLabel lblAddABook = new JLabel("Add a book");
		
		JPanel pnlAddUser = new JPanel();
		pnlAddUser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel pnlAddBook = new JPanel();
		pnlAddBook.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		pnlAddBook_1 = new JPanel();
		pnlAddBook_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		pnlSearchBook = new JPanel();
		pnlSearchBook.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		lblAdminSearch = new JLabel("Search for a book");
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAdminInterface.setVisible(false);
				pnlMenu.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(LibraryMenu.class.getResource("/MP/resources/home.png")));
		GroupLayout gl_pnlAdminInterface = new GroupLayout(pnlAdminInterface);
		gl_pnlAdminInterface.setHorizontalGroup(
			gl_pnlAdminInterface.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlAdminInterface.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlAdminInterface.createSequentialGroup()
							.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_4, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
								.addGroup(gl_pnlAdminInterface.createSequentialGroup()
									.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAddUser)
										.addComponent(pnlAddUser, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlAdminInterface.createSequentialGroup()
											.addGap(18)
											.addComponent(lblAddABook))
										.addGroup(gl_pnlAdminInterface.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(pnlAddBook, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(pnlAddBook_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAdminSearch)
										.addComponent(pnlSearchBook, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap())
						.addGroup(gl_pnlAdminInterface.createSequentialGroup()
							.addComponent(lblDashbord, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 708, Short.MAX_VALUE)
							.addComponent(btnHome)
							.addGap(27))))
		);
		gl_pnlAdminInterface.setVerticalGroup(
			gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdminInterface.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDashbord)
						.addComponent(btnHome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAdminInterface.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddUser)
								.addComponent(lblAddABook))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pnlAddBook, 0, 0, Short.MAX_VALUE)
								.addComponent(pnlAddUser, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)))
						.addGroup(gl_pnlAdminInterface.createSequentialGroup()
							.addGap(7)
							.addComponent(lblAdminSearch)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlAddBook_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnlSearchBook, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		lblSearchTitle = new JLabel("Title:");
		
		scrSearchTitle = new JScrollPane();
		
		lblSearchAuthor = new JLabel("Author:");
		
		scrSearchAuthor = new JScrollPane();
		GroupLayout gl_pnlSearchBook = new GroupLayout(pnlSearchBook);
		gl_pnlSearchBook.setHorizontalGroup(
			gl_pnlSearchBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSearchBook.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSearchBook.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSearchTitle)
						.addComponent(scrSearchTitle, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(lblSearchAuthor)
						.addComponent(scrSearchAuthor))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		gl_pnlSearchBook.setVerticalGroup(
			gl_pnlSearchBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSearchBook.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearchTitle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrSearchTitle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSearchAuthor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrSearchAuthor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(193, Short.MAX_VALUE))
		);
		
		txtAreaSearchAuthor = new JTextArea();
		scrSearchAuthor.setViewportView(txtAreaSearchAuthor);
		
		txtAreaSearchTitle = new JTextArea();
		scrSearchTitle.setViewportView(txtAreaSearchTitle);
		pnlSearchBook.setLayout(gl_pnlSearchBook);
		
		lblUsersID = new JLabel("User's ID:");
		
		scrUsersID = new JScrollPane();
		
		UsersName = new JLabel("User's name:");
		
		scrUsersName = new JScrollPane();
		
		JButton btnSearchUser = new JButton("");
		btnSearchUser.setIcon(new ImageIcon(LibraryMenu.class.getResource("/MP/resources/find (1).png")));
		GroupLayout gl_pnlAddBook_1 = new GroupLayout(pnlAddBook_1);
		gl_pnlAddBook_1.setHorizontalGroup(
			gl_pnlAddBook_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAddBook_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAddBook_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAddBook_1.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblUsersID)
							.addComponent(scrUsersID, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addComponent(UsersName)
							.addComponent(scrUsersName))
						.addComponent(btnSearchUser))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_pnlAddBook_1.setVerticalGroup(
			gl_pnlAddBook_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAddBook_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUsersID)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrUsersID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(UsersName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrUsersName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearchUser)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		
		txtAreaUsersName = new JTextArea();
		scrUsersName.setViewportView(txtAreaUsersName);
		
		txtAreaUsersID = new JTextArea();
		scrUsersID.setViewportView(txtAreaUsersID);
		pnlAddBook_1.setLayout(gl_pnlAddBook_1);
		
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
	}
}
