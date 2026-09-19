package eventdriven;

public class Student1 extends Person1 {
	
	private String studentId;

	 public Student1(String name ,String studentId) {
		super(name);
		this.studentId=studentId;
		
		
	}


	 public String getStudentId() {
		
		return studentId;
		}

	 @Override
	 
	 public void displayDetails() {
		 
		 
		 super.displayDetails();
		 System.out.println("ID :" +studentId);
		 
	 }

	
}
