package database;

public class Book {
	final String EOL = System.lineSeparator();
	private String title, author, genre, publisher;
	int pages;
	long isbn;
	
	public Book(String title, String author, String genre, String publisher, int pages, long isbn) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.pages = pages;
		this.isbn = isbn;
	}

	public String toString() {
		
		String result = "Title: " + title + EOL +
						"Author: " + author + EOL +
						"Genre: " + genre + EOL +
						"Publisher: " + publisher  + EOL +
						"Pages: " + pages + EOL +
						"ISBN: " + isbn;
		return result;		

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

}
