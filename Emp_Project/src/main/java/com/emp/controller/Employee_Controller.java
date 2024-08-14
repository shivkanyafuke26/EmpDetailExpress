package com.emp.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.model.EmployeeData;
public class Employee_Controller {
 static Connection con;
 static String url="jdbc:postgresql://localhost:5432/emp";
 static String pass="root";
 static String user="postgres";
 
 static {
	 try {
		 Class.forName("org.postgresql.Driver");
		 
		 con=DriverManager.getConnection(url,user,pass);
		 System.out.println(con);
		 }catch(ClassNotFoundException | SQLException e)
	 {
			 e.printStackTrace();
	 }
 }
 
 public static void insert(EmployeeData e)
 {
	try {
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getEname());
		ps.setDouble(3,e.getSal());
		ps.executeUpdate();
	}catch(SQLException e1) {
		e1.printStackTrace();
	}
 }
 
 public static boolean updateById(int id,String ename)
 {
	 EmployeeData emp=fetchById(id);
	 if(emp.getEname()!=null)
	 {
		try {
			 PreparedStatement ps=con.prepareStatement("update employee set ename=? where id=?");
			 ps.setString(1,ename);
			 ps.setInt(2,id);
			 ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		 return true;
	 }
		 else {
			 return false;
		 }
 }
 
 public static boolean updateBySal(int id,double sal)
 {
	 EmployeeData emp=fetchById(id);
	 if(emp.getSal()!=0)
	 {
		try {
			 PreparedStatement ps=con.prepareStatement("update employee set sal=? where id=?");
			 ps.setDouble(1,sal);
			 ps.setDouble(2,id);
			 ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		 return true;
	 }
		 else {
			 return false;
		 	}
 }
 
 public static EmployeeData fetchById(int id)
 {
	 EmployeeData e=new EmployeeData();
	 try {
		 PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
		 ps.setInt(1, id);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
			 e.setId(rs.getInt("id"));
			 e.setEname(rs.getString("ename"));
			 e.setSal(rs.getDouble("sal"));
		 }
	 }catch(SQLException e1){
		 e1.printStackTrace();
	 }
	return e;
 }
 
 public static boolean deleteById(int id)
 {
	 EmployeeData e=fetchById(id);
	 if(e.getEname()!=null)
	 {
		 try {
			 PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			 ps.setInt(1, id);
			 ps.executeUpdate();
		 }catch(SQLException e1)
		 {
			 e1.printStackTrace();
		 }
		 return true;
	 }
	 else {
		 return false;
	 }
 }
 
 public static List<EmployeeData> fetchAll()
 { 
	 List<EmployeeData> li=new ArrayList<EmployeeData>();
	 try {
		 PreparedStatement ps=con.prepareStatement("select * from employee");
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
			 EmployeeData e=new EmployeeData();
			 e.setId(rs.getInt("id"));
			 e.setEname(rs.getString("ename"));
			 e.setSal(rs.getDouble("sal"));
			 li.add(e);
		 }
	 }catch(SQLException e1){
		 e1.printStackTrace();
	 }
	return li;
 }
 public static void closeConnection()
 {
	 try {
		 con.close();
	 }catch(SQLException e){
		 e.printStackTrace();
	 }
 }
}