package collegeManager_TODO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GradingSystem {
	private final static String BASE_FILE = "systemData";
	private static int counter;
	private static ArrayList<Student> listStudents;
	private static ArrayList<Course> listCourses;
	private static ArrayList<Grade> listGrades;

//	Student Management:

	public static boolean addStudent(String studentName, String studentEmail) {
		if (!studentName.isBlank() && !studentEmail.isBlank() && studentEmail.contains("@")) {
			Student student = new Student(studentName, studentEmail);
			return true;
		}
		return false;
	}

	public static boolean removeStudent(String studentId) {
		if (!studentId.isBlank()) {
			Optional student = getStudentById(studentId);
			if (student.isPresent()) {
				return listStudents.remove(student.get());
			}
		}
		return false;
	}

	public static Optional<Student> getStudentById(String studentId) {
		List<Student> filteredStudents = listStudents.stream()
				.filter(student -> student.getStudentID().equalsIgnoreCase(studentId)).collect(Collectors.toList());
		if (filteredStudents.size() != 1) {
			System.out.println(
					"Problem with ID identification: " + filteredStudents.size() + " students with ID: " + studentId);
		}
		return Optional.of(filteredStudents.getFirst());
	}

	public static List<Student> getStudentByName(String studentName) {
		List<Student> filteredStudents = listStudents.stream()
				.filter(student -> student.getStudentName().contains(studentName)).collect(Collectors.toList());
		if (filteredStudents.size() != 1) {
			System.out.println("Problem with identification by name: " + filteredStudents.size()
					+ " students with name: " + studentName);
		}
		return filteredStudents;
	}

	public static List<Student> getStudentByEmail(String studentEmail) {
		List<Student> filteredStudents = listStudents.stream()
				.filter(student -> student.getStudentEmail().contains(studentEmail)).collect(Collectors.toList());
		if (filteredStudents.size() != 1) {
			System.out.println("Problem with identification by name: " + filteredStudents.size()
					+ " students with e-mail: " + studentEmail);
		}
		return filteredStudents;
	}

//	Course Management: 

	public static boolean addCourse(String courseName, int creditHours) {
		if (!courseName.isBlank() && creditHours != 0) {
			Course course = new Course(courseName, creditHours);
			return true;
		}
		return false;
	}

	public static boolean removeCourse(String courseId) {
		if (!courseId.isBlank()) {
			Optional<Course> course = getCourseById(courseId);
			if (course.isPresent()) {
				return listCourses.remove(course.get());
			}
		}
		return false;
	}

	public static Optional<Course> getCourseById(String courseId) {
		List<Course> filteredCourses = listCourses.stream()
				.filter(course -> course.getCourseId().equalsIgnoreCase(courseId)).collect(Collectors.toList());
		if (filteredCourses.size() != 1) {
			System.out.println(
					"Problem with ID identification: " + filteredCourses.size() + " students with ID: " + courseId);
		}
		return Optional.of(filteredCourses.getFirst());
	}

	public static Optional<Course> getCourseByName(String courseName) {
		List<Course> filteredCourses = listCourses.stream()
				.filter(course -> course.getCourseName().equalsIgnoreCase(courseName)).collect(Collectors.toList());
		if (filteredCourses.size() != 1) {
			System.out.println(
					"Problem with ID identification: " + filteredCourses.size() + " students with ID: " + courseName);
		}
		return Optional.of(filteredCourses.getFirst());
	}

//	Enrollment Management: 

	public static boolean enrollStudentInCourse(String studentId, String courseId) {
		if (!studentId.isBlank() && !courseId.isBlank()) {
			Optional<Student> student = getStudentById(studentId);
			Optional<Course> course = getCourseById(courseId);
			if (student.isPresent() && course.isPresent()) {
				course.get().getListStudent().add(student.get());
				ArrayList<Course> courses = student.get().getCourses();
				courses.add(course.get());
				student.get().setCourses(courses);
				return true;
			}
		}
		return false;
	}

	public static boolean deductStudentFromCourse(String studentId, String courseId) {
		if (!studentId.isBlank() && !courseId.isBlank()) {
			Optional<Student> student = getStudentById(studentId);
			Optional<Course> course = getCourseById(courseId);
			if (student.isPresent() && course.isPresent()) {
				student.get().getCourses().remove(course.get());
				return course.get().getListStudent().remove(student.get());
			}
		}
		return false;
	}

//	Grade Management: 

	public static boolean addGrade(String studentId, String courseId, double gradeValue) {
		if (!studentId.isBlank() && !courseId.isBlank() && gradeValue != 0) {
			Optional<Student> student = getStudentById(studentId);
			Optional<Course> course = getCourseById(courseId);
			if (student.isPresent() && course.isPresent()) {
				Grade grade = new Grade(student.get(), course.get(), gradeValue);
				return true;
			}
		}
		return false;
	}
	
	public static List<Grade> getGradesByStudentId(String StudentId) {
		List<Grade> filteredGrades = listGrades.stream().filter(grade -> grade.getStudent().getStudentID().equals(StudentId)).collect(Collectors.toList());
		return filteredGrades;
	}
	
	public static List<Grade> getGradesByCourseID(String CourseId) {
		List<Grade> filteredGrades = listGrades.stream().filter(grade -> grade.getCourse().getCourseId().equals(CourseId)).collect(Collectors.toList());
		return filteredGrades;
	}

//	File Operations:
	// serialization
	public static void saveData() {
		try {
			serializationData(makeFile("counter.ser"), Integer.valueOf(counter));
			serializationData(makeFile("listStudents.ser"), listStudents);
			serializationData(makeFile("listCourses.ser"), listCourses);
			serializationData(makeFile("listGrades.ser"), listGrades);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\nReturning without serialization.");
			return;
		}
	}

	private static void serializationData(File file, Object obj) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getPath()))) {
			out.writeObject(obj);
			System.out.println("Object was serialized in file: " + file.getPath());
		} catch (IOException e) {
			System.out.println("Problem with serialization: " + e.getMessage());
		}
	}

	private static File makeFile(String id) {
		try {
			File file = new File(BASE_FILE);
			if (!file.exists()) {
				file.mkdir();
			}
			File serialFile = new File(file, id);
			if (!serialFile.exists()) {
				serialFile.createNewFile();
			}
			return serialFile;
		} catch (Exception e) {
			System.out.println("Problem with creating files: " + e.getMessage());
		}
		return null;
	}

	// deserialization
	@SuppressWarnings("unchecked")
	public static void loadData() {
		File file = new File(BASE_FILE);
		if (!file.exists())
			return;

		try (ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(new File(BASE_FILE, "counter.ser").getPath()))) {
			counter = (Integer) in.readObject();
			System.out.println("Counter was deserialization");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Problem with deserialization counter: " + e.getMessage());
			return;
		}
		try (ObjectInputStream in2 = new ObjectInputStream(
				new FileInputStream(new File(BASE_FILE, "listStudents.ser").getPath()))) {
			listStudents = (ArrayList<Student>) in2.readObject();
			System.out.println("List of students was deserialization");
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			System.err.println("Problem with deserialization listStudents: " + e.getMessage());
			return;
		}
		try (ObjectInputStream in3 = new ObjectInputStream(
				new FileInputStream(new File(BASE_FILE, "listCourses.ser").getPath()))) {
			listCourses = (ArrayList<Course>) in3.readObject();
			System.out.println("List of courses was deserialization");
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			System.err.println("Problem with deserialization listCourses: " + e.getMessage());
			return;
		}
		try (ObjectInputStream in4 = new ObjectInputStream(
				new FileInputStream(new File(BASE_FILE, "listGrades.ser").getPath()))) {
			listGrades = (ArrayList<Grade>) in4.readObject();
			System.out.println("List of grades was deserialization");
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			System.err.println("Problem with deserialization listGrades: " + e.getMessage());
			return;
		}
	}

	public static ArrayList<Student> getListStudents() {
		return listStudents;
	}

	public static void setListStudents(ArrayList<Student> listStudents) {
		GradingSystem.listStudents = listStudents;
	}

	public static ArrayList<Course> getListCourses() {
		return listCourses;
	}

	public static void setListCourses(ArrayList<Course> listCourses) {
		GradingSystem.listCourses = listCourses;
	}

	public static ArrayList<Grade> getListGrades() {
		return listGrades;
	}

	public static void setListGrades(ArrayList<Grade> listGrades) {
		GradingSystem.listGrades = listGrades;
	}

}

/*
 * TZ Purpose: Manages the overall system, including students, courses, and
 * grades. Handles file operations for data persistence. Fields: ○ List<Student>
 * students A list of all students in the system. ○ List<Course> courses A list
 * of all courses available. ○ List<Grade> grades A list of all grades recorded.
 * 6. Methods: ○ Student Management: ■ addStudent(Student student) Add a new
 * student to the system. ■ removeStudent(String studentId) Remove a student
 * from the system. ■ getStudentById(String studentId) Retrieve a student by
 * their ID. ○ Course Management: ■ addCourse(Course course) Add a new course to
 * the system. ■ removeCourse(String courseId) Remove a course from the system.
 * ■ getCourseById(String courseId) Retrieve a course by its ID. ○ Enrollment
 * Management: ■ enrollStudentInCourse(String studentId, String courseId) Enroll
 * a student in a specific course. ○ Grade Management: ■ addGrade(String
 * studentId, String courseId, double gradeValue) Record a grade for a student
 * in a specific course. ○ File Operations: ■ saveData(String filename) Save all
 * system data to a file. ■ loadData(String filename) Load system data from a
 * file.
 */
