package companyManager;

import java.util.ArrayList;

public class Manager extends Worker{
	private final static int EXTRA_VACATION_DAYS = 10;
	private ArrayList<Worker> team;
	int vacationDays;
	
	public Manager(String name, double basicSalary) {
		super(name, basicSalary);
		this.team = new ArrayList<Worker>();
		vacationDays = setNewVacationDaysManager();
	}

	public int setNewVacationDaysManager() {
		return (setNewVacationDaysWorker()+EXTRA_VACATION_DAYS);
	}

	public double calculatePaycheck() {
		return super.getBasicSalary()*super.getHours();
	}
	
	void addTeamMember(Worker worker) {
		team.add(worker);
	}
	
	void displayTeam() {
		team.forEach(w -> w.displayInfo());
	}
	
	public ArrayList<Worker> getTeam() {
		return team;
	}
	
	public void printTeam() {
		team.forEach(w -> w.displayInfo());
	}

	public void setTeam(ArrayList<Worker> team) {
		this.team = team;	
	}

	@Override
	void displayInfo() {
		System.out.println("Manager id: "+getId()+"name: "+ getName()+" basic salary: "+getBasicSalary()
		+" total hours "+getHours()+" team:\n ");
		printTeam();	
	}
}




//**4. Класс: Manager (наследуется от Worker)**
//
//- **Атрибуты:**
//  - `private final static int EXTRA_VACATION_DAYS = 10`: Дополнительные дни отпуска для менеджеров.
//  - `private ArrayList<Worker> team`: Список рабочих, находящихся в подчинении у менеджера.
//
//- **Методы:**
//  - Конструктор: Инициализирует менеджера с дополнительными днями отпуска и пустой командой.
//  - Переопределённый метод: `double calculatePaycheck()`: Включает базовую зарплату и бонусы.
//  - `void addTeamMember(Worker worker)`: Добавляет рабочего в команду (обеспечивает отсутствие дублирующихся членов команды).
//  - `void displayTeam()`: Отображает всех рабочих, находящихся в подчинении у менеджера.

//Class: Manager (Inherits Worker)
//● Attributes:
//○ private final static int EXTRA_VACATION_DAYS
//= 10: Additional vacation days for managers.
//○ private ArrayList<Worker> team: List of workers
//managed by the manager.
//● Methods:
//○ Constructor: Initializes the manager with extra vacation
//days and an empty team.
//○ Override: double calculatePaycheck(): Includes base
//salary and bonuses.
//○ void addTeamMember(Worker worker): Adds a worker
//to the team (ensures no duplicates).
//○ void displayTeam(): Displays all workers managed by
//the manager.
