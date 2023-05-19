package com.encora.employee.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.service.EmployeeService;
import com.encora.employee.service.impl.EmployeeServiceImpl;
import com.encora.employee.view.EmployeeFrame;

public class EmployeeHandler implements ActionListener {

	EmployeeFrame ef ;
	EmployeeService employeeService;
	public EmployeeHandler(EmployeeFrame employeeFrame) {
		ef= employeeFrame;
		employeeService = new EmployeeServiceImpl();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand().toLowerCase();
		EmployeeDTO dto = getEmployeeData(ef);
		switch(action) {
		case "save": 
				employeeService.saveEmployee(dto);
			        break;
		case "update":
			System.out.println("update Clicked");
			
				
					break;
		case "search":
				EmployeeDTO searchResult = employeeService.searchEmployee(dto);
				System.out.println("This is queried from DB" + searchResult);
				// refresh your UI
			   break;
			   
		case  "delete":
			System.out.println("Delete Clicked");
			  break;
			        
		}
	}
	
	
	
	public EmployeeDTO getEmployeeData(EmployeeFrame ef) {

		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setEmployeeID(Integer.parseInt(ef.getEmployeeIdTxt().getText()));
		empDTO.setEmployeeName( ef.getEmployeeNameTxt().getText());
		empDTO.setGender(ef.getGenderGroup().getSelectedCheckbox().getLabel());
		empDTO.setPf(ef.getPfOption().getState());
		empDTO.setGraduity(ef.getGradutiyOption().getState());
		empDTO.setMealCard(ef.getMealCardOption().getState());
		empDTO.setOfficeLocation(ef.getOfficeLocation().getSelectedItem());
		
		System.out.println(empDTO);
		return empDTO;
	}

}
