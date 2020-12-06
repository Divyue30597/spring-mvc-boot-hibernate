package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcConnection {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to Database... " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connected Successfully!! " + myConn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
