package com.sms.service;

import com.sms.entity.Department;
import com.sms.model.DepartmentDTO;

public interface DepartmentService {

	DepartmentDTO saveDepartment(Department dept);
}
