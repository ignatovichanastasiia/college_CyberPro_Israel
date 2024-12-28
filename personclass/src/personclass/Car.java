package personclass;

public class Car {
	String brand;
	String model;
	int year;
	int gear;
	
	public Car(String brand, String model, int year, int gear) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.gear = gear;		
	}
	
	public void startEngine() {
		System.out.println("The engine of "+brand+" "+model+" (year "+year+") has started");
	}
	
	public void shiftGear(int change) {
		if(change == 1 || change == -1) {
			if((gear+change)>=1 && (gear+change)<=6) {
				gear+=change;
				System.out.println("The gear is "+gear);
			}
		}else {
			System.out.println("The gear is "+gear);
		}
	}

}



//1. Create a class Car with:
//○ Attributes: String brand, String model, int year, int gear
//○ Method: startEngine() that prints:
//i. The engine of [brand] [model] (year [year]) has started.
//○ Method: shiftGear(int change) that adds or removes one from the gear
//(never above 6 or lower then 1) and prints the current gear.
//2. In the Main class, instantiate Car objects, set the attributes, and call the
