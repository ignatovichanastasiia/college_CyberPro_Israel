package vehicle;

public class Truck extends Vehicle implements Detailable{
	private String brand;
	private int capacity;
	private int wheels; //10||12||18
		
	public Truck(String brand, int capacity, int wheels) {
		super(brand);
		this.capacity = capacity;
		setWheels(wheels);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		if(wheels==10||wheels==12||wheels==18) {
			this.wheels = wheels;
		}else{
			System.out.println("The number of wheels entered is incorrect");
			this.wheels = 10;				
		}
			System.out.println("Number of wheels now is "+getWheels());
	}

	public void details() {
		System.out.println("Truck (brand=" + getBrand() + ", capacity=" + getCapacity() + ", wheels=" + getWheels() + ")");	
	}

	@Override
	public String toString() {
		return "Truck [getCapacity()=" + getCapacity() + ", getWheels()=" + getWheels() + ", getBrand()=" + getBrand()
				+ "]";
	}
	
	
}



//Truck: Extend the Vehicle class. Add attributes like
//capacity (in tons) and implement a details() method.

