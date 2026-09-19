package oop;
//INHERITANCE: Student extends Person to reuse base attributes and behaviors
public class Student extends Person{
	// ENCAPSULATION: Hiding data using private access modifier
private String studentId;

 public Student(String name ,String studentId) {
	super(name);// Constructor Chaining: Invoking the parent class constructor
	this.studentId=studentId;
	
	
}


 public String getStudentId() {
	
	return studentId;
	}
//RUNTIME POLYMORPHISM: Overriding parent method to inject specialized logic
 @Override
 
 public void displayDetails() {
	 
	 
	 super.displayDetails();// Reusing the parent class display capability
	 System.out.println(" ID: " +studentId);// Adding subclass specific detail
	 
 }
}
