package com.encora.db.demo.report.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReportDTO {

	private Long id;
	
	private String variableName;
	
	private String variableCode;
	
	private String category;
	
	private String value;
}
