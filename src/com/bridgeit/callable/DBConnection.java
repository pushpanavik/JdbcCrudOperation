package com.bridgeit.callable;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
public static Connection getConnection()
{
	Properties ps=new Properties();
	FileInputStream fis=null;
	Connection con=null;
	try
	{
		fis=new FileInputStream("/home/bridgeit/test/JdbcCrudOperation/src/db.properties");
		ps.load(fis);
		
		// loads the Driver Class
		Class.forName(ps.getProperty("DB_DRIVER_CLASS"));
		
		//create connection now
		con=DriverManager.getConnection(ps.getProperty("DB_URL"),
	ps.getProperty("DB_USERNAME"), ps.getProperty("DB_PASSWORD"));
	}catch(IOException e)
	{
		e.printStackTrace();
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return con;
}
}
