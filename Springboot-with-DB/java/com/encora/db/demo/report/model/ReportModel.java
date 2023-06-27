package com.encora.db.demo.report.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="report_table")
@Getter
@Setter
public class ReportModel {

	@Id
	private Long id;
	
	private String variableCode;
	
	private String variableName;
	
	private String category;
	
	private String value;
}
