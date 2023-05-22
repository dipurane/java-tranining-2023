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
				if(searchResult.getEmployeeID()>0) {
				refreshEmployeeForm(searchResult);
				}
				  else {
					System.out.println("The result you are looking for doesnt exist");

				}
			   break;
			   
		case  "delete":
				
			  break;
			  
		case  "first":
			   	dto = employeeService.findFirstEmployee();
			   	refreshEmployeeForm(dto);
			   break;
			   
		case  "last":
		   	dto = employeeService.findLastEmployee();
		   	refreshEmployeeForm(dto);
		   break;
		   
		   
		   
		  
		}
	}
	
	
	
	public EmployeeDTO getEmployeeData(EmployeeFrame ef) {

		EmployeeDTO empDTO = new EmployeeDTO();
		if(!ef.getEmployeeIdTxt().getText().equals("")) {
		empDTO.setEmployeeID(Integer.parseInt(ef.getEmployeeIdTxt().getText()));
		}
		empDTO.setEmployeeName( ef.getEmployeeNameTxt().getText());
		empDTO.setGender(ef.getGenderGroup().getSelectedCheckbox().getLabel());
		empDTO.setPf(ef.getPfOption().getState());
		empDTO.setGraduity(ef.getGradutiyOption().getState());
		empDTO.setMealCard(ef.getMealCardOption().getState());
		empDTO.setOfficeLocation(ef.getOfficeLocation().getSelectedItem());
		
		System.out.println(empDTO);
		return empDTO;
	}
	
	public void refreshEmployeeForm(EmployeeDTO dto) {
		ef.getEmployeeIdTxt().setText(""+dto.getEmployeeID());
		ef.getEmployeeNameTxt().setText(dto.getEmployeeName());
		ef.getPfOption().setState(dto.getPf());
		ef.getMealCardOption().setState(dto.getMealCard());
		ef.getGradutiyOption().setState(dto.getGraduity());
		ef.getOfficeLocation().select(dto.getOfficeLocation());
		
		
	}

}
