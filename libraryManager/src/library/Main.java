package library;


//TODO
public class Main {
	Author nik = new Author("Nik","Mystery");
	Author mik = new Author("Mik","Mystery");
	Author samanta = new Author("Samanta","Fiction");
	Author jake = new Author("Jake","Fiction");
	Author lose = new Author("Lose","Fiction");
	
	//PaperBook(String title, Author author, boolean isAvailable, String shelfLocation)
	Book b1 = new PaperBook("Book1",nik,"a5");
	Book b2 = new PaperBook("Book2",nik,"a8");
	Book b3 = new PaperBook("Book3",mik,"b2");
	Book b4 = new PaperBook("Book4",nik,"b3");
	Book b5 = new PaperBook("Book5",samanta,"b6");
	//EBook(String title, Author author, double fileSize)
	Book b6 = new EBook("Book6",jake,455);
	Book b7 = new EBook("Book7",jake,677);
	Book b8 = new EBook("Book8",lose,654);
	Book b9 = new EBook("Book9",lose,678);
	
	//Arrs
	Book[] books = {b1,b2,b3,b4,b5,b6,b7,b8,b9};
	Author[] authors = {nik,mik,samanta,jake,lose};
	
	public static void main(String[]args) {
		menu();

		
		
		
		
	}
	
	private static void menu(){
	System.out.println("It is your menu. Enter number of program:\n "
			+ "1 - all books, 2 - ebooks, ");
	}

}

//
//5. Main
//The main method will act as the user interface through the console. It will present a
//menu of options, allow the user to select an action, and perform the corresponding
//operation. Here's an example of how it would look when running:
//HowIt Works
//● Theprogram runs in a loop until the user selects "Exit."
//● Foreach action, the system processes the request (e.g., creating, renting,
//returning, deleting, or displaying a book) and prints feedback.
//● Theoutput is designed to provide clear and concise information about the
//system's state after each action
