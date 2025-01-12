package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	private static int program = 1;
	private static String clientName;
	private static int clientsBookNum;
	private static boolean took;
	private static String clientTitle;
	private static Author clientAuthor;
	private static String clientAuthorsBiography;
	
	//authors 
	private static Author nik = new Author("Nik","Mystery");
	private static Author mik = new Author("Mik","Mystery");
	private static Author samanta = new Author("Samanta","Fiction");
	private static Author jake = new Author("Jake","Fiction");
	private static Author lose = new Author("Lose","Fiction");
	
	//PaperBook(String title, Author author, boolean isAvailable, String shelfLocation)
	private static Book b1 = new PaperBook("Book1",nik,"a5");
	private static Book b2 = new PaperBook("Book2",nik,"a8");
	private static Book b3 = new PaperBook("Book3",mik,"b2");
	private static Book b4 = new PaperBook("Book4",nik,"b3");
	private static Book b5 = new PaperBook("Book5",samanta,"b6");
	
	//EBook(String title, Author author, double fileSize)
	private static Book b6 = new EBook("Book6",jake,455);
	private static Book b7 = new EBook("Book7",jake,677);
	private static Book b8 = new EBook("Book8",lose,654);
	private static Book b9 = new EBook("Book9",lose,678);
	
	//arrays and array lists
	private static Book[] pbooks = {b1,b2,b3,b4,b5};
	private static Book[] ebooks = {b6,b7,b8,b9};
	private static List<Book> pbooksList = new ArrayList<Book>();
	private static List<Book> ebooksList = new ArrayList<Book>();
	private static Author[] authors = {nik,mik,samanta,jake,lose};
	private static List<Author> authorsList = new ArrayList<Author>();
	
	//scanner 
	private static Scanner sc = new Scanner(System.in);
	

	public static void main(String[]args) {
		//doing lists
		pbooksList = Arrays.asList(pbooks);
		ebooksList = Arrays.asList(ebooks);
		authorsList = Arrays.asList(authors); 
//		
//		enterClientName();
//		//loop with the menu 		
//		do {
//			menuText();
//			program = sc.nextInt();
//			if(program>=0 && program<10) {
//				System.out.println("You enter program "+program);
//				doProgram(program);
//			}else {
//				System.out.println("Number is not correct");
//			}
//		}while(program != 0);
//		exit();

	}
	
	private static void enterClientName() {
		System.out.println("Enter your name: ");
		clientName = sc.nextLine();
	}
	
	private static void menuText(){

	System.out.println("It is your menu. Enter number of program:\n "
			+ "Informations: 1 - all books by authors, 2 - paper books, 3 - ebooks. \n"
			+ "Take a book: 4 - paper books, 5 - ebooks. \n "
			+"Reseve: 6 - paper books, 7 - ebooks.\n "
			+ "Add: 8 - any book. \n Delete: 9 - any book. \n"
			+ "0 - exit" );	
	}
	
	private static void doProgram(int prog) {
		switch(program) {
			case 1: 
				booksByAuthors();
				break;
			case 2:
				pbooksList.forEach(p -> p.displayDetails());
				break;
			case 3:
				ebooksList.forEach(e -> e.displayDetails());
				break;
			case 4:	
				System.out.println("Your choose is 4: you want to take a paper book frow the library.");
				takeBookFromMenu('p');
				System.out.println("The book was taken: "+took);
				break;
			case 5:
				System.out.println("Your choose is 5: you want to take a ebook frow the library.");
				takeBookFromMenu('e');
				System.out.println("The book was taken: "+took);
				break;				
			case 6:
				System.out.println("Your choose is 6: you want to return a paper book to the library.");
				returnBookFromMenu('p');			
				break;
			case 7:
				System.out.println("Your choose is 7: you want to return a ebook to the library.");
				returnBookFromMenu('e');
				break;
			case 8:
				System.out.println("Your choose is 8: you want to add a book to the library.");
				addBook();
				break;				
			case 9:
				System.out.println("Your choose is 9: you want to delete a book to the library.");
				deleteBook();
				break;				
			default:
				
		}		
	}
	
