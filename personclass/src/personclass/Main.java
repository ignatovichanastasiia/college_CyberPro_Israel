package personclass;

public class Main {

	public static void main(String[] args) {
		//person's class call
		PersonClass per1 = new PersonClass("Va",7);
		PersonClass per2 = new PersonClass("Ty",10);
		per1.greet();
		per2.greet();
		
		//table's class call
		Table t1 = new Table();
		Table t2 = new Table(3, "Metal", 2020);
		Table t3 = new Table(4, "Plastic", 2002);
		t1.printer();
		t2.printer();
		t3.printer();
		
		//car's class call
		Car renault = new Car("Renault", "Megane", 2003, 5);
		Car toyota = new Car("Toyota", "Corolla",2007,6);
		renault.startEngine();
		toyota.startEngine();
		renault.shiftGear(-1);
		toyota.shiftGear(-1);
	}

}
