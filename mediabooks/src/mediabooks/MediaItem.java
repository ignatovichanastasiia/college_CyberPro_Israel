package mediabooks;

public class MediaItem {
	private static int counter= 1; 
	private int id;
	private String title;
	private boolean isRented;
	private String rentedBy;
	
	public MediaItem(String title) {
		int id = counter++;
		if(title.isBlank()) {
			System.out.println("Title is empty");
			title = "default";
		} else if(title.length() > 30) {
			System.out.println("Title too long!");
			title = "default";
		}
		this.title = title;			
		this.isRented = false;
	}
	
	
	public boolean isRented() {
		return isRented;
	}

	private void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public String getRentedBy() {
		return rentedBy;
	}

	private void setRentedBy(String rentedBy) {
		this.rentedBy = rentedBy;
	}
	

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean rent(String name) {
		if(this.isRented || name.isBlank()) {
			return false;
		}
		this.isRented = true;
		this.rentedBy = name;
		return true;
	}
	
	public boolean returnItem(String name) {
		if(!this.isRented || !this.rentedBy.equalsIgnoreCase(name)) {
			return false;
		}
		this.isRented = false;
		this.rentedBy = "nobody";
		return true;
	}
	
	public String getStatus() {
		if(isRented) {
			return "The item is rented by "+this.rentedBy;
		}
		return "The item is available";
	}
	
	public void getDetails() {
		System.out.println("MediaItem [id=" + id + ", title=" + title + ", isRented=" + isRented + ", rentedBy=" + rentedBy + "]");
	}

}




//: The title of the media item.
//○ boolean isRented: Indicates whether the item is currently rented.
//○ String rentedBy: The name of the person who rented the item.
//● Methods:
//○ MediaItem(String title): Constructor to initialize the title. The
//item starts as not rented.
//○ rent(String name): Marks the item as rented by a user if it is
//available.
//○ returnItem(String name): Marks the item as returned if it was
//rented by the same user.
//○ getStatus(): Returns the current status of the item (e.g., available or
//rented by someone).
//○ getDetails(): A placeholder method (to be overridden) that
//provides details specific to each type of media.