package companyManager;
import java.util.Scanner;

public class Main {
	//RegularWorker(String name, double basicSalary)
	//Manager(String name, double basicSalary) 
	//Client(String name, String companyName)
	private static String clientString;
	private static boolean b;
	private static int day;
	private static double total;
	private static RegularWorker defWorker = new RegularWorker("J",10);
	private static Manager defManager = new Manager("J",10);
	private static Client defClient = new Client("J","J");
	private static RegularWorker rw1 = new RegularWorker("J",34.6);
	private static RegularWorker rw2 = new RegularWorker("K",39);
	private static RegularWorker rw3 = new RegularWorker("L",34);
	private static RegularWorker rw4 = new RegularWorker("T",40);
	private static RegularWorker rw5 = new RegularWorker("M",44);
	private static Manager m1 = new Manager("L",56);
	private static Manager m2 = new Manager("H",60);
	private static Client cl1 = new Client("G","Tyu");
	private static Client cl2 = new Client("U","Dfg");
	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		start();
		menu();		
	}
	
	public static void menuPrinter(int num) {
		switch(num) {
		case 1:
			System.out.println("Menu\n1 - Regular workers\n2 - Managers\n3 - Clients\n4 - Work process(need a day)\n5 - Counting\n0 - exit");
			break;
		case 10:
			System.out.println("Regular workers:\n1 - All\n2 - Add\n3 - Delete\n0 - back");
			break;
		case 20:
			System.out.println("Managers:\n1 - All\n2 - Add\n3 - Delete\n4 - add member of manager's group\n0 - back");
			break;
		case 30:
			System.out.println("Clients:\n1 - All\n2 - Add\n3 - Delete\n0 - back");
			break;
		case 40:
			System.out.println("Work process(hours):\n1 - add hours for all workers\n2 - add hours for worker\n3 - add hours for all clients\n"
					+ "4 - add hours for client\0 - back");
			break;
		case 50:
			System.out.println("Counting:\n1 - count salary for all workersn\n2 - count salary for worker\n0 - back");
			break;
		default:
			menuPrinter(1);
			break;
		}
	}
	
	public static void menu() {
		int program1step = 1;
		do {
			try {
				menuPrinter(1);
				String clientString = sc.nextLine();
				program1step = 10*Integer.parseInt(clientString.trim());
				if(program1step!=0) {
					menuPrinter(program1step);				
					clientString = sc.nextLine();
					int program2step = program1step+Integer.parseInt(clientString.trim());
					goProgram(program2step);
				}
			}catch(ClassCastException e) {
				e.printStackTrace();
				menu();
				break;
			}catch(Exception e) {
				e.printStackTrace();
				exit();
				break;
			}
		}while(program1step!=0);
		exit();
	}	
	
	public static void goProgram(int program) {
		switch(program) {
		case 11: //("Regular workers:/n1 - All/n2 - Add/n3 - Delete/n0 - back");
			RegularWorker.getListRW().forEach(w -> w.displayInfo());
			break;
		case 12:
			System.out.println("Let's do regular worker data.\n Enter worker's name: ");
			String name = sc.nextLine().trim();
			System.out.println("Enter base salary: ");
			double salary = parseDouble(sc.nextLine(),12);
			if(!name.isBlank()) {
				RegularWorker rw = new RegularWorker(name,salary);
				System.out.println("Done!");
			}
			break;
		case 13:
			System.out.println("Let's delete a regular worker.\n Enter worker's name: ");
			name = sc.nextLine().trim();
			b = false;
			RegularWorker.getListRW().forEach(w -> 
				{
				if(w.getName().equalsIgnoreCase(name)){
					defWorker = w;
					b = true;
				}
			});
			if(b) {
				RegularWorker.getListRW().remove(defWorker);
				System.out.println("Done!");
			}
			break;
		case 10:
			menu();
			break;
		case 21: //("Managers:/n1 - All/n2 - Add/n3 - Delete/n4 - add member of manager's group/n0 - back");
			Manager.getListManagers().forEach(m -> m.displayInfo());
			break;
		case 22:
			System.out.println("Let's do manager data.\n Enter manager's name: ");
			name = sc.nextLine().trim();
			System.out.println("Enter base salary: ");
			salary = parseDouble(sc.nextLine(),22);
			if(!name.isBlank()) {
				Manager man = new Manager(name,salary);
				System.out.println("Done!");
			}
			break;
		case 23:
			System.out.println("Let's delete a manager.\n Enter manager's name: ");
			name = sc.nextLine().trim();
			b = false;
			Manager.getListManagers().forEach(m -> 
				{
				if(m.getName().equalsIgnoreCase(name)){
					defManager = m;
					b = true;
				}
			});
			if(b) {
				Manager.getListManagers().remove(defManager);
				System.out.println("Done!");
			}
			break;
		case 24:
			b = false;
			System.out.println("Let's add regular worker to a manager's team.\nEnter worker's name: ");
			String wName = sc.nextLine().trim();
			RegularWorker.getListRW().forEach(w -> 
			{
				if(w.getName().equalsIgnoreCase(wName)){
					defWorker = w;
					System.out.println("Enter manager's name: ");
					clientString = sc.nextLine().trim();
					Manager.getListManagers().forEach(m -> 
						{
							if(m.getName().equalsIgnoreCase(clientString)){
								defManager = m;
								b = true;
							}
						});
				}
			});
			if(b) {
				defManager.getTeam().add(defWorker);
				System.out.println("Done!");
			}
			break;
		case 20:
			menu();
			break;
		case 31: //("Clients:/n1 - All/n2 - Add/n3 - Delete/n0 - back")
			Client.getListClients().forEach(c -> c.displayInfo());
			break;
		case 32:
			System.out.println("Let's do client's data.\n Enter client's name: ");
			name = sc.nextLine().trim();
			System.out.println("Enter company name: ");
			clientString = sc.nextLine();
			if(!clientString.isBlank() && !name.isBlank()) {
				Client client = new Client(name, clientString);
				System.out.println("Done!");
			}
			break;
		case 33:
			System.out.println("Let's delete a client.\n Enter clients's name: ");
			name = sc.nextLine().trim();
			b = false;
			Client.getListClients().forEach(c -> 
				{
				if(c.getName().equalsIgnoreCase(name)){
					defClient = c;
					b = true;
				}
			});
			if(b) {
				Client.getListClients().remove(defClient);
				System.out.println("Done!");
			}
			break;
		case 30:
			menu();
			break;
		case 41: //"Work process(hours):/n1 - add hours for all workers/n2 - add hours for worker/n
			//3 - add hours for all clients/n"4 - add hours for client/0 - back"
			System.out.println("Enter date (int day): ");
			clientString = sc.nextLine().trim();
			int x = parseInteger(clientString,41);
			if(x<31 && x>0) {
				day=x;
				Worker.getWorkersList().forEach(w -> {
					System.out.println("Day: "+day+". Enter hours for "+w.getName()+": ");
					w.logHours(day, parseInteger(sc.nextLine(),41));
				});
			}
			break;
		case 42:
			System.out.println("Enter date (int day): ");
			clientString = sc.nextLine().trim();
			x = parseInteger(clientString,42);
			System.out.println("Enter worker's name: ");
			clientString = sc.nextLine().trim();
			if(x<31 && x>0) {
				day=x;
				Worker.getWorkersList().forEach(w -> {
					if(w.getName().equalsIgnoreCase(clientString))
					System.out.println("Day: "+day+". Enter hours for "+w.getName()+": ");
					w.logHours(day, parseInteger(sc.nextLine(),42));
				});
			}
			break;
		case 43:
			System.out.println("Enter date (int day): ");
			clientString = sc.nextLine().trim();
			x = parseInteger(clientString,43);
			if(x<31 && x>0) {
				day=x;
				Client.getListClients().forEach(c -> {
					System.out.println("Day: "+day+". Enter daily spending for "+c.getName()+": ");
					c.updateDailySpending(day, parseDouble(sc.nextLine(),43));
				});
			}
			break;
		case 44:
			System.out.println("Enter date (int day): ");
			clientString = sc.nextLine().trim();
			x = parseInteger(clientString,43);
			System.out.println("Enter client's name: ");
			clientString = sc.nextLine().trim();
			if(x<31 && x>0) {
				day=x;
				Client.getListClients().forEach(c -> {
					if(c.getName().equalsIgnoreCase(clientString))
					System.out.println("Day: "+day+". Enter daily spending for "+c.getName()+": ");
					c.updateDailySpending(day, parseDouble(sc.nextLine(),43));
				});
			}
			break;
		case 40:
			menu();
			break;
		case 51: //"Counting:/n1 - count salary for all workers/n2 - count salary for worker/n0 - back"
			Worker.getWorkersList().forEach(w -> {
				w.displayInfo();
				double sal = w.calculatePaycheck();
				System.out.println(w.getName()+"'s salary: "+sal+" \n");
				total+=sal;
			});
			break;
		case 52:
			System.out.println("Enter worker's name: ");
			clientString = sc.nextLine();
			Worker.getWorkersList().forEach(w -> {
				if(w.getName().equalsIgnoreCase(clientString)) {
					w.displayInfo();
					double sal = w.calculatePaycheck();
					System.out.println(w.getName()+"'s salary: "+sal+" \n");
					total+=sal;
				}
			});
			break;
		case 50:
			menu();
			break;
		}
	}
	
	public static double parseDouble(String clientString,int program) {
		double parseDouble = 0;
		try {
			parseDouble = Double.parseDouble(clientString);
		}catch(Exception e) {
			e.printStackTrace();
			goProgram(program);
		}
		return parseDouble;
	}
	
	public static int parseInteger(String clientString,int program) {
		int parseInteger = 0;
		try {
			parseInteger = Integer.parseInt(clientString);
		}catch(Exception e) {
			e.printStackTrace();
			goProgram(program);
		}
		return parseInteger;
	}
	
	public static void start() {
		RegularWorker.getListRW().remove(defWorker);
		Manager.getListManagers().remove(defManager);
		Worker.getWorkersList().remove(defWorker);
		Manager.getWorkersList().remove(defManager);
		Client.getListClients().remove(defClient);
	}
	
	public static void exit() {
		System.out.println("bye");
		sc.close();
	}

}
