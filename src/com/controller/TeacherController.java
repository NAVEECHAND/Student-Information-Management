package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.model.Course;
import com.model.Teacher;
import com.service.StudentService;

public class TeacherController {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		StudentService ss=new StudentService();
		while(true)
		{
			System.out.println("1.update teacher info");
			System.out.println("2.display teacher information");
			System.out.println("3.get assigned courses");
			int input=sc.nextInt();
			switch(input)
			{
			case 1:  
				
				break;                         
			case 2:
				try 
				{
					List<Teacher> lt = ss.fetchAllTeachers();
					ListIterator<Teacher> li=lt.listIterator();
					while(li.hasNext())
					{
						System.out.println(li.next());
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					List<Teacher> lt1=ss.fetchAllTeachers();
					List<Course> cl=ss.fetchAllCourse();
					
					for(Course c :cl)
					{
						for(Teacher t: lt1)
						{
							if(c.getTeacherId()== t.getTeacher_id())
							{
								System.out.println(t.getFirst_name()+""+t.getLast_name()+" "+c.getCourse_name());
							}
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			}
		}
	}

}
