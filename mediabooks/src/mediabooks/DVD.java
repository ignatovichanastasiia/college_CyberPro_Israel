package mediabooks;

public class DVD extends MediaItem{
	private int runtime;

	public DVD(String title, int runtime) {
		super(title);
		this.runtime = runtime;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		if(runtime>0) {
		this.runtime = runtime;
		}
	}

	@Override
	public void getDetails() {
		System.out.println("This DVD "+getTitle()+" is "+runtime+" minutes. And it is "+getStatus()+" now.");
	}
	
	
	

}


//DVD Class (Subclass)
//The DVD class represents a DVD, inheriting from MediaItem.
//● Additional Field:
//○ int runtime: The runtime of the DVD in minutes.
//● Methods:
//○ DVD(String title, int runtime): Constructor to set the title
//and runtime.
//○ getDetails(): Overrides getDetails() from MediaItem to return
//the DVD's specific details (e.g., title and runtime).
