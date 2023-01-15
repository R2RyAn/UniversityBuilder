

import java.util.*;
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Rayan Al Dajani
Student Number: 219069079
Course Section: EECS 2030 E
*/

public class CSD {
	// this is where we save our chair person's details
	ChairPerson chair;
	// this is where we save our program Director's details
	ProgramDirector ProgramDirector;
	// this is where we get our Faculty Records
	ArrayList<Faculty> facultyRecord = new ArrayList<>();
	// this is where we get our Student Records
	ArrayList<UGrad> stuRecord = new ArrayList<>();
	// this is where we get our Program Director faculty Records
	ArrayList<Faculty> ProgramDirectorRecord = new ArrayList<>();
	// this is where we get our Grad Records
	ArrayList<Grad> gradRecord = new ArrayList<>();

	/**
	 * This method Assigns our ChairPerson object to the one inputed in the
	 * parameter
	 * 
	 * @param chair is of ChairPerson object it contains all information regarding
	 *              this Object
	 */
	public CSD(ChairPerson chair) {
		this.chair = chair;
	}

	/**
	 * This method return the Universitie's Chair Person.
	 * 
	 * @return
	 */
	public ChairPerson getChairPerson() {
		return chair;
	}

	/**
	 * This method returns the universitie's Faculty Records
	 * 
	 * @return it returns an ArrayList containing all faculty in the University
	 */
	public ArrayList<Faculty> getfacRecord() {
		return facultyRecord;
	}

	/**
	 * This method hires Faculty and adds them to the Program Director's Record.
	 * 
	 * @param fac is the name of the faculty member we wish to hire and add to the
	 *            Program Director's Record
	 * 
	 * @throws NoSpaceException is an Exception thrown when more than 70 faculty
	 *                          members have been hired.
	 */

	public void HireFaculty(Faculty fac) throws NoSpaceException {
		// the variable flag is a boolean that helps us insure no duplicate is add to
		// the Faculty Records.
		boolean flag = true;
		for (int i = 0; i < facultyRecord.size(); i++) {
			if (fac.EmpID == facultyRecord.get(i).EmpID) {
				flag = false;

			}
		}
		// If more than 70 already existing faculty we throw a No space exception
		if (getNumOfFaculty() <= 70) {
			if (flag == true) {
				// adds faculty member to faulcty Record
				this.facultyRecord.add(fac);
				// if there is a Program director and that this faculty member belongs to the
				// same program
				// we should add the faculty member to the Program Director Records
				if (ProgramDirector != null && fac.program == ProgramDirector.program) {
					ProgramDirectorRecord.add(fac);
				}
			}
		}
		// If more than 70 faculties already exists we throw a No space exception
		else {
			throw new NoSpaceException();
		}
	}

	/**
	 * This method return the number of Faculty Members
	 * 
	 * @return the number of faculty members in the university
	 */
	public int getNumOfFaculty() {
		return this.facultyRecord.size();
	}

	/**
	 * This method return the faculty records in an ArrayList of object Faculty
	 * 
	 * @return the faculty records in an ArrayList of object Faculty
	 */
	public ArrayList<Faculty> getFaculty() {
		return this.facultyRecord;
	}

	/*
	 * This method admits students into the university by making sure there is no
	 * duplicates, and assigning them a Faculty Member as an advisor.
	 * 
	 * @param is the Object UGrad which we will be admitting into the university by
	 * adding his name to the records, assigning him a faculty member.
	 * 
	 * @throws NoSpaceException is an Exception thrown when more than 70 faculty
	 * members have been hired.
	 */
	public void AdmitStudent(UGrad stu) throws NoSpaceException {
		// flag is a boolean variable to make sure no duplicates have been made.
		boolean flag = true;
		// for loop to go through every student already in the Student Reconrds
		// and compares their ID's to the one in the parameter
		for (int i = 0; i < stuRecord.size(); i++) {
			if (stu.StuID == stuRecord.get(i).StuID) {
				flag = false;
			}
		}
		// this line checks if we have passed the total number of accepts Students
		if (getNumOfUGradStudents() < 500) {
			// if the method found that out UGrad stu isn't a duplicate we can add him to
			// the Student records
			if (flag == true) {
				this.stuRecord.add(stu);
				// the variable i is a number that represents how many faculty members do we
				// need for the total number of students.
				double i = Math.ceil((double) getNumOfUGradStudents() / 8.0);
				// we turn the variable I into in to an int and take away 1. This allows us to
				// place these students in the perfected spot to get an dvisor.
				int j = (int) i - 1;
				// this line sets the advisor of the UGrad Object stu a Faculty Member
				stu.advisor = facultyRecord.get(j);
				// this line adds the UGrad object to the advior's list of students.
				facultyRecord.get(j).advising.add(stu);

			}
		} else {
			// If more than 500 students (UGrad) already exists we throw a No space
			// exception
			throw new NoSpaceException();
		}
	}

