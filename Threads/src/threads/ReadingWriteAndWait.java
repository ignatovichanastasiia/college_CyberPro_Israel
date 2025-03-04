package threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class ReadingWriteAndWait {
	private final static File DIRECT = new File("threadsProj");
	private final static File FILE = new File(DIRECT, "notebook.txt");
	private final static int THREADS_QUANTITY = 3;
	private static int counter;
	private static ReentrantLock lock;

	public static void threadsStarter() {
		counter = 0;
		lock = new ReentrantLock();
		for (int x = 0; x < THREADS_QUANTITY; x++) {
			Thread thr = new Thread(new Runnable() {
				@Override
				public void run() {
					doing();
				}
			});
			thr.start();
		}
	}

	public static void doing() {
		try {
			if (!DIRECT.exists()) {
				DIRECT.mkdir();
			}
			if (!FILE.exists()) {
				FILE.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Creating files for righter falled: ");
			e.printStackTrace();
		}
		int i = 0;
		while (i < 6) {
			i++;
			int random = (int) (Math.random() * 4) + 1;

			switch (random) {
			case 1:
				System.out.println("It's random-num 1(write) for " + Thread.currentThread().getName());
				lock.lock();
				try (Writer writer = new FileWriter(FILE)) {
					String next = getText(++counter);
					System.out.println("Next line writing is: "+next+"\n");
					writer.append(next);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					lock.unlock();
				}
				lock.unlock();
				break;
			case 2:
				System.out.println("It's random-num 2(read) for " + Thread.currentThread().getName());
				lock.lock();
				try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                System.out.println("\n"+line+"\n\n"); 
		            }
				} catch (Exception e) {
					System.out.println(e.getMessage());
					lock.unlock();
				}
				lock.unlock();
				break;
			case 3:
				System.out.println("It's random-num 3(writer) for " + Thread.currentThread().getName());
				lock.lock();
				try (Writer writer = new FileWriter(FILE)) {
					String next = getText(++counter);
					System.out.println("Next line writing is: "+next+"\n");
					writer.append(next);
					lock.unlock();
					System.out.println(Thread.currentThread().getName() + " waits");
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					lock.unlock();
				}
				break;
			case 4:
				System.out.println("It's random-num 4(check) for " + Thread.currentThread().getName());
				if(lock.isLocked()) {
					System.out.println("Now The Lock is locked");
				}else {
					System.out.println("Now The Lock isn't locked");
				}
				break;
			}
		}
	}

	public static String getText(int counter) {
		ArrayList<String> listLines = new ArrayList();
		String text = new String("""
								As fast as thou shalt wane, so fast thou grow’st\n
				In one of thine, from that which thou departest;\n
				And that fresh blood which youngly thou bestow’st,\n
				Thou mayst call thine when thou from youth convertest.\n
				Herein lives wisdom, beauty, and increase;\n
				Without this folly, age, and cold decay:\n
				If all were minded so, the times should cease\n
				And threescore year would make the world away.\n
				Let those whom nature hath not made for store,\n
				Harsh, featureless, and rude, barrenly perish:\n
				Look whom she best endow’d, she gave the more;\n
				Which bounteous gift thou shouldst in bounty cherish:\n
				She carv’d thee for her seal, and meant thereby,\n
				Thou shouldst print more, not let that copy die.
								""");
		String[] textArray = text.split("\n");
		listLines.addAll(Arrays.asList(textArray));
		if (counter > listLines.size()) {
			counter -= listLines.size();
		}
		return listLines.get(counter);
	}

}

// We want to have 3 threads, that are working together, and randomazing a
// number between 1-4,
// if its 1 adding a line, if its 2 reading and if its 3 adding lines and
// waiting and 4, check if its looked if it is return if not add a line.

// we want to be updated each time a thread is doing something, and print out
// special mesaage when we wait on a lock.
