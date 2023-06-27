import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Entry {

	public static void main(String[] args) {
		
		Student s1 = new Student(1, "dipesh", 80.5f);
		Student s2 = new Student(2, "MSD", 50.5f);
		Student s3= new Student(3, "Virat", 82.15f);
		Student s4 = new Student(4, "Rohit", 36.66f);
		
		Map<Integer, Student> studentMap = new LinkedHashMap<Integer, Student>();
		
		Map<Student,Float> playerMap = new HashMap<Student, Float>();
		
		studentMap.put(4, s4);
		studentMap.put(1, s1);
		studentMap.put(2, s2);
		studentMap.put(3, s3);
		
		
		Student s = studentMap.get(3);
		s.setMarks(56.35f);
		studentMap.put(3, s);
		
		
		Student st1 = new Student(5, "Surya", 77.5f);
		studentMap.put(3, st1);
	
		//System.out.println(s);
		
		/*for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
			Integer key = entry.getKey();
			Student val = entry.getValue();
			
		}*/
		for (Integer key : studentMap.keySet()) {
			Student st = studentMap.get(key);
			System.out.println(st);
		}
		
		System.out.println("$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		playerMap.put(new Student(1, "dipesh", 80.5f), 555.5f);
		playerMap.put(new Student(2, "MSD", 50.5f), 9999.54f);
		playerMap.put(new Student(3, "Virat", 82.15f), 124125.54f);
		playerMap.put(new Student(4, "Rohit", 36.66f), 353534.54f);
		playerMap.put(new Student(2, "MSd", 50.5f), 343.5f);
		
		for (Student key : playerMap.keySet()) {
		
			System.out.println( " Fees for "+ key.getName() + " "+  playerMap.get(key));
		}
	
		System.out.println("$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		Set<Student> studentSet = new LinkedHashSet<Student>();
		studentSet.add(new Student(1, "dipesh", 80.5f));
		studentSet.add(new Student(2, "MSD", 50.5f));
		studentSet.add(new Student(3, "Virat", 82.15f));
		studentSet.add(new Student(4, "Rohit", 36.66f));
		studentSet.add(new Student(2, "MSd", 50.5f));
		
		for (Student student : studentSet) {
			System.out.println(student);
		}
		
		
	}
}
