package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.model.Course;
import com.model.Enrollement;
import com.model.Teacher;
import com.service.CourseService;

public class CourseController 
{
public static void main(String [] args) throws SQLException
{
	CourseService cs=new CourseService();
	Scanner sc=new Scanner(System.in);
	while(true)
	{
		System.out.println("1.Assign teacher");
		System.out.println("2.update Course info");
		System.out.println("3.Display coursee info");
		System.out.println("4.get enrollments");
		System.out.println("5.get teacher");
		System.out.println("press 0 to exit");
		int input=sc.nextInt();
		if(input==0)
		{
			System.out.println("Thank you");
			break;
		}
		switch(input)
		{
		case 1:
			List<Teacher> l=cs.fetchAllTeachers();
			System.out.println("Enter course name:");
			String cname=sc.nextLine();
			System.out.println("Enter teacher id:");
			int tid=sc.nextInt();
			cs.assignTeacher(cname,tid);
			break;
			
		case 2:
			List<Course> l1=cs.fetchAllCourses();
			System.out.println("Enter course name to be updated");
			String coursename = sc.nextLine();
			cs.updateCourse(l1,1,coursename);
			break;
					
		case 3:
			List<Course> l2 = cs.fetchAllCourses();
			ListIterator<Course> li = l2.listIterator();
			while(li.hasNext()) {
				System.out.println(li.next());
			}
			break;
			
		case 4:
			System.out.println("Enter course id: ");
			int cid = sc.nextInt();
			List<Enrollement> l3 = cs.fetchEnrollements(cid);
			ListIterator<Enrollement> li1 = l3.listIterator();
			while(li1.hasNext()) {
				System.out.println(li1.next());
			}
			break;
		
		case 5:
			List<Course> l4 = cs.fetchAllCourses();
			System.out.println("Enter course id: ");
			int cid1 = sc.nextInt();
			Course c = cs.getCourse(l4,cid1);
			String t = cs.getTeacher(c);
			System.out.println(t);
			break;
		}
				
	}
}

			
			
			
			
		}
	


