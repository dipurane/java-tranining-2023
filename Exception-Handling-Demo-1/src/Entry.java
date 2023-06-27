import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Entry {

	public static void main(String[] args) {
		
		int a = 20;
		int b = 10;
		FileOutputStream fos = null;
		File f = new File("data.txt");
		try {
			System.out.println("Line 1");
			System.out.println("Line 2");
			f.createNewFile();
			fos = new FileOutputStream(f);
			System.out.println(a/b);
			String number = "1";
			System.out.println("Line 3");
			System.out.println("Line 4");
			int i = Integer.parseInt(number);
			String fileName = null;
			if(fileName!=null) {
			 File f2 = new File(fileName);
			}else {
				return;
			}
			System.out.println("Integer value is " + i);
			System.out.println("Line 5");
			System.out.println("Line 6");
			System.out.println("Line 7");
			
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ArithmeticException are) {
			
			System.out.println("You cant have zero as denomnator");
		}catch(NumberFormatException nfe) {
			System.out.println("You cant convert text into numbers");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong please reach out to our teach team");
		}finally {
			System.out.println("This is finally block");
		}
		
		try {
			System.out.println("Something");
		//	FileOutputStream fos2 = new FileOutputStream(new File(""));
		} finally {
			System.out.println("Finllay without catch");
		}
		
		
		System.out.println("Entry Function over");
		
		
		
		
	}
}
