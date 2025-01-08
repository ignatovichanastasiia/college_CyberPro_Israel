package vehicle;

public class Vehicle implements Startable, Stopable{
	private String brand;
	
	public Vehicle(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public void start(){
		System.out.println("Vehicle is start.");
	}
	
	@Override
	public void stop(){
		System.out.println("Vehicle is stop.");		
	}

}


//○ Add attributes like brand and implement methods start()
//and stop().