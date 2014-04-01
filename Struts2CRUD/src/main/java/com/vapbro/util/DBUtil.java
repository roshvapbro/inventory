package com.vapbro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class DBUtil {

	Connection dbConnection = null;
	//PreparedStatement preparedStatement = null;
	//default values
	private static  String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static  String DB_URL = "jdbc:mysql://localhost/INVENTORY_NEW";
	private static  String DB_USER = "root";
	private static  String DB_PASSWORD = "root123";
 
	
	static{
		readPropertyFile();
	}
	
	public static Connection getDBConnection() {
		 
		Connection dbConnection = null;
		
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(
                            DB_URL, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
	public static void readPropertyFile(){
		ResourceBundle rb = ResourceBundle.getBundle("system");//systems.properties file
		Enumeration <String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			System.out.println("Key::" + key + " value:: " + value);
				
			if(key.equalsIgnoreCase("db.driver")){
				DB_DRIVER = value;
			}else if(key.equalsIgnoreCase("db.user")){
				DB_USER=value;
			}else if(key.equalsIgnoreCase("db.password")){
				DB_PASSWORD=value;
			}
		}
	}
	
	
	
}
