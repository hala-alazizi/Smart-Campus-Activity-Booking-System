package oop;
import java.util.ArrayList;
public class Activity {
	// ENCAPSULATION BOUNDARY: Making all attributes private to protect internal state
	private String title;
	private String location;
	private String dayAndTime;
	private int maxCapacity;
	// OBJECT AGGREGATION: Dynamic collection composition instead of rigid parallel arrays
	private ArrayList<Student>registeredStudents;
	
	
	public Activity( String title, String location,String dayAndTime, int maxCapacity) {
		 this.title=title;
		 this.location=location;
		 this.dayAndTime=dayAndTime;
		 this.maxCapacity=maxCapacity;
		this.registeredStudents= new ArrayList<>();// Safe execution resource allocation
		 
		
	}
	
	public String getTitle() {return title;}
	public String getLocation() {return location;}
	public String getdayAndTime() {return dayAndTime;}
	public int getMaxCapacity() {return maxCapacity;}
	public ArrayList<Student> getRegisteredStudents(){
		
		return registeredStudents;
	}
	
	
	// STATE ABSTRACTION: Decoupling size computation from external driver interface
	
	public int getActiveCapacity() {
		
		
		return registeredStudents.size();
		
	}
	
	
	
	

}
