package fileLes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileHandler {
	
	private static final String USERS = "/users";
	private static final String BYTE_FILES = "/byteFiles";
	private static final String EXIT = "exit";

	private Scanner scan;
	private String base;
	
	public FileHandler(Scanner scan, String baseDirectory) {
		this.scan = scan;
		this.base = baseDirectory;
		start();
	}
	
	private void start() {
		File directory = new File(this.base);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File usersDir = new File(this.base + USERS);
		if (!usersDir.exists()) {
			usersDir.mkdir();
		}
		File byteDir = new File(this.base + BYTE_FILES);
		if (!byteDir.exists()) {
			byteDir.mkdir();
		}
	}

	private String getFile() {
		System.out.println("Enter the file name: ");
		String name = scan.next();
		scan.nextLine();
		File file = new File(this.base+"/"+name+".txt");
		if(file.exists()) {
			System.out.println("File found!");
//		call the method that writes to the file
			return file.getAbsolutePath();
		} else {
			System.out.println("File doesn't exists!");
			return "";
		}
	}
	
	public void writeToFile() {
//		ask the user the file name
		String path = getFile();
		if(path.isBlank()) {
			return;
		}
		File file = new File(path);
		writeToFile(file);
	}
	
	private void writeToFile(File file) {
		// write to file
		try(FileWriter writer = new FileWriter(file, true)){
			String line = "";
			System.out.println("Please enter your lines: (enter 'exit' to stop)");
			while(true) {
				System.out.print("\t>");
				line = scan.nextLine();
				if(EXIT.equalsIgnoreCase(line)) {
					break;
				}
				writer.append(line);
				// same things as: +"\n"
				writer.append(System.lineSeparator());
			}
			System.out.println("Finished!");
		} catch (IOException e) {
			System.out.println("Error recived in writing to file: "+e.getMessage());
		}
	}

	public void newFile() {
// ask the user the file name
		System.out.println("Enter the file name: ");
		String name = scan.next();
		scan.nextLine();
		File file = new File(this.base+"/"+name+".txt");
// create the file with an extention (.txt)
		try {
			if(file.createNewFile()) {
				System.out.println("File created!");
//	start typing in the file
				writeToFile(file);
			} else {
				System.out.println("File already exists!");
			}
		} catch (IOException e) {
			System.out.println("Error recived in creating a new file: "+e.getMessage());
		}
	}

	public void readFile() {
//		ask the user the file name
		String path = getFile();
		if(path.isBlank()) {
			return;
		} //1441600
		File file = new File(path);
//		read the file
		long starter = System.nanoTime();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			StringBuilder strb = new StringBuilder(); // not a must, and when dealing with a small amount of lines (under few thousand)  
			String line = "";
			while((line = reader.readLine()) != null) {
				strb.append(System.lineSeparator());
				strb.append(line);
			} 
			
			System.out.println("Time:" +(System.nanoTime() - starter));
			System.out.println("The file contained:\n"+strb.toString()+"\tFinished!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newUser() {
		// name+time(hours and minutes)+.ser
		try{
			System.out.println("Lets start with some data...");
// ask from user all the User details and create a User obj
			System.out.print("Enter the name: ");
			String name = scan.next();
			scan.nextLine();
			System.out.print("Enter the age: ");
			int age = scan.nextInt();
			scan.nextLine();
			System.out.print("Enter the email: ");
			String email = scan.next();
			scan.nextLine();
			
			// Creating the user
			User user = new User(name, email, age);

			// Creating the file
			String myTime = createTime();
			String filePath = base+USERS+"/"+name+"."+myTime+".ser";
			File userFile = new File(filePath);
			userFile.createNewFile();
			
// save it into a file
			try(FileOutputStream fileOutStream = new FileOutputStream(userFile);
				ObjectOutputStream outStream = new ObjectOutputStream(fileOutStream)){
				outStream.writeObject(user);
			}
		} catch (InputMismatchException e) {
			System.err.println("Age isn't a number!");
			return;
		} catch (IOException e) {
			System.err.println("Error while saving a user: "+e.getMessage());
		}
	}

	private String createTime() {
		LocalTime time = LocalTime.now();
		String[] parts = time.toString().split(":");
		return parts[0]+"."+parts[1];
	}

	public void findUser() {
		System.out.println("User name?");
		String name = scan.next();
		scan.nextLine();
		this.findUser(name);
	}
	
	public void findUser(String name) {
		// look the file
		File file = new File(base + USERS);
		for (String str:file.list()) {
			// By splitiing the string
	//			parts = str.split("\\.");
			
			// By taking the needed substring
			String nameFromFile = str.substring(0, name.length());
			
			if(nameFromFile.equals(name)) {
				System.out.println("Found user!");
				printUser(new File(file, name));
			}
		}
		System.out.println("Couln't find user!");
	}
	
	private void printUser(File userFile) {
		try(FileInputStream fileInStream = new FileInputStream(userFile);
			ObjectInputStream inStream = new ObjectInputStream(fileInStream)){
			User user = (User) inStream.readObject();
			System.out.println(user);
			return;
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error while finding a user: "+e.getMessage());
			return;
		}
	}

	public void allUsers() {
		System.out.println("You want all users or all names? ('users' || 'names'");
		String answer = scan.next();
		scan.nextLine();
		if(answer.equalsIgnoreCase("users")) {
			File file = new File(base + USERS);
			for (String str:file.list()) {
				printUser(new File(file, str));
			}
		} else {
			File file = new File(base + USERS);
			ArrayList<String> names = new ArrayList<String>();
			for (String str:file.list()) {
				String[] parts = str.split("\\.");
				names.add(parts[0]);
			}
			System.out.println(names);
		}
	}

	public void toByteStream() {
		try {
			// to find a wanted file (with name)
			System.out.println("Enter the name of the file you want to convert: ");
			String name = scan.next();
			scan.nextLine();
			File textFile = new File(this.base+"/"+name+".txt");
			if(!textFile.isFile()) {
				System.out.println("File not found!");
				return;
			}
			File byteFile = new File(this.base+BYTE_FILES+"/"+name+".byte");
			byteFile.createNewFile();
			try (FileInputStream fis = new FileInputStream(textFile);
				FileOutputStream fos = new FileOutputStream(byteFile)){
				
				// we can use the build in buffer classes or create one ourself
				byte[] buffer = new byte[1024];
				int count;
				while((count = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, count);
				}
				System.out.println("Finished!");
			}
		} catch (IOException e) {
			System.err.println("Error while converting into a byte file: "+e.getMessage());
		}
	}

	public void fromByteStream() {
		// to find a wanted file (by name)
		System.out.println("Enter the name of the file you want to read: ");
		String name = scan.next();
		scan.nextLine();
		File byteFile = new File(this.base+BYTE_FILES+"/"+name+".byte");
		if(!byteFile.isFile()) {
			System.out.println("File not found!");
			return;
		}
		// print the file (as text)
		try(FileInputStream fis = new FileInputStream(byteFile)){
			byte[] data = fis.readAllBytes();
			String text = new String(data);
			System.out.println("Content of the file name "+name+":\n"+text);
		} catch (IOException e) {
			System.err.println("Error while converting from a byte file: "+e.getMessage());
		}
	}
}
