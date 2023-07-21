package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Department;
import com.sms.model.DepartmentDTO;
import com.sms.service.DepartmentService;
import com.sms.util.DepartmentConverter;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	@Autowired
	DepartmentConverter deptConverter;

	@PostMapping("/saveDept")
	public DepartmentDTO saveDepartment(@Valid @RequestBody DepartmentDTO deptDTO)
	{
		Department dept = deptConverter.convertToDeptEntity(deptDTO);
		return deptService.saveDepartment(dept);
	}

}
