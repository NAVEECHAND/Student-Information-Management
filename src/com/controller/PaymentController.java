package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.model.Payment;
import com.model.Student;
import com.service.StudentService;
public class PaymentController {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		StudentService ss=new StudentService();
		
		while(true)
		{
			System.out.println("Payment");
			System.out.println("1.to get student associated with payments");
			System.out.println("2.get payment amount");
			System.out.println("3.get payment date");
			int input=sc.nextInt();
			switch(input)
			{
			case 1:
				
				try {
					List<Payment> pl= ss.fetchAllPayment();
					List<Student> sl=ss.fetchAllStudent();
					
					
					List<Student> sl1=ss.Studentpay(pl,sl);
					List<Payment> pl1=ss.StudentPay1(pl,sl);
					ListIterator<Student> li= sl1.listIterator();
					ListIterator<Payment> li1=pl1.listIterator();
					
					while(li.hasNext()&& li1.hasNext())
					{
						System.out.println(li.next());
						System.out.println(li1.next());
						System.out.println();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				
				try
				{
				  List<Payment> l=ss.fetchAllPayment();
				  for(Payment p : l)
				  {
					  System.out.println(p.getPayment_id()+"  "+p.getAmount());
				  }
				  
				}
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			case 3:
				try
				{
					List<Payment> l=ss.fetchAllPayment();
					  for(Payment p : l)
					  {
						  System.out.println(p.getPayment_id()+"  "+p.getPayment_date());
					  }
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	}

}