	/**
	 * This method return the number of UGrad objects or students in the University
	 * 
	 * @return the number of UGrad objects or students in the University
	 */
	public int getNumOfUGradStudents() {
		return this.stuRecord.size();
	}

	/**
	 * This method sets the University Program Director to the ProgramDirector
	 * Object in the parameter.
	 * 
	 * @param ProgramDirector
	 */
	public void addProgramDirector(ProgramDirector ProgramDirector) {
		this.ProgramDirector = ProgramDirector;
	}

	/**
	 * This method hires TA's (Grad objects) and assigns them a faculty member
	 * 
	 * @param stu is of type Grad is the object that we wish to assign to a TA
	 * @throws NoSpaceException is an Exception thrown when more than 150 TA's have
	 *                          been hired.
	 */
	public void HireTA(Grad stu) throws NoSpaceException {
		// this line checks each TA's ID in order to prevent a duplicate Student
		boolean flag = true;
		for (int i = 0; i < gradRecord.size(); i++) {
			if (stu.StuID == gradRecord.get(i).StuID) {
				flag = false;
			}
		}
		// this line checks if we have surpasses the total number of accepted TAs
		if (getNumOfGradStudents() < 150) {
			if (flag == true) {
				// this line adds the student of type Grad to the Graduate Records.
				this.gradRecord.add(stu);
				// the variable i is a number that represents how many faculty members do we
				// need for the total number of students.
				double i = Math.ceil((double) getNumOfGradStudents() / 5.0);
				// we turn the variable I into in to an int and take away 1. This allows us to
				// place these students in the perfected spot to get an dvisor.
				int j = (int) i - 1;
				// this line assigns the TA to a faculty Member
				stu.TAFor = facultyRecord.get(j);
				// this line adds the TA to the list of TA under a faculty member
				facultyRecord.get(j).TAs.add(stu);
				// this line assigns this TA to an advisor of type Faculty
				stu.advisor = facultyRecord.get(j);
			}
		}
		// If more than 150 students (UGrad) already exists we throw a No space
		// exception
		else {
			throw new NoSpaceException();
		}
	}

	/**
	 * This method returns the number of Grad students in the university
	 * 
	 * @return the number of Grad students in the university
	 */
	public int getNumOfGradStudents() {
		return gradRecord.size();
	}

	/**
	 * this method allows a UGrad student to Graduate by removing him from his
	 * advisors student list and also from the student record
	 * 
	 * @param stu is the UGrad object of which we wish to graduate
	 */
	public void AlumnusUGrad(UGrad stu) {
		// this line removes the parameter student from the student records
		stuRecord.remove(stu);
		// this line removes the parameter student of UGrad type for his advisor's
		// advising list
		stu.advisor.advising.remove(stu);
	}

	/**
	 * this method allows a UGrad student to Graduate by removing him from his
	 * advisors student list and also from the student record
	 * 
	 * @param stu is the Grad object of which we wish to graduate
	 * @throws NoTAException is thrown when the student objects advisor had no other
	 *                       TA's
	 */
	public void AlumnusGrad(Grad stu) throws NoTAException {
		// checks if this Grad TA is the only TA to a faculty member
		if (stu.TAFor.TAs.size() == 1) {
			// this line removes the student from the grad records
			gradRecord.remove(stu);
			// this line removes the grad from his advisors TA list
			stu.advisor.TAs.remove(stu);
			// throws an exception if hes the only TA to an advisor
			throw new NoTAException();
		} else {
			// If he's not the only TA then we can safely remove him with no exception
			gradRecord.remove(stu);
			// this line removes the grad from his advisors TA list
			stu.advisor.TAs.remove(stu);
		}

	}

