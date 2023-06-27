
public class Entry {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Ping());
		t1.start();
		
		
		
		Thread t2 = new Thread(new Pong());
		t2.start();
		
		int a =0;
		while(true) {
			a ++;
			if(a==50000)
				t1.join();
			System.out.println("This is main thread");
		}
	}
}
