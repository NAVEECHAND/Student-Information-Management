package com.model;

import java.time.LocalDate;

public class Student {
   private int student_id;
   private String First_name;
   private String Last_name;
   private LocalDate dob;
   private String email;
   private String phone_number;
   
   public Student(int student_id, String first_name, String last_name, LocalDate dob, String email, String phone_number) {
		super();
		this.student_id = student_id;
		First_name = first_name;
		Last_name = last_name;
		this.dob = dob;
		this.email = email;
		this.phone_number = phone_number;
	}
   
   public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
   
   

public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getFirst_name() {
	return First_name;
}
public void setFirst_name(String first_name) {
	First_name = first_name;
}
public String getLast_name() {
	return Last_name;
}
public void setLast_name(String last_name) {
	Last_name = last_name;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}

@Override
public String toString() {
	return "Student [student_id=" + student_id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", dob="
			+ dob + ", email=" + email + ", phone_number=" + phone_number + "]";
}


}
