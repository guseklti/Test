package database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BorrowedBook extends Book {
	private long epoch_borrowed, epoch_return;
	private int card_id;
	

	
	public BorrowedBook(int book_id, String title, String author, String genre, String publisher, int pages, long isbn, long epoch_borrowed, long epoch_return, int card_id) {
		super(title, author, genre, publisher, pages, isbn, book_id);
		this.epoch_borrowed = epoch_borrowed;
		this.epoch_return = epoch_return;
		this.card_id = card_id;
	}
	public  String formatEpoch(long epoch) {
		 Date date = new Date(epoch * 1000L);
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String formatted = format.format(date);
		 return formatted;
	}
	public String getBorrowedDate() {
		
		String result = formatEpoch(this.epoch_borrowed);
		return result;
	}
	public String getReturnDate() {
		
		String result = formatEpoch(this.epoch_return);
		return result;
	}
	public int getDaysDue() {
		int borrowed, due;
		borrowed = (int) TimeUnit.SECONDS.toDays(System.currentTimeMillis() / 1000L);
		due = (int) TimeUnit.SECONDS.toDays(this.epoch_return);
		return due - borrowed;
	}
	public int getDaysOver() {
		int due, now;
		now = (int) TimeUnit.SECONDS.toDays(System.currentTimeMillis() / 1000L);
		due = (int) TimeUnit.SECONDS.toDays(this.epoch_return);
		return (now - due) * -1;
	}
	public boolean onTime() {

		boolean result = false;
		if((System.currentTimeMillis() / 1000L) < this.epoch_return) {
			result = true; 
		}
		else if((System.currentTimeMillis() / 1000L) > this.epoch_return) {
			result = false;
		}
		return result;
	}
	public String toString() {
		String result="";
		if((System.currentTimeMillis() / 1000L) < this.epoch_return) {
			result = this.getTitle() + " is due in " + this.getDaysDue() + " days.";  
		}
		else if((System.currentTimeMillis() / 1000L) > this.epoch_return) {
			result = this.getTitle() + " was due " + this.getDaysOver() + " days ago.";
		}
		return result;
	}
	public String toStringReturn() {
		String result="";
		if((System.currentTimeMillis() / 1000L) < this.epoch_return) {
			result ="Book ID: " + this.getBook_ID()+"." + this.getTitle() + " is due in " + this.getDaysDue() + " days.";  
		}
		else if((System.currentTimeMillis() / 1000L) > this.epoch_return) {
			result ="Book ID: " + this.getBook_ID()+"." + this.getTitle() + " was due " + this.getDaysOver() + " days ago.";
		}
		return result;
	}
	public String returnOnTime() {
		String result="";
		if((System.currentTimeMillis() / 1000L) < this.epoch_return) {
			result= "Yes";
		}
		else if((System.currentTimeMillis() / 1000L) > this.epoch_return) {
			result ="No, " + this.getDaysOver() + " days past due";
		}
		return result;
	}
	public String delayedString() {
		String result = "";
		
		result = this.toString() + " | Loaned out to Card #: " + this.card_id;
		
		return result;
	}
	
	
}
