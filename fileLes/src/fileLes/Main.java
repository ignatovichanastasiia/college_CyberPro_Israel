package fileLes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static File journalRootDir = new File("Journals"); // Main directory for journals

	public static void main(String[] args) {
		// Ensure the "Journals" root directory exists
		if (!journalRootDir.exists()) {
			journalRootDir.mkdir();
		}

		while (true) {
			showMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character after the integer input

			switch (choice) {
			case 1:
				createNewJournal();
				break;
			case 2:
				createNewFileInJournal();
				break;
			case 3:
				editExistingFile();
				break;
			case 4:
				deleteFile();
				break;
			case 5:
				readFileOrJournal();
				break;
			case 6:
				exportEntry();
				break;
			case 7:
				System.out.println("Exiting application...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	// Show the main menu
	private static void showMenu() {
		System.out.println("\nJournal Application Menu:");
		System.out.println("1. Create a new journal");
		System.out.println("2. Create a new file in an existing journal");
		System.out.println("3. Edit an existing file");
		System.out.println("4. Delete an existing file");
		System.out.println("5. Read a file or journal");
		System.out.println("6. Export an entry (Serialization)");
		System.out.println("7. Exit");
		System.out.print("Enter your choice: ");
	}

	// Create a new journal folder
	private static void createNewJournal() {
		System.out.print("Enter the name of the new journal: ");
		String journalName = scanner.nextLine();
		File journalDir = new File(journalRootDir, journalName);

		if (journalDir.exists()) {
			System.out.println("Journal already exists.");
		} else {
			journalDir.mkdir();
			System.out.println("Journal '" + journalName + "' created successfully.");
		}
	}

	// Create a new file in an existing journal
	private static void createNewFileInJournal() {
		//Проверяет есть ли какие-нибудь папки в единой рабочей папке Жорнал
		File[] journals = journalRootDir.listFiles(File::isDirectory);
		if (journals == null || journals.length == 0) {
			System.out.println("No journals available. Please create one first.");
			return;
		}
		//выводим все журналы
		System.out.println("Available journals:");
		for (int i = 0; i < journals.length; i++) {
			System.out.println((i + 1) + ". " + journals[i].getName());
		}
		//выбираем нужный
		System.out.print("Select a journal: ");
		int journalIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character
		//проверка
		if (journalIndex < 0 || journalIndex >= journals.length) {
			System.out.println("Invalid journal selection.");
			return;
		}
		// выбираем имя файлу, создаем
		File selectedJournal = journals[journalIndex];
		System.out.print("Enter the name of the new file: ");
		String fileName = scanner.nextLine();
		File newFile = new File(selectedJournal, fileName);
		// проверка существования
		if (newFile.exists()) {
			System.out.println("File already exists.");
		} else {
			try {
				//создаем
				newFile.createNewFile();
				System.out.println("File '" + fileName + "' created successfully.");
			} catch (IOException e) {
				System.out.println("Error creating file.");
			}
		}
	}

	// Edit an existing file (append)
	private static void editExistingFile() {
		//перебор директорий
		File[] journals = journalRootDir.listFiles(File::isDirectory);
		if (journals == null || journals.length == 0) {
			System.out.println("No journals available.");
			return;
		}

		System.out.println("Available journals:");
		for (int i = 0; i < journals.length; i++) {
			System.out.println((i + 1) + ". " + journals[i].getName());
		}

		System.out.print("Select a journal: ");
		int journalIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character

		if (journalIndex < 0 || journalIndex >= journals.length) {
			System.out.println("Invalid journal selection.");
			return;
		}
		//выбираем директорию, перебираем файлы
		File selectedJournal = journals[journalIndex];
		File[] files = selectedJournal.listFiles(File::isFile);

		if (files == null || files.length == 0) {
			System.out.println("No files in this journal.");
			return;
		}
		//перебор файлов
		System.out.println("Available files:");
		for (int i = 0; i < files.length; i++) {
			System.out.println((i + 1) + ". " + files[i].getName());
		}
		//выбор файла 
		System.out.print("Select a file to edit: ");
		int fileIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character
		//проверка ввода
		if (fileIndex < 0 || fileIndex >= files.length) {
			System.out.println("Invalid file selection.");
			return;
		}
		//добавляем информацию в файл!!!
		File selectedFile = files[fileIndex];
		System.out.print("Enter the text you want to add: ");
		String newText = scanner.nextLine();
		//true в аргументе - дозапись
		try (FileWriter writer = new FileWriter(selectedFile, true)) {
			writer.write(newText + "\n");
			System.out.println("Text added successfully.");
		} catch (IOException e) {
			System.out.println("Error editing file.");
		}
	}

	// Delete an existing file
	private static void deleteFile() {
		File[] journals = journalRootDir.listFiles(File::isDirectory);
		if (journals == null || journals.length == 0) {
			System.out.println("No journals available.");
			return;
		}

		System.out.println("Available journals:");
		for (int i = 0; i < journals.length; i++) {
			System.out.println((i + 1) + ". " + journals[i].getName());
		}

		System.out.print("Select a journal: ");
		int journalIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character

		if (journalIndex < 0 || journalIndex >= journals.length) {
			System.out.println("Invalid journal selection.");
			return;
		}

		File selectedJournal = journals[journalIndex];
		File[] files = selectedJournal.listFiles(File::isFile);

		if (files == null || files.length == 0) {
			System.out.println("No files in this journal.");
			return;
		}

		System.out.println("Available files:");
		for (int i = 0; i < files.length; i++) {
			System.out.println((i + 1) + ". " + files[i].getName());
		}

		System.out.print("Select a file to delete: ");
		int fileIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character

		if (fileIndex < 0 || fileIndex >= files.length) {
			System.out.println("Invalid file selection.");
			return;
		}

		File selectedFile = files[fileIndex];
		if (selectedFile.delete()) {
			System.out.println("File deleted successfully.");
		} else {
			System.out.println("Error deleting file.");
		}
	}

	// Read a file or journal (display all files in the journal)
	private static void readFileOrJournal() {
		File[] journals = journalRootDir.listFiles(File::isDirectory);
		if (journals == null || journals.length == 0) {
			System.out.println("No journals available.");
			return;
		}

		System.out.println("Available journals:");
		for (int i = 0; i < journals.length; i++) {
			System.out.println((i + 1) + ". " + journals[i].getName());
		}

		System.out.print("Select a journal: ");
		int journalIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character

		if (journalIndex < 0 || journalIndex >= journals.length) {
			System.out.println("Invalid journal selection.");
			return;
		}

		File selectedJournal = journals[journalIndex];
		File[] files = selectedJournal.listFiles(File::isFile);

		if (files == null || files.length == 0) {
			System.out.println("No files in this journal.");
			return;
		}

		System.out.println("Available files:");
		for (int i = 0; i < files.length; i++) {
			System.out.println((i + 1) + ". " + files[i].getName());
		}

		System.out.print("Select a file to read (or press 0 to read all files): ");
		int fileIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character

		if (fileIndex == -1) {
			for (File file : files) {
				readFile(file);
			}
		} else if (fileIndex >= 0 && fileIndex < files.length) {
			readFile(files[fileIndex]);
		} else {
			System.out.println("Invalid file selection.");
		}
	}

	// Helper method to read and display a file's content
	private static void readFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file.");
		}
	}

	// Export an entry into bytes format using Serialization
	private static void exportEntry() {
		File[] journals = journalRootDir.listFiles(File::isDirectory);
		if (journals == null || journals.length == 0) {
			System.out.println("No journals available.");
			return;
		}

		System.out.println("Available journals:");
		for (int i = 0; i < journals.length; i++) {
			System.out.println((i + 1) + ". " + journals[i].getName());
		}

		System.out.print("Select a journal: ");
		int journalIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character

		if (journalIndex < 0 || journalIndex >= journals.length) {
			System.out.println("Invalid journal selection.");
			return;
		}

		File selectedJournal = journals[journalIndex];
		File[] files = selectedJournal.listFiles(File::isFile);

		if (files == null || files.length == 0) {
			System.out.println("No files in this journal.");
			return;
		}

		System.out.println("Available files:");
		for (int i = 0; i < files.length; i++) {
			System.out.println((i + 1) + ". " + files[i].getName());
		}

		System.out.print("Select a file to export: ");
		int fileIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Consume the newline character

		if (fileIndex < 0 || fileIndex >= files.length) {
			System.out.println("Invalid file selection.");
			return;
		}
		//Serialization!!! STR
		//Нельзя сериализовать Файл - нет интерфейса, можно стрингу
		File selectedFile = files[fileIndex];
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(selectedFile.getName() + ".ser"))) {
			out.writeObject(new String(Files.readAllBytes(selectedFile.toPath())));
			System.out.println("File exported as bytes (serialization).");
		} catch (IOException e) {
			System.out.println("Error exporting file.");
		}
	}
}
