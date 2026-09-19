package eventdriven;

public class Person1 {
protected String name;
	
	public Person1 (String name) {
		
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void displayDetails() {
		
		System.out.print("Name : " + name);
		
	}

}
