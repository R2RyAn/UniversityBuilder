import java.util.ArrayList;

public class UniData{
	
	Dean dean;
	ArrayList<Dean> deanRecord = new ArrayList<>();
	// this is where we save our program Director's details
	ArrayList<Faculty> facultyRecord = new ArrayList<>();
	// this is where we get our Student Records
	ArrayList<Student> stuRecord = new ArrayList<>();
	
	public UniData() {
		
	}
	
	public int getNumOfFaculty() {
		return facultyRecord.size();
	}
	
	public int getNumOfStudent() {
		return stuRecord.size();
	}
	
	
	public void addStudent(Student dn) {
		stuRecord.add(dn);
	}
}

class Person{
	public String firstName;
	public String lastName;
	public String country;
	public String profilePic ="/ProfilePIc.jpeg";
}





class Dean extends Person{
	int Id;
	
	public Dean(String firstName, String lastName, String country) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.country=country;
		Id = (int)(Math.random() * 999999-100000) + 100000;
	}
}

class Faculty extends Person{
	int Id;
	
	public Faculty(String firstName, String lastName, String country) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.country=country;
		Id = (int)(Math.random() * 999999-100000) + 100000;
	}
}

class Student extends Person{
	int Id;
	
	public Student(String firstName, String lastName, String country) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.country=country;
		Id = (int)(Math.random() * 999999-100000) + 100000;
		
		
	}
	
	
}
