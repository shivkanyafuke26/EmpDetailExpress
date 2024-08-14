package com.emp.model;

public class EmployeeData {

	private int id;
	private String ename;
	private double sal;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
		public int getId()
		{
			return id;
		}
		public void setId(int id)
		{
			this.id=id;
		}
		public String getEname()
		{
			return ename;
		}
		public void setEname(String ename)
		{
			this.ename=ename;
		}
		public double getSal()
		{
			return sal;
		}
		public void setSal(double sal)
		{
			this.sal=sal;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Id : "+id+" Ename : "+ename+" Salary : "+sal;
		}
}
