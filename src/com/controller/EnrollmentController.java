package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.model.Enrollement;
import com.model.Student;
import com.service.EnrollmentService;
import com.service.StudentService;

public class EnrollmentController {
	public static void main(String [] args) 
	{
		Scanner sc=new Scanner(System.in);
		StudentService ss=new StudentService();
		EnrollmentService es=new EnrollmentService();
		while(true)
		{
			System.out.println("Enrollment");
			System.out.println("1.to get student with enrollment");
			System.out.println("2.to get course with enrollment");
			int input=sc.nextInt();
			switch(input)
			{
			case 1:
				try {
					List<Enrollement> l=ss.fetchAllEnrollment();
					List<Student> l1=ss.fetchAllStudent();
					
					List<Student> sl=es.studentEnroll(l,l1);
					
					ListIterator<Student> li=sl.listIterator();
					while(li.hasNext())
					{
						System.out.println(li.next());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
