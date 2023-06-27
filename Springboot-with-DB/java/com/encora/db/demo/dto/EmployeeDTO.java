package com.encora.db.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDTO {
	
	private int employeeId;

	private String employeeName;

	private String gender;

	private Boolean pf;

	private Boolean graduity;

	private Boolean mealCard;

	private Boolean nps;

	private Boolean medilcaim;

	private String officeLocation;
	
}