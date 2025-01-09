package library;

public abstract class Book {
	private String title;
	private Author author;
	private boolean isAvailable;
	
	
	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	public String getTitle() {
		return title;
	}


	public Author getAuthor() {
		return author;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	abstract void displayDetails();

}



//1. Class: Book (Abstract Class)
//● Purpose: Serves as a base class for all types of books.
//● Attributes:
//○ String title-Thetitle of the book.
//○ Author author-Theauthor of the book.
//○ boolean isAvailable- Indicates whether the book is available for
//rent.
//● Methods:
//○ String getTitle()- Returns the title of the book.
//○ Author getAuthor()- Returns the associated author.
//○ boolean isAvailable()- Returns whether the book is available
//for rent.
//○ void setAvailability(boolean)- Updates the availability
//status.
//○ abstract void displayDetails()- Abstract method to display
//specific details of the book (implemented by subclasses)