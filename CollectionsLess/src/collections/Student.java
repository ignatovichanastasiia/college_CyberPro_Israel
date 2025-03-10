package collections;

import java.util.List;
import java.util.Objects;

public class Student {
	private String studentName;
	private String ID;
	private Double rate;

	public Student(String studentName, double rate) {
		this.studentName = studentName;
		ID = String.valueOf(hashCode());
		this.rate = rate;
		List<Student> students = StudentManager.getListStudents();
		students.add(this);
		StudentManager.setListStudents(students);
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		ID = ID;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(studentName, other.studentName);
	}

	@Override
	public String toString() {
		return "\nStudent [student: " + ID + ", student name= " + studentName + ", rate=" + rate + "]";
	}

	public int compareTo(Student stud2) {
		 return this.rate.compareTo(stud2.getRate());

	}

}
