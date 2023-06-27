package com.encora.db.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "employee_info")
@Setter
@Getter
@Entity
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer employeeId;
	
	
	private String employeeName;
	
	@Column(name = "gender")
	private String employeeGender;
	
	private Boolean pf;
	
	private Boolean graduity;
	
	private Boolean mealCard;
	
	private String officeLocation;
	
}
