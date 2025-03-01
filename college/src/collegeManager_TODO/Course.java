package collegeManager_TODO;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
	private static final String BASE_NAME_FOR_COURSE_ID = "course";
	private static int counter = 0;
	private String courseId;
	private String courseName;
	private int creditHours;
	private ArrayList<Student> listStudent;
	
	public Course(String courseName, int creditHours) {
		this.courseId = BASE_NAME_FOR_COURSE_ID+counter;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.listStudent = new ArrayList<Student>();
		ArrayList<Course> listCourses = GradingSystem.getListCourses();
		listCourses.add(this);
		GradingSystem.setListCourses(listCourses);
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getCreditHours() {
		return creditHours;
	}
	
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", creditHours=" + creditHours + "students:\n"
				+ listStudent.toString()+"]";
	}

}

/*
Purpose: Represents a course offered in the system. 
Fields: 
○ String courseId: A unique identifier for each course. 
○ String courseName: The name of the course. 
○ int creditHours: The number of credit hours the course is 
worth. 
Methods: 
○ getCourseId(), setCourseId(String courseId) 
Access and modify the course ID. 
○ getCourseName(), setCourseName(String courseName) 
Access and modify the course name. 
○ getCreditHours(), setCreditHours(int creditHours) 
Access and modify the credit hours. 
*/