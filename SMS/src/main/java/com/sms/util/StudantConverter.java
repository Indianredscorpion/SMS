package com.sms.util;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.entity.Studant;
import com.sms.model.StudantDTO;

@Component
public class StudantConverter {

	//convert Studant  entity into Studant DTO
	public StudantDTO convertToSmpDTO(Studant smp)
	{
		StudantDTO sDto = new StudantDTO();
		if(smp!=null)
		{
			BeanUtils.copyProperties(smp, sDto);
		}
		return sDto;
	}
	
	//convert StudantDTO to Studant entity
	public Studant convertToSmpEntity(StudantDTO sDto)
	{
		Studant Smp = new Studant();
		if(sDto!=null)
		{
			BeanUtils.copyProperties(sDto, Smp);
		}
		return Smp;
	}

	

	
}
