package com.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Studant;
import com.sms.model.StudantDTO;
import com.sms.service.StudantService;
import com.sms.util.StudantConverter;

@RestController
@RequestMapping("/api")
public class StudantController {

	@Autowired
	StudantService smpService;
	
	@Autowired
	StudantConverter converter;
	
	//build save method using REST API
	@PostMapping("/saveStudant")
	public StudantDTO saveStudant(@Valid @RequestBody StudantDTO smpDto)
	{
		final Studant smp = converter.convertToSmpEntity(smpDto);
		return smpService.saveStudant(smp);
	}
	
	//build get Studant details using id REST API
	@GetMapping("/getSmpById/{smpId}")
	public StudantDTO getSmpById(@PathVariable("smpId") int id)
	{
		return smpService.getStudantById(id);
	}
	
	//build get all Studant details using REST API
	@GetMapping("/getAllSmps")
	public List<StudantDTO> getAllStudant()
	{
		return smpService.getAllStudantDetails();
	}
	
	@PutMapping("/updatesmp/{smpId}")
	public StudantDTO updateSmp(@PathVariable("smpId") int smpId,
		 	@Valid @RequestBody StudantDTO smpDto)
	{
		final Studant smp = converter.convertToSmpEntity(smpDto);
		return smpService.updateStudantById(smpId, smp);
	}
	
	@DeleteMapping("/deleteSmp/{smpId}")
	public ResponseEntity<String> deleteSmpById(@PathVariable("smpId") int smpId)
	{
		smpService.deleteStudantById(smpId);
		return new ResponseEntity<String>("Studant details with id "+smpId+" deleted successfully.",
				HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllSmp")
	public ResponseEntity<String> deleteAllSmps()
	{
		smpService.deleteAllStudents(); 
		return new ResponseEntity<String>("All Studant details deleted successfully.",
				HttpStatus.OK);
	}
	
	@GetMapping("/getSmpByName/{name}")
	public List<StudantDTO> getStudantByName(@PathVariable("name") String name)
	{
		return smpService.getStudantUsingName(name);
	}
	
	@GetMapping("/getSmpByEmail/{email}")
	public StudantDTO getStudantByEmail(@PathVariable("email") String email)
	{
		return smpService.getStudantByEmail(email);
	}
	
	@PostMapping("/assignSmp/{smpId}/toDept/{deptId}")
	public StudantDTO assignSmpToDept(@PathVariable("smpId") int smpId,
			@PathVariable("deptId") int deptId)
	{
		return smpService.assignStudantToDept(smpId, deptId);
	}
	
}
