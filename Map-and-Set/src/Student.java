import java.util.Objects;

public class Student {

	private int roll;
	
	private String name;
	
	private float marks;

	
	
	public Student(int roll, String name, float marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		
		
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}


	@Override
	public int hashCode() {
		//return Objects.hash(name.toLowerCase(), roll);
		return this.roll* 312;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		//return Objects.equals(name, other.name) && roll == other.roll;
		return name.equalsIgnoreCase(other.name) && roll == other.roll;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [roll=");
		builder.append(roll);
		builder.append(", name=");
		builder.append(name);
		builder.append(", marks=");
		builder.append(marks);
		builder.append("]");
		return builder.toString();
	}
	
	
}

