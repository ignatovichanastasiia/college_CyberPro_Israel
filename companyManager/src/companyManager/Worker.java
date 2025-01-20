package companyManager;

import java.util.ArrayList;

public abstract class Worker extends Person {
	int DAYS_ON_MONTHS = 31;
	final int START_VACATION_DAYS = 10;
	private double[] dailyHours; //30 
	private int vacationDays;
	private double basicSalary;
	private final String id;
	private static ArrayList<Worker> workersList;
	
	public Worker(String name, double basicSalary) {
		super(name);
		this.dailyHours = new double[DAYS_ON_MONTHS = 31-1];
		this.vacationDays = 0;
		this.basicSalary = basicSalary;
		this.id = "W-"+super.getId();
		workersList.add(this);
	}
	
	public abstract double calculatePaycheck();
	
	public void logHours(int day, double hours) {
		dailyHours[day-1] = hours;
	}
	
	public boolean takeVacationDays(int days) {
		if(vacationDays-days>=0) {
			vacationDays-=days;
			return true;
		}
		return false;
	}

	public double[] getDailyHours() {
		return dailyHours;
	}
	
	public double getHours() {
		double hours = 0;
		for(int x = 0; x < dailyHours.length; x++) {
			hours+=dailyHours[x];
		}
		return hours;
	}

	public void setDailyHours(double[] dailyHours) {
		this.dailyHours = dailyHours;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	public int setNewVacationDaysWorker() {
		return START_VACATION_DAYS;
	}

	public static ArrayList<Worker> getWorkersList() {
		return workersList;
	}

	public static void setWorkersList(ArrayList<Worker> workersList) {
		Worker.workersList = workersList;
	}

	public String getId() {
		return id;
	}
	
	@Override
	void displayInfo() {
		System.out.println("Worker id: "+id+"name: "+ getName()+" basic salary: "+getBasicSalary()
		+" total hours "+getHours()+" vacationDays:" + vacationDays + " salary: "+calculatePaycheck());
	}	
}

//
//**3. Абстрактный класс: Worker (наследуется от Person)**
//
//- **Атрибуты:**
//  - `private final static int START_VACATION_DAYS = 10`: Начальное количество дней отпуска для рабочих.
//  - `private double[] dailyHours (size 30)`: Отслеживает количество отработанных часов за последние 30 дней.
//  - `private int vacationDays`: Оставшиеся дни отпуска.
//  - `private double basicSalary`: Базовая зарплата.
//
//- **Методы:**
//- Конструктор: Инициализирует dailyHours и vacationDays значениями по умолчанию.
//- Абстрактный метод: `double calculatePaycheck()`.
//- Переопределённый метод: `void displayInfo()`: Отображает основную информацию о рабочем.
//- `void logHours(int day, double hours)`: Логирует часы за конкретный день (валидирует часы между 0 и 24).
//- `boolean takeVacationDays(int days)`: Уменьшает количество дней отпуска, 
//если достаточно; возвращает true, если успешно, иначе false.

//3. Abstract Class: Worker (Inherits Person)
//● Attributes:
//○ private final static int : Initial vacation days for workers.
//○ private double[] dailyHours (size 30): Tracks
//hours worked for the last 30 days.
//○ private int vacationDays: Remaining vacation days.
//○ private double basicSalary;
//● Methods:
//○ Constructor: Initializes dailyHours and vacationDays
//to default values.
//○ Abstract: double calculatePaycheck().
//○ Override: void displayInfo(): Displays basic worker
//information.
//○ void logHours(int day, double hours): Logs
//hours for a specific day (validates hours between 0–24).
//○ boolean takeVacationDays(int days): Deducts
//vacation days if sufficient; returns true if successful,
//otherwise false.

//● Workers:
//○ Use dailyHours to track hours worked per day (valid hours
//between 0–24).
//○ Provide helper methods to reset hours at the end of the
//month.

