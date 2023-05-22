package com.encora.employee.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.encora.employee.common.utils.DBHelper;
import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	Connection con;

	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) {

		try {
			DBHelper helper = DBHelper.getInstance();
			con = helper.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO emp_db.employee_info\n"
					+ "(employee_name, gender, pf, graduity, meal_card, office_location)\n"
					+ "VALUES(?, ?, ?, ?, ?, ?);");
			ps = copyFromDTOToDatabase(ps, employeeDTO);
			ps.execute();

			// Statement stmt = con.createStatement();
			/*
			 * String query = "INSERT INTO emp_db.employee_info\n" +
			 * "(employee_name, gender, pf, graduity, meal_card, office_location)\n" +
			 * "VALUES('" + employeeDTO.getEmployeeName() + "', '" + employeeDTO.getGender()
			 * + "'," + employeeDTO.getPf() + "," + employeeDTO.getGraduity() + "," +
			 * employeeDTO.getMealCard() + "," + "'" + employeeDTO.getOfficeLocation() +
			 * "')"; stmt.execute(query);
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
			DBHelper helper = DBHelper.getInstance();
			con = helper.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE emp_db.employee_info"
					+ "SET employee_name=?, gender=?, pf=?, graduity=?, meal_card=?, office_location=?"
					+ "WHERE employee_id=?");
			ps = copyFromDTOToDatabase(ps, employeeDTO);
			ps.setInt(7, employeeDTO.getEmployeeID());
			ps.execute();

		} catch (Exception e) {

		}
	}

	@Override
	public EmployeeDTO searchEmployee(EmployeeDTO employeeDTO) {
		EmployeeDTO dto = new EmployeeDTO();

		try {
			DBHelper helper = DBHelper.getInstance();
			con = helper.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT employee_id, employee_name, gender, pf, graduity, meal_card, office_location\n"
							+ "FROM emp_db.employee_info where employee_id =?");
			ps.setInt(1, employeeDTO.getEmployeeID());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				copyFromDatabaseToEmployeeDTO(rs, dto);
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}
	}

	@Override
	public EmployeeDTO findFirstEmployee() {
		EmployeeDTO dto = new EmployeeDTO();
		DBHelper helper = DBHelper.getInstance();
		con = helper.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from emp_db.employee_info",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				copyFromDatabaseToEmployeeDTO(rs, dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}

	}

	@Override
	public EmployeeDTO findLastEmployee() {
		EmployeeDTO dto = new EmployeeDTO();
		try {
			DBHelper helper = DBHelper.getInstance();
			con = helper.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from emp_db.employee_info",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			if (rs.last()) {
				copyFromDatabaseToEmployeeDTO(rs, dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}

	}

	private EmployeeDTO copyFromDatabaseToEmployeeDTO(ResultSet rs, EmployeeDTO dto) throws SQLException {

		dto.setEmployeeID(rs.getInt(1));
		dto.setEmployeeName(rs.getString(2));
		dto.setGender(rs.getNString(3));
		dto.setPf(rs.getBoolean(4));
		dto.setGraduity(rs.getBoolean(5));
		dto.setMealCard(rs.getBoolean(6));
		dto.setOfficeLocation(rs.getString(7));
		return dto;
	}

	private PreparedStatement copyFromDTOToDatabase(PreparedStatement ps, EmployeeDTO employeeDTO) throws SQLException{
		ps.setString(1, employeeDTO.getEmployeeName());
		ps.setString(2, employeeDTO.getGender());
		ps.setBoolean(3, employeeDTO.getPf());
		ps.setBoolean(4, employeeDTO.getGraduity());
		ps.setBoolean(5, employeeDTO.getMealCard());
		ps.setString(6, employeeDTO.getOfficeLocation());
		return ps;
	}
}
