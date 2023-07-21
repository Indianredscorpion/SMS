package com.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.entity.Department;
import com.sms.entity.Studant;
import com.sms.model.DepartmentDTO;
import com.sms.model.StudantDTO;

@Component
public class DepartmentConverter {

	//convert Studant  entity into Studant DTO
		public DepartmentDTO convertToDeptDTO(Department dept)
		{
			DepartmentDTO deptDto = new DepartmentDTO();
			if(dept!=null)
			{
				BeanUtils.copyProperties(dept, deptDto);
			}
			return deptDto;
		}
		
		//convert StudantDTO to Studant entity
		public Department convertToDeptEntity(DepartmentDTO deptDto)
		{
			Department dept = new Department();
			if(deptDto!=null)
			{
				BeanUtils.copyProperties(deptDto, dept);
			}
			return dept;
		}
}
