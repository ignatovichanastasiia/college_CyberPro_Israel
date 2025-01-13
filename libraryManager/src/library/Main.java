package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	private static int program = 1;
	private static String clientName;
	private static int clientsBookNum;
	private static boolean took;
	private static String clientTitle;
	private static String clientAuthorName;
	private static Author clientAuthor;
	private static String clientAuthorsBiography;
	private static String clientSelflocation;
	private static double clientFileSize;
	private static boolean done;
	
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
		
		try {
			enterClientName();
			//loop with the menu 		
			do {
				menuText();
				program = sc.nextInt();
					if(program>=0 && program<10) {
						System.out.println("You entered program "+program);
						doProgram(program);
					}else {
						System.out.println("Number is not correct");
					}
			}while(program != 0);
		}catch(Exception e) {
			System.out.println("Something wrong... \n"+e.getMessage());
		};
		exit();

	}
	
	private static void enterClientName() {
		System.out.println("Enter your name: ");
		clientName = sc.nextLine();
	}
	
	private static void menuText(){

	System.out.println("It is your menu. Enter number of program:\n"
			+ "Informations: \n1 - all books by authors, 2 - paper books, 3 - ebooks. \n"
			+ "Take a book: \n4 - paper books, 5 - ebooks. \n"
			+ "Reseve: \n6 - paper books, 7 - ebooks.\n"
			+ "Add: \n8 - any book. \nDelete: \n9 - any book. \n"
			+ "0 - exit\n" );	
	}
	
	private static void doProgram(int prog) {
		switch(program) {
			case 1: 
				booksByAuthors();
				break;
			case 2:
				pbooksList.forEach(p -> p.displayDetails());
				System.out.println("");
				break;
			case 3:
				ebooksList.forEach(e -> e.displayDetails());
				System.out.println("");
				break;
			case 4:	
				System.out.println("Your choose is 4: you want to take a paper book frow the library.");
				takeBookFromMenu('p');
				System.out.println("The book was taken: "+took+"\n");
				break;
			case 5:
				System.out.println("Your choose is 5: you want to take a ebook frow the library.");
				takeBookFromMenu('e');
				System.out.println("The book was taken: "+took+"\n");
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
				System.out.println("Your choose is 8: you want to add a book to the library. But now this program don't work.");
//				addBook();
				break;				
			case 9:
				System.out.println("Your choose is 9: you want to delete a book to the library. But now this program don't work.");
//				deleteBook();
				break;				
			default:
				
		}		
	}
	
//	This method uses searching without information from author's book-list. 
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
		done = false;
	    if(type == 'p') {
	        pbooksList.forEach(book -> {
	            if(clientName.equalsIgnoreCase(book.getTookBy())) {
	                if(clientProof(book) && book.returnBook(clientName)) {
	                    System.out.println("The paper book was returned.\n");
	                    done=true;
	                }
	             }
	            
	        });
	    } else if(type == 'e') {
	        ebooksList.forEach(book -> {
	            if(clientName.equalsIgnoreCase(book.getTookBy())) {
	                if(clientProof(book) && book.returnBook(clientName)) {
	                    System.out.println("The e-book was returned\n");
	                    done=true;
	                }  	
	            }
	            
	        });
	    } 
	    if(!done) System.out.println("We have a problem with the client name or you don't have books any more.\n");
	}
	
	private static boolean clientProof(Book book){
		System.out.println("Do you need this book?");
		book.displayDetails();
		System.out.println("Enter 1 - yes or 0 - to reserch another book : ");
		int answer = sc.nextInt();
		return (answer==1);
		
	}
	
