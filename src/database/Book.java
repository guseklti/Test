package database;

public class Book {
	final String EOL = System.lineSeparator();
	private String title, author, genre, publisher;
	private int pages, book_id;
	private long isbn;
	
	public Book(String title, String author, String genre, String publisher, int pages, long isbn, int book_id) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.pages = pages;
		this.isbn = isbn;
		this.book_id = book_id;
	}

	public String toString() {
		
		String result = "|Title: " + title + 
						"| Author: " + author +
						"| Genre: " + genre +
						"| Publisher: " + publisher  +
						"| Pages: " + pages + 
						"| ISBN: " + isbn;
		return result;		

	}
	public int getBook_ID() {
		return book_id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getGenre() {
		return genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getPages() {
		return pages;
	}
	public long getIsbn() {
		return isbn;
	}
}