	/**
	 * This method sorts all the Grad Details in an arrayList and sorts it
	 * 
	 * @return return a sorted ArrayList<Grad> of object Grad containing all the
	 *         information about the person
	 */
	public ArrayList<Grad> ExtractAllGradDetails() {

		// this line sorts the Graduate Records ArrayList in order to return it sorted
		Collections.sort(gradRecord, new Comparator<Grad>() {

			/**
			 * this method compares the first object to the second object to make sure its
			 * well sorted
			 * 
			 * @param g1 is of type Grad which is used to sort the array
			 * @param g2 is of type Grad which is used to sort the array
			 * @return this returns weather g1 comes after or before g2.
			 */
			@Override
			public int compare(Grad g1, Grad g2) {
				return g1.getName().compareTo(g2.getName());
			}
		});
		// we return the gradRecord sorted
		return gradRecord;
	}

	/**
	 * This method sorts all the UGrad Details in an arrayList and sorts it
	 * 
	 * @return return a sorted ArrayList<Grad> of object UGrad containing all the
	 *         information about the person
	 */
	public ArrayList<UGrad> ExtractAllUGradDetails() {

		// this line sorts the Graduate Records ArrayList in order to return it sorted
		Collections.sort(stuRecord, new Comparator<UGrad>() {
			/**
			 * this method compares the first object to the second object to make sure its
			 * well sorted
			 * 
			 * @param s1 is of type UGrad which is used to sort the array
			 * @param s2 is of type UGrad which is used to sort the array
			 * @return this returns weather s1 comes after or before s2.
			 */
			@Override
			public int compare(UGrad s1, UGrad s2) {
				return s1.getName().compareTo(s2.getName());
			}
		});
		// we return the gradRecord sorted
		return stuRecord;
	}

	/**
	 * This method sorts all the Faculty Details in an arrayList and sorts it
	 * 
	 * @return return a sorted ArrayList<Faculty> of object UGrad containing all the
	 *         information about the person
	 */
	public ArrayList<Faculty> ExtractAllFacultyDetails() {

		// this line sorts the Faculty Records ArrayList in order to return it sorted
		Collections.sort(facultyRecord, new Comparator<Faculty>() {
			/**
			 * this method compares the first object to the second object to make sure its
			 * well sorted
			 * 
			 * @param f1 is of type Faculty which is used to sort the array
			 * @param f2 is of type Faculty which is used to sort the array
			 * @return this returns weather f1 comes after or before f2.
			 */
			@Override
			public int compare(Faculty f1, Faculty f2) {
				return f1.getName().compareTo(f2.getName());
			}
		});
		// we return the Faculty Records sorted
		return facultyRecord;
	}

	/**
	 * This method sorts all the Faculty Details in an arrayList and sorts it
	 * 
	 * @param prog is a parameter of type of string which tells us the Faculty's
	 *             program
	 * @return return a sorted ArrayList<Faculty> of object UGrad containing all the
	 *         information about the person
	 */
	public ArrayList<Faculty> ExtractFacultyDetails(String prog) {

		// these lines search for every Faculty member belonging the to prameter's
		// program
		ArrayList<Faculty> arr = new ArrayList<>();
		for (int i = 0; i < facultyRecord.size(); i++) {
			// this line checks if the faculty member is part of the parameter's program
			if ((facultyRecord.get(i).program).equals(prog)) {
				// this line adds every faculty member's belonging to a program to the same
				// array
				arr.add(facultyRecord.get(i));
			}
		}

		// this line sorts the ArrayList in order to return it sorted
		Collections.sort(arr, new Comparator<Faculty>() {
			/**
			 * this method compares the first object to the second object to make sure its
			 * well sorted
			 * 
			 * @param f1 is of type Faculty which is used to sort the array
			 * @param f2 is of type Faculty which is used to sort the array
			 * @return this returns weather f1 comes after or before f2.
			 */
			@Override
			public int compare(Faculty f1, Faculty f2) {
				return f1.getName().compareTo(f2.getName());
			}
		});
		// we return the array of Faculty members sorted
		return arr;

	}

