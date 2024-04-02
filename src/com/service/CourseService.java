package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.model.Course;
import com.model.Enrollement;
import com.model.Teacher;

public class CourseService {
CourseDao cd=new CourseDaoImpl();
	
	public List<Enrollement> fetchAllEnrollement() throws SQLException {
		List<Enrollement> l=cd.fetchAllEnrollement();
		return l;

	};

	public List<Teacher> fetchAllTeachers() throws SQLException {
		List<Teacher> l=cd.fetchAllTeachers();
		return l;
	}

	public void assignTeacher(String cname, int tid) throws SQLException {
		cd.assignTeacher(cname,tid);
		
	}
	public List<Course> fetchAllCourses() throws SQLException {
		List<Course> l=cd.fetchAllCourses();
		return l;
	}

	public void updateCourse(List<Course> l1, int i, String coursename) throws SQLException {
		cd.updateCourse (l1, i, coursename);
		
	}

	public List<Enrollement> fetchEnrollements(int cid) throws SQLException {
		List<Enrollement> l=cd.fetchEnrollements(cid);
		return l;
	}

	public Course getCourse(List<Course> l4, int cid) {
		Course course = null;
		for(Course c: l4) {
			if(c.getCourse_id()==cid) {
				 course= c;			
			}
		}
		return course;
}

	public String getTeacher(Course c) throws SQLException {
		String t = cd.getTeacher(c);
		return t;
	}

}
