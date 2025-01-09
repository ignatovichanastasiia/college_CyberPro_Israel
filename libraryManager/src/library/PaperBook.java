package library;


//TODO
public class PaperBook extends Book{
	private String shelfLocation;
	
	
	public PaperBook(String title, Author author, String shelfLocation) {
		super(title, author);
		this.shelfLocation = shelfLocation;
	}
	
	
	
	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}



	void displayDetails() {
		
	}
	

}


//2. Class: PaperBook (Extends Book)
//● Purpose: Represents a physical book with additional attributes specific to
//printed editions.
//● Attributes:
//○ String shelfLocation- The location of the book in the library.
//● Methods:
//○ String getShelfLocation()- Returns the shelf location of the
//book.
//○ void displayDetails()- Displays details specific to a paper book,
//including the shelf location and availability
