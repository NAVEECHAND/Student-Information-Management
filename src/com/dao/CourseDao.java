package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Course;
import com.model.Enrollement;
import com.model.Teacher;

public interface CourseDao {

	
		public List<Teacher> fetchAllTeachers() throws SQLException;

		public void assignTeacher(String cname, int tid) throws SQLException;

		public List<Course> fetchAllCourses() throws SQLException;

		public void updateCourse(List<Course> l1, int i, String coursename) throws SQLException;

		public List<Enrollement> fetchAllEnrollement() throws SQLException;

		public List<Enrollement> fetchEnrollements(int cid) throws SQLException;

		public String getTeacher(Course c) throws SQLException;


	}
