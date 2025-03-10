package collections;

public class Main {
	public static void main(String[] args) {
//		List<String> city = new ArrayList<String>();
//		city.add("New York");
//		city.add("London");
//		city.add("Tokyo");
//		city.add("Paris");
//		city.add("Sydney");
//		city.remove(0);
//		System.out.println(city.get(2));
//
//		List<String> names = new LinkedList();
//		names.add("Dan");
//		names.add("Nill");
//		names.add("Tamar");
//		names.add("Flor");
//		names.removeFirst();
//		names.removeLast();
//		System.out.println(names);
//
//		Vector<String> vec = new Vector<String>();
//		vec.add("message1");
//		vec.add("message2");
//		vec.add("message3");
//		System.out.println(vec.getFirst());
//		vec.removeFirst();
//		System.out.println(vec.getFirst());
//		System.out.println(vec);
//
//		Stack<String> actions = new Stack<String>();
//		Collections.addAll(actions, "Open", "Edit", "Save", "Close");
//		actions.removeLast();
//		actions.removeLast();
//		System.out.println(actions);
//
//		PriorityQueue<String> taskQueue = new PriorityQueue<>((task1, task2) -> {
//			// Custom priority order: High Priority > Medium Priority > Low Priority
//			if (task1.contains("High") && task2.contains("Medium"))
//				return -1; // High > Medium
//			if (task1.contains("High") && task2.contains("Low"))
//				return -1; // High > Low
//			if (task1.contains("Medium") && task2.contains("Low"))
//				return -1; // Medium > Low
//			return task1.compareTo(task2); // Default alphabetical order
//		});
//
//		// Adding tasks with custom priority
//		taskQueue.add("Low Priority Task");
//		taskQueue.add("High Priority Task");
//		taskQueue.add("Medium Priority Task");
//
//		// Poll the highest priority task first
//		System.out.println("Polling the highest priority task: " + taskQueue.poll());
//
//		// Print remaining tasks
//		System.out.println("Remaining tasks:");
//		while (!taskQueue.isEmpty()) {
//			System.out.println(taskQueue.poll());
//		}
//
//		ArrayDeque<String> history = new ArrayDeque<>();
//		history.add("www.google.com");
//		history.add("www.youtube.com");
//		history.add("www.github.com");
//		history.add("www.stackoverflow.com");
//
//		System.out.println("Current browser history:");
//		for (String site : history) {
//			System.out.println(site);
//		}
//
//		System.out.println("\nGoing back one page...");
//		history.pollLast();
//
//		System.out.println("\nRemaining browser history:");
//		for (String site : history) {
//			System.out.println(site);
//		}
//
//		Queue<String> namesQ = new LinkedList<String>();
//		Collections.addAll(namesQ, "Alice", "Bob", "Charlie");
//		System.out.println(namesQ.poll());
//		System.out.println(namesQ);
//
//		Set<String> set = new HashSet<String>();
//		Collections.addAll(set, "Laptop", "Phone", "Tablet", "Laptop", "Phone");
//		System.out.println(set);
//
//		Set<String> set2 = new LinkedHashSet<String>();
//		Collections.addAll(set2, "Laptop", "Phone", "Tablet", "Laptop", "Phone");
//		System.out.println(set2);
//
//		TreeSet<String> studentNames = new TreeSet<>();
//		studentNames.add("David");
//		studentNames.add("Alice");
//		studentNames.add("Charlie");
//		studentNames.add("Bob");
//
//		System.out.println("Sorted student names:");
//		for (String name : studentNames) {
//			System.out.println(name);
//		}
//
//		HashMap<Integer, String> employeeDirectory = new HashMap<>();
//		employeeDirectory.put(101, "Alice");
//		employeeDirectory.put(102, "Bob");
//		employeeDirectory.put(103, "Charlie");
//		String employeeName = employeeDirectory.get(102);
//
//		if (employeeName != null) {
//			System.out.println("Employee with ID 102: " + employeeName);
//		} else {
//			System.out.println("Employee not found.");
//		}
//
//		LinkedHashMap<String, Integer> studentGrades = new LinkedHashMap<>();
//
//		studentGrades.put("Alice", 85);
//		studentGrades.put("Bob", 90);
//		studentGrades.put("Charlie", 80);
//
//		// Print the LinkedHashMap (it will maintain insertion order)
//		System.out.println("Student Grades:");
//		for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
//			System.out.println(entry.getKey() + " → " + entry.getValue());
//		}
//
//		TreeMap<String, Integer> countryPopulation = new TreeMap<>();
//		countryPopulation.put("USA", 330000000);
//		countryPopulation.put("China", 1400000000);
//		countryPopulation.put("India", 1300000000);
//
//		System.out.println("Country Population Data (sorted by country name):");
//		for (Map.Entry<String, Integer> entry : countryPopulation.entrySet()) {
//			System.out.println(entry.getKey() + " → " + entry.getValue());
//		}
//
//		EnumSet<Day> workingDays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY);
//		System.out.println("Working days: " + workingDays);
//
//		HashMap<Integer, String> studentDirectory = new HashMap<>();
//
//		studentDirectory.put(101, "Alice");
//		studentDirectory.put(102, "Bob");
//		studentDirectory.put(103, "Charlie");
//
//		String studentName = studentDirectory.get(102);
//		System.out.println("Student with ID 102: " + studentName);
//
//		LinkedHashMap<Integer, String> bookHistory = new LinkedHashMap<>();
//		bookHistory.put(101, "Harry Potter");
//		bookHistory.put(102, "Lord of the Rings");
//		bookHistory.put(103, "1984");
//
//		System.out.println("Book Borrow History:");
//		for (Map.Entry<Integer, String> entry : bookHistory.entrySet()) {
//			System.out.println("Book ID: " + entry.getKey() + " → " + entry.getValue());
//		}
//
//		TreeMap<String, Double> productPrices = new TreeMap<>();
//
//		productPrices.put("Laptop", 1200.0);
//		productPrices.put("Phone", 800.0);
//		productPrices.put("Tablet", 600.0);
//
//		System.out.println("Sorted Product Prices:");
//		for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
//			System.out.println(entry.getKey() + " → $" + entry.getValue());
//		}
//
//		Hashtable<Integer, Double> employeeSalaries = new Hashtable<>();
//
//		employeeSalaries.put(201, 5000.0);
//		employeeSalaries.put(202, 5500.0);
//		employeeSalaries.put(203, 6000.0);
//
//		System.out.println("Employee Salaries:");
//		for (Map.Entry<Integer, Double> entry : employeeSalaries.entrySet()) {
//			System.out.println("Employee ID: " + entry.getKey() + " → Salary: $" + entry.getValue());
//		}
//
//		EnumMap<Day, Integer> workSchedule = new EnumMap<>(Day.class);
//
//		workSchedule.put(Day.MONDAY, 8);
//		workSchedule.put(Day.TUESDAY, 8);
//		workSchedule.put(Day.WEDNESDAY, 6);
//		workSchedule.put(Day.THURSDAY, 8);
//		workSchedule.put(Day.FRIDAY, 8);
//
//		System.out.println("Work Schedule:");
//		for (Map.Entry<Day, Integer> entry : workSchedule.entrySet()) {
//			System.out.println(entry.getKey() + " → " + entry.getValue() + " hours");
//		}
		
		StudentManager.realization();
	}
	
	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

}


/*
 * New York London Tokyo Paris Sydney
 * 
 */