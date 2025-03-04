package threads;

public class NumberPrinter extends Thread{
	@Override
    public void run() {
		for(int i = 1; i<11;i++) {
        System.out.println(this.getName()+" -> "+i);
		}
    }
}


