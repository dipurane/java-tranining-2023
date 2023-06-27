package com.encora.db.demo.report.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encora.db.demo.report.model.ReportModel;


public interface ReportRepository extends JpaRepository<ReportModel, Long> {

}
