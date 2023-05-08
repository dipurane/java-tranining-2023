package com.encora.employee.controller;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.view.EmployeeFrame;

public class EmployeeHandler implements ActionListener {

	EmployeeFrame ef ;
	public EmployeeHandler(EmployeeFrame employeeFrame) {
		ef= employeeFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand().toLowerCase();
		EmployeeDTO dto = getEmployeeData(ef);
		switch(action) {
		case "save": 
					saveOrUpdate(dto);
			        break;
		case "update":
			
			saveOrUpdate(dto);
					break;
			          
			        
		}
	}
	
	public void saveOrUpdate(EmployeeDTO empDto) {
		// this will save or update in DB
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
