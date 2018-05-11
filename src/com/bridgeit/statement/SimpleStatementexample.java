package com.bridgeit.statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleStatementexample {
	public static void main(String args[])
	{
		try
		{
			
			 int ts;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDetails","pushpa","pushpa1992");
			Statement stmt=conn.createStatement();
			
			ts=stmt.executeUpdate("insert into employee(empId,empName,empSalary)values(1007,'Anuj',42000)");
			System.out.println("rows affected" +ts);
			
			ts=stmt.executeUpdate("update employee set empSalary=27000 where empID=1003");
			System.out.println("rows affected" +ts);
			
			ts=stmt.executeUpdate("delete  from employee where empId=1007 ");
			System.out.println("rows affected" +ts);
			
			ResultSet rs=stmt.executeQuery("select * from employee");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ " "+ rs.getString(2)+ " " + rs.getInt(3));
			}
			System.out.println("rows affected");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("nothing to display");
		}
	}
	}


