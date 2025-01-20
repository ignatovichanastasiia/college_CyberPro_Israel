package companyManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Client extends Person{
	int DAYS_ON_MONTHS = 31;
	private String companyName;
	private double[] dailySpending;
	private final String id;
	private static ArrayList<Client> clients = new ArrayList<Client>();
		
	public Client(String name, String companyName) {
		super(name);
		this.companyName = companyName;
		this.dailySpending = new double[DAYS_ON_MONTHS-1];
		id = "C-"+super.getId();
		clients.add(this);
	}
	
	public double totalSpending() {
		double total= 0;
		for(int x=0;x<DAYS_ON_MONTHS;x++){
			total+=dailySpending[x];
		}
		return total;
	}

	public void updateDailySpending(int day, double amount) {
		if(day<=DAYS_ON_MONTHS && day>=1) {
			dailySpending[day-1] = amount;
		}
	}

	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static void setClients(ArrayList<Client> clients) {
		Client.clients = clients;
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
	
	@Override
	public void displayInfo() {
		System.out.println("Client id: " + getId()+", name: "+getName()+ ", companyName: " + companyName + ", total spending: "+totalSpending());
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


