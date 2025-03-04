package threads;

public class PriorityPrinter implements Runnable{

	@Override
	public void run() {
		for(int x = 1; x <51; x++) {
			if(x%Thread.currentThread().getPriority()==0) {
				System.out.println(Thread.currentThread().getPriority()+" - prior: "+x+" % "+Thread.currentThread().getPriority());
			}
		}
		
	}
	

}
