package companyManager;

import java.util.ArrayList;

public class RegularWorker extends Worker{
	private static ArrayList<RegularWorker> listRW = new ArrayList<RegularWorker>();
	final static int START_SICK_DAYS = 15;
	private int sickDays;
	
	//constructor
	public RegularWorker(String name, double basicSalary) {
		super(name, basicSalary);
		this.sickDays = START_SICK_DAYS;
		listRW.add(this);
	}
	
	//count salary per month
	public double calculatePaycheck() {
		return super.getBasicSalary()*super.getHours();
	}
	
	//count bonus per month
	public double calculateBonus(int percent) {
		return calculatePaycheck()/100*percent;
	}
	
	//take dayoff for worker 
	public boolean takeSickDays(int days) {
		if(sickDays-days>=0) {
			sickDays-=days;
			return true;
		}
		return false;
	}
	
	//information method
	@Override
	void displayInfo() {
		System.out.println("RegularWorker id: "+getId()+" name: "+getName()+" basic salary: "+getBasicSalary()+" total hours: "
				+getHours()+" vacation days: "+getVacationDays()+" sick days "+sickDays);	
	}

	//getters and setters
	public int getSickDays() {
		return sickDays;
	}

	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}

	public static int getStartSickDays() {
		return START_SICK_DAYS;
	}

	public static ArrayList<RegularWorker> getListRW() {
		return listRW;
	}

	public static void setListRW(ArrayList<RegularWorker> listRW) {
		RegularWorker.listRW = listRW;
	}
	
	
}


//**5. Класс: RegularWorker (наследуется от Worker)**
//
//- **Атрибуты:**
//  - `private final static int START_SICK_DAYS = 15`: Начальное количество больничных дней для обычных рабочих.
//  - `private int sickDays`: Оставшиеся больничные дни.
//
//- **Методы:**
//  - Конструктор: Инициализирует sickDays значением по умолчанию.
//  - Переопределённый метод: `double calculatePaycheck()`: Рассчитывает оплату на основе отработанных 
//  часов и бонусов за сверхурочные.
//  - `boolean takeSickDays(int days)`: Уменьшает количество больничных дней, если достаточно; возвращает 
//  true или false.


//
//5. Class: RegularWorker (Inherits Worker)
//● Attributes:
//○ private final static int START_SICK_DAYS =
//15: Starting sick days for regular workers.
//○ private int sickDays: Remaining sick days.
//● Methods:
//○ Constructor: Initializes sickDays to default.
//○ Override: double calculatePaycheck(): Calculates
//pay based on hours worked and bonuses for overtime.
//○ boolean takeSickDays(int days): Deducts sick days
//if sufficient; returns true or false.
