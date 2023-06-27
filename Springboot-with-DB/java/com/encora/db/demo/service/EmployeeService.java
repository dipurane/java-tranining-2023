package com.encora.db.demo.service;

import com.encora.db.demo.dto.EmployeeDTO;

public interface EmployeeService {

	public EmployeeDTO saveEmployee(EmployeeDTO dto);
	
	public EmployeeDTO findEmployeeById(Long empId) throws Exception;
	
	public void deleteEmployee(Integer employeeId);
}
