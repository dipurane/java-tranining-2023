package com.encora.db.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.db.demo.dto.EmployeeDTO;
import com.encora.db.demo.model.EmployeeModel;
import com.encora.db.demo.repo.EmployeeRepository;
import com.encora.db.demo.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO dto) {
		EmployeeModel model = new EmployeeModel();
		BeanUtils.copyProperties(dto, model);
		model.setEmployeeGender(dto.getGender());
		
		employeeRepo.save(model);
		dto.setEmployeeId(model.getEmployeeId());
		return dto;
	}

	@Override
	public EmployeeDTO findEmployeeById(Long empId)throws Exception {

		EmployeeDTO empDTO = new EmployeeDTO();
		Optional<EmployeeModel> optdto = this.employeeRepo.findById(empId.intValue());
		EmployeeModel model = optdto.get();
		BeanUtils.copyProperties(model, empDTO);
		empDTO.setGender(model.getEmployeeGender());
		
		return empDTO;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeRepo.deleteById(employeeId);
	}

}
