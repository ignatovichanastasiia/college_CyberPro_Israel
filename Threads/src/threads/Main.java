package threads;

public class Main {
	public static void main(String[] args) {
//		for (int i = 1; i < 6; i++) {
//			NumberPrinter thread = new NumberPrinter();
//			thread.start();
//		}
//
//		for (int y = 1; y < 6; y++) {
//			Thread thr = new Thread(new PriorityPrinter());
//			thr.setPriority(y*2);
//			thr.start();
//		}
		ReadingWriteAndWait.threadsStarter();
	}

}
