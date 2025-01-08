package vehicle;

import shape.Circle;
import shape.Cube;
import shape.Rectangle;
import shape.Sphere;

public class Main {

	public static void main(String[] args) {
		
		Car car1 = new Car("Some brand","Some model",1999);
		Motorcycle moto1 = new Motorcycle("Some brand", "Some model", 350);
		Truck truck1 = new Truck("Some brand", 15, 10);
		
		//calls for Car		
		car1.details();
		car1.playMusic();
		System.out.println(car1.getBrand());
		car1.start();
		car1.stop();
		System.out.println(car1.toString());
		//calls for Motorcycle
		moto1.details();
		System.out.println(moto1.getBrand());
		moto1.start();
		moto1.stop();
		System.out.println(moto1.toString());
		//calls for Truck
		truck1.details();
		System.out.println(truck1.getBrand());
		truck1.start();
		truck1.stop();
		System.out.println(truck1.toString());
		
		//calls shapes
		Circle cr1 = new Circle("red",34);
				//Circle(String color, double radius)
		double areaCr1 = cr1.area();
		double perimetrCr1 = cr1.perimeter();
		int idCr1 = cr1.getId();
		System.out.println("Circle cr1 radius is "+cr1.getRadius()+" area is "+areaCr1+" perimetr is "+perimetrCr1+" id is "+idCr1);
		Rectangle rec1 = new Rectangle("blue",12,35);
				//Rectangle(String color, double length, double width)
		double areaRec1 = rec1.area();
		double perimetrRec1 = rec1.perimeter();
		int idRec1 = rec1.getId();
		System.out.println("Rectangle rec1 parametrs are "+rec1.getLength()+","+rec1.getWidth()+" area is "+areaRec1+" perimetr is "+perimetrRec1+" id is "+idRec1);
		Cube cu1 = new Cube("yellow",15);
				//Cube (String color,double height)
		double sAreaCu1 = cu1.surfaceArea();
		double volumeCu1 = cu1.volume();
		int idCu1 = cu1.getId();
		System.out.println("Cube cu1 height is "+cu1.getHeight() +" surface area is "+sAreaCu1+" volume is "+volumeCu1+" id is "+idCu1);
		Sphere sph1 = new Sphere("orange",5);
				//Sphere (String color, double radius)
		double surfaceAreaSph1 = sph1.surfaceArea();
		double volumeSph1 = sph1.volume();
		int idSph1 = sph1.getId();
		System.out.println("Sphere sph1 radius is "+sph1.getRadius()+" surface Area is " +surfaceAreaSph1+" volume is "+volumeSph1+" id is "+idSph1);
		
		
	}

}


//НЕ СДЕЛАЛА: ФИГУРЫ. Круг и треугольник. 

//1. Base Class: Vehicle
//○ Add attributes like brand and implement methods start()
//and stop().
//2. Derived Classes:
//○ Car: Extend the Vehicle class. Add attributes like model
//and a method play_music(). Implement a details()
//method to display car-specific information.
//○ Motorcycle: Extend the Vehicle class. Add attributes like
//cc (engine capacity) and implement a details() method.
//○ Truck: Extend the Vehicle class. Add attributes like
//capacity (in tons) and implement a details() method
//3. Demonstration:
//○ Create objects of Car, Motorcycle, and Truck.
//○ Call methods to start and stop each vehicle and display
//specific details.
//4. Creating:
//○ getters and setters as needed.
//○ Three type constructors for each relevant class
//○ override the toString method for all
//In the end:
//● A program that demonstrates the functionality of all vehicle types.
//● Output showing interactions with each type of vehicle.