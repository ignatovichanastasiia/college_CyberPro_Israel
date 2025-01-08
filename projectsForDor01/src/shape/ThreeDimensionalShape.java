package shape;

public abstract class ThreeDimensionalShape extends Shape {
	final String type = "ThreeDimensional";
	
	public ThreeDimensionalShape(String color) {
		super(color);
	}
	
	public abstract double surfaceArea();
	public abstract double volume();
}

//now add ThreeDimensionalShape (another abstract class
//extending Shape, with methods like volume() and
//surfaceArea()) and create classes like Cube or Sphere to
//explore 3D concepts.

//sfera area 4piR2
//4/3piR3
//volume
