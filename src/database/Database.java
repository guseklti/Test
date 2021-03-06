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

import org.mindrot.jbcrypt.BCrypt;

public class Database  {
	static final String dbUrl = "jdbc:sqlite:./sqlite/db/library.db";
	final String EOL = System.lineSeparator();
	static Connection conn;
	static Statement stmt;
	final long UNIXMONTH = 2592000;
	final long UNIXWEEK = 604800;
	public Database() throws SQLException { 
		createLibraryDatabase();
		stmt = conn.createStatement();
		createBooksTable();
		createBorrowedBooksTable();
		createCustomerTable();
		createHistoryTable();
		createAdminTable();
		createDebtTable();
		/*createAdmin("tiEkl", "hejhej123");
		createAdmin("maDan", "password");
		createAdmin("saBol", "1ab2c3");
		System.out.println("Admins created");*/
	}
	public void createAdmin(String username, String password) throws SQLException {
		String sql = "INSERT INTO admin (username, password) VALUES(?,?)";
		
		String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		PreparedStatement create = conn.prepareStatement(sql);
		create.setString(1, username);
		create.setString(2, encryptedPassword);
		create.execute();
		create.close();
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
				"rating INTEGER, " +
				" UNIQUE (card_id, book_id) ON CONFLICT REPLACE" +
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
	public void addBorrowed(int book_id, int card_id, int nrWeeks) throws SQLException {
		long unixBorrowed = System.currentTimeMillis() / 1000L;
		long unixReturn = unixBorrowed + (UNIXWEEK * nrWeeks);
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

		String sql = "SELECT * FROM books INNER JOIN borrowed_books USING(book_id)"
					+ " WHERE card_id = "+card_id;
		
		ResultSet borrowedSet = stmt.executeQuery(sql);		
		BorrowedBook[] borrowedArray = getBorrowedArray(borrowedSet, card_id );
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
	public String searchOneBook(int book_id) throws SQLException {
		String title, author, genre, publisher;
		long isbn;
		int pages, quantity;
		double rating;
		String sql = "SELECT * FROM books books "
					+ " WHERE book_id = "+book_id;
		
		ResultSet rs = stmt.executeQuery(sql);		
		title = rs.getString("title");
		author = rs.getString("author");
		genre = rs.getString("genre");
		publisher = rs.getString("publisher");
		isbn = rs.getLong("isbn");
		pages = rs.getInt("pages");
		quantity = getNumberAvailable(book_id);
		rating = getRating(book_id);
		Book searchedBook = new Book(title, author, genre, publisher, pages, isbn, book_id, quantity, rating);			
		String result = searchedBook.toString();
		rs.close();
		stmt.close();
		return result;
	}
	public String getDelayedBooksList() throws SQLException {
		long todayEpoch = System.currentTimeMillis() / 1000L;
		String result= "";
		String title, author, genre, publisher;
		long isbn, borrowed_epoch, return_epoch;
		int pages, book_id, card_id;
		ArrayList<BorrowedBook> delayedList = new ArrayList<BorrowedBook>();
		String sql = "SELECT * FROM books INNER JOIN borrowed_books USING(book_id)  WHERE return_epoch <" + todayEpoch +
				" ORDER BY card_id asc";
		
		ResultSet books = stmt.executeQuery(sql);
		
		while(books.next()) {
			book_id = books.getInt("book_id");
			borrowed_epoch = books.getLong("borrowed_epoch");
			return_epoch = books.getLong("return_epoch");
			title = books.getString("title");
			author = books.getString("author");
			genre = books.getString("genre");
			publisher = books.getString("publisher");
			isbn = books.getLong("isbn");
			pages = books.getInt("pages");
			card_id = books.getInt("card_id");
			BorrowedBook temp = new BorrowedBook(book_id,title, author, genre, publisher, pages, isbn, borrowed_epoch, return_epoch, card_id);
			delayedList.add(temp);
		}
		
		for(BorrowedBook delayedBook : delayedList) {
			result+= delayedBook.delayedString() + EOL;
		}
		
		return result;
	}
	public boolean verifyLogin(String username, String password) throws SQLException {
		boolean result = false;
		String sql = "SELECT * FROM admin WHERE username = '"+username+"'";
		ResultSet rs = stmt.executeQuery(sql);
		String hashed = rs.getString("password");
		if (BCrypt.checkpw(password, hashed)) {
			result = true;
		}		
		return result;
	}
	public Book[] search(String search, String category) {
		ArrayList<Book> searchedBooks = new ArrayList<Book>();
		String sql = "SELECT * FROM books " +
				"WHERE "+category+" LIKE '%"+search+"%' "+ 
				" ORDER BY  title ASC ";
		try {
			ResultSet rs = stmt.executeQuery(sql);  
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				String publisher = rs.getString("publisher");
				int pages = rs.getInt("pages");
				int shelf = rs.getInt("shelf");	  
				int book_id = rs.getInt("book_id");
				long isbn = rs.getLong("isbn");
				int quantity = getNumberAvailable(book_id);
				double rating = getRating(book_id);
				Book temp = new Book(title, author, genre, publisher, pages, isbn, book_id, quantity, rating);	
				searchedBooks.add(temp);
			}
			Book[] searchedArray = searchedBooks.toArray(new Book[searchedBooks.size()]);
			return searchedArray;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	public double[] getRating(Book[] searchedArray) throws SQLException {
		
		double[] ratingArray = new double[searchedArray.length];
		
		for(int i = 0; i < searchedArray.length; i++) {
			double count = 0, sum = 0;
			String sqlCount = "SELECT count(*) FROM history WHERE book_id =" + searchedArray[i].getBook_ID() + " AND rating > 0";
			String sqlSum = "SELECT sum(rating) FROM history WHERE book_id =" + searchedArray[i].getBook_ID(); 
			
			ResultSet rsCount = stmt.executeQuery(sqlCount);
			count = rsCount.getInt(1);
			ResultSet rsSum = stmt.executeQuery(sqlSum);
			sum =rsSum.getInt(1);
			double rating = sum / count; 
			ratingArray[i] = rating;
		}
		
		return ratingArray;
	}
	public double getRating(int book_id) throws SQLException {
		
		double rating;
		int count, sum;
		String sqlCount = "SELECT count(*) FROM history WHERE book_id =" + book_id + " AND rating > 0";
		String sqlSum = "SELECT sum(rating) FROM history WHERE book_id =" + book_id;
		ResultSet rsCount = stmt.executeQuery(sqlCount);
		count = rsCount.getInt(1);
		ResultSet rsSum = stmt.executeQuery(sqlSum);
		sum =rsSum.getInt(1);
		rsCount.close();
		rsSum.close();
		if (count == 0) {
			return 0;
		}
		rating = sum / count; 
		return rating;
	}
	public void addDebt(int card_id, int debt) throws SQLException {
		String sql = "UPDATE customer_debt " +
					 " SET accumulated_fees = accumulated_fees + ? " +
					 " WHERE card_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, debt);
		pstmt.setInt(2, card_id);
		pstmt.executeUpdate();
		pstmt.close();
	}
	public void payDebt(int card_id, int payment) throws SQLException {
		String sql = "UPDATE customer_debt " +
				 " SET paid = paid + ? " +
				 " WHERE card_id = ? ";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, payment);
	pstmt.setInt(2, card_id);
	pstmt.executeUpdate();
	pstmt.close();
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
		if (rating <= 0) {
			insert.setNull(4, rating);
		}
		else {
			insert.setInt(4, rating);
		}
		insert.execute();
		insert.close();
		String deleteBorrowed =  "DELETE FROM borrowed_books WHERE card_id = ? AND book_id = ?";		
		PreparedStatement delete = conn.prepareStatement(deleteBorrowed);
		delete.setInt(1, card_id);
		delete.setInt(2, book_id);
		delete.execute();
		delete.close();
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
	public void removeBook(int book_id) throws SQLException {
		String delete = "DELETE FROM books WHERE book_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(delete);
		pstmt.setInt(1, book_id);
		pstmt.execute();
		pstmt.close();
		return;
	}
	public BorrowedBook[] getBorrowedArray(ResultSet borrowedSet, int card_id) throws SQLException {
		
		ArrayList<BorrowedBook> borrowed_list = new ArrayList<BorrowedBook>();
		String title, author, genre, publisher;
		long isbn, borrowed_epoch, return_epoch;
		int pages, book_id;
	
		while (borrowedSet.next()) {
			book_id = borrowedSet.getInt("book_id");
			borrowed_epoch = borrowedSet.getLong("borrowed_epoch");
			return_epoch = borrowedSet.getLong("return_epoch");
			title = borrowedSet.getString("title");
			author = borrowedSet.getString("author");
			genre = borrowedSet.getString("genre");
			publisher = borrowedSet.getString("publisher");
			isbn = borrowedSet.getLong("isbn");
			pages = borrowedSet.getInt("pages");
			BorrowedBook temp = new BorrowedBook(book_id,title, author, genre, publisher, pages, isbn, borrowed_epoch, return_epoch, card_id);
			borrowed_list.add(temp);	
		}
		BorrowedBook[] borrowedArray = borrowed_list.toArray(new BorrowedBook[borrowed_list.size()]);
		return borrowedArray;
	}
	public Book[] getBookArray(ResultSet bookSet) throws SQLException {
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		String title, author, genre, publisher;
		long isbn;
		int pages, book_id, quantity;
		double rating;
		while (bookSet.next()) {
			book_id = bookSet.getInt("book_id");
			title = bookSet.getString("title");
			author = bookSet.getString("author");
			genre = bookSet.getString("genre");
			publisher = bookSet.getString("publisher");
			isbn = bookSet.getLong("isbn");
			pages = bookSet.getInt("pages");
			quantity = getNumberAvailable(book_id);
			rating = getRating(book_id);
			Book temp = new Book(title, author, genre, publisher, pages, isbn, book_id, quantity, rating);
			bookList.add(temp);	
		}
		Book[] bookArray = bookList.toArray(new Book[bookList.size()]);
		return bookArray;
	}
	public Book[] getGenreBooks(String genre) throws SQLException {
		
		String sql = "SELECT * FROM books WHERE genre = ?";
		
		PreparedStatement getBooks = conn.prepareStatement(sql);
		getBooks.setString(1, genre);
		ResultSet genreBooks = getBooks.executeQuery();
		Book[] result = getBookArray(genreBooks);
		return result;
	}
	public int getNumberAvailable(int book_id) throws SQLException {
		int quantity, borrowed, result;
		String countBooks = "SELECT count(*) FROM borrowed_books WHERE book_id ="+book_id;
		ResultSet nrOfBorrowed = stmt.executeQuery(countBooks);
		borrowed = nrOfBorrowed.getInt(1);
		String sqlQuantity = "SELECT quantity FROM books WHERE book_id ="+book_id;
		ResultSet bookQuantity = stmt.executeQuery(sqlQuantity);
		quantity = bookQuantity.getInt("quantity");
		result = quantity - borrowed;
		return result;		
	}
}
