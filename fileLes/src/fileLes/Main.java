package fileLes;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static final String WRITE = "write";
	private static final String READ = "read";
	private static final String NEW_FILE = "new";
	private static final String TO_BYTE_STREAM = "to byte";
	private static final String FROM_BYTE_STREAM = "from byte";
	private static final String NEW_USER = "new user";
	private static final String FIND_USER = "find user";
	private static final String ALL_USERS = "all users";
	private static final String EXIT = "exit";
	
	private static final String BASE_DIRECTORY = "src/base/AllFiles";
	
	private static FileHandler fileHanlder;

	public static void main(String[] args) throws IOException {
		System.out.println("Starting file handler...\n"+".".repeat(100)+"\n");
		String answer = "";
		try (Scanner scan = new Scanner(System.in)){
			fileHanlder = new FileHandler(scan, BASE_DIRECTORY);
			boolean running = true;
			while(running) {
				printOpt();
				answer = scan.nextLine().toLowerCase();
				switch(answer) {
					case WRITE: 
						fileHanlder.writeToFile();
						break;
					case NEW_FILE: 
						fileHanlder.newFile();
						break;
					case READ: 
						fileHanlder.readFile();
						break;
					case NEW_USER: 
						fileHanlder.newUser();
						break;
					case FIND_USER: 
						fileHanlder.findUser();
						break;
					case ALL_USERS: 
						fileHanlder.allUsers();
						break;
					case TO_BYTE_STREAM: 
						fileHanlder.toByteStream();
						break;
					case FROM_BYTE_STREAM: 
						fileHanlder.fromByteStream();
						break;
					case EXIT:
						running = false;
						continue;
					case "else":
						File newFile = new File("src/base/AllFiles/users/ddd.19:51:58.184155300.ser");
						newFile.createNewFile();
					default:
						System.out.println("Couldn't read that, try again?");
						continue;
				}
			}
			System.out.println("Goodbye!");
		}
	}

	private static void printOpt() {
		System.out.println("""
				Please choose your action:
				\tNew Entry? -new-
				\tWrite in exsiting file? -write-
				\tRead a file? -read-
				\tNew User? -new user-
				\tFind user? -find user-
				\tAll users? -all users-
				\tConvert to bytes -find user-
				\tConvert from bytes -all users-
				\tAll done? -exit-
				""");
	}
}
