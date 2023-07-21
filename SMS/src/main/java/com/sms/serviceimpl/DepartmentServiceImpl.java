package com.sms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Department;
import com.sms.model.DepartmentDTO;
import com.sms.repository.DepartmentRepository;
import com.sms.service.DepartmentService;
import com.sms.util.DepartmentConverter;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@Override
	public DepartmentDTO saveDepartment(Department dept) {
		deptRepository.save(dept);
		return deptConverter.convertToDeptDTO(dept);
	}

}
