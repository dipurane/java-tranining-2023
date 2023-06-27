package com.encora.db.demo.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.encora.db.demo.report.dao.ReportRepository;
import com.encora.db.demo.report.dto.ReportDTO;
import com.encora.db.demo.report.model.ReportModel;
import com.encora.db.demo.report.service.ReportService;

@Service("reportService")
public class ReportServiceImpl implements ReportService{

	
	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	@Cacheable("reportCache")
	public List<ReportDTO> getReportData() {
		List<ReportModel> modelList = reportRepository.findAll();
		List<ReportDTO> reportDTOList = new ArrayList<ReportDTO>(modelList.size());
		ReportDTO dto = null;
		for (ReportModel model : modelList) {
			dto = new ReportDTO();
			BeanUtils.copyProperties(model, dto);
			reportDTOList.add(dto);
		}
		return reportDTOList;
	}

}
