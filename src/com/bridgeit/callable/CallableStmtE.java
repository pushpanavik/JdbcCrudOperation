package com.bridgeit.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgeit.statement.JdbcConnection;

public class CallableStmtE {
	static Connection con=null;
	static int i;
	static Scanner scanner=new Scanner(System.in);
	static CallableStmtE ep=new CallableStmtE();
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Display");

		System.out.println("Enter your choice");
		int choice = scanner.nextInt();

		while (choice < 5) {
			switch (choice) {
			case 1:
				ep.insert();
				break;
			case 2:
				ep.update();
				break;
			case 3:
				ep.delete();
				break;
			case 4:
//				ep.display();
//				break;
			}
			System.out.println("Enter your choice");
			choice=scanner.nextInt();
		}

		
		
		/*stmt.setString(2, "Abhishek");
		stmt.setInt(1, 1011);
		stmt.setInt(3, 55000);
//		int i=stmt.executeUpdate();*/
//		System.out.println(i + "records added");
//		con.close();
	}
//	private void display() {
//		con=JdbcConnection.getConnection();
//		CallableStatement stmt=con.prepareCall();
//		ResultSet rs = stmt.executeQuery();
//		while (rs.next()) {
//			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
//		}
//
//		con.close();
//		
//	}
	private void delete() {
		
		
	}
	private void update() throws SQLException {
		try {
			con = JdbcConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unused")
		CallableStatement stmt=con.prepareCall("{call updateemp(?,?,?)}" );
		
		System.out.println("Enter your choice");
		int choice = scanner.nextInt();
		while(choice < 4)
		{
			switch(choice)
			{
			case 1: ep.updateId();
					break;
			case 2: ep.updateName();
					break;
			case 3: ep.updateSalary();
					break;
			}
			System.out.println("Enter your choice ");
			choice=scanner.nextInt();
		}
		
		
		
	}
	private void insert() throws SQLException {
		
		try {
			con = JdbcConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CallableStatement stmt=con.prepareCall("{call empprocedure(?,?,?)}" );
		System.out.println("Enter the employee name");
		String empName = scanner.next();
		System.out.println("Enter the employee ID");
		int empID = scanner.nextInt();
		System.out.println("Enter the employee Salary");
		int empSalary = scanner.nextInt();
		stmt.setString(2,empName );
		stmt.setInt(1, empID);
		stmt.setInt(3, empSalary);
		i=stmt.executeUpdate();
		con.close();
		System.out.println(i + "records inserted");
	}
	private void updateId() throws SQLException
	{
		CallableStatement stmt=con.prepareCall("{call updateid(?)}");
		System.out.println("Enter the existing employee ID   ");
		@SuppressWarnings("unused")
		int empID = scanner.nextInt();
		
		System.out.println("Enter the new  employee ID to update  ");
		int empID1 = scanner.nextInt();
		
		stmt.setInt(1, empID1);
		i=stmt.executeUpdate();
		System.out.println(i +"employee id updated");
		con.close();
		
	}
	private void updateName() throws SQLException
	{
		@SuppressWarnings("unused")
		CallableStatement stmt=con.prepareCall("{call updateName(?)}");
		System.out.println("Enter the employee ID to update  ");
		@SuppressWarnings("unused")
		int empID = scanner.nextInt();
	}
	private void updateSalary()
	{
		System.out.println("Enter the employee ID to update  ");
		@SuppressWarnings("unused")
		int empID = scanner.nextInt();
	}
}
