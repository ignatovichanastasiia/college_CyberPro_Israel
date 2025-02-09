package journalManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class JournalManagerClass {

	/*
	 * The program without an interface for working with files and folders. 
	 * Files are represented by serialized Entry classes, folders can be serialized by 
	 * specifying the path to the save location, and then the folder structure can be restored.
	 * 
	 */

	private static File rootDirectory; // directory - for start working in

	public static String getPathRootDirectory() {
		return rootDirectory.getPath();
	}
	
	public static File getRootDirectoryFile() {
		return rootDirectory;
	}

	// Start directory
	public static void startRootDirectory() {
		File rootFile = new File("journals");
		if (!rootFile.exists()) {
			rootFile.mkdir();
		}
		JournalManagerClass.rootDirectory = rootFile;
	}

	// Create a new journal folder
	public static void createJournal(String journalName) {
		// proof of root exists
		if (!rootDirectory.exists()) {
			startRootDirectory();
		}
		File journal = new File(rootDirectory, journalName);
		// proof of user's is not exists
		if (journal.exists()) {
			System.out.println("Journal already exists.");
		} else {
			journal.mkdir();
			System.out.println("Journal " + journalName + " created");
		}
	}

	// Delete an existing file
	public static void deleteJournal(String journalName) {
		if (!rootDirectory.exists()) {
			System.out.println("No journals available.");
			return;
		}
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

	//create entry-serial-file
	public static void createEntry(String journalName, String entryName, String content) {
		if (!rootDirectory.exists()) {
			startRootDirectory();
		}
		File userJournal = new File("" + rootDirectory + "/" + journalName);
		File newUserFile = new File("" + rootDirectory + "/" + journalName + "/" + entryName + ".ser");
		// create user's entry
		Entry entry = new Entry(entryName, content);
		// user's directory
		try {
			if (!userJournal.exists()) {
				createJournal(journalName);
				System.out.println("Created journal with name " + journalName);
			}
			newUserFile.createNewFile();
			System.out.println("Created new fail for serialization " + newUserFile.getName());
		} catch (IOException e) {
			System.out.println("We have some problem with creating fales: " + e.getMessage());
			return;
		}
		// serialization user's file
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(newUserFile.getPath()))) {
			out.writeObject(entry);
			System.out.println("Object was serialization on file " + newUserFile.getPath());
		} catch (IOException e) {
			System.out.println("We have a problem with serialization: " + e.getMessage());
			return;
		}
		System.out.println("All done!");
	}

	//delete serializated file
	public static void deleteEntry(String journalName, String entryName) {
		File userFile = new File(journalName + "/" + entryName + ".ser");
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

	//print deserializated file
	public static void printEntry(String journalName, String entryName) {
		File userFile = new File(journalName + "/" + entryName + ".ser");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(userFile.getPath()))) {
			Entry deserializedEntry = (Entry) in.readObject();
			System.out.println("Entry was serialized: " + deserializedEntry.getEntryName());
			System.out.println(deserializedEntry.toString());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("We have troble with serialization: " + e.getMessage());
		}
	}

	//print structure from users file
	public static void printJournal(String journalName) {
		if (!rootDirectory.exists()) {
			System.out.println("No journals available.");
			return;
		}
		File userJournal = new File(journalName);
		if (userJournal.exists()) {
			File[] files = userJournal.listFiles();
			System.out.println("Journal " + userJournal.getName());
			if (files == null || files.length == 0) {
				System.out.println("No journals and files inside of " + userJournal.getName() + " is available");
				return;
			}
			System.out.println("Inside: ");
			for (int x = 0; x < files.length; x++) {
				if (files[x].isFile()) {
					System.out.println("File: " + files[x].getName() + "/n");
				} else {
					System.out.println("Directory: " + files[x].getName() + "/n");
				}
			}
		}
	}

	//save String-journalinfo-file to user's directory by filePath
	public static void saveJournalAsBytes(String journalName, String filePath) {
		File userDirectory = new File(filePath);
		if (!userDirectory.exists()) {
			createJournal(journalName);
		}
		File userJournalForSerialization = new File(journalName);
		String fileForSerialization = "";
		if (userJournalForSerialization.exists()) {
			fileForSerialization = journalToString(userJournalForSerialization);
		} else {
			System.out.println("Journal is not exists.");
			return;
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath+"/"+journalName+".ser"))) {
			if (!fileForSerialization.isBlank()) {
				out.writeObject(fileForSerialization);
				System.out.println("Object was serialization on file " + filePath);
			} else {
				System.out.println("File for serialization is empty");
			}
		} catch (IOException e) {
			System.out.println("We have a problem with serialization: " + e.getMessage());
			return;
		}

	}

	//print info about saved journal with inserts and asks about recreate journals
	public static void loadJournalFromBytes(String filePath, String journalName) {
		String deserializedFile = "";
		File userDirectory = new File(filePath);
		File fileForDeserialization = new File(journalName);
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath+"/"+journalName+".ser"))) {
			deserializedFile = (String) in.readObject();
            System.out.println("Object was deserialized:/n" + deserializedFile+"/nRestore folder contents? Y/N");
            try(Scanner sc = new Scanner(System.in)){
            	if(sc.nextLine().trim().equalsIgnoreCase("y")) {
            		journalFromString(deserializedFile);
            		System.out.println("All done!");
            	}else {
            		System.out.println("Your data remains unchanged");
            	}
            }
		} catch (IOException e) {
			System.out.println("We have problem with deserialization: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("We have problem with class-cast: "+e.getMessage());
		}

	}

	//put in String information about journal for saving 
	private static String journalToString(File journal) {
		String forPrint = "";
		if (journal.exists()) {
			File[] files = journal.listFiles();
			forPrint = "Journal " + journal.getName();
			if (files == null || files.length == 0) {
				forPrint += "/nNothing inside of " + journal.getName();
			}
			forPrint += "/nInside the journal:/n";
			for (int x = 0; x < files.length; x++) {
				if (files[x].isFile()) {
					forPrint += "File: " + files[x].getName() + "/n";
				} else {
					forPrint += "Directory: " + files[x].getName() + "/n";
				}
			}
		}
		return forPrint;
	}
	
	//proofs and recreate journals from info-file
	private static void journalFromString(String journal) {
		String[] files = journal.split("/n");
		String[] journalNamePath = files[0].split(" ");
		String userJournalName = journalNamePath[1];
		File userJournal = new File(userJournalName);
		createJournal(userJournalName);
		if(files[1].trim().startsWith("Inside")) {
			for(int x=2;x<files.length;x++) {
				if(files[x].startsWith("Directory")) {
					String insertNamePath[] = files[x].split(":");
					File userInsertJournal = new File(userJournal,insertNamePath[1].trim());
					createJournal(userInsertJournal.getPath());
				}
			}
		}
		System.out.println("All directories on there places");
	}
	

//	class Entry implements Serializable { //don't work with static class 
//
//		private String entryName;
//		private String content;
//
//		public Entry(String entryName, String content) {
//			this.entryName = entryName;
//			this.content = content;
//		}
//
//		public String getEntryName() {
//			return entryName;
//		}
//
//		public void setEntryName(String entryName) {
//			this.entryName = entryName;
//		}
//
//		public String getContent() {
//			return content;
//		}
//
//		public void setContent(String content) {
//			this.content = content;
//		}
//
//	}
}
