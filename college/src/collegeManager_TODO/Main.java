package collegeManager_TODO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		start();
		int choose = 1;
		while (choose != 0) {
			menu(1);
			int role = getNumberFromClientEnter();
			if (role != 0) {
				menu(role + 1);
				choose = getNumberFromClientEnter();
				if (choose != 0) {
					switch (role) {
					case 1:
						studentPrograms(choose);
						break;
					case 2:
						coursePrograms(choose);
						break;
					case 3:
						gradePrograms(choose);
						break;
					}
				} else {
					choose = 0;
				}
			} else {
				choose = 0;
			}
		}
		System.out.println("Bye!");
		close();
	}

	public static void menu(int num) {
		switch (num) {
		case 1:
			System.out.println("""
					Welcome to the menu.
					\t1 -> Student's menu
					\t2 -> Course's menu
					\t3 -> Grades's menu
					\t0 -> Exit
					""");
			break;
		case 2:
			System.out.println("""
					Student menu:
					\t1 -> Add
					\t2 -> Search by ID
					\t3 -> Search by E-mail
					\t4 -> Search by name
					\t5 -> All students
					\t0 -> Exit
					""");
			break;
		case 3:
			System.out.println("""
					Course menu:
					\t1 -> Add
					\t2 -> Search by ID
					\t3 -> Search by name
					\t4 -> All courses
					\t0 -> Exit
					""");
			break;
		case 4:
			System.out.println("""
					Grade menu:
					\t1 -> Add
					\t2 -> Search by course
					\t3 -> Search by student
					\t4 -> All grades
					\t0 -> Exit
					""");
			break;
		case 0:
			break;
		}
	}

	public static void studentPrograms(int num) {
		switch (num) {
		case 1:
			System.out.println("Enter student's name:");
			String name = scanner.nextLine();
			System.out.println("Enter student's e-mail:");
			String email = scanner.nextLine();
			if (GradingSystem.addStudent(name, email)) {
				System.out.println("All done!");
			} else {
				System.out.println("Problem with adding the student!");
			}
			break;
		case 2:
			System.out.println("Enter student's ID: ");
			String id = scanner.nextLine();
			Optional<Student> student = GradingSystem.getStudentById(id);
			studentFunctions(student);
			break;
		case 3:
			System.out.println("Enter student's e-mail: ");
			String studentEmail = scanner.nextLine();
			List<Student> students = GradingSystem.getStudentByEmail(studentEmail);
			if (students.size() == 1) {
				studentFunctions(Optional.of(students.getFirst()));
			} else {
				System.out.println("System found " + students.size() + " students.\n" + students.toString());
			}
			break;
		case 4:
			System.out.println("Enter student's name: ");
			String studentName = scanner.nextLine();
			List<Student> students2 = GradingSystem.getStudentByName(studentName);
			if (students2.size() == 1) {
				studentFunctions(Optional.of(students2.getFirst()));
			} else {
				System.out.println("System found " + students2.size() + " students.\n" + students2.toString());
			}
			break;
		case 5:
			System.out.println(GradingSystem.getListStudents().toString());
		}
	}

	public static void studentFunctions(Optional<Student> student) {
		if (student.isPresent()) {
			System.out.println("The system found " + student.get().toString()
					+ "\nWhat do you want to do with the entry?"
					+ "\t1 -> Delete\t2 -> See all student's courses\t3 -> Enroll student to a course\t4 -> See all student's grades\t0 -> exit");
			int number = getNumberFromClientEnter();
			if (number == 0) {
				return;
			}
			switch (number) {
			case 1:
				GradingSystem.removeStudent(student.get().getStudentID());
				break;
			case 2:
				System.out.println(student.get().getCourses().toString());
				break;
			case 3:
				System.out.println(GradingSystem.getListCourses().toString() + "\nEnter course ID: ");
				String courseId = scanner.nextLine();
				GradingSystem.enrollStudentInCourse(student.get().getStudentID(), courseId);
				break;
			case 4:
				System.out.println(GradingSystem.getListGrades().toString());
				break;
			case 0:
				break;
			}
		} else {
			System.out.println("Student not found");
		}
	}

	public static void coursePrograms(int num) {
		switch (num) {
		case 1:
			System.out.println("Enter new cours's name: ");
			String courseName = scanner.nextLine();
			System.out.println("Enter new cour's hours: ");
			int hours = getNumberFromClientEnter();
			if (GradingSystem.addCourse(courseName, hours)) {
				System.out.println("All done!");
			} else {
				System.out.println("Problem with adding the course!");
			}
			break;
		case 2:
			System.out.println("Enter course's ID: ");
			String courseID = scanner.nextLine();
			Optional<Course> course = GradingSystem.getCourseById(courseID);
			courseFunctions(course);
			break;
		case 3:
			System.out.println("Enter course's name: ");
			String courseName1 = scanner.nextLine();
			Optional<Course> course1 = GradingSystem.getCourseByName(courseName1);
			courseFunctions(course1);
			break;
		case 4:
			System.out.println(GradingSystem.getListCourses().toString());
			break;
		case 0:
			break;
		}

	}

	public static void courseFunctions(Optional<Course> course) {
		if (course.isPresent()) {
			System.out.println("The system found " + course.get().toString()
					+ "\nWhat do you want to do with the entry?"
					+ "\t1 -> Delete\t2 -> See all student of the course\t3 -> Enroll a student to the course\t4 -> See all course's grades\t0 -> exit");
			int number = getNumberFromClientEnter();
			if (number == 0) {
				return;
			}
			switch (number) {
			case 1:
				if (GradingSystem.getListCourses().remove(course.get())) {
					System.out.println("All done!");
				} else {
					System.out.println("Problem with removing the course!");
				}
				break;
			case 2:
				System.out.println(course.get().getListStudent().toString());
				break;
			case 3:
				System.out.println(GradingSystem.getListStudents().toString() + "\nEnter student's ID: ");
				String studID = scanner.nextLine();
				if (GradingSystem.enrollStudentInCourse(studID, course.get().getCourseId())) {
					System.out.println("All done!");
				} else {
					System.out.println("Problem with enrolling in the course");
				}
				break;
			case 4:
				System.out.println(GradingSystem.getGradesByCourseID(course.get().getCourseId()).toString());
				break;
			case 0:
				break;
			}
		} else {
			System.out.println("Course not found!");
		}
	}

	public static void gradePrograms(int num) {
		switch (num) {
		case 1:
			System.out.println("Enter new grade's student ID: ");
			String stID = scanner.nextLine();
			Optional<Student> stud = GradingSystem.getStudentById(stID);
			System.out.println("Enter new grade's course ID: ");
			String couID = scanner.nextLine();
			System.out.println("Enter new grade (10-100):");
			double grade = (double) getNumberFromClientEnter();
			if (GradingSystem.addGrade(stID, couID, grade)) {
				System.out.println("All done!");
			} else {
				System.out.println("Problem with new grade!");
			}
			break;
		case 2:
			System.out.println("Enter course ID: ");
			String course = scanner.nextLine();
			System.out.println(GradingSystem.getGradesByCourseID(course));
			break;
		case 3:
			System.out.println("Enter student ID: ");
			String sID = scanner.nextLine();
			System.out.println(GradingSystem.getGradesByStudentId(sID));
			break;
		case 4:
			System.out.println(GradingSystem.getListGrades().toString());
			break;
		case 0:
			break;
		}
	}

	public static void start() {
		scanner = new Scanner(System.in);
		GradingSystem.setListCourses(new ArrayList<Course>());
		GradingSystem.setListStudents(new ArrayList<Student>());
		GradingSystem.setListGrades(new ArrayList<Grade>());
		GradingSystem.loadData();
	}

	public static int getNumberFromClientEnter() {
		boolean doing = true;
		int clientNum = 0;
		while (doing) {
			try {
				System.out.println("Enter number:");
				clientNum = scanner.nextInt();
				scanner.nextLine();
				doing = false;
			} catch (NullPointerException e) {
				System.out.println("Problem with cast entry to number: " + e.getMessage());
			}
		}
		return clientNum;
	}

	public static void close() {
		scanner.close();
	}
}

