package shape;

public class Rectangle extends TwoDimensionalShape{
	private double length;
	private double width;
	
	public Rectangle(String color, double length, double width) {
		super(color);
		this.length = length;
		this.width = width;
	}
	
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	@Override
	public double area() {
		return length*width;
	}
	@Override
	public double perimeter() {
		return (length+width)*2;
	}
	
	

}



//. Rectangle (Concrete Class, extends TwoDimensionalShape)
//○ Attributes: double length, double width.
//○ Implements area() and perimeter() (use standard
//rectangle formulas).
//○ Also updates the static counter through the parent’s
//constructor.

