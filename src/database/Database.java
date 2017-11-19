package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	static final String dbUrl = "jdbc:sqlite:./sqlite/db/library.db";
	final String EOL = System.lineSeparator();
	static Connection conn;
	public Database() {
		createLibraryDatabase();
		createBooksTable();
		createBorrowedBooksTable();
		createCustomerTable();
		createHistoryTable();
	}
	public void createLibraryDatabase() {
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
		try {
			conn = DriverManager.getConnection(dbUrl);
			if (conn != null) {
				System.out.println("A new database has been created.");
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void createBooksTable() {
		String sql = "CREATE TABLE IF NOT EXISTS books (\n" +
				"isbn integer PRIMARY KEY NOT NULL, \n"+
				"title text NOT NULL, \n " +
				"author text NOT NULL, \n " +
				"genre text NOT NULL, \n" +
				"shelf integer NOT NULL, \n"+
				"publisher text NOT NULL, \n" +
				"quantity integer NOT NULL, \n" +
				"pages integer NOT NULL \n" +
				");";
		try	{
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void createBorrowedBooksTable() {
		String sql = "CREATE TABLE IF NOT EXISTS borrowed_books (\n" +
				"isbn integer PRIMARY KEY NOT NULL, \n"+
				"card_id integer NOT NULL, \n " +
				"borrowed_date integer NOT NULL, \n " +
				"return_date integer NOT NULL \n" +
				");";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void createCustomerTable() {
		String sql = "CREATE TABLE IF NOT EXISTS customer (\n" +
				"card_id integer PRIMARY KEY NOT NULL, \n"+
				"name text NOT NULL, \n " +
				"address text NOT NULL, \n " +
				"phone_nr text NOT NULL\n" +
				");";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void createHistoryTable() {
		String sql = "CREATE TABLE IF NOT EXISTS history (\n" +
				"card_id integer PRIMARY KEY NOT NULL, \n"+
				"isbn integer NOT NULL, \n " +
				"returned_on_time text NOT NULL, \n " +
				"rating integer NOT NULL \n" +
				");";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void addBook(int isbn, String title, String author, String genre, int shelf, String publisher, int quantity, int pages) {
		String sql = "INSERT INTO books " + EOL +
				"(isbn, title, author, genre, shelf, publisher, quantity, pages) " + EOL +
				"VALUES " + EOL +
				"(" + isbn + ",'" + title + "', '" + author + "', '" + genre + "'," + shelf + EOL +
				",'" + publisher + "', " + quantity +"," + pages +");";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
