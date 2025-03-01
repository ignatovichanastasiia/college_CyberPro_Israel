package collegeManager_TODO;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	private static final String BASE_NAME_FOR_STUDENT_ID = "student";
	private static int counter = 0;
	private String studentID;
	private String studentName;
	private String studentEmail;
	private ArrayList<Course> courses;
	
	public Student(String studentName, String studentEmail) {
		this.studentID = BASE_NAME_FOR_STUDENT_ID+counter;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> students = GradingSystem.getListStudents();
		students.add(this);
		GradingSystem.setListStudents(students);
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ "]";
	}
}



/*
Student Class 
Purpose: Represents a student with personal details.   
Fields: 
○ String studentId: A unique identifier for each student. 
○ String name: The student's full name. 
○ String email: The student's email address. 
Methods: 
○ getStudentId(): Access and modify the student ID. 
○ getName(), setName(String name): Access and modify 
the student's name. 
○ getEmail(), setEmail(String email): Access and 
modify the student's email.
*/