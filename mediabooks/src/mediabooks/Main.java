package mediabooks;

import java.util.Scanner;

public class Main {
	static Book b1 = new Book("Igogo", 20);
	static Book b2 = new Book("JJJ", 200);
	static Book b3 = new Book("LLLLL", 170);
	static Book b4 = new Book("DDDD", 420);
	static DVD d1 = new DVD("FFF", 450);
	static DVD d2 = new DVD("fghj", 50);
	static DVD d3 = new DVD("rtyu", 150);
	static DVD d4 = new DVD("cvbnm,", 950);
	static Book[] books= {b1,b2,b3,b4};
	static DVD[] dvds = {d1,d2,d3,d4};
	static String[] clients = {"Zoo","Gash","Marry","July"};
	static int program = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("b1 rented: "+ b1.rent("Sanny"));
		System.out.println("b1 rented: "+b1.rent("Billy"));
		System.out.println("d1 rented: "+d1.rent(clients[1]));
		
		menu();
		System.out.println("Have a good day");
		sc.close();
	}
	
	public static void menu() {
		while(program!=6) {
			choose();
			program = sc.nextInt();
			programs(program);
		}
	}
	
	public static void choose() {
		System.out.println("Enter number of program.\n Programs: \n 1 - details about all medias.\n 2 - details about books. \n "
				+ "3 - details about dvds.\n 4 - rent media \n 5 - return media \n 6 - exit menu");
	}
	
	public static void programs(int program) {
		if(program==1) {
			detailsAllBooks();
			detailsAllDVDs();			
		}
		if(program==2) detailsAllBooks();
		if(program==3) detailsAllDVDs();
		if(program==4) rentMedia();
		if(program==5) returnMedia();
		
	}
	
	
	private static void detailsAllDVDs(){
		for(int x=0;x<dvds.length;x++) {
			dvds[x].getDetails();
		}
	}
	
	private static void detailsAllBooks(){
		for(int x=0;x<books.length;x++) {
			books[x].getDetails();
		}
	}
	
	private static void rentMedia() {
		System.out.println("1 - books, 2 - dvds, 3 - back to the menu");	
		int x = sc.nextInt();
		System.out.println("Enter your name: ");
		String name = sc.next();
		System.out.println("Enter number of media: ");
		switch(x) {
			case 1:
				for(int y=0;y<books.length;y++) {
					if(!books[y].isRented()) {
						System.out.println("n"+(y+1)+": " + books[y].getTitle());
					}
				}
				int z = sc.nextInt()-1;
				if(books[z].rent(name)) {
					System.out.println("All done"); 
				}else {
					System.out.println("Something going wrong.");
					rentMedia();
				}
				break;
			case 2:
				for(int y=0;y<dvds.length;y++) {
					if(!books[y].isRented()) {
						System.out.println("n"+(y+1)+": " + dvds[y].getTitle());
					}
				}
				int d = sc.nextInt()-1;
				if(dvds[d].rent(name)) {
					System.out.println("All done"); 
				}else {
					System.out.println("Something going wrong.");
					rentMedia();
				}
				break;
			default:
				menu();
		}
	}
	
	private static void returnMedia() {
		System.out.println("1 - books, 2 - dvds, 3 - back to the menu");	
		int x = sc.nextInt();
		System.out.println("Enter your name: ");
		String name = sc.next();
		System.out.println("Enter number of media: ");
		switch(x) {
			case 1:
				for(int y=0;y<books.length;y++) {
					if(books[y].isRented()) {
						System.out.println("n"+(y+1)+": " + books[y].getTitle());
					}
				}
				int z = sc.nextInt()-1;
				if(books[z].returnItem(name)) {
					System.out.println("All done"); 
				}else {
					System.out.println("Something going wrong.");
					rentMedia();
				}
				break;
			case 2:
				for(int y=0;y<dvds.length;y++) {
					if(books[y].isRented()) {
						System.out.println("n"+(y+1)+": " + dvds[y].getTitle());
					}
				}
				int d = sc.nextInt()-1;
				if(dvds[d].returnItem(name)) {
					System.out.println("All done"); 
				}else {
					System.out.println("Something going wrong.");
					rentMedia();
				}
				break;
			default:
				menu();
		}
	}
		
}
	
