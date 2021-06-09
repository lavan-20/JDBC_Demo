package com.lav.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnectionManager {
	
	private final String url;
	private final Properties properties = new Properties();
	
	public DatabaseConnectionManager(String url, String userName, String password) {
		// TODO Auto-generated constructor stub
		this.url = url;
		properties.setProperty("user",userName);
		properties.setProperty("password",password);
	}
	
	public Connection getConnection() throws SQLException {
		 return DriverManager.getConnection(url, properties);
	}

}
