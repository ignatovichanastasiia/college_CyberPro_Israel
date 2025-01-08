package shape;

public class Cube extends ThreeDimensionalShape{
	private double height;

	public Cube(String color,double height) {
		super(color);
		this.height = height; 
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double surfaceArea() {
		return Math.pow(height, 3);
	}

	@Override
	public double volume() {
		return 6*Math.pow(height, 2);
	}
	
	
	
	
	

}
