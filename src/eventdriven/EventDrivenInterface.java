package eventdriven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class EventDrivenInterface extends JFrame{
	
private JComboBox<String> activityMenu;
private JTextField nameField , idField, deleteIdField;
private JTextArea displayArea;
private JButton registerButton , deleteButton,displayButton,helloButton;

private Activity1 football;
private Activity1 chess;

public  EventDrivenInterface() {
	
	 football= new Activity1("Digital football match","SoftArea","Sunday at 12 AM",10);
	 chess= new Activity1("Chess competition","Orange Village"," Monday at 3 PM",10);
	 
	 setTitle("HTU- Smart Campus Activity System");
	 setSize(550,650);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setLayout(new BorderLayout(15,15));
	
	 
	 JPanel inputPanel=new JPanel(new GridLayout(0,2,5,5));
	 
	 inputPanel.add(new JLabel("Select Activity"));
	 activityMenu=new JComboBox<>(new String[] {"Digital Football Match","Chess Competition"});
	inputPanel.add(activityMenu);
	
	inputPanel.add(new JLabel("Student Name:"));
	nameField=new JTextField();
	inputPanel.add(nameField);
	
	inputPanel.add(new JLabel("Student ID:"));
	idField=new JTextField();
	inputPanel.add(idField);
	
	inputPanel.add(new JLabel(""));
	registerButton =new JButton("Register Student");
	inputPanel.add(registerButton);
	
	
	inputPanel.add(new JLabel("Cancel Registration (Enter ID):"));
	deleteIdField=new JTextField();
	inputPanel.add(deleteIdField);
	
	inputPanel.add(new JLabel(""));
	deleteButton =new JButton("UnRegister Student");
	inputPanel.add(deleteButton);
	
	
	inputPanel.add(new JLabel("Display Participants"));
	inputPanel.add(new JLabel(""));
	displayButton =new JButton("Display Participants");
	inputPanel.add(new JLabel(""));
	inputPanel.add(displayButton);
	
	
	
	inputPanel.add(new JLabel("Greetings"));
	helloButton=new JButton("Click Me");
	inputPanel.add(helloButton);
	
	
	displayArea =new JTextArea();
	displayArea.setEditable(false);
	JScrollPane scrollPane =new JScrollPane(displayArea);
	
	add(inputPanel,BorderLayout.NORTH);
	add(scrollPane,BorderLayout.CENTER);
	
	// EVENT REGISTRATION: Binding visual components to independent action events
	registerButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// ASYNCHRONOUS TRIGGER: Invokes registration logic on user demand
			handleRegistration();	
		}
		
	});
	// USER-DRIVEN DECOUPLING: Handling dynamic unregistration without sequential loops
	deleteButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			handleUnRegistration();	
		}
		
	});
	
	// REPAINT ROUTINE: Manually updating the visual state matrix from data structures
	displayButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			handleDisplay();	
		}
		
	});
	
	
	helloButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e ) {
			
			greetings();
			
			
		}
		
		
	});
	
	
}
	
	 private void handleRegistration() {
		 
		 Activity1 selected = getSelectedActivity();
		 String name =nameField.getText().trim();
		 String id =idField.getText().trim();
		 
		 if(name.isEmpty()|| id.isEmpty()) {
			 
			 JOptionPane.showMessageDialog(this, "Error :Name and ID fields cannot be empty!", "Input Error",JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 
		 ArrayList<Student1>list=selected.getRegisteredStudents();
		 if(selected.getActiveCapacity() >= selected.getMaxCapacity()) {
			 JOptionPane.showMessageDialog(this, "Error "+ selected.getTitle()+" Capacity Error", "Input Error",JOptionPane.ERROR_MESSAGE); 
		 }
		 else {
			 list.add(new Student1(name,id));
			 JOptionPane.showMessageDialog(this, "Successfully Registered:\nName "+name + "\nID " +id, "Success",JOptionPane.INFORMATION_MESSAGE); 
		     nameField.setText("");
		     idField.setText("");}
		      
			 
	 }
		 
		 
		 private void handleUnRegistration() {
			 
			 Activity1 selected = getSelectedActivity();
			 String idToCancle =deleteIdField.getText().trim();
			 
			 if( idToCancle.isEmpty()) {
				 
				 JOptionPane.showMessageDialog(this, "Error : Please enter a Student ID to unregister", "Input Error",JOptionPane.WARNING_MESSAGE);
				 return;
			 }
			 
			 ArrayList<Student1>list=selected.getRegisteredStudents();
			 int count=list.size();
			boolean found=false;
			
			for(int i=0;i<count;i++) {
				if(list.get(i).getStudentId().equalsIgnoreCase(idToCancle)){
					
				found=true;
				
				for(int j=i; j<count-1;j++) {
					
					list.set(j,list.get(j+1));
					
				}
				list.remove(count-1);
				
				JOptionPane.showMessageDialog(this, "Successfully UnRegistered Student with ID"+ idToCancle , "Success",JOptionPane.INFORMATION_MESSAGE); 
			     deleteIdField.setText("");
				break;
				
				}}
			
			if(!found) {
				JOptionPane.showMessageDialog(this, "Error : Student ID ["+idToCancle +"] not found in "+ selected.getTitle() , "Not Found",JOptionPane.ERROR_MESSAGE);
				
			
			}}
		
			
			private void handleDisplay() {
				
				Activity1 selected = getSelectedActivity();
				ArrayList<Student1>list=selected.getRegisteredStudents();
				
				String resultText="Activity Details :\n";
				resultText+="Tiltle: "+selected.getTitle()+"\n";
				resultText+="Current Capacity:"+selected.getActiveCapacity()+"/"+selected.getMaxCapacity()+"\n";
				resultText+="Time: "+selected.getdayAndTime()+"\n";
				
				
				
				if(list.isEmpty()) {
					
				resultText+="No student registred yet";
				}else {
					
			resultText+="Registred participants;\n";
				}
				for(int i=0;i<list.size();i++) {
					
					resultText+=(i+1)+".";
					 Person1 currentPerson =list.get(i);
					 
					 resultText+="Name: "+currentPerson.getName()+"|ID";
					 
					 if(currentPerson instanceof Student1) {
						 
						 resultText+=((Student1)currentPerson).getStudentId();
					 }
				
					 resultText+="\n";
			
				}
				 displayArea.setText(resultText);
				 
			}	 
			
			
			
			
			private void greetings() {
				
				JOptionPane.showMessageDialog(this,"Hello","greetings",JOptionPane.INFORMATION_MESSAGE);
				
				
			}
				 
			private Activity1 getSelectedActivity() {
				
			if(activityMenu.getSelectedIndex()==0) {
				return football;
			}else {
				return chess;
			}
			
			}
			
			public static void main(String[] args) {
				
				EventDrivenInterface frame=new EventDrivenInterface();
				frame.setVisible(true);
			 
			}
	 }

	


	
	




