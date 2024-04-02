package com.model;

public class Teacher {
  private int teacher_id;
  private String first_name;
  private String last_name;
  private String email;
  
  
public Teacher(int teacher_id, String first_name, String last_name, String email) {
	super();
	this.teacher_id = teacher_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
}


public Teacher() {
	super();
	// TODO Auto-generated constructor stub
}


public int getTeacher_id() {
	return teacher_id;
}


public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}


public String getFirst_name() {
	return first_name;
}


public void setFirst_name(String first_name) {
	this.first_name = first_name;
}


public String getLast_name() {
	return last_name;
}


public void setLast_name(String last_name) {
	this.last_name = last_name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


@Override
public String toString() {
	return "Teacher [teacher_id=" + teacher_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
			+ email + "]";
}
  

  
 
}
