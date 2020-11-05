package it.corso.accenture.connessioneDB.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection conn;
	
	//private String driver;
	
	private String dbHost;
	private String dbPort;
	
	private String dbUsername;
	private String dbPassword;
	private String dbName;
	private String dbOption;
	
	
	
	public Connection getConnection() {
		
		//this.driver = "com.mysql.cj.jdbc.Driver";
		
		this.dbHost = "127.0.0.1";
		this.dbPort = "3306";
		
		this.dbName = "biblioteca";
		this.dbUsername = "root";
		this.dbPassword = "root";
		this.dbOption = "?serverTimezone=Europe/Rome";
		
		
		String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort;
		connectionString += "/"  + dbName + dbOption;
		
		
		try {
			this.conn = DriverManager.getConnection(connectionString, dbUsername, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	
	
	
	

}
