
public class Entry {

	
	public static void main(String[] args)   {
		
		System.out.println("Lin1 of Entry");
		System.out.println("Lin2 of Entry");
		System.out.println("Lin3 of Entry");
		TranscationManager manager = new TranscationManager();
		try {
			manager.validateATMPin();
			System.out.println("Lin4 of Entry");
			System.out.println("Lin5 of Entry");
			System.out.println("Please collect money and enjoy");
			// ATM machine will dispatch money
		} catch (BankTransactionException e) {
			System.out.println("Our Servers are facing issues please visit other ATM");
			// TODO Auto-generated catch block
		}
		
		
	}
}
