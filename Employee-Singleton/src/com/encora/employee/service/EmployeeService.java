package com.encora.employee.service;

import com.encora.employee.dto.EmployeeDTO;

public interface EmployeeService {

	public void saveEmployee(EmployeeDTO employeeDTO);
	
	public void updateEmployee(EmployeeDTO employeeDTO);
	
	public EmployeeDTO searchEmployee(EmployeeDTO employeeDTO);
	
	
	public EmployeeDTO findFirstEmployee();
	
	public EmployeeDTO findLastEmployee();
	
	
}
