package com.emp.view;

import java.util.List;
import java.util.Scanner;

import com.emp.controller.Employee_Controller;
import com.emp.model.EmployeeData;

public class Employee_View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("!....Welcome....!");
		do {
			System.out.println("1 Insert Employee");
			System.out.println("2 Update Employee Name by Id");
			System.out.println("3 Update Employee Salary by Id");
			System.out.println("4 Fetch Employee By Id");
			System.out.println("5 Delete Employee By Id");
			System.out.println("6 Fetch All Employee");
			System.out.println("7 Exit");
			System.out.println("Enter input : ");
		switch(sc.nextInt())
		{
		case 1:{
			EmployeeData ed= new EmployeeData();
			System.out.println("Enter the ID");
			ed.setId(sc.nextInt());
			System.out.println("Enter the Ename");
			ed.setEname(sc.next());
			System.out.println("Enter the Sal");
			ed.setSal(sc.nextDouble());
			Employee_Controller.insert(ed);
			System.out.println("Inserted");
		}
		break;
		
		case 2:{
			System.out.println("Enter the ID");
			int id=sc.nextInt();
			System.out.println("Enter the Ename");
			String newName=sc.next();
			boolean b=Employee_Controller.updateById(id,newName);
			if(b)
			{
				System.out.println("Updated....!");
			}
			else 
			{
				System.out.println("Not Updated....!");
			}	
		}
		break;
		
		case 3:{
			System.out.println("Enter the ID");
			int id=sc.nextInt();
			System.out.println("Enter the Salary");
			Double newSal=sc.nextDouble();
			boolean b=Employee_Controller.updateBySal(id,newSal);
			if(b)
			{
				System.out.println("Updated....!");
			}
			else 
			{
				System.out.println("Not Updated....!");
			}	
		}
		break;
		
		case 4:{
			System.out.println("Enter the ID");
			EmployeeData e=Employee_Controller.fetchById(sc.nextInt());
			System.out.println(e);
		}
		break;
		
		case 5:{
			System.out.println("Enter the ID");
			boolean d=Employee_Controller.deleteById(sc.nextInt());
			System.out.println(d);
			if(d)
			{
				System.out.println("Deleted....!");
			}
			else 
			{
				System.out.println("Not Deleted....!");
			}
		}
		break;
		
		case 6:{
			List<EmployeeData> li =Employee_Controller.fetchAll();
			for(EmployeeData e:li)
			{
				System.out.println(e);
			}
		}
		break;
		case 7:{
			Employee_Controller.closeConnection();
			System.out.println("Connection is closed");
		}
		break;
		default :{
			System.out.println("Wrong Input....!");
		}
		}
		System.out.println("Enter Y to continue");
		}while("y".equalsIgnoreCase(sc.next()));
		
		}
	}
//what is Api give example
//what is JDBC
//WHAT is JDBD Driver
//types of jdbc driver
//steps of jdbc
//what is resultset, why we use it
//how to create statement , explain it
//how to create connection explain it
//how to load the driver explain it
//what is class loading
//what is jar file
//how to execute query
//explain all methods
//what is the retun type of executeQuery method
//how to execute dynamic query, what is delimeter or placeholder
//how to store data inside delimeter by using setX method
//what is the need of closing the connection
