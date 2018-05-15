package com.bridgeit.callable;

public class ConnectionWithThread {
	String className="com.mysql.jdbc.Driver";
	
	Class theClass=null;{
	try
	{
		Thread thread=Thread.currentThread();
		theClass=Thread.currentThread().getContextClassLoader().loadClass(className);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public static void main(String args[])
	{
		
	}

}
