package com.encora.db.demo.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.encora.db.demo.report.dto.ActivityDTO;
import com.encora.db.demo.report.dto.ReportDTO;
import com.encora.db.demo.report.service.ReportService;

@RestController
@RequestMapping("/api/v1/data")
public class ReportController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ReportService reportService;
	
	
	@GetMapping("/report")
	public List<ReportDTO> getReportData(){
		
		return reportService.getReportData();
	}
	
	@GetMapping("/whattodo")
	public String getActivity() {
		
		ActivityDTO dto = restTemplate.getForObject("https://www.boredapi.com/api/activity", ActivityDTO.class);
		String response = "If you are bored you can "+ dto.getActivity() + " and it requires only "+ dto.getParticipants() + " participants"; 
		return response;
	}
}
