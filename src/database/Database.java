package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Database  {
	static final String dbUrl = "jdbc:sqlite:./sqlite/db/library.db";
	final String EOL = System.lineSeparator();
	static Connection conn;
	static Statement stmt;
	final long UNIXMONTH = 2592000;
	public Database() throws SQLException { 
		createLibraryDatabase();
		stmt = conn.createStatement();
		createBooksTable();
		createBorrowedBooksTable();
		createCustomerTable();
		createHistoryTable();
		createAdminTable();
		createDebtTable();
	}

	public void createLibraryDatabase() throws SQLException {
		File dir = new File("./sqlite/db");
		// attempt to create the directory here
		boolean successful = dir.mkdirs();
		if (successful)
		{
			// creating the directory succeeded
			System.out.println("directory was created successfully");
		}
		else
		{
			// creating the directory failed
			System.out.println("failed trying to create the directory");
		}
			conn = DriverManager.getConnection(dbUrl);
			if (conn != null) {
				System.out.println("A new database has been created.");
			}
	}
	public void createBooksTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS books (" +
				"book_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
				"title TEXT NOT NULL,  " +
				"author TEXT NOT NULL,  " +
				"genre TEXT NOT NULL, " +
				"shelf INTEGER NOT NULL, "+
				"publisher TEXT NOT NULL, " +
				"quantity INTEGER NOT NULL, " +
				"pages INTEGER NOT NULL, " +
				"isbn TEXT NOT NULL" +
				");";
			stmt.execute(sql);

	}
	public void createBorrowedBooksTable()throws SQLException  {
		String sql = "CREATE TABLE IF NOT EXISTS borrowed_books (" +
				"id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
				"card_id INTEGER NOT NULL, "+
				"book_id INTEGER NOT NULL, " +
				"borrowed_epoch INTEGER(8) NOT NULL, " +
				"return_epoch INTEGER(8) NOT NULL " +
				");";
			stmt.execute(sql);

	}
	public void createCustomerTable() throws SQLException  {
		String sql = "CREATE TABLE IF NOT EXISTS customer (" +
				"card_id INTEGER PRIMARY KEY NOT NULL,"+
				"name TEXT NOT NULL,  " +
				"address TEXT NOT NULL, " +
				"phone_nr TEXT NOT NULL" +
				");";
			stmt.execute(sql);
	}
	public void createHistoryTable() throws SQLException  {
		String sql = "CREATE TABLE IF NOT EXISTS history (" +
				"id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
				"card_id INTEGER NOT NULL, " +
				"book_id INTEGER NOT NULL,  " +
				"returned_on_time TEXT NOT NULL,  " +
				"rating INTEGER NOT NULL " +
				");";
			stmt.execute(sql);
	}
	public void createDebtTable() throws SQLException  {
		String sql = "CREATE TABLE IF NOT EXISTS customer_debt (" +
				"card_id INTEGER PRIMARY KEY NOT NULL, "+
				"accumulated_fees INTEGER DEFAULT 0,  " +
				"paid INTEGER DEFAULT 0" +
				");";
			stmt.execute(sql);
	}
	public void createAdminTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS admin (" +
					"id INTEGER PRIMARY KEY AUTOINCREMENT," +
					"username TEXT UNIQUE NOT NULL," +
					"password TEXT NOT NULL);";
			stmt.execute(sql);
	}
	public void addBook(String isbn, String title, String author, String genre, int shelf, String publisher, int quantity, int pages)  {
		String sql = "INSERT INTO books " + EOL +
				"(title, author, genre, shelf, publisher, quantity, pages, isbn) " + EOL +
				"VALUES " + EOL +
				"('"  + title + "', '" + author + "', '" + genre + "'," + shelf + EOL +
				",'" + publisher + "', " + quantity +"," + pages + ", " + isbn + ");";
		try {	
		stmt.execute(sql);
		} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	public void addCustomer(int card_id, String name, String address, String phone_nr) throws SQLException {
		String sql = "INSERT INTO customer " + EOL +
				"(card_id, name, address, phone_nr) " + EOL +
				"VALUES " + EOL +
				"("+card_id+", '"+ name + "', '" + address + "', '" + phone_nr +"');" +
				"INSERT INTO customer_debt" +
				"(card_id, accumulated_fees, paid) " +
				"VALUES " +
				"("+card_id+");";
			stmt.execute(sql);
	}
	public void addBorrowed(int book_id, int card_id) throws SQLException {
		long unixBorrowed = System.currentTimeMillis() / 1000L;
		long unixReturn = unixBorrowed + UNIXMONTH;
		String sql = "INSERT INTO borrowed_books" +
					"(book_id, card_id, borrowed_epoch, return_epoch)"  +
					"VALUES " +
					"("+book_id+","+card_id+", "+unixBorrowed+", "+unixReturn+");";
		stmt.execute(sql);
	}
	public boolean checkIfAlreadyBorrowed(int book_id, int card_id) throws SQLException {
		boolean result = false;
		BorrowedBook[] borrowedList = getBorrowedBooks(card_id);
		
		for(int i = 0; i < borrowedList.length; i++) {
			
			if(book_id == borrowedList[i].getBook_ID()) {
				result = true;
			}
		}
		return result;
	}
	public BorrowedBook[] getBorrowedBooks(int card_id) throws SQLException {

		ArrayList<BorrowedBook> borrowed_list = new ArrayList<BorrowedBook>();
		String title, author, genre, publisher;
		long isbn, borrowed_epoch, return_epoch;
		int pages, book_id;
		String sql = "SELECT * FROM books INNER JOIN borrowed_books USING(book_id)"
					+ " WHERE card_id = "+card_id;
		
		ResultSet rs = stmt.executeQuery(sql);		
		
		while (rs.next()) {
			book_id = rs.getInt("book_id");
			borrowed_epoch = rs.getLong("borrowed_epoch");
			return_epoch = rs.getLong("return_epoch");
			title = rs.getString("title");
			author = rs.getString("author");
			genre = rs.getString("genre");
			publisher = rs.getString("publisher");
			isbn = rs.getLong("isbn");
			pages = rs.getInt("pages");
			BorrowedBook temp = new BorrowedBook(book_id,title, author, genre, publisher, pages, isbn, borrowed_epoch, return_epoch, card_id);
			borrowed_list.add(temp);	
		}
		BorrowedBook[] borrowedArray = borrowed_list.toArray(new BorrowedBook[borrowed_list.size()]);
		return borrowedArray;
	}
	public BorrowedBook getOneBorrowedBook(int card_id, int book_id) throws SQLException {
		String title, author, genre, publisher;
		long isbn, borrowed_epoch, return_epoch;
		int pages;
		String sql = "SELECT * FROM books INNER JOIN borrowed_books USING(book_id)"
					+ " WHERE card_id = "+card_id + " AND book_id = "+book_id;
		
		ResultSet rs = stmt.executeQuery(sql);		
		borrowed_epoch = rs.getLong("borrowed_epoch");
		return_epoch = rs.getLong("return_epoch");
		title = rs.getString("title");
		author = rs.getString("author");
		genre = rs.getString("genre");
		publisher = rs.getString("publisher");
		isbn = rs.getLong("isbn");
		pages = rs.getInt("pages");
		BorrowedBook result = new BorrowedBook(book_id,title, author, genre, publisher, pages, isbn, borrowed_epoch, return_epoch, card_id);	
		
		return result;
	}
	public boolean verifyLogin(String username, String password) throws SQLException {
		boolean result = false;
		String sql = "SELECT * FROM admin WHERE username = '"+username+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if (password.equals(rs.getString("password"))) {
			result = true;
		}		
		return result;
	}
	public String search(String search, String category) {
		String result = "";
		try {
			ResultSet rs = stmt.executeQuery("SELECT title, author, genre, pages, shelf  FROM books WHERE "+category+" LIKE '%"+search+"%'");  
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				String pages = rs.getString("pages");
				String shelf = rs.getString("shelf");	  
				result+="Title: " + title + "\n" +"Author: "+ author + "\n" +"Genre: "+ genre + "\n" +"Number of pages: "+pages + "\n" + "Shelf:"+shelf+ "\n";
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return result;
	}
	public void addDebt(int card_id, int debt) throws SQLException {
		String sql = "UPDATE INTO customer_debt" +
					 "SET accumulated_debt = accumulated_debt + ? " +
					 "WHERE card_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, debt);
		pstmt.setInt(2, card_id);
	}
	public void payDebt(int card_id, int payment) throws SQLException {
		String sql = "UPDATE INTO customer_debt" +
				 "SET paid = paid + ? " +
				 "WHERE card_id = ? ";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, payment);
	pstmt.setInt(2, card_id);
	}
	public void returnBook(int card_id, int book_id, int rating) throws SQLException {
		BorrowedBook book;
		book = getOneBorrowedBook(card_id, book_id);
		if (!book.onTime()) {
			int debt = 0;
			debt = book.getDaysOver() * 2;
			addDebt(card_id, debt);
		}
		String onTime =book.returnOnTime();
		String insertHistory = "INSERT INTO history " +
				 "(card_id, book_id, returned_on_time, rating)" +
				 "VALUES " +
				 "( ?, ?, ?, ?);";
		PreparedStatement insert = conn.prepareStatement(insertHistory);
		insert.setInt(1, card_id);
		insert.setInt(2, book_id);
		insert.setString(3, onTime);
		insert.setInt(4, rating);
		insert.execute();
		String deleteBorrowed =  "DELETE FROM borrowed_books WHERE card_id = ? AND book_id = ?";		
		PreparedStatement delete = conn.prepareStatement(deleteBorrowed);
		delete.setInt(1, card_id);
		delete.setInt(2, book_id);
		delete.execute();
	}
	public boolean checkIfAvailable(int book_id) throws SQLException {
		boolean result = false;
		int quantity, borrowed;
		String countBooks = "SELECT count(*) FROM borrowed_books WHERE book_id ="+book_id;
		ResultSet nrOfBorrowed = stmt.executeQuery(countBooks);
		borrowed = nrOfBorrowed.getInt(1);
		String sqlQuantity = "SELECT quantity FROM books WHERE book_id ="+book_id;
		ResultSet bookQuantity = stmt.executeQuery(sqlQuantity);
		quantity = bookQuantity.getInt("quantity");
		if(borrowed >= quantity) {
			result = false;
		}
		else if (borrowed < quantity) {
			result = true;
		}
		return result;
	}
}
