package com.bridgeit.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		 Connection conn=null;
		String url="jdbc:mysql://localhost:3306/EmployeeDetails";
		String username="pushpa";
		String password="pushpa1992";
			 Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);
			
			 return conn;
	}
}
