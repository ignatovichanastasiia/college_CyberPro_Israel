package shape;

public abstract class Shape {
	static int counter = 1;
	int id;
	String color;
	
	public Shape(String color) {
		this.id = counter++;
		this.color = color;
		System.out.println("Shape "+id+" is created.");
	}

	public static int getCounter() {
		return counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}


//Shape (Abstract Class)
//○ Two attributes:
//■ int id (unique identifier).
//■ String color.
//○ Keep a static counter that increments each time a new
//Shape is created.
//○ The constructor sets id using the static counter.

