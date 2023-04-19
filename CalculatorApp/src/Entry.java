import java.io.IOException;

public class Entry {

	public static void main(String[] args) throws IOException {
	
		System.out.println("Please Enter first number");
		int number1 =BasicInput.readInteger();
		
		System.out.println("Please Enter Second number");
		int number2 =BasicInput.readInteger();
		
		Maths m = new Maths();
		
	    m.add(number1, number2);
	    
	    m.multiply(number1, number2);
		
	}
}
