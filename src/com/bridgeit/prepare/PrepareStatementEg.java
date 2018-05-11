package com.bridgeit.prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgeit.statement.JdbcConnection;

public class PrepareStatementEg {
	static PreparedStatement ps;
	static Connection con;
	static Scanner scanner = new Scanner(System.in);
	static int i;

	public static void main(String args[]) throws SQLException, ClassNotFoundException {
	
		PrepareStatementEg ep = new PrepareStatementEg();

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
				ep.display();
				break;
			}
			System.out.println("Enter your choice");
			choice=scanner.nextInt();
		}

	}

	private void display() throws SQLException, ClassNotFoundException {

		con=JdbcConnection.getConnection();
		ps = con.prepareStatement("select * from employee");
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}

		con.close();
	}

	
	private void delete() throws SQLException, ClassNotFoundException {

		con=JdbcConnection.getConnection();
		ps = con.prepareStatement("delete from employee where empId=?");
		
		System.out.println("Enter the employee ID");
		int empID = scanner.nextInt();
		ps.setInt(1, empID);
		i = ps.executeUpdate();

		con.close();
		System.out.println(i + "records deleted");
	}

	private void update() throws SQLException, ClassNotFoundException {

		con=JdbcConnection.getConnection();
		ps = con.prepareStatement("update employee set empName=? where empID=?");
		
		System.out.println("Enter the employee ID");
		int empID = scanner.nextInt();
		System.out.println("Enter the employee new name ");
		String empName = scanner.next();
		ps.setString(1, empName);
		ps.setInt(2, empID);
		i = ps.executeUpdate();
		con.close();
		System.out.println(i + "records updated");

	}

	private void insert() throws SQLException, ClassNotFoundException {

		con=JdbcConnection.getConnection();
		ps = con.prepareStatement("insert into employee values(?,?,?)");
		
		System.out.println("Enter the employee name");
		String empName = scanner.next();
		System.out.println("Enter the employee ID");
		int empID = scanner.nextInt();
		System.out.println("Enter the employee Salary");
		int empSalary = scanner.nextInt();
		ps.setInt(3, empSalary);
		ps.setString(2, empName);
		ps.setInt(1, empID);
		i=ps.executeUpdate();
		con.close();
		System.out.println(i + "records inserted");

	}

}
