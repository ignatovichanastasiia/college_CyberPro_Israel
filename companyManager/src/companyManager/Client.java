package companyManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Client extends Person{
	private static ArrayList<Client> listClients = new ArrayList<Client>();
	private final int DAYS_ON_MONTHS = 31;
	private String companyName;
	private double[] dailySpending;
	private final String id;
	
	//constructor	
	public Client(String name, String companyName) {
		super(name);
		this.companyName = companyName;
		this.dailySpending = new double[DAYS_ON_MONTHS-1];
		id = "C-"+super.getId();
		listClients.add(this);
	}
	
	//all spending hours
	public double totalSpending() {
		double total= 0;
		for(int x=0;x<DAYS_ON_MONTHS;x++){
			total+=dailySpending[x];
		}
		return total;
	}
	
	//insert spending ours
	public void updateDailySpending(int day, double amount) {
		if(day<=DAYS_ON_MONTHS && day>=1) {
			dailySpending[day-1] = amount;
		}
	}
	
	//info method
	@Override
	public void displayInfo() {
		System.out.println("Client id: " + getId()+", name: "+getName()+ ", companyName: " + companyName + ", total spending: "+totalSpending());
	}

	//getters and setters
	public static ArrayList<Client> getClients() {
		return listClients;
	}

	public static void setClients(ArrayList<Client> clients) {
		Client.listClients = clients;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double[] getDailySpending() {
		return dailySpending;
	}

	public void setDailySpending(double[] dailySpending) {
		this.dailySpending = dailySpending;
	}

	public static ArrayList<Client> getListClients() {
		return listClients;
	}

	public static void setListClients(ArrayList<Client> listClients) {
		Client.listClients = listClients;
	}

}



//
//**2. Класс: Client (наследуется от Person)**
//
//- **Атрибуты:**
//  - `private String companyName`: Название компании клиента.
//  - `private double[] dailySpending (size 30)`: Отслеживает расходы за последние 30 дней.
//
//- **Методы:**
//  - Переопределённый метод: `void displayInfo()`: Отображает имя клиента, название компании и недавние расходы.
//  - `void updateDailySpending(int day, double amount)`: Обновляет расходы за конкретный день (с валидацией).
//
//2. Class: Client (Inherits Person)
//● Attributes:
//○ private String companyName: Name of the client's
//company.
//○ private double[] dailySpending (size 30):
//Tracks spending for the last 30 days.
//● Methods:
//○ Override: void displayInfo(): Displays the client’s
//name, company name, and recent spending.
//○ void updateDailySpending(int day, double
//amount): Updates spending for a specific day (with
//validation).

//● Clients:
//○ Use dailySpending to track spending for the last 30 days.
//○ Replace invalid or missing days with zero values during
//updates.


