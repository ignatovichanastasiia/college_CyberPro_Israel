package companyManager;

import java.util.Arrays;

public class RegularWorker extends Worker{
	private final static int START_SICK_DAYS = 15;
	private int sickDays;

	public RegularWorker(String name, double basicSalary) {
		super(name, basicSalary);
		this.sickDays = START_SICK_DAYS;
	}
	
	public double calculatePaycheck() {
		return super.getBasicSalary()*super.getHours();
	}
	
	public boolean takeSickDays(int days) {
		if(sickDays-days>=0) {
			sickDays-=days;
			return true;
		}
		return false;
	}

	public int getSickDays() {
		return sickDays;
	}

	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}

	public static int getStartSickDays() {
		return START_SICK_DAYS;
	}
	
	@Override
	void displayInfo() {
		System.out.println("RegularWorker id: "+getId()+" name: "+getName()+" basic salary: "+getBasicSalary()+" total hours: "
				+getHours()+" vacation days: "+getVacationDays()+" sick days "+sickDays);	
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
