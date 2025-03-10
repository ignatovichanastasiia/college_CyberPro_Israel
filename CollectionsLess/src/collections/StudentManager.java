package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StudentManager {
	private static List<Student> listStudents = new ArrayList<Student>();
	private static Map<String, String> mapStudents = new HashMap<String, String>();
	private static Set<String> treeNames = new TreeSet<String>();
	private static Queue<Student> queue;

	public static void realization(){
	queue = new PriorityQueue<>((stud1, stud2) -> {
			return stud1.compareTo(stud2);
	});

	Student st1 = new Student("Darel",56);
	Student st2 = new Student("Tanya",45);
	Student st3 = new Student("Michel",89);
	Student st4 = new Student("Farel",78);
	
	mapStudents = listStudents.stream().collect(Collectors.toMap(Student::getID, Student::getStudentName));
	List<String> names= listStudents.stream().map(s -> s.getStudentName()).toList();
	treeNames.addAll(names);
	queue.addAll(listStudents); 
	
	System.out.println("\nAll students: "+getListStudents());
	System.out.println("\nAll names by ABC: " +getTreeNames());
	System.out.println("\nStudent by ID 65802909: "+getNamebyID("65802909"));
	System.out.println("\nTickets priority by rate: "+getQueue().toString());
	}
	
	public static String getNamebyID(String ID) {
		return mapStudents.get(ID);
	}

	public static List<Student> getListStudents() {
		return listStudents;
	}

	public static void setListStudents(List<Student> listStudents) {
		StudentManager.listStudents = listStudents;
	}

	public static Map<String, String> getMapStudents() {
		return mapStudents;
	}

	public static void setMapStudents(Map<String, String> mapStudents) {
		StudentManager.mapStudents = mapStudents;
	}

	public static Set<String> getTreeNames() {
		return treeNames;
	}

	public static void setTreeNames(Set<String> treeNames) {
		StudentManager.treeNames = treeNames;
	}

	public static Queue<Student> getQueue() {
		return queue;
	}

	public static void setQueue(Queue<Student> queue) {
		StudentManager.queue = queue;
	}

}

/*
 * ✔ Covers: ● ArrayList → Storing student objects. ● HashMap → Mapping student
 * IDs to student names. ● TreeSet → Storing sorted student names. ●
 * PriorityQueue → Managing student support requests. Description: Create a
 * Student Management System that: ● Registers students and assigns them an ID.
 * ● Sorts students alphabetically for quick retrieval. ● Uses a priority queue
 * for student support requests (urgent issues first). ● Stores student ID and
 * name in a HashMap for fast lookups. Features: ✅ Add new students. ✅ Sort
 * students by name. ✅ Handle student support tickets (priority-based queue). ✅
 * Quickly find a student by ID.
 * 
 */