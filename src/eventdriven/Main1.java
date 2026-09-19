package eventdriven;
import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Scanner scanner= new Scanner(System.in);
		
		
		Activity1 football= new Activity1("Digital football match","SoftArea","Sunday at 12 AM",10);
		Activity1 chess= new Activity1("Chess competition","Orange Village"," Monday at 3 PM",10);
		
		while(true) {
			
	System.out.println("Enter the number for what you want:\n ") ;
	
	System.out.println("1- Register in Activity ") ;
	System.out.println("2-Unregister in Activity ") ;
	System.out.println("3-Displaying registered participants in Activity") ;
	System.out.println("4-To exit enter ") ;
	
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
	

	Activity1 selectedActivity=null;
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
	 
	 
	 ArrayList<Student1> list = selectedActivity.getRegisteredStudents();
	
	 switch(choice) {
	 
	 case 1:
		 
		 if(selectedActivity.getActiveCapacity()>=selectedActivity.getMaxCapacity()) {
			 
			 System.out.println("Erorr:"+selectedActivity.getTitle()+"is full") ; 
			  
		 }
		 else {
			 
			 System.out.println("Enter your name ") ;
			 String nameToRegister= scanner.nextLine();
			 
			 System.out.println("Enter your ID ") ;
			 String id= scanner.nextLine();
			 
			 Student1 newStudent=new Student1(nameToRegister,id);
			 
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
				for(int j=i;j<count-1;j++) {
					
					list.set(j, list.get(j+1));
					}
				list.remove(count-1);
				
				
				 System.out.println("Sucsessfully UnRegistered "+idToCancle+" for "+selectedActivity.getTitle()) ;
				 
				 break;
				
			} 
			 
		 }
		 
		 if(found==false) {
			 System.out.println("Erorr: ID not found in "+ selectedActivity.getTitle()) ;
			 
		 }
		 break;
		 
		 
		 
		 
	 case 3:
		 System.out.println("Registered names in "+selectedActivity.getTitle()) ;
		 System.out.println("Location :"+selectedActivity.getLocation()+" Time :"+selectedActivity.getdayAndTime()) ;
		 
		 
		 if(list.isEmpty()) {
				
				System.out.println("No students registered yet") ;
				
			}	
		 
		 
		 else {
			 
			 for(int i=0; i<list.size();i++) {
				 
				 System.out.print((i+1)+".") ;
				 
				 Person1 currentPerson=list.get(i);
				 
				 currentPerson.displayDetails();
			 }
			 
		 }
		 break;
	 }
	
	
}
		
	
	scanner.close();	
	}
		
		
		
		
	}


