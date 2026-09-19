package eventdriven;
import java.util.ArrayList;
public class Activity1 {

	private String title;
	private String location;
	private String dayAndTime;
	private int maxCapacity;
	private ArrayList<Student1>registeredStudents;
	
	
	public Activity1( String title, String location,String dayAndTime, int maxCapacity) {
		
		 this.title=title;
		 this.location=location;
		 this.dayAndTime=dayAndTime;
		 this.maxCapacity=maxCapacity;
		this.registeredStudents= new ArrayList<>();
		 
		
	}
	
	public String getTitle() {return title;}
	public String getLocation() {return location;}
	public String getdayAndTime() {return dayAndTime;}
	public int getMaxCapacity() {return maxCapacity;}
	public ArrayList<Student1> getRegisteredStudents(){
		
		return registeredStudents;
	}
	
	
	
	
	public int getActiveCapacity() {
		
		
		return registeredStudents.size();
		
	}
	
	
	
	

}


