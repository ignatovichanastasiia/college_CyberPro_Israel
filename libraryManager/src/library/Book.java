package library;

public abstract class Book {
	private static int counter=0;
	private int number;
	private String title;
	private Author author;
	private boolean isAvailable;
	private String tookBy;
	
	
	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
		this.number = ++counter;
		this.author.insertToAuthorsBooks(this);	
		this.tookBy = "";
	}
	
	public boolean takeBook(String name) {
		if(!this.isAvailable || name.isBlank()) {
			return false;
		}
		this.isAvailable = false;
		this.tookBy = name;
		return true;
	}
	
	public boolean returnBook(String name){
			if(this.isAvailable || !this.tookBy.equalsIgnoreCase(name)) {
				return false;
			}
			this.isAvailable = true;
			this.tookBy = "nobody";
			return true;
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
	

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
	

	public String getTookBy() {
		return tookBy;
	}

	public void setTookBy(String tookBy) {
		this.tookBy = tookBy;
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