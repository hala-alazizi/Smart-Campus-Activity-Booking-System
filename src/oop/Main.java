package oop;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		
		// OBJECT INSTANTIATION: Constructing separate, independent entity instances from a single reusable class blueprint
		Activity football= new Activity("Digital football match","SoftArea","Sunday at 12 AM",10);
		Activity chess= new Activity("Chess competition","Orange Village"," Monday at 3 PM",10);
		
		while(true) {
			
	System.out.println("Enter the number for what you want:\n ") ;
	
	System.out.println("1- Register in Activity ") ;
	System.out.println("2-Unregister in Activity ") ;
	System.out.println("3-Displaying registered participants in Activity") ;
	System.out.println("4-To exit ") ;
	
	int choice= scanner.nextInt();
	scanner.nextLine();
	
	
	if(choice==4) {
		
		System.out.println("wish too see you again ") ;
		break;
	}
	
	
	System.out.println("Enter the number for what activity you want:\n ") ;
	
	System.out.println("1-"+football.getTitle()) ;
	System.out.println("2- "+chess.getTitle()) ;
	
	int activityCoice= scanner.nextInt();
	scanner.nextLine();
	
	// POLYMORPHIC REFERENCE MATRIX: Creating a single reference pointer to dynamically hold whichever activity the user selects, eliminating code duplication
	Activity selectedActivity=null;
	 if (activityCoice==1) {
		 
		 selectedActivity=football;
		 
	 }
	
	 else if (activityCoice==2) {
		 
		 selectedActivity=chess;
		 
	 }
	
	 else {
		 System.out.println("Invalid choice ") ;
		 continue;
		 
	 }
	 
	 
	 ArrayList<Student> list = selectedActivity.getRegisteredStudents();
	
	 switch(choice) {
	 
	 case 1:
		// CAPACITY VERIFICATION: Inspecting encapsulated activity properties before authorizing registration
		 if(selectedActivity.getActiveCapacity()>=selectedActivity.getMaxCapacity()) {
			 
			 System.out.println("Erorr:"+selectedActivity.getTitle()+"is full") ; 
			  
		 }
		 else {
			 
			 System.out.println("Enter your name ") ;
			 String nameToRegister= scanner.nextLine();
			 
			 System.out.println("Enter your ID ") ;
			 String id= scanner.nextLine();
			// COMPOSITION & INSTANTIATION: Dynamically creating a new Student entity to encapsulate user details
			 Student newStudent=new Student(nameToRegister,id);
			 
			 list.add(newStudent);
			 
			 System.out.println("Sucsessfully Registered "+nameToRegister+" for "+selectedActivity.getTitle()) ;
			 
			 
		 }
		 
		 break;
		 
		 
	 case 2:
		 System.out.println("Enter your ID to Unregister ") ;
		 String idToCancle= scanner.nextLine();
		 
		int count =list.size();
		 boolean found=false;
		 
		 for(int i=0; i<count ;i++) {
			if( list.get(i).getStudentId().equalsIgnoreCase(idToCancle)) {
				
				found=true;
				// DYNAMIC INDEX SHIFTING: Maintaining structural contiguity manually within the list
				for(int j=i;j<count-1;j++) {
					
					list.set(j, list.get(j+1))	;
					}
				list.remove(count-1);// Truncating the redundant dangling tail element
				
				
				 System.out.println("Sucsessfully UnRegistered "+idToCancle+" for "+selectedActivity.getTitle()) ;
				 
				 break;
				
			} 
			 
		 }
		 
		 if(found==false) {
			 System.out.println("Erorr: ID not found in "+selectedActivity.getTitle()) ;
			 
		 }
		 break;
		 
		 
		 
		 
	 case 3:
		 System.out.println("Registered names in "+selectedActivity.getTitle()) ;
		 System.out.println("Location: "+selectedActivity.getLocation()+"\n Time: "+selectedActivity.getdayAndTime()) ;
		 
		 
		 if(list.isEmpty()) {
				
				System.out.println("No students registered yet") ;
				
			}	
		 
		 
		 else {
			 
			 for(int i=0; i<list.size();i++) {
				 
				 System.out.print((i+1)+".") ;
				// POLYMORPHIC INVOCATION: Treating the subclass object as its parent type, triggering overridden details at runtime
				 Person currentPerson=list.get(i);
				 
				 currentPerson.displayDetails();// Dynamic binding triggers Student's overridden displayDetails method
			 }
			 
		 }
		 break;
	 }
	
	
}
		
	
	scanner.close();	
	}

}
