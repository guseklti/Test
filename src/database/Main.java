package database;
import static dit042.SimpleIO.*;
public class Main {
	String DbUrl = "./sqlite/db/test.db";
	static Database library;
	final String EOL = System.lineSeparator();
	public Main() {
		library = new Database();
	}

	public void menu() {
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
				break;
			case 2:
				searchBook();
				break;*/
			case 3:
				addBookInput();
				break;
				/*case 4: 
				addCustomer();
				break;
			case 5:
				listBorrowedBooks();
				break;*/
			default:
				System.out.println("Invalid input.");
				menu();
			}
		} while (choice != 0);
	}
	public  String menuList() {
		String result = "======|| Welcome to the Library Database ||=====" + EOL +
				"1. List a databse" + EOL +
				"2. Search for a book" + EOL +
				"3. Add a book" + EOL +
				"4. Add a customer" + EOL +
				"5. View borrowed books" + EOL +
				"================================================" + EOL +
				"Enter choice: ";
		return result;	
	}
	public void addBookInput() {
		int isbn, shelf, quantity, pages;
		String title, author, genre, publisher;
		System.out.println("Adding a book");
		System.out.println("ISBN: ");
		isbn = readInt();
		System.out.println("Title: ");
		title = readString();
		System.out.println("Author: ");
		author = readString();
		System.out.println("Genre: ");
		genre = readString();
		System.out.println("Shelf: ");
		shelf = readInt();
		System.out.println("Publisher: ");
		publisher = readString();
		System.out.println("Quantity: ");
		quantity = readInt();
		System.out.println("Pages: ");
		pages = readInt();

		library.addBook(isbn, title, author, genre, shelf, publisher, quantity, pages);

	}
	public static void main(String[] args) {
		Main program = new Main();
		program.menu();
	}

}
