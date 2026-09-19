
package registration;
import java.util.Scanner;

public class CampusRegistration {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		 
		int maxCapacity=10;//I set the value"10" to test the effectiveness of the code and the overbooking prevention feature.
		int chessCapacity=0;
		int footballCapacity=0;
		String footballLocation="SoftArea";
		String chessLocation="Orange Village";
		String footballdayandtime="Sunday at 12pm";
		String chessdayandtime="Monday at 3pm";
		
		// DECLARING PARALLEL ARRAYS: Maintaining student data using primitive index alignment
		String footballname[]=new String[maxCapacity];
		String footballId[]=new String[maxCapacity];
		
		String chessname[]=new String[maxCapacity];
		String chessId[]=new String[maxCapacity];
		
		
		
		
		System.out.println("Welcome to the Campus Registration System\n ") ;
		
		
		
		while(true) {
			
			System.out.println("Enter the number for what you want:\n ") ;
			

			System.out.println("1- Register in DigitalFootball match ") ;
			System.out.println("2-Register in Chess competition ") ;
			System.out.println("3-Unregister in DigitalFootball match ") ;
			System.out.println("4-Unregister in Chess competition ") ;
			System.out.println("5-Displaying registered participants in DigitalFootball match") ;
			System.out.println("6- Displaying registered participants in Chess competition ") ;
			System.out.println(" -To exit enter'0' ") ;
			
			
			
			int activity= input.nextInt();
			input.nextLine();
			
			
			if(activity==0) {
				
				System.out.println("wish too see you again ") ;
				break;
				
			}
			
			
			if(activity==1) {
				
				// PREVENTING OVERBOOKING: Check if current registration is strictly less than the capacity ceiling
				if(footballCapacity<maxCapacity) {
					
					System.out.println("Enter your name ") ;
					String studentName=   input.nextLine(); 
					
					System.out.println("Enter your ID ") ;
					String studentID=   input.nextLine();
					
					
					
					System.out.println("Welcome "+studentName+" Registration completed successfully") ;
					System.out.println("This is the match detalis:") ;
					System.out.println("Title: Digital Football match") ;
					System.out.println("Location: "+footballLocation) ;
					System.out.println("Day & Time: "+footballdayandtime) ;
					System.out.println("Capacity:"+maxCapacity); 
					
					footballname[footballCapacity]=studentName;
					footballId[footballCapacity]=studentID;
					
					footballCapacity++;
					
				}
				
				else {
					System.out.println("football match is full ") ;
				}
				
			}
			
			else if(activity==2) {
				
				if(chessCapacity<maxCapacity) {
					
					System.out.println("Enter your name ") ;
					String studentName= input.nextLine();
					
					System.out.println("Enter your ID ") ;
					String studentID=   input.nextLine();
					
					
					System.out.println("Welcome "+studentName+" Registration completed successfully") ;
					System.out.println("This is the competition detalis:") ;
					System.out.println("Title: Chess competition") ;
					System.out.println("Location: "+chessLocation) ;
					System.out.println("Day & Time: "+chessdayandtime) ;
					System.out.println("Capacity:"+maxCapacity); 
					
					chessname[chessCapacity]=studentName;
					chessId[chessCapacity]=studentID;
					chessCapacity++;
					
				}	
				
				else {
					System.out.println("chess competition is full ") ;
				}
			}
			
			
			else if(activity==3) {
				if(footballCapacity>0) {
				
					System.out.println("Enter your ID to cancel:") ;
					String cancleID= input.nextLine();
					
					boolean flag=false;
				
				// INDEX LOCALIZATION: Scanning the array sequentially to find the matching student ID
					for(int i=0;i<footballCapacity;i++) {
						
						
						if(footballId[i].equalsIgnoreCase(cancleID)) {
							
							 flag=true;
							
			// INSERTION-BASED INDEX SHIFTING: Moving subsequent elements forward to fill the structural gap
					for(int j=i;j<footballCapacity-1;j++) {
							
							footballname[j]=footballname[j+1];	
							footballId[j]=footballId[j+1];	
							}
						// BOUNDARY CLEANUP: Overwriting the trailing duplicate record with null
						footballname[footballCapacity-1]=null;
						footballId[footballCapacity-1]=null;
						
						// COUNTER MODIFICATION: Decrementing total active count to free up space
						footballCapacity--;
						
						System.out.println("UnRegistration in DigitalFootball match completed successfully") ;
						break;
						}
					}
						if(flag==false) {
						
						System.out.println("ID not found") ;

						
						
					}
				
				}
					
				else {
					System.out.println("There is no student to cancel their registration") ;

				}
			}
			
			
			else if(activity==4) {
				if(chessCapacity>0) {
					
					String CancleID=input.nextLine();
					boolean flag= false;
					
					for(int i=0;i<chessCapacity;i++) {
						
						if(chessId[i].equalsIgnoreCase(CancleID)) {
							
							flag=true;
						for(int j=i;j<chessCapacity-1;j++) {
							
							chessname[j]=chessname[j+1];
							chessId[j]=chessId[j+1];
						}
						chessname[chessCapacity-1]=null;
						chessId[chessCapacity-1]=null;
						
						chessCapacity--;
						
					System.out.println("UnRegistration in chess match completed successfully") ;
							break;
						
					
				}//closing if 
						
				
			}//closing for loop
					
					if(flag==false) {
						
						System.out.println("ID not found") ;

						
						
					}
					}
				else {
					System.out.println("There is no student to cancel their registration") ;

				}
			}
			
			else if(activity==5) {
				
				if(footballCapacity==0) {
					
					System.out.println("No students registered yet") ;
					
				}	
				
				else {
					// SEQUENTIAL DATA DISPLAY: Iterating through active array indices up to the current counter limit
			               for(int i=0;i<footballCapacity;i++) {
			                System.out.println("- Name: "+footballname[i]+"  |ID"+footballId[i]+"\n") ;
			                  }
				}
			}
			
			else if(activity==6) {
				
				if(chessCapacity==0) {
					
					System.out.println("No students registered yet") ;
					
				}	
				
				else {
			               for(int i=0;i<chessCapacity;i++) {
			                	  
			                System.out.println("-Name: "+chessname[i]+" |ID:"+chessId[i]+"\n2") ;
			                  }
				}
			}
			
			else {
				
				
				System.out.println(" number is invalid ") ;
				
			}
			
			
			
			
		}
		
		
		input.close();
    
	}

}
