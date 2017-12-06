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
				break;
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
				//checkAvailable();
				break;
			case 6:
				reserveBook();
				break;
			case 7:
				checkDelayed();
				break;
			case 8:
				changeQuantityInput();
				break;
			case 9:
				removeBookInput();
				break;
			default: 
				System.out.println("Invalid input.");
				adminMenu();
			}
		} while (choice != 0);
	}
	public String menuList() {
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
						"0. To logout" + EOL +
						"1. Add a book" + EOL +
						"2. Add a customer" + EOL +
						"3. Who has borrowed a specific book"  + EOL +
						"4. All lent out books" + EOL +
						"5. Availability of a book "  + EOL +
						"6. Reserve a book" + EOL +
						"7. Check delayed books" + EOL +
						"8. Change quantity of a book" + EOL +
						"9. Remove a book" + EOL + 
						"------------------------" + EOL +
						"Enter choice: ";
		return result;
	}
	public char yesOrNo() {
		char result;
		result = readChar();
		if (result == 'n' || result == 'N' || result == 'Y' || result == 'y') {
			return result;
		}
		else { 
			System.out.println("Incorrect input. You must answer with Y or N.");
			yesOrNo();
		}
		return result;
	}
	public void removeBookInput() throws SQLException {
		System.out.println("Input the ID of the book you'd like to remove: ");
		int book_id = readInt();
		System.out.println(library.searchOneBook(book_id));
		System.out.println("Confirm deleting this book from the registry? Y/N");
		char choice = yesOrNo();
		if(choice == 'y' || choice == 'Y') {
			library.removeBook(book_id);
			System.out.println("Book deleted.");
		}
		else if(choice == 'n' || choice == 'N') {
			System.out.println("Book was not deleted.");
		}
	}
	public void changeQuantityInput() {
		System.out.println("");
		int choice = readInt();
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
		int card_id, book_id, nrWeeks;
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
		else {
			nrWeeks = readWeeks();
			library.addBorrowed(book_id, card_id, nrWeeks);
		}
	}
	public void listBorrowedBooks() throws SQLException {
		int card_id;
		card_id = readCardID();
		String listOfBooks = "";
		BorrowedBook[] borrowedList = library.getBorrowedBooks(card_id);
		if (borrowedList.length <= 0) {
			System.out.println("You currently have no borrowed books.");
		}
		else {
			for(int i = 0; i < borrowedList.length; i++) {
				listOfBooks+= borrowedList[i].toString() + EOL;
			}
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
	public void checkAvailableAmount() {
		
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
	public int readWeeks() {
		int result;
		System.out.println("How many weeks would you like to borrow the book? (No more than 8 consecutive weeks)");
		result = readInt();
		if(result >= 1 && result <= 8) {
			return result;
		}
		else {
			System.out.println("The amount of weeks must be between 1 and 8.");
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
			searchInput(category);
			break;
		case 2: 
			category="author";
			searchInput(category);
			break;
		case 3: 
			category="genre";
			searchInput(category);
			break;
		case 4:
			category="publisher";
			searchInput(category);
			break;
		default: 
			System.out.println("Invalid input");
			searchBook();
		}
	}
	public void searchInput(String category) {
		String searchPhrase="";
		System.out.println("Search phrase: ");
		searchPhrase = readLine();
		Book[] searchResult = library.search(searchPhrase, category);
		for (Book book : searchResult) {
			System.out.println(book);
		}
	}
	public static void main(String[] args) throws SQLException {
		Main program = new Main();
		program.menu();
	}
}