	/**
	 * This method sorts all the Faculty Details in an arrayList and sorts it
	 * 
	 * @param fac is a parameter of type Faculty which tells up which faculty to
	 *            extract the data from
	 * @return return a sorted ArrayList<UGrad> of object UGrad containing all the
	 *         information about the person
	 */
	public ArrayList<UGrad> ExtractAdviseesDetails(Faculty fac) {
		// these lines search for every UGrad student belonging to a faculty
		ArrayList<UGrad> arr = new ArrayList<>();
		for (int i = 0; i < stuRecord.size(); i++) {
			// this line checks if the student is part of the parameter's faculty
			if ((stuRecord.get(i).advisor).equals(fac)) {
				// this line adds every student belonging to a faculty to the same array
				arr.add(stuRecord.get(i));
			}
		}
		// this line sorts the ArrayList in order to return it sorted
		Collections.sort(arr, new Comparator<UGrad>() {
			/**
			 * this method compares the first object to the second object to make sure its
			 * well sorted
			 * 
			 * @param s1 is of type UGrad which is used to sort the array
			 * @param s2 is of type UGrad which is used to sort the array
			 * @return this returns weather s1 comes after or before s2.
			 */
			@Override
			public int compare(UGrad s1, UGrad s2) {
				return s1.getName().compareTo(s2.getName());
			}
		});
		// we return the array of UGrad sorted
		return arr;
	}

	/**
	 * This method sorts all the UGrad Details in an arrayList and sorts it
	 * 
	 * @param is of type Faculty which is used to know who's information to extract
	 * @return return a sorted ArrayList<Grad> of object UGrad containing all the
	 *         information about the person
	 */
	public ArrayList<Grad> ExtractTAsDetails(Faculty fac) {

		Collections.sort(fac.TAs, new Comparator<Grad>() {
			/**
			 * this method compares the first object to the second object to make sure its
			 * well sorted
			 * 
			 * @param g1 is of type Grad which is used to sort the array
			 * @param g2 is of type Grad which is used to sort the array
			 * @return this returns weather g1 comes after or before g2.
			 */
			@Override
			public int compare(Grad g1, Grad g2) {
				return g1.getName().compareTo(g2.getName());
			}
		});
		// we return the array of Grad sorted
		return fac.TAs;

	}

	/**
	 * This method retires a faculty member by assigning all of the member TA's and
	 * Students to another Faculty Member
	 * 
	 * @param fac is an object of type Faculty which is the person we wish to retire
	 * @throws NoSpecialtyException is an exception thrown when the faculty member
	 *                              is the only faculty of that program
	 */

	public void RetireFaculty(Faculty fac) throws NoSpecialtyException {

		// These lines checks to make sure this faculty member is not the only person in
		// its program
		for (int i = 0; i < facultyRecord.size(); i++) {
			// checks to see if there exits another faculty in the same program
			if (!(facultyRecord.get(i).equals(fac)) && facultyRecord.get(i).program == fac.program) {
				// this line breaks out the loop in order to retire the faculty
				break;
			}
			// this line checks that if there aren't any other Faculty member in the same
			// program
			else if (i == facultyRecord.size() - 1) {
				// throw this exception when the faculty member is the only faculty of that
				// program
				throw new NoSpecialtyException();
			}
		}
		// this line checks if the faculty is advising at least one student
		if (fac.advising.size() > 0) {
			// loops through the advisor's student list in order to assign them to another
			// faculty member
			for (int i = 0, j = 0; i < facultyRecord.size() && j < fac.advising.size(); i++) {
				// this line makes sure we do not add the student to same faculty we wish to
				// remove it from
				// and also if the other faculty advising list is less than 8
				if (facultyRecord.get(i).advising.size() < 8 && facultyRecord.get(i) != fac) {
					// this line loops through the faculty advising list until it is full or no more
					// student to move
					while (facultyRecord.get(i).advising.size() < 8 && j != 8) {
						// this line adds the student to a new faculty
						facultyRecord.get(i).advising.add(fac.advising.get(j));
						// this line sets the students advisor to the brand new advisor
						fac.advising.get(j).advisor = facultyRecord.get(i);
						// this line increments j which is used to loop through the old advisors student
						// list
						j++;

					}
				}
			}
			// this line removes the faculty member that retired from the Faculty record

		}
		// this line checks if the faculty has at least one TA
		if (fac.TAs.size() > 0) {
			// loops through the advisor's TA list in order to assign them to another
			// faculty member
			for (int i = 0, j = 0; i < facultyRecord.size() && j < fac.TAs.size(); i++) {
				// this line makes sure we do not add the TA to same faculty we wish to remove
				// it from
				// and also if the other faculty TA list is less than 5
				if (facultyRecord.get(i).TAs.size() < 5 && facultyRecord.get(i) != fac) {
					// this line loops through the faculty TA list until it is full or no more TA to
					// move
					while (facultyRecord.get(i).TAs.size() < 5 && j != 5) {
						// this line adds the TA to a new faculty
						facultyRecord.get(i).TAs.add(fac.TAs.get(j));
						// this line sets the TA's advisor to the brand new advisor
						fac.TAs.get(j).advisor = facultyRecord.get(i);
						// this line increments j which is used to loop through the old advisors TA list
						j++;

					}
				}
			}
			// this line removes the faculty member that retired from the Faculty record

		}
		facultyRecord.remove(fac);
	}

}

