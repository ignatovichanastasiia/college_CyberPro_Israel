package vehicle;

public class Motorcycle extends Vehicle implements Detailable{
	private String brand;
	private String model;
	private int cc; //cc (engine capacity) 50-3000
	
	public Motorcycle(String brand, String model, int cc) {
		super(brand);
		this.model = model;
		this.cc = cc;
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

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		if(cc>50 && cc<3000) {
			this.cc = cc;
		}else {
			System.out.println("cc is not correct");
		}
	}
	

	public void details() {
		System.out.println("Motorcycle (model=" + getModel() + ", cc=" + getCc() + ", brand=" + getBrand() + ")");
		
	}

	@Override
	public String toString() {
		return "Motorcycle [getModel()=" + getModel() + ", getCc()=" + getCc() + ", getBrand()=" + getBrand() + "]";
	}
	
	

}

//Motorcycle: Extend the Vehicle class. Add attributes like
//cc (engine capacity) and implement a details() method.