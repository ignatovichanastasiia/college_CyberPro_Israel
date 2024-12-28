package personclass;

public class PersonClass {
	String name;
	int age;

	PersonClass(String name, int age){
		System.out.println("Person class's constructor.");
		this.name = name;
		this.age = age;
	}
	
	public void greet() {
		System.out.println("Hi! My name is "+name+" I'm "+age);
	}

}