//	private static void booksByAuthors() {
//		ArrayList<String> aL = new ArrayList<String>();
//		pbooksList.forEach(p -> aL.add(p.getAuthor().getName()+" - "+p.getTitle()+", is available: "+p.isAvailable()));
//		ebooksList.forEach(e -> aL.add(e.getAuthor().getName()+" - "+e.getTitle()+", is available: "+e.isAvailable()));
//		Collections.sort(aL);
//		aL.forEach(a -> System.out.println(a));
//	}
	
	private static void booksByAuthors() {
		authorsList.forEach(a -> System.out.println("Author: "+a.getName()+" - "+a.getBiography()+": \n"+ a.booksToString()+"\n"));	
	}
	
	//TODO
	private static boolean takeBookFromMenu(char type){
		System.out.println("Enter number of the book or enter 0 for print all books");
		clientsBookNum = sc.nextInt();
		if(clientsBookNum==0) {
			booksByAuthors();
			System.out.println("Enter number of the book: ");
			clientsBookNum = sc.nextInt();
		}
		if(type=='p') {
			pbooksList.forEach(new Consumer<Book>() {
				   @Override
				   public void accept(Book book) {
				       if(clientsBookNum!=0 && clientsBookNum==book.getNumber()) {
				    	   took= book.takeBook(clientName);
				       }
				   }
				});
	    }else if(type=='e') {
			ebooksList.forEach(new Consumer<Book>() {
				   @Override
				   public void accept(Book book) {
				       if(clientsBookNum!=0 && clientsBookNum==book.getNumber()) {
				    	   took= book.takeBook(clientName);
				       }
				   }
				});
		}
		return took;
	}
	
	private static void returnBookFromMenu(char type) {
	    if(type == 'p') {
	        pbooksList.forEach(book -> {
	            if(clientName.equalsIgnoreCase(book.getTookBy())) {
	                if(book.returnBook(clientName)) {
	                    System.out.println("The paper book was returned");
	                }
	            }
	        });
	    } else if(type == 'e') {
	        ebooksList.forEach(book -> {
	            if(clientName.equalsIgnoreCase(book.getTookBy())) {
	                if(book.returnBook(clientName)) {
	                    System.out.println("The e-book was returned");  
	                }
	            }
	        });
	    }
	}
	
	private static void addBook() {
		//Book(String title, Author author) - new Book
		System.out.println("Enter title of the book:");
		clientTitle = sc.next();
		System.out.println("Enter author of the book:");
		String authorName = sc.next();
		System.out.println("Enter file size of the book, if it's exist or enter 0:");
		double fileSize = sc.nextDouble();
		System.out.println("Enter shelfLocation, if it's paper book or enter \"no\":");
		String selflocation = sc.next();
		authorsList.forEach(new Consumer<Author>() {
		   @Override
		   public void accept(Author a) {
		       if(a.getName().contains(authorName)) {
		    	   clientAuthor = a;
		       }else {
		    	   System.out.println("Enter biography: ");
		    	   clientAuthorsBiography = sc.next();
		    	   Author b = new Author(authorName, clientAuthorsBiography);
		    	   clientAuthor = b;
		       }
		       if(fileSize == 0) {
		    	   Book book = new PaperBook(clientTitle,clientAuthor,selflocation);
		    	   System.out.println("Paper book has been added");
		       }else {
		    	   Book book = new EBook(clientTitle,clientAuthor,fileSize);
		    	   System.out.println("Ebook has been added");   
		       }
		   }
		});
	}
	
	private static void deleteBook() {
		System.out.println("Enter title of the book you want to delete: ");
		clientTitle = sc.next();
//		clientTitle.isBlank() TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		ebooksList.forEach(new Consumer<Book>() {
			   @Override
			   public void accept(Book book) {
			       if(clientTitle.equalsIgnoreCase(book.getTitle())) {
			    	   ebooksList.remove(book);
			    	   System.out.println("The EBook was erased from list.");
			       }
			   }
			});
		pbooksList.forEach(new Consumer<Book>() {
			   @Override
			   public void accept(Book book) {
				   if(clientTitle.equalsIgnoreCase(book.getTitle())) {
					   pbooksList.remove(book);
					   System.out.println("The paper book was erased from list.");
			       }
			   }
			});
		
	}
	
	
	private static void exit() {
		System.out.println("Good bye.");
		sc.close();
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
