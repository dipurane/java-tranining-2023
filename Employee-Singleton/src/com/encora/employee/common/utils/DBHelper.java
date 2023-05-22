package com.encora.employee.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class DBHelper {

	 private static DBHelper helper = new DBHelper();
	 private DBHelper() {
		 
	 }
	 public static DBHelper getInstance() {
		 if(helper ==null) {
			 helper = new DBHelper();
		 }
		 return helper;
	 }
	
	public Connection getConnection() {
		Connection con =null;
		try {

			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3000/emp_db", "root", "root123");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return con;
		}
	}
}
