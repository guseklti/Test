package views;

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
	private JPanel pnlSearch;
	private JPanel pnlAdminInterface;
	private JPanel panel_3;
	private JLabel lblUserid;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblAdress;
	private JTextArea textArea;
	private JScrollPane scrollPane_3;
	private JTextArea textArea_1;
	private JScrollPane scrollPane_4;
	private JTextArea textArea_2;
	private JScrollPane scrollPane_5;
	private JTextArea textArea_3;
	private JLabel lblNewLabel_1;
	private JPanel panel_4;
	

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
	public void initialize() {
		
		frmLibrary = new JFrame();
		frmLibrary.setTitle("Library");
		frmLibrary.setBounds(100, 100, 767, 463);
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
		
		frmLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdvanced = new JButton("Advanced Search");
		btnAdvanced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdvancedSearchv2 advancedsearch = new AdvancedSearchv2();
				advancedsearch.setVisible(true);
				frmLibrary.dispose();
				new AdvancedSearchv2();
			    
				
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
		
		pnlSearch = new JPanel();
		frmLibrary.getContentPane().add(pnlSearch, "name_1381036905321");
		
		JLabel lblSearchResult = new JLabel("Search Result");
		lblSearchResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResult.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JSeparator separator_3 = new JSeparator();
		
		JButton btnSearchBack = new JButton("Back");
		btnSearchBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlSearch.setVisible(false);
				pnlMenu.setVisible(true);
			}
		});
		btnSearchBack.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GroupLayout gl_pnlSearch = new GroupLayout(pnlSearch);
		gl_pnlSearch.setHorizontalGroup(
			gl_pnlSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSearch.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSearch.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlSearch.createSequentialGroup()
							.addComponent(btnSearchBack, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(127)
							.addComponent(lblSearchResult, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
							.addGap(189))
						.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnlSearch.setVerticalGroup(
			gl_pnlSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSearch.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSearch.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchResult)
						.addComponent(btnSearchBack))
					.addGap(18)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(305, Short.MAX_VALUE))
		);
		pnlSearch.setLayout(gl_pnlSearch);
		
		pnlAdminInterface = new JPanel();
		frmLibrary.getContentPane().add(pnlAdminInterface, "name_1093316362517");
		
		JLabel lblDashbord = new JLabel("DASHBORD");
		lblDashbord.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashbord.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JSeparator separator_4 = new JSeparator();
		
		JLabel lblAddAUser = new JLabel("Add a user");
		
		JLabel lblAddABook = new JLabel("Add a book");
		
		JLabel lblSearchForA = new JLabel("Search for a user");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel_4 = new JPanel();
		GroupLayout gl_pnlAdminInterface = new GroupLayout(pnlAdminInterface);
		gl_pnlAdminInterface.setHorizontalGroup(
			gl_pnlAdminInterface.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlAdminInterface.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_4, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
						.addComponent(lblDashbord, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlAdminInterface.createSequentialGroup()
							.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddAUser)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddABook))
							.addGap(18)
							.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSearchForA)
								.addGroup(gl_pnlAdminInterface.createSequentialGroup()
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_pnlAdminInterface.setVerticalGroup(
			gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdminInterface.createSequentialGroup()
					.addGap(15)
					.addComponent(lblDashbord)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddAUser)
						.addComponent(lblAddABook)
						.addComponent(lblSearchForA))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAdminInterface.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 171, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 172, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);
		
		lblNewLabel_1 = new JLabel("Title");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addContainerGap(204, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		lblUserid = new JLabel("UserID:");
		
		lblName = new JLabel("Name:");
		
		lblNewLabel = new JLabel("Phone number:");
		
		lblAdress = new JLabel("Address:");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		scrollPane_3 = new JScrollPane();
		
		scrollPane_4 = new JScrollPane();
		
		scrollPane_5 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblAdress)
							.addContainerGap(115, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane_5, Alignment.LEADING)
								.addComponent(scrollPane_4, Alignment.LEADING)
								.addComponent(lblName, Alignment.LEADING)
								.addComponent(lblUserid, Alignment.LEADING)
								.addComponent(scrollPane_3, Alignment.LEADING)
								.addComponent(scrollPane_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING))
							.addContainerGap(29, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUserid, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAdress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(10, Short.MAX_VALUE))
		);
		
		textArea_3 = new JTextArea();
		scrollPane_5.setViewportView(textArea_3);
		
		textArea_2 = new JTextArea();
		scrollPane_4.setViewportView(textArea_2);
		
		textArea_1 = new JTextArea();
		scrollPane_3.setViewportView(textArea_1);
		
		textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		panel_1.setLayout(gl_panel_1);
		pnlAdminInterface.setLayout(gl_pnlAdminInterface);
	}
}
