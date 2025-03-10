package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsService {

	public static void justDoing() throws InterruptedException {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("It's just a message");
			}
		};
		try {
			ExecutorService executor = Executors.newCachedThreadPool();
			for (int i = 0; i < 5; i++) {
				executor.submit(run);
			}
			executor.awaitTermination(300, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.getMessage();
		}

	}
}
