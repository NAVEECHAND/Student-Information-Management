package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.model.Course;
import com.model.Enrollement;
import com.model.Payment;
import com.model.Student;
import com.model.Teacher;
import com.util.DBUtil;


public class StudentDaoImpl implements StudentDao
{
    
	@Override
	public List<Student> fetchAllStudent() throws SQLException {
		List<Student> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();

		String sql = "select * from student";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) 
		{
			int student_id = rst.getInt("id");
			
			String First_name = rst.getString("first_name");
			String Last_name = rst.getString("last_name");
			
			LocalDate dob = rst.getDate("date_of_birth").toLocalDate();
			
			String email = rst.getString("email");
			
			String phone_number = rst.getString("phone_number");
			
			
			Student c = new Student(student_id,First_name, Last_name, dob, email, phone_number);
			list.add(c);
		}

		DBUtil.dbClose();
		return list;
	}
	
	/*public void enrollCourse(int id, String field, String newVal) throws DatabaseConnectionException, SQLException, InvalidInputException 
	{
		String fieldd=field.toLowerCase().replace(" ","_");
		if(fieldd.equals("id"))
			throw new InvalidInputException("Sorry!! Customer Id could not be updated :<");
		else
			customerDao.updateCustomer(id,fieldd,newVal);
		
	}*/
	
	@Override
	public List<Course> fetchAllCourse() throws SQLException {
		List<Course> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();

		String sql = "select * from course";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) 
		{
			int course_id = rst.getInt("course_id");
			
			String course_name = rst.getString("course_name");
			int course_code= rst.getInt("credits");
			int teacher_id = rst.getInt("teacher_id");
			
			
			
			Course a = new Course(course_id,course_name,course_code,teacher_id);
			list.add(a);
		}

		DBUtil.dbClose();
		return list;
	}

	@Override
	public void updateStudent(List<Student> l, int id,String field,String newval) throws SQLException {
		Connection conn = DBUtil.getDBConn();

		String sql = "update customer set "+field+"=? where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		if(field.equals("email"))
			pstmt.setString(1, newval);
		
		pstmt.setInt(2, id);


		pstmt.executeUpdate();

		DBUtil.dbClose();
		
	}

	@Override
	public List<Payment> fetchAllPayment() throws SQLException {
		List<Payment> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();

		String sql = "select * from payment";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) 
		{
			int payment_id = rst.getInt("payment_id");
			
		    double amount = rst.getDouble("amount");
			
			LocalDate payment_date = rst.getDate("payment_date").toLocalDate();
			
			int sid=rst.getInt("student_id");
			
			
			Payment p=new Payment(payment_id,sid,amount,payment_date);
			list.add(p);
		}

		DBUtil.dbClose();
		return list;

	}

	@Override
	public List<Enrollement> fetchAllEnrollment() throws SQLException {
		List<Enrollement> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();

		String sql = "select * from enrollments";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) 
		{
			int Enrollment_id = rst.getInt("enrollment_id");
			
			LocalDate enrollment_date = rst.getDate("enrollment_date").toLocalDate();
			
			int sid=rst.getInt("student_id");
			
			int cid = rst.getInt("courses_id");
			
			
			Enrollement e=new Enrollement(Enrollment_id,sid,cid,enrollment_date);
			list.add(e);
		}

		DBUtil.dbClose();
		return list;
		
	}

	@Override
	public void makePayment(double amount, LocalDate payment_date, int sid1) throws SQLException {
		Connection conn = DBUtil.getDBConn();
	      String sql = "insert into payment(amount,payment_date,student_id) values(?,?,?)";

	        
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setDouble(1,amount);
			pstmt.setDate(2,Date.valueOf(payment_date));
			 
			 
			pstmt.setInt(3,sid1);
			pstmt.executeUpdate();
			  DBUtil.dbClose();
		
	}

	@Override
	public List<Teacher> fetchAllTeachers() throws SQLException {
		List<Teacher> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();

		String sql = "select * from teacher";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) 
		{
			int teacher_id = rst.getInt("teacher_id");
			
			String First_name = rst.getString("first_name");
			String Last_name = rst.getString("last_name");
			String email = rst.getString("email");	
			Teacher t = new Teacher(teacher_id,First_name, Last_name,email);
			list.add(t);
		}

		DBUtil.dbClose();
		return list;
	}
	

}
