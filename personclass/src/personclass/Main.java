package personclass;

import java.util.Scanner;

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
		
		//book's class call
		//Book(String title,String author,int maxPages, int currentPage)
		Book pushkin = new Book("Poetica","Pushkin",500,10);
		Book shekspire = new Book("Gamlet","Shekspire", 300, 20);
		pushkin.read();
		pushkin.readPages(400);
		shekspire.read();
		shekspire.readPages(152);
		
		
		//public static void main(String[] args){
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Enter age of human");
		    //enter from user:
		    int age = (int)sc.nextInt();
		    String ageGroup = "nun";
		    // Determine age group based on age:
		    	if(age<0) {
		    		System.out.println("This age is not correct");
		    	}else if(age>=0&&age<=2){
		            ageGroup = "infant";
		        }else if(age>=3&&age<=12){
		            ageGroup = "child";
		        }else if(age>=13&&age<=19){
		            ageGroup = "teen";
		        }else if(age>=20&&age<=64){
		            ageGroup = "adult";
		        }else if(age>=65){
		            ageGroup = "senior";
		        }
		    System.out.println(ageGroup);
		//}
		
	}

}
