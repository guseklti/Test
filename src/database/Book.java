package database;

public class Book {
	final String EOL = System.lineSeparator();
	private String title, author, genre, publisher;
	private int pages, book_id, quantity;
	private long isbn;
	private double rating;
	public Book(String title, String author, String genre, String publisher, int pages, long isbn, int book_id) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.pages = pages;
		this.isbn = isbn;
		this.book_id = book_id;
	}
	public Book(String title, String author, String genre, String publisher, int pages, long isbn, int book_id, int quantity, double rating) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.pages = pages;
		this.isbn = isbn;
		this.book_id = book_id;
		this.quantity = quantity;
		this.rating = rating;
	}
	public String toString() {
		
		String result = "|Title: " + title + 
						" | Author: " + author +
						" | Genre: " + genre +
						" | Publisher: " + publisher  +
						" | Pages: " + pages +
						" | Quantity Available: " + quantity +
						" | Rating: " + rating +
						" | ISBN: " + isbn;
		return result;		

	}
	public int getBook_ID() {
		return this.book_id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getGenre() {
		return this.genre;
	}
	public String getPublisher() {
		return this.publisher;
	}
	public int getPages() {
		return this.pages;
	}
	public long getIsbn() {
		return this.isbn;
	}
	public void setRating(int count, int totalRating) {	
		this.rating = totalRating / count;
	}
	public double getRating() {
		return this.rating;
	}
	public int getQuantity() {
		return this.quantity;
	}
}
