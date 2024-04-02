package com.model;

import java.time.LocalDate;

public class Payment {
	
	private int payment_id;
	private int student_id;
	private double amount;
	private LocalDate payment_date;
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Payment(int payment_id, int student_id, double amount, LocalDate payment_date) {
		super();
		this.payment_id = payment_id;
		this.student_id = student_id;
		this.amount = amount;
		this.payment_date = payment_date;
	}


	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDate getPayment_date() {
		return payment_date;
	}


	public void setPayment_date(LocalDate payment_date) {
		this.payment_date = payment_date;
	}


	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", student_id=" + student_id + ", amount=" + amount
				+ ", payment_date=" + payment_date + "]";
	}
	
	
	
	

}
