package personclass;

public class Table {
	public int legs;
	public String material;
	public int yearCreated;
	
	public Table() {
		this.legs = 4;
		this.material = "Wood";
		this.yearCreated = 2023;
	}
	
	public Table(int legs, String mat, int year) {
		this.legs = legs;
		this.material = mat;
		this.yearCreated = year;
	}
	
	public void printer() {
		System.out.println("I'm a "+this.legs+
				" legged table from "+this.material+
				" from "+this.yearCreated);
	}
}
