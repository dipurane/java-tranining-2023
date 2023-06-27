package com.encora.test.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class DBConnector {

	public Connection getConnection() {
		Connection con =null;
		try {
		DriverManager.registerDriver(new Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3000/emp_db","root","root123");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
