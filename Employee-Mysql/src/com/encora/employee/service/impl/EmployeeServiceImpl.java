package com.encora.employee.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.service.EmployeeService;
import com.mysql.jdbc.Driver;

public class EmployeeServiceImpl implements EmployeeService {

	Connection con;
	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) {

		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3000/emp_db", "root", "root123");
			PreparedStatement ps = con.prepareStatement("INSERT INTO emp_db.employee_info\n"
					+ "(employee_name, gender, pf, graduity, meal_card, office_location)\n"
					+ "VALUES(?, ?, ?, ?, ?, ?);");
			ps.setString(1, employeeDTO.getEmployeeName());
			ps.setString(2, employeeDTO.getGender());
			ps.setBoolean(3,employeeDTO.getPf());
			ps.setBoolean(4, employeeDTO.getGraduity());
			ps.setBoolean(5, employeeDTO.getMealCard());
			ps.setString(6, employeeDTO.getOfficeLocation());
			ps.execute();
			
					
		//	Statement stmt = con.createStatement();
		/*	String query = "INSERT INTO emp_db.employee_info\n"
					+ "(employee_name, gender, pf, graduity, meal_card, office_location)\n" + "VALUES('"
					+ employeeDTO.getEmployeeName() + "', '" + employeeDTO.getGender() + "'," + employeeDTO.getPf()
					+ "," + employeeDTO.getGraduity() + "," + employeeDTO.getMealCard() + "," + "'"
					+ employeeDTO.getOfficeLocation() + "')";
			stmt.execute(query);*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		try {
		DriverManager.registerDriver(new Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3000/emp_db", "root", "root123");
		PreparedStatement ps = con.prepareStatement("UPDATE emp_db.employee_info"
				+ "SET employee_name=?, gender=?, pf=?, graduity=?, meal_card=?, office_location=?"
				+ "WHERE employee_id=?");
		ps.setString(1, employeeDTO.getEmployeeName());
		ps.setString(2, employeeDTO.getGender());
		ps.setBoolean(3,employeeDTO.getPf());
		ps.setBoolean(4, employeeDTO.getGraduity());
		ps.setBoolean(5, employeeDTO.getMealCard());
		ps.setString(6, employeeDTO.getOfficeLocation());
		ps.setInt(7, employeeDTO.getEmployeeID());
		ps.execute();
		
		}catch(Exception e) {
			
		}
	}
	@Override
	public EmployeeDTO searchEmployee(EmployeeDTO employeeDTO) {
		EmployeeDTO dto = new EmployeeDTO();
		try {
		DriverManager.registerDriver(new Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3000/emp_db", "root", "root123");
		PreparedStatement ps = con.prepareStatement("SELECT employee_id, employee_name, gender, pf, graduity, meal_card, office_location\n"
				+ "FROM emp_db.employee_info where employee_id =?");
		ps.setInt(1, employeeDTO.getEmployeeID());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			dto.setEmployeeName(rs.getString(2));
			dto.setGender(rs.getNString(3));
			dto.setPf(rs.getBoolean(4));
			dto.setGraduity(rs.getBoolean(5));
			dto.setMealCard(rs.getBoolean(6));
			dto.setOfficeLocation(rs.getString(7));
		}
		return dto;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}
	}

}
