package shape;

public class Sphere extends ThreeDimensionalShape{
	double radius;

	public Sphere(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double surfaceArea() {
		return 4*Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double volume() {
		return 4/3*Math.PI*Math.pow(radius, 3);
	}
	
	//4piR2 - area
	//4/3piR3 - volume
	
	
	
	
	

}
