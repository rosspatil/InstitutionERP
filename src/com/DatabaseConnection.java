package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
static Connection con=null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","roshan","hibuddy");
		return con;
	}

}
