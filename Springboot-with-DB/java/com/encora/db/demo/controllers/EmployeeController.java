package com.encora.db.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encora.db.demo.dto.EmployeeDTO;
import com.encora.db.demo.service.EmployeeService;

@RequestMapping("/api/v1")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService; 
	
	

	@PostMapping("/employee")
	public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO dto) {

		return employeeService.saveEmployee(dto);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Integer empId) {
		this.employeeService.deleteEmployee(empId);
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeInfo(@PathVariable("employeeId") Long empId ) {
		System.out.println("Fetching record for employee"+ empId);
		EmployeeDTO dto  = null;
		try {
		dto = employeeService.findEmployeeById(empId);
		return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	 return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.NOT_FOUND);
	}
	
	
	
}
