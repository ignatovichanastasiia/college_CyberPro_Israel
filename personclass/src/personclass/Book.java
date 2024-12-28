package personclass;

public class Book {
	String title;
	String author;
	int maxPages;
	int currentPage;
	
	Book(String title,String author,int maxPages, int currentPage) {
		this.title= title;
		this.author = author;
		this.maxPages = maxPages;
		this.currentPage = currentPage;
	}
	
	public void read() {
		System.out.println("Reading "+title+" by "+author+".");
	}
	
	public void readPages(int among) {
		if(among<=maxPages&&among>0) {
			currentPage = among;
			System.out.println("Reading... page "+currentPage);
			if(among>(maxPages/3*2)){
				System.out.println("This is less than a third of the book left");
			}else if(among>(maxPages/2)) {
				System.out.println("This is less than half of the book left.");
			}
		}else {
			System.out.println("This is not real page.");
		}
	}

}


//1. Create a class Book with:
//○ Attributes: String title, String author, int maxPages, int currentPage
//○ Method: read() that prints
//i. Reading [title] by [author].
//○ Method: readPAges(int amount) that adds that number (must be
//positive) to the currentPages, and print if we have left less than half or
//fourth of the maxPages.
//2. In the Main class, instantiate a Book object, set its attributes, and call read().
