
public class Entry {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Line 1 of Main");
		System.out.println("Line 2 of Main");
		System.out.println("Line 3 of Main");
		System.out.println("Line 4 of Main");
		DollorPrintTask task = new DollorPrintTask();
		Thread t1 = new Thread(task);
		t1.start();
		
		EuroPrintingTask etask = new EuroPrintingTask();
		Thread t2 = new Thread(etask);
		t2.start();
		
		int a = 0;
		while(true) {
			Thread.sleep(500);
			System.out.println("#######Excecuting main forever");
		  // a++;
			if(a==15)
				break;
		}
	}
}
