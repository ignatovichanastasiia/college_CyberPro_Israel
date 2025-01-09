package library;


//TODO
public class Author {
	private String name;
	private String biography;
	
	
	public Author(String name, String biography) {
		this.name = name;
		this.biography = biography;
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
