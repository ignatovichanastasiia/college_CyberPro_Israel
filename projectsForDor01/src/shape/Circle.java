package shape;

public class Circle extends TwoDimensionalShape{
	private double radius;
	
	
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

	public double area() {
		return (Math.PI*Math.pow(radius, 2));
	}

	public double perimeter() {
		return (2*Math.PI*radius);
	}
	

}






//Circle (Concrete Class, extends TwoDimensionalShape)
//○ Attribute: double radius.
//○ Implements area() and perimeter() (use standard circle
//formulas).
//○ In its constructor, remember to call the parent constructor so
//the static counter updates.
