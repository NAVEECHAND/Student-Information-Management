package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.model.Course;
import com.model.Enrollement;
import com.model.Teacher;
import com.util.DBUtil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public List<Teacher> fetchAllTeachers() throws SQLException {
		List<Teacher> l=new ArrayList<Teacher>();
        Connection conn=DBUtil.getDBConn();
		
		String sql="select * from course";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int teacher_id=rst.getInt("teacher_id");
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			String email=rst.getString("email");
			
			Teacher c=new Teacher(teacher_id,first_name,last_name,email);
			l.add(c);
		}
		
		DBUtil.dbClose();
		
		return l;
	}

	@Override
	public void assignTeacher(String cname, int tid) throws SQLException {
       Connection conn=DBUtil.getDBConn();
       String fieldd="course_name";
		
		String sql = "update course set "+fieldd+"=? where teacher_id=?";
		
         PreparedStatement pstmt = conn.prepareStatement(sql);
		
		if(fieldd.equals("course_name"))
			pstmt.setString(1,"Mysql");
	
		
		pstmt.setInt(2, tid);


		pstmt.executeUpdate();

		DBUtil.dbClose();
	}

	@Override
	public List<Course> fetchAllCourses() throws SQLException {
		List<Course> l=new ArrayList<Course>();
        Connection conn=DBUtil.getDBConn();
		
		String sql="select * from course";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int course_id=rst.getInt("course_id");
			String course_name=rst.getString("course_name");
			int credits =rst.getInt("credits");
			int teacher_id =rst.getInt("teacher_id");
			
			Course c=new Course(course_id,course_name,credits,teacher_id);
			l.add(c);
		}
		
		DBUtil.dbClose();
		
		return l;
		
	}

	@Override
	public void updateCourse(List<Course> l1, int i, String coursename) throws SQLException {
		Connection conn=DBUtil.getDBConn();
	       String fieldd="course_name";
			
			String sql = "update course set "+fieldd+"=? where course_id=?";
			
	         PreparedStatement pstmt = conn.prepareStatement(sql);
			
			if(fieldd.equals("course_name"))
				pstmt.setString(1,coursename);
		
			pstmt.setInt(2, i);

			pstmt.executeUpdate();

			DBUtil.dbClose();
		
		
	}

	@Override
	public List<Enrollement> fetchAllEnrollement() throws SQLException {
		List<Enrollement> l=new ArrayList<Enrollement>();
        Connection conn=DBUtil.getDBConn();
		
		String sql="select * from enrollements";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int enrollment_id=rst.getInt("enrollment_id");
			LocalDate enrollment_date=rst.getDate("enrollment_date").toLocalDate();
			int student_id =rst.getInt("student_id");
			int courses_id =rst.getInt("courses_id");
			
			Enrollement e=new Enrollement(enrollment_id,student_id,courses_id,enrollment_date);
			l.add(e);
		}
		
		DBUtil.dbClose();
		
		return l;
	}

	@Override
	public List<Enrollement> fetchEnrollements(int cid) throws SQLException {
		List<Enrollement> l=new ArrayList<Enrollement>();
        Connection conn=DBUtil.getDBConn();
		
		String sql="select * from enrollments where course_id=? ";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, cid);
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int enrollment_id=rst.getInt("enrollment_id");
			LocalDate enrollment_date=rst.getDate("enrollment_date").toLocalDate();
			int student_id =rst.getInt("student_id");
			int courses_id =rst.getInt("course_id");
			
			Enrollement e=new Enrollement(enrollment_id,student_id,courses_id,enrollment_date);
			l.add(e);
		}
		
		DBUtil.dbClose();
		
		return l;
	}

	@Override
	public String getTeacher(Course c) throws SQLException {
			Connection conn=DBUtil.getDBConn();
			
			String sql="select t.first_name,t.last_name from course c join teacher t on c.teacher_id = t.teacher_id where course_id=? ";
			
	         PreparedStatement pstmt = conn.prepareStatement(sql);
			
	         pstmt.setInt(1, c.getCourse_id());
	         ResultSet rst=pstmt.executeQuery();
	         String teachername = "";
	         if (rst.next()) {
	             teachername = rst.getString("first_name");
	             teachername += rst.getString("last_name");
	         }
	         return teachername;
	}
	
}