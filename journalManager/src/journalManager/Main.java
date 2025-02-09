package journalManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	private static int counter = 0;
	private static Scanner sc = new Scanner(System.in);
	private static boolean exit;

	public static void main(String[] args) {
		int num = 1;
		while (num != 0) {
			menu();
			num = sc.nextInt();
			choose(num);
		}
	}

	public static void menu() {
		System.out.println("""
				Choose number:
				\tCreate note - 1
				\tDelete note - 2
				\tDelete journal - 3
				\tPrint note in journal - 4
				\tAlljournals - 5
				\tExit - 0
				""");
	}

	public static void choose(int num) {
		switch (num) {
		case 1: {
			createNote();
			break;
		}
		case 2: {
			System.out.println("Enter name of journal: ");
			String journalName = sc.nextLine();
			JournalManagerClass.printJournal(journalName);
			System.out.println("Enter name of entry: ");
			String entryName = sc.nextLine();
			JournalManagerClass.deleteEntry(journalName, entryName);
			break;
		}
		case 3: {
			System.out.println("Enter name of journal: ");
			String journalName = sc.nextLine();
			JournalManagerClass.deleteJournal(journalName);
			break;
		}
		case 4: {
			System.out.println("Enter name of journal: ");
			String journalName = sc.nextLine();
			JournalManagerClass.printJournal(journalName);
			System.out.println("Enter name of entry: ");
			String entryName = sc.nextLine();
			JournalManagerClass.printEntry(journalName, entryName);
			break;
		}
		case 5: {
			printUserJournals();
			break;
		}
		case 0:
			System.out.println("Bye");
			sc.close();
			break;
		}
	}

	public static void createNote() {
		while (!exit) {
			System.out.println("Write name of your journal:/n");
			String userJournal = sc.nextLine();
			// createEntry(String journalName, String entryName, String content)
			System.out.println("Write your note:/n");
			String note = "";
			StringBuffer sb = new StringBuffer();
			while (sc.hasNext()) {
				sb.append(sc.nextLine());
				note = sb.toString();
			}
			JournalManagerClass.createEntry(userJournal, "note" + (LocalDateTime.now().toString()), note);
			System.out.println("All done. One more note? Y/N");
			exit = (sc.nextLine().trim().equalsIgnoreCase("y"));
			sc.nextLine();
		}
	}

	public static void printUserJournals() {
		String journalName = JournalManagerClass.getPathRootDirectory();
		while (!journalName.isBlank()) {
			System.out.println("Choose one of the journal's name or print only enter:\n");
			JournalManagerClass.printJournal(journalName);
			journalName = sc.nextLine().trim();
		}
	}
}
