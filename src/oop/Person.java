package oop;

public class Person {
	
	// ACCESS CONTROL: protected allows direct visibility to subclasses like Student
	protected String name;
	
	public Person (String name) {
		
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	// BASE METHOD: To be polymorphically extended by subclasses
	public void displayDetails() {
		
		System.out.print("Name : " + name);
		
	}
}