/*
 * Project Title: Student Grading System Overview In this project, you will
 * create a Student Grading System in Java. The application will enable users to
 * add students and courses, enroll students in courses, record grades, and view
 * all students, courses, and grades—all by interacting with a console-based
 * menu. All self creating ids. 1. Student Class Purpose: Represents a student
 * with personal details. Fields: ○ String studentId: A unique identifier for
 * each student. ○ String name: The student's full name. ○ String email: The
 * student's email address. Methods: ○ getStudentId(): Access and modify the
 * student ID. ○ getName(), setName(String name): Access and modify the
 * student's name. ○ getEmail(), setEmail(String email): Access and modify the
 * student's email. 2. Course Class Purpose: Represents a course offered in the
 * system. Fields: ○ String courseId: A unique identifier for each course. ○
 * String courseName: The name of the course. ○ int creditHours: The number of
 * credit hours the course is worth. Methods: ○ getCourseId(),
 * setCourseId(String courseId) Access and modify the course ID. ○
 * getCourseName(), setCourseName(String courseName) Access and modify the
 * course name. ○ getCreditHours(), setCreditHours(int creditHours) Access and
 * modify the credit hours. 3. 3. Grade Class Purpose: Represents a grade
 * assigned to a student for a specific course. Fields: ○ Student student The
 * student who received the grade. ○ Course course The course for which the
 * grade was given. ○ double gradeValue The numerical value of the grade (e.g.,
 * on a 100-point scale). 4. Methods: ○ getStudent(), setStudent(Student
 * student) Access and modify the student associated with the grade. ○
 * getCourse(), setCourse(Course course) Access and modify the course associated
 * with the grade. ○ getGradeValue(), setGradeValue(double gradeValue) Access
 * and modify the grade value. 5. 4. GradingSystem Class Purpose: Manages the
 * overall system, including students, courses, and grades. Handles file
 * operations for data persistence. Fields: ○ List<Student> students A list of
 * all students in the system. ○ List<Course> courses A list of all courses
 * available. ○ List<Grade> grades A list of all grades recorded. 6. Methods: ○
 * Student Management: ■ addStudent(Student student) Add a new student to the
 * system. ■ removeStudent(String studentId) Remove a student from the system. ■
 * getStudentById(String studentId) Retrieve a student by their ID. ○ Course
 * Management: ■ addCourse(Course course) Add a new course to the system. ■
 * removeCourse(String courseId) Remove a course from the system. ■
 * getCourseById(String courseId) Retrieve a course by its ID. ○ Enrollment
 * Management: ■ enrollStudentInCourse(String studentId, String courseId) Enroll
 * a student in a specific course. ○ Grade Management: ■ addGrade(String
 * studentId, String courseId, double gradeValue) Record a grade for a student
 * in a specific course. ○ File Operations: ■ saveData(String filename) Save all
 * system data to a file. ■ loadData(String filename) Load system data from a
 * file. 7. Main Class Purpose: Serves as the entry point of the application,
 * facilitating user interaction through a console-based menu. Requirements: ○
 * Initialize the Grading System: ■ Create an instance of the GradingSystem
 * class. ■ Load existing data from files if available. ○ User Interface: ■
 * Implement a simple text-based menu with options. ■ Use a loop to continuously
 * display the menu until the user chooses to exit. ○ Handle User Choices: ■ Add
 * Student: Prompt the user for student ID, name, and email. Create a new
 * Student object and add it to the system. ■ Add Course: Prompt the user for
 * course ID, name, and credit hours. Create a new Course object and add it to
 * the system. ■ Enroll Student in Course: Prompt the user for student ID and
 * course ID. Enroll the specified student in the specified course. ■ Record
 * Grade: Prompt the user for student ID, course ID, and grade value. Record the
 * grade for the student in the specified course. ■ Show All Students: Display a
 * list of all students with their details. ■ Show All Courses: Display a list
 * of all courses with their details. ■ Show All Grades: Display a list of all
 * recorded grades. ■ Exit: Save all data to files to ensure persistence and
 * terminate the application. ○ Exit Procedure: ■ Before exiting, ensure all
 * current data is saved to files. ■ Provide a confirmation message indicating
 * that data has been saved and the application is closing. 8. Data Persistence
 * Purpose: Ensure that all data (students, courses, grades) is saved to files
 * so that information is retained between sessions.
 *
 *
 *** 
 * Название проекта**: Система оценки студентов
 ** 
 * Обзор** В этом проекте вы создадите Систему оценки студентов на языке Java.
 * Приложение позволит пользователям добавлять студентов и курсы, зачислять
 * студентов на курсы, записывать оценки и просматривать все студентов, курсы и
 * оценки — всё это с помощью консольного меню. \ Все идентификаторы (ID)
 * создаются автоматически.
 * 
 * ### 1. Класс **Student** Цель**: Представляет студента с личными данными.
 ** Поля**: - `String studentId`: Уникальный идентификатор для каждого студента.
 * - `String name`: Полное имя студента. - `String email`: Электронная почта
 * студента.
 ** 
 * Методы**: - `getStudentId()`: Доступ к идентификатору студента и его
 * изменение. - `getName(), setName(String name)`: Доступ и изменение имени
 * студента. - `getEmail(), setEmail(String email)`: Доступ и изменение
 * электронной почты студента.
 * 
 * ### 2. Класс **Course** Цель**: Представляет курс, предлагаемый в системе.
 ** Поля**: - `String courseId`: Уникальный идентификатор для каждого курса. -
 * `String courseName`: Название курса. - `int creditHours`: Количество
 * кредитных часов курса.
 ** 
 * Методы**: - `getCourseId(), setCourseId(String courseId)`: Доступ и изменение
 * идентификатора курса. - `getCourseName(), setCourseName(String courseName)`:
 * Доступ и изменение названия курса. - `getCreditHours(), setCreditHours(int
 * creditHours)`: Доступ и изменение количества кредитных часов.
 * 
 * ### 3. Класс **Grade** Цель**: Представляет оценку, присвоенную студенту за
 * конкретный курс. Поля**: - `Student student`: Студент, получивший оценку. -
 * `Course course`: Курс, за который была присвоена оценка. - `double
 * gradeValue`: Числовое значение оценки (например, по шкале 100).
 ** 
 * Методы**: - `getStudent(), setStudent(Student student)`: Доступ и изменение
 * студента, связанного с оценкой. - `getCourse(), setCourse(Course course)`:
 * Доступ и изменение курса, связанного с оценкой. - `getGradeValue(),
 * setGradeValue(double gradeValue)`: Доступ и изменение значения оценки.
 * 
 * ### 4. Класс **GradingSystem** Цель**: Управляет общей системой, включая
 * студентов, курсы и оценки. Обрабатывает операции с файлами для сохранения
 * данных. Поля**: - `List<Student> students`: Список всех студентов в системе.
 * - `List<Course> courses`: Список всех доступных курсов. - `List<Grade>
 * grades`: Список всех записанных оценок.
 ** 
 * Методы**: - **Управление студентами**: - `addStudent(Student student)`:
 * Добавить нового студента в систему. - `removeStudent(String studentId)`:
 * Удалить студента из системы. - `getStudentById(String studentId)`: Получить
 * студента по его ID.
 * 
 * - **Управление курсами**: - `addCourse(Course course)`: Добавить новый курс в
 * систему. - `removeCourse(String courseId)`: Удалить курс из системы. -
 * `getCourseById(String courseId)`: Получить курс по его ID.
 * 
 * - **Управление зачислениями**: - `enrollStudentInCourse(String studentId,
 * String courseId)`: Зачислить студента на конкретный курс.
 * 
 * - **Управление оценками**: - `addGrade(String studentId, String courseId,
 * double gradeValue)`: Записать оценку для студента по конкретному курсу.
 * 
 * - **Операции с файлами**: - `saveData(String filename)`: Сохранить все данные
 * системы в файл. - `loadData(String filename)`: Загрузить данные системы из
 * файла.
 * 
 * ### 5. Класс **Main** Цель**: Является точкой входа в приложение, обеспечивая
 * взаимодействие с пользователем через консольное меню. Требования**: -
 * **Инициализация системы оценок**: - Создать экземпляр класса GradingSystem. -
 * Загрузить существующие данные из файлов, если они есть.
 * 
 * - **Пользовательский интерфейс**: - Реализовать простое текстовое меню с
 * вариантами. - Использовать цикл для постоянного отображения меню, пока
 * пользователь не выберет выход.
 * 
 * - **Обработка выбора пользователя**: - **Добавить студента**: Запросить у
 * пользователя ID студента, имя и электронную почту. Создать новый объект
 * Student и добавить его в систему. - **Добавить курс**: Запросить у
 * пользователя ID курса, название и количество кредитных часов. Создать новый
 * объект Course и добавить его в систему. - **Зачислить студента на курс**:
 * Запросить у пользователя ID студента и ID курса. Зачислить указанного
 * студента на указанный курс. - **Записать оценку**: Запросить у пользователя
 * ID студента, ID курса и значение оценки. Записать оценку для студента по
 * указанному курсу. - **Показать всех студентов**: Отобразить список всех
 * студентов с их данными. - **Показать все курсы**: Отобразить список всех
 * курсов с их данными. - **Показать все оценки**: Отобразить список всех
 * записанных оценок. - **Выход**: Сохранить все данные в файлы для обеспечения
 * их сохранности и завершить работу приложения.
 * 
 * - **Процедура выхода**: - Перед выходом убедиться, что все текущие данные
 * сохранены в файлы. - Показать сообщение о подтверждении сохранения данных и
 * закрытии приложения.
 * 
 * ### 6. Сохранение данных Цель**: Обеспечить сохранение всех данных
 * (студентов, курсов, оценок) в файлы, чтобы информация сохранялась между
 * сессиями.
 */