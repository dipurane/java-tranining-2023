package com.encora.employee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.encora.employee.dto.EmployeeDTO;
import com.encora.employee.view.EmployeeFrame;

public class Entry {

	public static List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
	public static void main(String argsp[]) {
		new EmployeeFrame();
	}
}
