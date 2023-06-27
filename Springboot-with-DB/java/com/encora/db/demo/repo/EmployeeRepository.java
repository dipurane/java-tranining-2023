package com.encora.db.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.db.demo.model.EmployeeModel;

@Repository("employeeRepo")
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

	
}
