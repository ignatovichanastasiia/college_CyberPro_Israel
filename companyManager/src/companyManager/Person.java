package companyManager;

import java.util.ArrayList;

public abstract class Person {
	private static int counter = 1;
	private String name;
	private final String id;
	
	
	public Person(String name) {
		this.name = name;
		if(counter < 10) {
			this.id = "00"+counter++;
		}else if(counter < 100) {
			this.id = "0"+counter++;
		}else {
			this.id = ""+counter++;
		}
	}
	
	abstract void displayInfo();
	
	//logic for restart all days - reset all data per month
	public static void resetAllDays() {
		ArrayList<Worker> workers = Worker.getWorkersList();
		ArrayList<Client> clients = Client.getClients();
		workers.forEach(w -> {
			w.setDailyHours(new double[(w.DAYS_ON_MONTHS)-1]);
			if(w instanceof Manager){
				w.setVacationDays(((Manager) w).resetVacationDaysManager());
			}else if(w instanceof RegularWorker){
				((RegularWorker) w).setSickDays(RegularWorker.getStartSickDays());
			}else {
				w.setVacationDays(w.resetVacationDaysWorker());
			}
		});	
		clients.forEach(c -> {
			c.setDailySpending(new double[(c.DAYS_ON_MONTHS)-1]);
		});
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	
}

//	
//**1. Абстрактный класс: Person**
//
//- **Атрибуты:**
//  - `private static int idCounter`: Генерирует уникальные ID для всех объектов класса Person.
//  - `private String name`: Имя человека.
//  - `private final String id`: Уникальный ID, присваиваемый с использованием статического счётчика.
//
//- **Методы:**
//  - Конструктор: Инициализирует имя и присваивает уникальный id с помощью idCounter.
//  - Абстрактный метод: `void displayInfo()`.
//  - Статический метод:
//    - `void resetAllDays(ArrayList<Worker> workers)`: 
//    	Сбрасывает дни отпуска и больничные для всех рабочих (использует приватные вспомогательные методы 
//    			в Worker для логики, специфичной для ролей).	
	
//Class Structure
//1. Abstract Class: Person
//● Attributes:
//○ private static int idCounter: Generates unique IDs
//for all Person objects.
//○ private String name: Name of the person.
//○ private final String id: Unique ID assigned using
//the static counter.
//● Methods:
//○ Constructor: Initializes name and assigns a unique id using
//idCounter.
//○ Abstract: void displayInfo().
//○ Static:
//■ void resetAllDays(ArrayList<Worker>
//workers): Resets vacation and sick days for all
//workers. (Uses private helper methods in Worker for
//role-specific logic.)

//Key Features
//1. Automatic Unique IDs
//● Managed using a static int idCounter in Person.
//● IDs are prefixed to distinguish types (C-001 for clients, W-001 for
//workers).

//2. Static Method for Resetting Days
//● Person.resetAllDays(ArrayList<Worker> workers):
//○ Logic: Calls private helper methods in Worker to reset
//vacationDays and sickDays.
//○ Manager Logic: Adds extra vacation days during reset