//	DON'T WORK	
//	private static void addBook() { 
//	    // Попросим пользователя ввести имя автора
//	    System.out.println("Enter author's name");
//	    String aName = sc.nextLine();  // Используем nextLine для полного ввода
//
//	    // Попросим пользователя ввести название книги
//	    System.out.println("Enter title");
//	    String title = sc.nextLine();  // Используем nextLine для полного ввода
//
//	    // Попросим пользователя ввести биографию автора
//	    System.out.println("Enter biography");
//	    String bio = sc.nextLine();  // Используем nextLine для полного ввода
//
//	    // Попросим пользователя ввести размер книги
//	    System.out.println("Enter size");
//	    double size = sc.nextDouble();
//	    sc.nextLine();  // Считываем символ новой строки после nextDouble()
//
//	    // Попросим пользователя ввести местоположение книги
//	    System.out.println("Enter location");
//	    String location = sc.nextLine();  // Используем nextLine для полного ввода
//
//	    // Добавляем книгу в соответствующий список в зависимости от размера
//	    if(size == 0) {
//	        pbooksList.add(new PaperBook(title, new Author(aName, bio), location));    
//	        System.out.println("PB - Done!");
//	    } else {
//	        ebooksList.add(new EBook(title, new Author(aName, bio), size));
//	        System.out.println("EB - Done!");
//	    }
//	}
	
	
//	DON'T WORK	
//	private static void addBook() {
//
//		System.out.println("Enter author's name");
//		String aName = sc.next();
//		System.out.println("Enter title");
//		String title = sc.next();
//		System.out.println("Enter biography");
//		String bio = sc.next();
//		System.out.println("Enter size");
//		double size = sc.nextDouble();
//		System.out.println("Enter location");
//		String location = sc.next();
//		if(size==0) {
//			pbooksList.add(new PaperBook(title,new Author(aName,bio),location));	
//			System.out.println("PB - Done!");
//		}else {
//			ebooksList.add(new EBook(title,new Author(aName,bio),size));
//			System.out.println("EB - Done!");
//		}
//		
//	}
	
// DON'T WORK	
//	private static void addBook() {
//		//done - for operation with author
//		
//		done = false;
//		System.out.println("Enter title of the book:");
//		clientTitle = sc.next();
//		System.out.println("Enter author of the book:");
//		clientAuthorName = sc.next();
//		System.out.println("Enter file size of the book, if it's exist or enter 0:");
//		clientFileSize = sc.nextDouble();
//		System.out.println("Enter shelfLocation, if it's paper book or enter \"no\":");
//		clientSelflocation = sc.next();
//		//searching author
//		authorsList.forEach(new Consumer<Author>() {
//		   @Override
//		   public void accept(Author a) {
//		       if(a.getName().equalsIgnoreCase(clientAuthorName.trim())){
//		    	   clientAuthor = a;
//		    	   done=true;
//		       }
//		   }
//		 });
//		//doing author 	   		
//		if(!done){
//			System.out.println("Enter biography: ");
//		    clientAuthorsBiography = sc.next();
//		    Author b = new Author(clientAuthorName, clientAuthorsBiography);
//		    authorsList.add(b);
//		    clientAuthor = b;
//		  }
//		  
//		if(clientFileSize == 0) {
//		    pbooksList.add(new PaperBook(clientTitle,clientAuthor,clientSelflocation));
//		    System.out.println("Paper book has been added\n");
//		}else{
//			ebooksList.add(new EBook(clientTitle,clientAuthor,clientFileSize));
//		    System.out.println("Ebook has been added\n");   
//		}		
//	}
	
	
	
	
	
	
//	DON'T WORK
//	private static void deleteBook() {
//		booksByAuthors();
//		System.out.println("Enter title of the book you want to delete: ");
//		clientTitle = sc.next();
//		ebooksList.forEach(new Consumer<Book>() {
//			   @Override
//			   public void accept(Book book) {
//			       if(clientTitle.equalsIgnoreCase(book.getTitle())) {
//			    	   ebooksList.remove(book);
//			    	   System.out.println("The EBook was erased from list.");
//			       }
//			   }
//			});
//		pbooksList.forEach(new Consumer<Book>() {
//			   @Override
//			   public void accept(Book book) {
//				   if(clientTitle.equalsIgnoreCase(book.getTitle())) {
//					   pbooksList.remove(book);
//					   System.out.println("The paper book was erased from list.");
//			       }
//			   }
//			});
//		
//	}
	
	
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
