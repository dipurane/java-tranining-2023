import java.io.IOException;

public class TranscationManager {

	public void validateATMPin() throws BankTransactionException {
		System.out.println("Line1 of validateATMPin");
		System.out.println("Line2 of validateATMPin");
		System.out.println("Line3 of validateATMPin");
		validateBalance();
		System.out.println("Line4 of validateATMPin");
		System.out.println("Line5 of validateATMPin");
	}
	
	public void validateBalance() throws BankTransactionException {
	
		System.out.println("Line1 of validateBalance");
		System.out.println("Line2 of validateBalance");
		System.out.println("Line3 of validateBalance");
		doTransaction();
		System.out.println("Line4 of validateBalance");
		System.out.println("Line5 of validateBalance");
	}
	
	public void doTransaction() throws BankTransactionException {
		System.out.println("Line1 of doTransaction");
		System.out.println("Line2 of doTransaction");
		System.out.println("Line3 of doTransaction");
		try {
		int a = 10;
		a = a/1;
		}catch(Exception e) {
			// entry in log file
			System.out.println("Number cant be zero in denomnetor");
			throw new  BankTransactionException("Wrong Input Entred");
		}
		System.out.println("Line4 of doTransaction");
		System.out.println("Line5 of doTransaction");
	}
}
