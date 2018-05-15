package com.bridgeit.callable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			long start = System.currentTimeMillis();
			for(int i =1; i<1000;i++){
				String query = "insert into Employee values ("+i+",'name"+i+"')";
				stmt.execute(query);
			}
			
			System.out.println("Time Taken="+(System.currentTimeMillis()-start));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}