/**
 * This class allows us to throw NoSPace Exceptions when ever the maximum number
 * of people added
 */
@SuppressWarnings("serial")
class NoSpaceException extends Exception {
	public NoSpaceException() {
		super("Not enouch space");
	}
}

/**
 * 
 * This class allows us to throw No TA Exceptions when ever there isnt any TA in
 * the faculty Members list added
 *
 */
@SuppressWarnings("serial")
class NoTAException extends Exception {
	public NoTAException() {
		super("TA not found");
	}
}

/**
 * This class allows us to throw No Specialty Exception when ever the maximum
 * number of people added
 * 
 */
@SuppressWarnings("serial")
class NoSpecialtyException extends Exception {
	public NoSpecialtyException() {
		super("No other speciality");
	}
}

/**
 * This class defines a Person using multiple instance variables.
 * 
 * @author Rayan Al Dajani
 */
class Person {
	// private string to hold the Persons name
	private String name;
	// private string to hold the Persons family name
	private String fName;
	// private integer to hold the Persons age
	private int age;
	// private string to hold the Persons gender
	private String gender;
	// private string to hold the Persons address
	private String address;

	/**
	 * This method get's the name of the person
	 * 
	 * @return the name of the person in a string
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * this method sets the person's name to the parameter
	 * 
	 * @param name is of type string used to set the name of the person
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method get's the family name of the person
	 * 
	 * @return the family name of the person in a string
	 */
	public String getfName() {
		return this.fName;
	}

	/**
	 * this method sets the person's family name to the parameter
	 * 
	 * @param fName is of type string used to set the family name of the person
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * this method gets the person's age
	 * 
	 * @return this method return the person's age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * this method sets the age of the person to the parameter
	 * 
	 * @param age is of type int to set the person's age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This method get's the gender of the person
	 * 
	 * @return the gender of the person in a string
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * this method sets the person's gender to the parameter
	 * 
	 * @param fName is of type string used to set the gender of the person
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * This method get's the address of the person
	 * 
	 * @return the address of the person in a string
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * this method sets the person's address to the parameter
	 * 
	 * @param fName is of type string used to set the address of the person
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}

/**
 * This class defines Academics using multiple instance variables.
 * 
 * @author Rayan Al Dajani
 *
 */
class Academics extends Person {
	static int EmployeeID = 100;
	double salary;

	/**
	 * this method sets the salary of each Employee to the parameter
	 * 
	 * @param salary is an int used to assign a salary to each employee
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

}

/**
 * This class defines a Student using an instance variable.
 * 
 * @author Rayan Al Dajani
 * 
 *
 */
class Student extends Person implements Comparable {
	static int StudentID = 999;
}

/**
 * This class defines an Administrator
 * 
 * @author Rayan Al Dajani
 *
 */
abstract class Administrator extends Academics {
	int EmpID;

}

/**
 * This class defines a Faculty Member using many instance variable.
 * 
 * @author Rayan Al Dajani
 *
 */
class Faculty extends Academics implements Comparable {
	int EmpID;
	ArrayList<UGrad> advising = new ArrayList<>();
	ArrayList<Grad> TAs = new ArrayList<>();
	String program;

	/**
	 * this method is a constructor in order to create more Faculty Objects
	 * 
	 * @param name    is a string to assign a name to the Faculty member
	 * @param fName   is a string to assign a family name to the Faculty member
	 * @param age     is an int to assign an age to the faculty member
	 * @param gender  is a string to assign a gender to the Faculty member
	 * @param address is a string to assign an address to the Faculty member
	 */
	public Faculty(String name, String fName, int age, String gender, String address) {
		setName(name);
		setfName(fName);
		setAge(age);
		setGender(gender);
		setAddress(address);
		// increments faculty member's ID and assigns it to him
		EmpID = EmployeeID++;
	}

