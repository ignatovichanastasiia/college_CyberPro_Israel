package collegeManager;

public class Grade {
	private Student student;
	private Course course;
	private double gradeValue; //100
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public double getGradeValue() {
		return gradeValue;
	}
	public void setGradeValue(double gradeValue) {
		this.gradeValue = gradeValue;
	}
	
	
	

}


//Purpose: Represents a grade assigned to a student for a specific course. 
//Fields: 
//○ Student student 
//The student who received the grade. 
//○ Course course 
//The course for which the grade was given. 
//○ double gradeValue 
//The numerical value of the grade (e.g., on a 100-point scale). 
//4. Methods: 
//○ getStudent(), setStudent(Student student) 
//Access and modify the student associated with the grade. 
//○ getCourse(), setCourse(Course course) 
//Access and modify the course associated with the grade. 
//○ getGradeValue(), setGradeValue(double gradeValue) 
//Access and modify the grade value. 
