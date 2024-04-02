package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.model.Course;
import com.model.Enrollement;
import com.model.Payment;
import com.model.Student;
import com.model.Teacher;

public interface StudentDao {
	public List<Student> fetchAllStudent()throws SQLException;

	public List<Course> fetchAllCourse() throws SQLException;

	public void updateStudent( List<Student> l, int id, String field, String newval) throws SQLException;

	public List<Payment> fetchAllPayment() throws SQLException;

	public List<Enrollement> fetchAllEnrollment() throws SQLException;

	public void makePayment(double amount, LocalDate payment_date, int sid1) throws SQLException;

	public List<Teacher> fetchAllTeachers() throws SQLException;

}
