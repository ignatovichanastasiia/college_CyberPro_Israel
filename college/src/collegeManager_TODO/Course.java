package collegeManager_TODO;

public class Course {
	private String courseId;
	private String courseName;
	private int creditHours;
	
	
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
	
	

}


//Purpose: Represents a course offered in the system. 
//Fields: 
//○ String courseId: A unique identifier for each course. 
//○ String courseName: The name of the course. 
//○ int creditHours: The number of credit hours the course is 
//worth. 
//Methods: 
//○ getCourseId(), setCourseId(String courseId) 
//Access and modify the course ID. 
//○ getCourseName(), setCourseName(String courseName) 
//Access and modify the course name. 
//○ getCreditHours(), setCreditHours(int creditHours) 
//Access and modify the credit hours. 