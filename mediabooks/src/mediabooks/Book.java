package mediabooks;

public class Book extends MediaItem{
	private int pages;

	public Book(String title, int pages) {
		super(title);
		setPages(pages);
	}
	
	
	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		if(pages>0) {
		this.pages = pages;
		}
	}


	
	@Override
	public void getDetails() {
		System.out.println("This book "+getTitle()+" with "+pages+" pages. And it is "+getStatus()+" now.");
	}

}


//Book Class (Subclass)
//The Book class represents a book, inheriting from MediaItem.
//● Additional Field:
//○ int pages: The number of pages in the book.
//● Methods:
//○ Book(String title, int pages): Constructor to set the title and
//number of pages.
//○ getDetails(): Overrides getDetails() from MediaItem to return
//the book's specific details (e.g., title and page count).

