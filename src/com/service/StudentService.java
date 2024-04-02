package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;
import com.model.Enrollement;
import com.model.Payment;
import com.model.Student;
import com.model.Teacher;
import com.dao.*;

public class StudentService {
	StudentDao sd=new StudentDaoImpl();
	
	
	public List<Student> fetchAllStudent() throws SQLException {
		List<Student> list = sd.fetchAllStudent();
		return list;
	}
	public Student getStudentById(List<Student> sl, int sid)
	{
		for(Student s: sl)
		{
			if(s.getStudent_id()== sid)
			{
				return s;
			}
		}
		return null;
	}
	public List<Course> fetchAllCourse() throws SQLException {
		List<Course> list = sd.fetchAllCourse();
		return list;
	}
	public Student enrollCourse(int sid, int cid, List<Student> sl, List<Course> cl) {
		// TODO Auto-generated method stub
		return null;
	}
	public Student updateStudent(List<Student> l, int id, String field, String newval) throws SQLException {
		sd.updateStudent(l,id,field,newval);
		return null;
	}
	public List<Payment> fetchAllPayment() throws SQLException {
		List<Payment> l=sd.fetchAllPayment();
		
		return l;
	}
	public Payment getPaymentHistory(List<Payment> li2, int sid) {
		for(Payment p:li2)
		{
			if(p.getStudent_id()==sid)
			{
				return p;
			}
		}
		return null;
	}
	public List<Enrollement> fetchAllEnrollment() throws SQLException {
	List<Enrollement> l=sd.fetchAllEnrollment();
	return l;
	}
	public List<Course> getEnrolledCourses(List<Course> li3, List<Enrollement> li4) {
		List<Course> l=new ArrayList<>();
		for(Course c1:li3)
		{
			for(Enrollement e1:li4)
			{
				if(c1.getCourse_id()== e1.getCourse_id())
				{
					l.add(c1);
					break;
				}
			}
			
		}
		return l;
	}
	public boolean makePayment(double amount, LocalDate payment_date, int sid1) throws SQLException {
		sd.makePayment(amount,payment_date,sid1);
		return true;
	}
	public List<Student> Studentpay(List<Payment> pl, List<Student> sl) {
		List<Student> sl1=new ArrayList();
		List<Payment> pl1=new ArrayList();
		for(Payment p : pl)
		{
			for(Student s : sl)
			{
				if(p.getStudent_id()== s.getStudent_id())
				{
					sl1.add(s);
					pl1.add(p);
				}
			}
		}
		return sl1;
	}
	public List<Payment> StudentPay1(List<Payment> pl, List<Student> sl) {
		List<Student> sl1=new ArrayList();
		List<Payment> pl1=new ArrayList();
		for(Payment p : pl)
		{
			for(Student s : sl)
			{
				if(p.getStudent_id()== s.getStudent_id())
				{
					sl1.add(s);
					pl1.add(p);
				}
			}
		}
		return pl1;
	}
	public List<Teacher> fetchAllTeachers() throws SQLException {
		List<Teacher> tl=sd.fetchAllTeachers();
		return tl;
	}

}
