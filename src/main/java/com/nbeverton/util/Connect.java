package com.nbeverton.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private static Connection connect;
	public static final String URL_CONNECT = "jdbc:mysql://localhost/InfoTeraJSF";
	public static final String USER = "root";
	public static final String PASSWORD = "12345678";
	
	

	public static Connection getConnect() {
		if (connect == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connect = DriverManager.getConnection(URL_CONNECT, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		return connect;
	}
	
	public static void closeConnect() {
		if (connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connect = null;
		}
	}
	
	
}