	/**
	 * this method sets the Faculty members program
	 * 
	 * @param program is of type string to set the faculty members program
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * this method gets the faculty members program
	 * 
	 * @return it return the program of the faculty member in a string
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * this method return the employee's ID number
	 * 
	 * @return return an int for the employee
	 */
	public int getEmployeeID() {
		return EmpID;
	}

	/**
	 * This method print's out the Faculty member's details in a organized and
	 * readable way.
	 * 
	 * @return returns a readable organized string of the faculty members details
	 */
	public String toString() {
		// adds the variables in which we need to print out in order
		String result = "Faculty " + program + "[[" + EmpID + ", " + salary + "[" + getName() + ", " + getfName() + ", "
				+ getAge() + ", " + getGender() + ", " + getAddress() + "]]]";
		return result;
	}

	/**
	 * THis method returns in an arrayList the list of students the faculty is in
	 * charge of
	 * 
	 * @return in an arrayList the list of students the faculty is in charge of
	 */
	public ArrayList<UGrad> getAdvisingUgrads() {

		return advising;
	}

	/**
	 * THis method returns in an arrayList the list of TA that work for the faculty
	 * member
	 * 
	 * @return in an arrayList the list of TA that work for the faculty member
	 */
	public ArrayList<Grad> getTAs() {
		return TAs;
	}

	/**
	 * THis method returns the number of UGrads the faculty is in charger of
	 * 
	 * @return in an int of the number of UGrads the faculty is in charger of
	 * 
	 */
	public int getNumOfAdvisingUGrads() {
		return advising.size();
	}

	/**
	 * THis method returns the number of TA's the faculty is in charger of
	 * 
	 * @return is an int of the number of TA's the faculty is in charger of
	 * 
	 */
	public int getNumOfTAs() {
		return TAs.size();
	}

}

/**
 * This class defines a Program Director using many instance variable.
 * 
 * @author Rayan Al Dajani
 *
 */
class ProgramDirector extends Administrator {
	String program;
	int EmpID;

	/**
	 * this method is a constructor in order to create more a Program Director
	 * 
	 * @param name    is a string to assign a name to the Program Director
	 * @param fName   is a string to assign a family name to the Program Director
	 * @param age     is an int to assign an age to the Program Director
	 * @param gender  is a string to assign a gender to the Program Director
	 * @param address is a string to assign an address to the Program Director
	 */
	public ProgramDirector(String name, String fName, int age, String gender, String address) {
		setName(name);
		setfName(fName);
		setAge(age);
		setGender(gender);
		setAddress(address);
		// increments Program Director's ID and assigns it to him
		EmpID = EmployeeID++;
	}

	/**
	 * This method set's the Program directors program
	 * 
	 * @param program is a string to assign the Program Directors program
	 */
	public void setProgram(String program) {
		this.program = program;
	}

}

/**
 * This class defines a ChairPerson using many instance variable.
 * 
 * @author Rayan Al Dajani
 *
 */
class ChairPerson extends Administrator {
	int EmpID;

	/**
	 * this method is a constructor in order to create more a ChairPerson
	 * 
	 * @param name    is a string to assign a name to the ChairPerson
	 * @param fName   is a string to assign a family name to the ChairPerson
	 * @param age     is an int to assign an age to the ChairPerson
	 * @param gender  is a string to assign a gender to the ChairPerson
	 * @param address is a string to assign an address to the ChairPerson
	 */
	public ChairPerson(String name, String fName, int age, String gender, String address) {
		setName(name);
		setfName(fName);
		setAge(age);
		setGender(gender);
		setAddress(address);
		// increments ChairPerson's ID and assigns it to him
		EmpID = EmployeeID++;
	}

	/**
	 * this method returns the ChairPerson's Employee ID
	 * 
	 * @return the ChairPerson's Employee ID in a int
	 */
	public int getEmployeeID() {
		return EmpID;
	}

