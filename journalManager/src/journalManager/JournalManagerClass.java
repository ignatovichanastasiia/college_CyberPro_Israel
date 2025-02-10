package journalManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JournalManagerClass {

	/*
	 * The program without an interface for working with files and folders. Files
	 * are represented by serialized Entry classes, folders can be serialized by
	 * specifying the path to the save location, and then the folder structure can
	 * be restored.
	 * 
	 */

	private static File rootDirectory = new File("journals"); // directory - for start working in

	public static String getPathRootDirectory() {
		return rootDirectory.getPath();
	}

	/*
	 * (Create a new journal folder - ОК) The method takes the directory name as an
	 * argument, creates this directory in the parent folder.
	 */
	public static void createJournal(String journalName) {
		File journal = new File(rootDirectory, journalName);
		// proof of user's is not exists
		if (journal.exists()) {
			System.out.println("Journal already exists.");
		} else {
			journal.mkdir();
			System.out.println("Journal " + journalName + " created");
		}
	}

	/*
	 * (Delete an existing file - ОК) The method takes the directory name as an
	 * argument, collects all files into a list, and deletes the specified one.
	 */
	public static void deleteJournal(String journalName) {
		File[] journals = rootDirectory.listFiles(File::isDirectory);
		if (journals == null || journals.length == 0) {
			System.out.println("No journals available.");
			return;
		}

		for (int x = 0; x < journals.length; x++) {
			if (journals[x].getName().equals(journalName)) {
				journals[x].delete();
				System.out.println("Journal " + journalName + " deleted");
				return;
			}
		}
	}

	/*
	 * (create entry-ser-file - OK) The method takes the data for creating an
	 * `Entry` class object and the folder name where the serialized object should
	 * be placed. The method creates the user's folder if it doesn't exist in the
	 * parent folder, creates an object for serialization, and serializes it into
	 * the folder.
	 * 
	 */
	public static void createEntry(String journalName, String entryName, String content) {
		File userJournal = new File(rootDirectory, journalName);
		File newUserFile = new File(userJournal, entryName + ".ser");
		// create user's entry
		Entry entry = new Entry(entryName, content);
		// user's directory
		try {
			if (!userJournal.exists()) {
				createJournal(journalName);
			}
			if (!newUserFile.exists()) {
				boolean created = newUserFile.createNewFile();
				if (created) {
					System.out.println("Created new file for serialization: " + newUserFile.getName());
				} else {
					System.out.println("File already exists: " + newUserFile.getName());
				}
			}
		} catch (IOException e) {
			System.out.println("We have some problem with creating files: " + e.getMessage());
			return;
		}
		// serialization user's file
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(newUserFile))) {
			out.writeObject(entry);
			System.out.println("Object was serialized into file: " + newUserFile.getPath());
		} catch (IOException e) {
			System.out.println("We have a problem with serialization: " + e.getMessage());
			return;
		}
		System.out.println("All done!");
	}

	/*
	 * (delete ser-file - OK) The method takes the file and folder names as
	 * arguments, finds the specified file in the specified folder, and deletes the
	 * file using methods from the `File` class.
	 */
	public static void deleteEntry(String journalName, String entryName) {
		File userFile = new File("" + rootDirectory.getPath() + "/" + journalName + "/" + entryName + ".ser");
		if (userFile.exists()) {
			if (userFile.delete()) {
				System.out.println("File " + userFile.getName() + " deleted");
			} else {
				System.out.println("File is not deleted");
			}
		} else {
			System.out.println("No files available.");
		}

	}

	/*
	 * (take all files on map - OK) The method collects all folders and their files
	 * into a `Map`, with the folder names (non-absolute path) as keys, and the list
	 * of files as values.
	 */
	public static Map<String, String[]> collectFiles() {
		Map<String, String[]> fileMap = new HashMap<>();
		if (rootDirectory.exists()) {
			File[] subDirs = rootDirectory.listFiles();
			if (subDirs != null) {
				for (File subDir : subDirs) {
					if (subDir.isDirectory()) {
						String[] files = subDir.list((dir, name) -> new File(dir, name).isFile());
						fileMap.put(subDir.getPath(), files);
					}
				}
			}
		}
		return fileMap;
	}

	/*
	 * (print deserializes file - OK) The method takes the folder name containing
	 * the file and the file name as arguments, then deserializes the required Entry
	 * object and prints it using the toString utility method.
	 */
	public static void printEntry(String journalName, String entryName) {
		File userDir = new File(rootDirectory, journalName);
		File userFile = new File(userDir, entryName + ".ser");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(userFile.getPath()))) {
			Entry deserializedEntry = (Entry) in.readObject();
			System.out.println("Entry was deserialized: " + deserializedEntry.getEntryName());
			System.out.println(deserializedEntry.toString());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("We have troble with deserialization: " + e.getMessage());
		}
	}

	/*
	 * (print structure from users dir - OK) The method takes the folder name as an
	 * argument to print the folder and the names of the contained files.
	 */
	public static void printJournal(String journalName) {
		if (!rootDirectory.exists()) {
			System.out.println("No journals available.");
			return;
		}
		Map<String, String[]> fileMap = new HashMap<>(collectFiles());
		for (Map.Entry<String, String[]> entry : fileMap.entrySet()) {
			if (entry.getKey().contains(journalName)) {
				System.out.println("Directory: " + entry.getKey());
				for (String file : entry.getValue()) {
					System.out.println("  File: " + file);
				}
			}
		}
	}

	/*
	 * The method uses the Map from the collectFiles method to print the names of
	 * all existing files and folders. OK
	 */
	public static void printAllJournal() {
		if (!rootDirectory.exists()) {
			System.out.println("No journals available.");
			return;
		}
		Map<String, String[]> fileMap = new HashMap<>(collectFiles());
		for (Map.Entry<String, String[]> entry : fileMap.entrySet()) {
			System.out.println("Directory: " + entry.getKey());
			for (String file : entry.getValue()) {
				System.out.println("  File: " + file);
			}
		}
	}

	/*
	 * The method delete all files in parent directory - TODO
	 */
	public static void deleteAllJournals() {
		if (!rootDirectory.exists()) {
			System.out.println("No journals available.");
			return;
		}
		Map<String, String[]> fileMap = new HashMap<>(collectFiles());
		for (Map.Entry<String, String[]> entry : fileMap.entrySet()) {
			for (String file : entry.getValue()) {
				System.out.println("File: " + file + " - deleting...");
				File deleteFail = new File(file);
				deleteFail.delete();
			}
		}
		for (Map.Entry<String, String[]> entry : fileMap.entrySet()) {
			System.out.println("Directory: " + entry.getKey() + " - deleting...");
			File deleteDir = new File(entry.getKey());
			deleteDir.delete();
		}
	}

	/*
	 * save Map-journalinfo-file to user's directory by filePath
	 */
	public static void saveJournalAsBytes(String journalName, String filePath) {
		File userJournalForSerialization = new File(rootDirectory, journalName + ".ser");
		File userJournalForSaving = new File(filePath);
		if (!userJournalForSerialization.exists()) {
			System.out.println("Journal for saving is not exist");
			return;
		}
		if (!userJournalForSaving.exists()) {
			System.out.println("Place for saving is not exist");
			return;
		}
		Map<String, String[]> fileMapForSerialization = new HashMap<>();
		File[] subDirs = userJournalForSerialization.listFiles();
		if (subDirs != null) {
			for (File subDir : subDirs) {
				if (subDir.isDirectory()) {
					String[] files = subDir.list((dir, name) -> new File(dir, name).isFile());
					fileMapForSerialization.put(subDir.getPath(), files);
				}
			}
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userJournalForSaving.getPath()))) {
			out.writeObject(fileMapForSerialization);
			System.out.println("Object was serialization on file " + userJournalForSaving.getPath());
		} catch (IOException e) {
			System.out.println("We have a problem with serialization: " + e.getMessage());
			return;
		}

	}

	public static String getPathOfDirectoryByName(String dirName) {
		File userFile = new File(rootDirectory, dirName);
		return userFile.getPath();
	}

	/*
	 * (print info about saved journals with inserts and asks about recreate
	 * journals)
	 */
	public static void loadJournalFromBytes(String journalName, String filePath) {
		File deserializationUserFile = new File(filePath, journalName);
		Map<String, String[]> fileMapDeserialization = new HashMap<>();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(deserializationUserFile.getPath()))) {
			fileMapDeserialization = (HashMap) in.readObject();
			System.out.println("Object was deserialized. Restore folder contents? Y/N");
			try (Scanner sc = new Scanner(System.in)) {
				if (sc.nextLine().trim().equalsIgnoreCase("y")) {
					journalsFromMap(fileMapDeserialization);
					System.out.println("All done!");
				} else {
					System.out.println("Your data remains unchanged");
				}
			}
		} catch (IOException e) {
			System.out.println("We have problem with deserialization: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("We have problem with class-cast: " + e.getMessage());
		}

	}

	/*
	 * (proofs and recreate journals from info-file)
	 * 
	 */
	private static void journalsFromMap(Map allJournals) {
		Map<String, String[]> journals = new HashMap<>(allJournals);
		for (Map.Entry<String, String[]> entry : journals.entrySet()) {
			createJournal(entry.getKey());
			for (String file : entry.getValue()) {
				File proofFile = new File(file);
				if (!proofFile.exists()) {
					System.out.println("There is no file " + file + " in " + entry.getKey());
				}
			}
		}
		System.out.println("All directories on there places");
	}
}
