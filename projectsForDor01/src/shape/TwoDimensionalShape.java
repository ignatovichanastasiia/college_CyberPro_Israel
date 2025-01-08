package shape;

public abstract class TwoDimensionalShape extends Shape {
	final String type = "TwoDimensional";
	
	
	public TwoDimensionalShape(String color) {
		super(color);
	}
	
	public abstract double area();
	public abstract double perimeter();
	

}


//TwoDimensionalShape (Abstract Class, extends Shape)
//○ Has a fixed type indicating it is two-dimensional (e.g., final
//String type = "TwoDimensional").
//○ Declares two abstract methods: double area() and
//double perimeter().

