
public class EuroPrintingTask extends Thread {

	int a = 0;


	@Override
	public void run() {
		while (true) {
			System.out.println("This is printing @@@@@@@@@@@@@@@@@@@@@@@@");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//a++;
			if (a == 15)
				break;
		}
	}
}
