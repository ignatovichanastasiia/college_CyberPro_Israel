package journalManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static boolean exite;

	public static void main(String[] args) {
		int num = 9;
		while (num != 0) {
			menu();
			try {
			num = (int)sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("We have a problem with choose insert");
			}
			sc.nextLine();
			choose(num);
		}
	}

	public static void menu() {
		System.out.println("""
				Choose number:
				\tCreate note - 1
				\tDelete note - 2
				\tPrint journal - 3
				\tDelete journal - 4
				\tPrint note in journal - 5
				\tAll journals - 6
				\tDelete all journals - 7
				\tSave and restore journal - 8
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
			JournalManagerClass.printJournal(journalName);
			break;
		}
		case 4: {
			System.out.println("Enter name of journal: ");
			String journalName = sc.nextLine();
			JournalManagerClass.deleteJournal(journalName);
			break;
		}
		case 5: {
			System.out.println("Enter name of journal: ");
			String journalName = sc.nextLine();
			JournalManagerClass.printJournal(journalName);
			System.out.println("Enter name of entry: ");
			String entryName = sc.nextLine();
			JournalManagerClass.printEntry(journalName, entryName);
			break;
		}
		case 6: {
			JournalManagerClass.printAllJournal();
			break;
		}
		case 7:{
			JournalManagerClass.deleteAllJournals();
			break;
		}
		case 8:{
			System.out.println("Enter name of journal: ");
			String journalName = sc.nextLine();
			System.out.println("Save or restore? S/R");
			String answer = sc.nextLine();
			JournalManagerClass.createJournal("saving");
			if(answer.contains("R")) {
				
				JournalManagerClass.loadJournalFromBytes(journalName, JournalManagerClass.getPathOfDirectoryByName("saving"));
			}else {
				JournalManagerClass.saveJournalAsBytes(journalName, JournalManagerClass.getPathOfDirectoryByName("saving"));
			}
			
			break;
		}
		case 9:{
			break;
		}
		case 0:
			System.out.println("Bye");
			sc.close();
			break;
		}
	}

	public static void createNote() {
		exite = false;
		while (!exite) {
			System.out.println("Write name of your journal:");
			String userJournal = sc.nextLine();
			// createEntry(String journalName, String entryName, String content)
			System.out.println("Write your note:");
			String note = sc.nextLine();
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			JournalManagerClass.createEntry(userJournal, "note" + now.format(formatter), note);
			System.out.println("One more note? Y/N");
			String strExite = sc.nextLine().trim();
			exite = (strExite.equalsIgnoreCase("n"));
		}
	}

	public static void printUserJournals() {
		String journalName = JournalManagerClass.getPathRootDirectory();
		System.out.println("Choose one of the journal's name or press only enter:");
		JournalManagerClass.printJournal(journalName);
	}
}
