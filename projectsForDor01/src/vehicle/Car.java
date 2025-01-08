package vehicle;
import java.time.Year;

public class Car extends Vehicle implements Detailable{
	final int CurrentYEAR = Year.now().getValue();
	private String brand;
	private String model;
	private int year;
	
	public Car(String brand, String model, int year) {
		super(brand);
		this.model = model;
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if(model.length()<30) {
			this.model = model;
		}else{
			System.out.println("This name of model is too long");
		}
		
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year<1885||year>CurrentYEAR) {
			System.out.println("The number of year entered is incorrect.");
			if(getYear()<1885||getYear()>CurrentYEAR) {
				this.year=CurrentYEAR;
			}
			System.out.println("Now year is "+getYear());
		}
	}

	public void playMusic(){
		System.out.println("The music is playing loudly, someone is whining into the microphone.");
		
	}
	
	public void details() {
		System.out.println("Car (model=" + getModel() + ", year=" + getYear() + ", brand=" + getBrand() + ")");
	}

	@Override
	public String toString() {
		return "Car [getModel()=" + getModel() + ", getYear()=" + getYear() + ", getBrand()=" + getBrand() + "]";
	}
	
	
	
}

//Car: Extend the Vehicle class. Add attributes like model
//and a method play_music(). Implement a details()
//method to display car-specific information.

