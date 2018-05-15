package com.bridgeit.callable;
/****************************************************************************************
 @Purpose: To demonstrate CallableStatement using Stored Procedures.
 @author: Pushpa Navik
 @version : 1.0
 @since: 12-05-2018
 ****************************************************************************************/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgeit.statement.JdbcConnection;

public class CallableStmtE {
	static Connection con = null;
	static int i;
	static Scanner scanner = new Scanner(System.in);
	static CallableStmtE ep = new CallableStmtE();

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
				ep.display();
				break;
			}
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
		}

	}

	@SuppressWarnings("unused")
	private void display() throws SQLException, ClassNotFoundException {
		con = JdbcConnection.getConnection();
		CallableStatement stmt = con.prepareCall("{call displayRecord()}");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}

	}

	private void delete() throws SQLException, ClassNotFoundException {
		con = JdbcConnection.getConnection();
		CallableStatement stmt = con.prepareCall("{call deleteRecords(?)}");

		System.out.println("Enter the employee ID");
		int empID = scanner.nextInt();
		stmt.setInt(1, empID);
		i = stmt.executeUpdate();

		System.out.println(i + "records deleted");

	}

	private void update() throws SQLException, ClassNotFoundException {

		System.out.println("1.update Id");
		System.out.println("2.update name");
		System.out.println("3.update salary");
		System.out.println("4.exit");

		System.out.println("Enter your choice");
		int choice = scanner.nextInt();
		while (choice < 4) {
			switch (choice) {
			case 1:
				ep.updateId();
				break;
			case 2:
				ep.updateName();
				break;
			case 3:
				ep.updateSalary();
				break;
			}
			System.out.println("Enter your choice ");
			choice = scanner.nextInt();
		}

	}

	private void insert() throws SQLException {

		try {
			con = JdbcConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CallableStatement stmt = con.prepareCall("{call empprocedure(?,?,?)}");
		System.out.println("Enter the employee name");
		String empName = scanner.next();
		System.out.println("Enter the employee ID");
		int empID = scanner.nextInt();
		System.out.println("Enter the employee Salary");
		int empSalary = scanner.nextInt();

		stmt.setString(2, empName);
		stmt.setInt(1, empID);
		stmt.setInt(3, empSalary);
		i = stmt.executeUpdate();

		System.out.println(i + "records inserted");
	}

	private void updateId() throws SQLException, ClassNotFoundException {
		con = JdbcConnection.getConnection();
		System.out.println("Enter the existing employee ID to update ");
		int oldId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the new  employee Id to update ");
		String newId = scanner.nextLine();

		CallableStatement stmt = con.prepareCall("{call updateEmpId(?, ?)}");
		stmt.setInt(1, oldId);
		stmt.setString(2, newId);
		// System.out.println(stmt);
		int i = stmt.executeUpdate();
		if (i > 0) {
			System.out.println(i + "employee id updated");
		} else {
			System.out.println("failed");
		}

	}

	private void updateName() throws SQLException, ClassNotFoundException {
		con = JdbcConnection.getConnection();
		System.out.println("Enter the existing employee ID to update ");
		int oldId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the new  employee name to update ");
		String name = scanner.nextLine();

		CallableStatement stmt = con.prepareCall("{call updateName(?, ?)}");
		stmt.setInt(1, oldId);
		stmt.setString(2, name);
		// System.out.println(stmt);
		int i = stmt.executeUpdate();
		if (i > 0) {
			System.out.println(i + "employee id updated");
		} else {
			System.out.println("failed");
		}

	}

	private void updateSalary() throws SQLException, ClassNotFoundException {
		con = JdbcConnection.getConnection();
		System.out.println("Enter the existing employee ID to update ");
		int oldId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the employee salary to update  ");
		int sal = scanner.nextInt();

		CallableStatement stmt = con.prepareCall("{call updateSalary(?,?)}");
		stmt.setInt(2, oldId);
		stmt.setInt(1, sal);
		int i = stmt.executeUpdate();
		if (i > 0) {
			System.out.println(i + "employee id updated");
		} else {
			System.out.println("failed");
		}
		con.close();
	}

}
