package library;

import java.util.ArrayList;

public class Author {
	private String name;
	private String biography;
	private ArrayList<Book> authorsBooks;	
	
	
	public Author(String name, String biography) {
		this.name = name;
		this.biography = biography;
		this.authorsBooks = new ArrayList<Book>();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}


	public ArrayList<Book> getAuthorsBooks() {
		return authorsBooks;
	}
	
	public String booksToString() {
		StringBuilder sb = new StringBuilder();
		authorsBooks.forEach(b -> sb.append(b.getNumber()+" "+b.getTitle()+" is Available: "+b.isAvailable()+"\n"));
		return sb.toString();
	}


	public void insertToAuthorsBooks(Book book) {
		authorsBooks.add(book);
	}
	
	
		
}


//
//4. Class: Author
//● Purpose: Represents an author who is associated with books.
//● Attributes:
//○ String name-Thenameof the author.
//○ String biography- Ashort biography of the author.
//● Methods:
//○ String getName()- Returns the name of the author.
//○ String getBiography()- Returns the biography of the author
