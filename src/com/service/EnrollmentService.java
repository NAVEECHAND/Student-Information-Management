package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Course;
import com.model.Enrollement;
import com.model.Student;
import com.dao.*;

public class EnrollmentService {



	public List<Student> studentEnroll(List<Enrollement> l, List<Student> l1) {
		List<Student> sl=new ArrayList();
		for(Enrollement e:l)
		{
			for(Student s:l1)
			{
				if(e.getStudent_id()==s.getStudent_id())
				{
					sl.add(s);
					break;
				}
			}
		}
		return sl;
	}

	public List<Course> CourseEnroll(List<Enrollement> l, List<Course> cl) {
		List<Course> cl1=new ArrayList();
		for(Enrollement e: l)
		{
			for(Course c: cl1)
			{
				if(e.getCourse_id()==c.getCourse_id())
				{
					cl1.add(c);
					break;
				}
			}
		}
		return cl1;
		
	}

}
