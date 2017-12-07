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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

public class AdvancedSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearchByTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvancedSearch frame = new AdvancedSearch();
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
	public AdvancedSearch() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdvancedSearch.class.getResource("/resources/3d_library32x32.png")));
		setTitle("Advanced Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 950, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSearchByTitle = new JTextField();
		txtSearchByTitle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSearchByTitle.setText("Search by title, author or Book ID...");
		txtSearchByTitle.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(AdvancedSearch.class.getResource("/resources/searchicon32x32.png")));
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(AdvancedSearch.class.getResource("/resources/return.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JTree tree = new JTree();
		tree.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollBar scrollBar = new JScrollBar();
		
		JButton btnNewButton = new JButton("Checkout");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tree, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtSearchByTitle, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtSearchByTitle, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(tree, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(430)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addGap(57))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