	/**
	 * This method print's out the ChairPerson's details in a organized and readable
	 * way.
	 * 
	 * @return returns a readable organized string of the ChairPerson's details
	 */
	public String toString() {
		String result = "Chair Person [[[" + EmpID + ", " + salary + "[" + getName() + ", " + getfName() + ", "
				+ getAge() + ", " + getGender() + ", " + getAddress() + "]]]]";

		return result;
	}

}

/**
 * this is an interface
 * 
 * @author Rayan Al Dajani
 *
 */
interface Comparable {

}

/**
 * This class defines a UGrad using many instance variable.
 * 
 * @author Rayan Al Dajani
 *
 */
class UGrad extends Student {
	int StuID;
	Faculty advisor;

	/**
	 * this method is a constructor in order to create more a UGrad
	 * 
	 * @param name    is a string to assign a name to the UGrad
	 * @param fName   is a string to assign a family name to the UGrad
	 * @param age     is an int to assign an age to the UGrad
	 * @param gender  is a string to assign a gender to the UGrad
	 * @param address is a string to assign an address to the UGrad
	 */
	public UGrad(String name, String fName, int age, String gender, String address) {
		setName(name);
		setfName(fName);
		setAge(age);
		setGender(gender);
		setAddress(address);
		// increments UGrad's ID and assigns it to him
		StuID = StudentID++;
	}

	/**
	 * This method print's out the UGrads details in a organized and readable way.
	 * 
	 * @return returns a readable organized string of the UGrad's details
	 */
	public String toString() {
		String result = "Undergraduate [" + StudentID + "[[" + getName() + ", " + getfName() + ", " + getAge() + ", "
				+ getGender() + ", " + getAddress() + "]]]";

		return result;
	}

	/**
	 * this method return the advisor of type Faculty of the student
	 * 
	 * @return this method return the advisor of type Faculty of the student
	 */
	public Faculty getAdvisor() {
		return advisor;
	}

	/**
	 * this method checks if two objects of type UGrad are equal
	 * 
	 * @param stu2 is the second student of type UGrad
	 * @return true if both students are equal, false if they're not
	 */
	public boolean equals(UGrad stu2) {
		// checks if every variable of both students are equal
		if ((this.getfName().equals(stu2.getfName())) && (this.getName().equals(stu2.getName()))
				&& this.getAge() == stu2.getAge() && (this.getAddress().equals(stu2.getAddress()))
				&& (this.getGender().equals(stu2.getGender()))) {
			return true;
		}

		return false;
	}
}

/**
 * This class defines a Grad using many instance variable.
 * 
 * @author Rayan Al Dajani
 *
 */
class Grad extends Student {
	int StuID;
	Faculty TAFor;
	Faculty advisor;

	/**
	 * this method is a constructor in order to create more a UGrad
	 * 
	 * @param name    is a string to assign a name to the Grad
	 * @param fName   is a string to assign a family name to the Grad
	 * @param age     is an int to assign an age to the Grad
	 * @param gender  is a string to assign a gender to the Grad
	 * @param address is a string to assign an address to the Grad
	 */
	public Grad(String name, String fName, int age, String gender, String address) {
		setName(name);
		setfName(fName);
		setAge(age);
		setGender(gender);
		setAddress(address);
		// increments Grad's ID and assigns it to him
		StuID = StudentID++;
	}

	/**
	 * This method print's out the Grad's details in a organized and readable way.
	 * 
	 * @return returns a readable organized string of the UGrad's details
	 */
	public String toString() {
		String result = "Graduate [" + StudentID + "[[" + getName() + ", " + getfName() + ", " + getAge() + ", "
				+ getGender() + ", " + getAddress() + "]]]";
		return result;
	}

	/**
	 * This method return the Grad's advisor
	 * 
	 * @return the Grad's advisor of type faculty
	 */
	public Faculty getAdvisor() {
		return advisor;
	}

	/**
	 * this method checks if two objects of type Grad are equal
	 * 
	 * @param stu2 is the second student of type Grad
	 * @return true if both students are equal, false if they're not
	 */
	public boolean equals(Grad stu2) {
		// checks if every variable of both students are equal
		if ((this.getfName().equals(stu2.getfName())) && (this.getName().equals(stu2.getName()))
				&& this.getAge() == stu2.getAge() && (this.getAddress().equals(stu2.getAddress()))
				&& (this.getGender().equals(stu2.getGender()))) {
			return true;
		}

		return false;
	}
}
