package database;
import static dit042.SimpleIO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Main {
	static Database library;
	static boolean adminStatus = false;
	final String EOL = System.lineSeparator();
	public Main() throws SQLException {
		library = new Database();
	}
	public void menu() throws SQLException  {
		int choice;
		do {
			System.out.println(menuList());
			choice = readInt();

			switch (choice) {
			case 0:
				System.out.println("Exiting database program.");
				break;
				/*case 1:
				list_db_Choice();
				break; */
			case 2:
				searchBook();
				break;
			case 3:
				addBookInput();
				break;
			case 5:
				listBorrowedBooks();
				break;
			case 6: 
				borrowBook();
				break;
			case 7:
				login();
			case 8:
				returnBookInput();
				break;
			default:
				System.out.println("Invalid input.");
				menu();
			}
		} while (choice != 0);
	}
	public void adminMenu() throws SQLException {
		int choice;
		do {
			System.out.println(adminMenuList());
			choice = readInt();
			
			switch (choice) {
			case 0:
				System.out.println("Logging out.");
				adminStatus = false;
				break;
			case 1:
				addBookInput();
				break;
			case 2:
				addCustomerInput();
				break;
			case 3: 
				listBorrowedBooks(adminStatus);
				break;
			case 4:
				listBorrowedBooks();
			case 5:
				checkAvailable();
				break;
			case 6:
				reserveBook();
				break;
			case 7:
				checkDelayed();
				break;
			default: 
				System.out.println("Invalid input.");
				adminMenu();
			}
		} while (choice != 0);
	}
	public  String menuList() {
		String result = "======|| Welcome to the Library Database ||=====" + EOL +
				"1. List a databse" + EOL +
				"2. Search for a book" + EOL +
				"3. Add a book" + EOL +
				"5. View borrowed books" + EOL +
				"6. Borrow a book" + EOL +
				"7. Admin login" + EOL +
				"8. Return a book" + EOL +
				"================================================" + EOL +
				"Enter choice: ";
		return result;	
	}
	public String adminMenuList() {
		String result = "||>>>>Admin Page <<<<<||" + EOL +
						"1. Add a book" + EOL +
						"2. Add a customer" + EOL +
						"3. Who has borrowed a specific book"  + EOL +
						"4. All lent out books" + EOL +
						"5. Availability of a book "  + EOL +
						"6. Reserve a book" + EOL +
						"7. Check delayed books" + EOL +
						"------------------------" + EOL +
						"Enter choice: ";
		return result;
	}
	public void addBookInput() throws SQLException {
		int shelf, quantity, pages;
		String isbn, title, author, genre, publisher;
		System.out.println("Adding a book");
		System.out.println("ISBN: ");
		isbn = readString();
		System.out.println("Title: ");
		title = readLine();
		System.out.println("Author: ");
		author = readLine();
		System.out.println("Genre: ");
		genre = readLine();
		System.out.println("Shelf: ");
		shelf = readInt();
		System.out.println("Publisher: ");
		publisher = readLine();
		System.out.println("Quantity: ");
		quantity = readInt();
		System.out.println("Pages: ");
		pages = readInt();
		library.addBook(isbn, title, author, genre, shelf, publisher, quantity, pages);
	}
	public void addCustomerInput() throws SQLException {
		int card_id;
		String name, address, phone_nr;
		System.out.println("Adding a customer");
		System.out.println("Card id: ");
		card_id = readCardID();
		System.out.println("Name: ");
		name = readLine();
		System.out.println("Address");
		address = readLine();
		System.out.println("Phone nr: ");
		phone_nr = readLine();
		library.addCustomer(card_id, name, address, phone_nr);
	}
	public void borrowBook() throws SQLException {
		int card_id, book_id;
		System.out.println("Input the ID of the chosen book: ");
		book_id = readInt();
		card_id = readCardID();
		if (library.checkIfAlreadyBorrowed(book_id, card_id)) {
			System.out.println("You are not allowed to borrow several copies of the same book.");
			return;
		}
		if (!library.checkIfAvailable(book_id)) {
			System.out.println("All copies of this book is currently lent out.");
			return;
		}
		else {library.addBorrowed(book_id, card_id);}
	}
	public void listBorrowedBooks() throws SQLException {
		int card_id;
		card_id = readCardID();
		String listOfBooks = "";
		BorrowedBook[] borrowedList = library.getBorrowedBooks(card_id);
		
		for(int i = 0; i < borrowedList.length; i++) {
			
			listOfBooks+= borrowedList[i].toString() + EOL;
		}
		System.out.println(listOfBooks);
	}
	public void listBorrowedBooks(int card_id) throws SQLException {
		String listOfBooks = "";
		BorrowedBook[] borrowedList = library.getBorrowedBooks(card_id);
		for(int i = 0; i < borrowedList.length; i++) {
			listOfBooks+= borrowedList[i].toStringReturn() + EOL;
		}
		System.out.println(listOfBooks);
	}
	public void listBorrowedBooks(boolean admin) throws SQLException {
		//TO-DO
	}
	public void listDelayedBooks() throws SQLException {
		
		BorrowedBook[] delayedBooks = library.getDelayedBooks();
		
		
	}
	public void checkAvailable() {
		//TO-DO
	}
	public void reserveBook() {
		//TO-DO
	}
	public int readCardID() {
		int result;
		String check = "";
		System.out.println("Input the Library Card ID: ");
		result = readInt();
		check += result;
		if (check.length() < 4 || check.length() > 4) {
			System.out.println("Library Card ID is only 4 digits long, please try again.");
			readCardID();
		}
		return result;
	}
	public int readRating() {
		int result;
		System.out.println("Rate the book between 1 and 5");
		result = readInt();
		if(result >= 1 && result <= 5) {
			return result;
		}
		else {
			System.out.println("Rating must be between 1 to 5.");
			readRating();
		}
		return result;
	}
	public int rateBook() {
		int rating = 0;
		char ratingChoice;
		System.out.println("Would you like to rate the book? Y/N");
		ratingChoice = readChar();
		if(ratingChoice == 'y' || ratingChoice == 'Y') {
			rating = readRating();
		}
		else if (ratingChoice == 'n' || ratingChoice == 'N') {
			rating = 0;
		}
		return rating;
	}
	public void returnBookInput()throws SQLException {
		int card_id, book_id,rating;
		char ratingChoice;
		card_id = readCardID();
		listBorrowedBooks(card_id);
		System.out.println("Which book would you like to return?"+ EOL +
							"Please input the Book ID: ");
		book_id = readInt();
		rating = rateBook();
		library.returnBook(card_id, book_id, rating);
		System.out.println("Book has been returned.");
	}
	public void login() throws SQLException {
		String username, password;
		char choice;
		System.out.println("Username: ");
		username = readString();
		System.out.println("Password: ");
		password = readString();
		
		if (library.verifyLogin(username, password)) {
			adminStatus = true;
			adminMenu();
		}
		else {
			System.out.println("Incorrect login. Try again? Y/N");
			choice = readChar();
			if (choice == 'y' || choice == 'Y') {
				login();
			}
			else if (choice == 'n' || choice == 'N') {
				return;
			}
		}
	}
	public void checkDelayed() throws SQLException {
		
		System.out.println(library.getDelayedBooksList());
		
	}
	public void searchBook() throws SQLException {
		System.out.println("Search by...");
		System.out.println("1) Title");
		System.out.println("2) Author");
		System.out.println("3) Genre");
		int option = readInt();
		String searchPhrase, category = "";
		switch(option) {
		case 1 :
			category="title";
			break;
		case 2: 
			category="author";;
			break;
		case 3: 
			category="genre";
			break;
		case 4:
			category="publisher";
			break;
		default: 
			System.out.println("Invalid input");
			searchBook();
		}
		System.out.println("Search phrase: ");
		searchPhrase = readLine();
		System.out.println(library.search(searchPhrase, category));
	}
	public static void main(String[] args) throws SQLException {
		Main program = new Main();
		program.menu();
	}

}
