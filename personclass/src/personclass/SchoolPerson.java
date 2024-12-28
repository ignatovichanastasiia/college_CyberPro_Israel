package personclass;

public class SchoolPerson extends PersonClass {
	String name;
	int age; 
	
	SchoolPerson(String name, int age) {
		super(name,age);
		System.out.println("School person class's constructor.");
	}
	
	@Override
	public void greet() {
		super.greet();
	}

}
