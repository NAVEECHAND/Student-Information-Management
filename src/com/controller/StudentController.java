package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.model.Course;
import com.model.Enrollement;
import com.model.Payment;
import com.model.Student;
import com.service.StudentService;

public class StudentController {
    public static void main(String [] args) throws SQLException
    {
    	Scanner sc=new Scanner(System.in);
    	StudentService ss=new StudentService();
    	while(true)
    	{
    		System.out.println("****student managment****");
    		System.out.println("press 1 enroll course:");
    		System.out.println("press 2 update student information:");
    		System.out.println("press 3 to make payment:");
    		System.out.println("press 4 to display student information");
    		System.out.println("press 5 to get enrolled courses");
    		System.out.println("press 6 to get payment history");
    		int input=sc.nextInt();
    		if(input == 0)
    		{
    			System.out.println("Thank you !!!");
    			break;
    		}
    		
    		switch(input)
    		{
    		case 1:
    			
    		break;	
 
    		case 2:
    		List<Student> l=ss.fetchAllStudent();
    		System.out.println("Enter the id of the student to be updated");
    		int id=sc.nextInt();
    		System.out.println("Enter the field to be updated:");;
    		String field=sc.nextLine();
    		System.out.println("Enter the new value");
    		String newval=sc.nextLine();
    		Student s=ss.updateStudent(l,id,field,newval);
    		ListIterator<Student> li=l.listIterator();
    		while(li.hasNext())
    		{
    			System.out.println(li.next());
    		}	
    		break;
    		
    		case 4:
    			List<Student> l1=ss.fetchAllStudent();
    			ListIterator<Student> li1=l1.listIterator();
        		while(li1.hasNext())
        		{
        			System.out.println(li1.next());
        		}	
    		    break;
    		
    		case 6:
    			List<Payment> li2=ss.fetchAllPayment();
    			System.out.println("Enter ur student id:");
    			int sid=sc.nextInt();
    			Payment p=ss.getPaymentHistory(li2,sid);
    			System.out.println(p.getPayment_id()+" "+p.getStudent_id()+" "+p.getAmount()+" "+p.getPayment_date());
    			break;
    		case 5:
    			List<Course> li3=ss.fetchAllCourse();
    			List<Enrollement> li4=ss.fetchAllEnrollment();
    			List<Course> li5=ss.getEnrolledCourses(li3,li4);
    			ListIterator<Course> li6=li5.listIterator();
        		while(li6.hasNext())
        		{
        			System.out.println(li6.next());
        		}	
    		    break;
    		    
    		case 3:
    			System.out.println("Enter the amount:");
    			double amount=sc.nextDouble();
    			System.out.println("Enter payment date:");
    			String date=sc.nextLine();
    			LocalDate payment_date= LocalDate.parse(date);
    			System.out.println("Enter Student ID:");
    			int sid1=sc.nextInt();
    			boolean b=ss.makePayment(amount,payment_date,sid1);
    			if(b==true)
    			{
    				System.out.println("Payment successful");
    			}
    			else
    			{
    				System.out.println("Payment not successful");
    			}
    			break;
    			
    			
    			
    			
    			
    			
    		}	
    	
    	}
    	
    	
    	
    }

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
