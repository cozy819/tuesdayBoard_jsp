package com.green.tuesday.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbuid  = "tuesday";
	private String dbpwd  = "1234";
	
	private Connection connection = null;
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, dbuid, dbpwd);			
		
		} catch (SQLException e) {
			e.printStackTrace();			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
		return connection;
	
	}

	
	public void close() {
		try {
			if(connection != null) connection.close();
		
		} catch (SQLException e) {			
			e.printStackTrace();
		
		}
	
	}
	
}