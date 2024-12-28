package personclass;

public class TeacherSchoolPerson extends SchoolPerson {
	String name;
	int age; 
	String school;
	
	TeacherSchoolPerson(String name, int age, String school) {
		super(name,age);
		this.school = school;		
		System.out.println("Teacher school person class's constructor.");
	}
	
	@Override
	public void greet() {
		super.greet();
	}

}
