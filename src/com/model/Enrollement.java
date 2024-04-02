package com.model;

import java.time.LocalDate;

public class Enrollement 
{
	private int enrollment_id;
	private int student_id;
	private int course_id;
	private LocalDate enrollment_date;
	
	public Enrollement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollement(int enrollment_id, int student_id, int course_id, LocalDate enrollment_date) {
		super();
		this.enrollment_id = enrollment_id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.enrollment_date = enrollment_date;
	}

	public int getEnrollment_id() {
		return enrollment_id;
	}

	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public LocalDate getEnrollment_date() {
		return enrollment_date;
	}

	public void setEnrollment_date(LocalDate enrollment_date) {
		this.enrollment_date = enrollment_date;
	}

	@Override
	public String toString() {
		return "Enrollement [enrollment_id=" + enrollment_id + ", student_id=" + student_id + ", course_id=" + course_id
				+ ", enrollment_date=" + enrollment_date + "]";
	}
	
	
	
	
	
	
}