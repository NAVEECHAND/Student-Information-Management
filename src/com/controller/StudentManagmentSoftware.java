package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagmentSoftware
{
public static void main(String [] args) throws SQLException
{
  Scanner sc=new Scanner(System.in);
  while(true)
  {
     System.out.println("press 1 for Course Controller");
     System.out.println("press 2 for Enrollement Controller");
     System.out.println("press 3 for Payment Controller");
     System.out.println("press 4 for Student Controller");
     System.out.println("press 5 for Teacher Controller");
     int input=sc.nextInt();
     switch(input)
     {
         case 1:
           CourseController.main(args);
           break;

          case 2:
           EnrollmentController.main(args);
           break;

           case 3:
           PaymentController.main(args);
           break;

           case 4:
           StudentController.main(args);
           break;

           case 5:
           TeacherController.main(args);
           break;
     }

    
  }
}
}
