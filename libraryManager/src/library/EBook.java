package library;

//TODO
public class EBook extends Book{
	private double fileSize;
		
	public EBook(String title, Author author, double fileSize) {
		super(title, author);
		this.fileSize = fileSize;
	}
	
	
	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	@Override 
	void displayDetails() {
		System.out.println("EBook number "+getNumber()+" - " + getTitle()+" size: " + getFileSize() + " Author: " + getAuthor().getName() + " is available: " + isAvailable());
	}

}


//3. Class: EBook (Extends Book)
//● Purpose: Represents a digital book with additional attributes specific to
//eBooks.
//● Attributes:
//○ double fileSize- The file size of the eBook in megabytes.
//● Methods:
//○ double getFileSize()- Returns the file size of the eBook.
//○ void displayDetails()- Displays details specific to an eBook,
//including file size and availability.