package com.bridgeit.callable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgeit.statement.JdbcConnection;


public class LoginExample {

	public static void main(String arh[])
	{
		Scanner scanner=new Scanner(System.in);
		String email;
		String password;
		try
		{
			Connection con=JdbcConnection.getConnection();
			System.out.println("enter the email id");
			email=scanner.nextLine();
			System.out.println("Enter password");
			password=scanner.nextLine();
//			
			
			Statement stmt=con.createStatement();
			String sql="select email,password from user1 where email='" + email + "' and password='" + password + "'";
			
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				System.out.println("Successfully logged in, username: " + rs.getString("email"));
			} else {
				System.out.println("Invalid credentials");
			}
			con.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
