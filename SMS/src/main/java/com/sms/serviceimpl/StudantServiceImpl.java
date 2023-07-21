package com.sms.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Department;
import com.sms.entity.Studant;
import com.sms.entity.User;
import com.sms.entity.Role;
import com.sms.exceptions.PropertyAlreadyExistException;
import com.sms.exceptions.ResourceNotFoundException;
import com.sms.model.StudantDTO;
import com.sms.repository.DepartmentRepository;
import com.sms.repository.StudantRepository;
import com.sms.repository.RoleRepository;
import com.sms.service.StudantService;
import com.sms.util.StudantConverter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudantServiceImpl implements StudantService {

    //logger statically created
    private static final Logger log = LoggerFactory.getLogger(Studant.class);

    @Autowired
    StudantRepository smpRepository; //injecting Studant repository

    @Autowired
    RoleRepository roleRepository; //injecting role repository

    @Autowired
    DepartmentRepository deptRepository; //injecting department repository

    //injecting the converter which is used to convert entity to dto and vice versa
    @Autowired
    StudantConverter converter;

    // method used to save Studant details
    @Override
    public StudantDTO saveStudant(Studant studant) throws PropertyAlreadyExistException {
        List<Studant> Studant = smpRepository.findAll();
        for (Studant s : Studant) {
            if (s.getEmail().equals(((com.sms.entity.Studant) Studant).getEmail())) {
                log.error("Email was already present");
                throw new PropertyAlreadyExistException("Email Already exists.");
            }
            if (s.getContact().equals(((com.sms.entity.Studant) Studant).getContact())) {
                log.error("Phone Number was already present");
                throw new PropertyAlreadyExistException("Phone Number Already exists.");
            }
        }
        Role role = roleRepository.findById(2).get(); //find the object using the id and get the object
        ((User) Studant).setRole(role); //setting the object to your studant
        log.info("New studant details " + Studant.toString() + " saved at " + new Date());
        smpRepository.save(Studant); //save the studant details
        return converter.convertToSmpDTO(studant); //return studant details
    }

    //method used to fetch studant details using studant id
    @Override
    public StudantDTO getStudantById(int smpId) throws ResourceNotFoundException {
        Studant smp = smpRepository.findById(smpId).orElseThrow(() ->
                new ResourceNotFoundException("Studant", "Id", smpId));
        log.info("Studant details with id " + smpId + " was fetched at " + new Date());
        return converter.convertToSmpDTO(smp);
    }

    //method used to get all student details
    @Override
    public List<StudantDTO> getAllStudantDetails() {
        List<Studant> students = smpRepository.findAll();
        List<StudantDTO> smpDto = new ArrayList<>();
        for (Studant s : students) {
            smpDto.add(converter.convertToSmpDTO(s));
        }
        log.info("All student details were fetched at " + new Date());
        return smpDto;
    }

    @Override
    public StudantDTO updateStudantById(int studantId, Studant studant) throws ResourceNotFoundException {
        Studant existStudant = smpRepository.findById(studantId).orElseThrow(
            () -> new ResourceNotFoundException("Studant", "Id", studantId));

        //updating the existing studant details with new details
        existStudant.setSmpName(studant.getSmpName());
        existStudant.setContact(studant.getContact());
        existStudant.setSubject(studant.getSubject());
        existStudant.setDoj(studant.getDoj());
        existStudant.setEmail(studant.getEmail());
        existStudant.setMark(studant.getMark());
        existStudant.setUserName(studant.getUserName());
        existStudant.setPassword(studant.getPassword());

        //saving the updated details
        smpRepository.save(existStudant);

        log.info("Studant with id " + studantId + " has been updated to " + existStudant.toString());
        return converter.convertToSmpDTO(existStudant);
    }

    @Override
    public void deleteStudantById(int studantId) throws ResourceNotFoundException {
        Optional<Studant> opStudant = smpRepository.findById(studantId);
        Department dept = opStudant.get().getDept();
        if (dept != null) {
            dept.setTotalSmp(dept.getTotalSmp() - 1);
            deptRepository.save(dept);
        }
        if (opStudant.isPresent()) {
            smpRepository.deleteById(studantId);
        } else {
            throw new ResourceNotFoundException("Studant", "Id", studantId);
        }
    }

    @Override
    public void deleteAllStudants() {
        smpRepository.deleteAll();
    }

    @Override
    public List<StudantDTO> getStudantUsingName(String name) {
        List<Studant> students = StudantRepository.getStudantByName(name);
        List<StudantDTO> studantDto = new ArrayList<>();
        for (Studant s : students) {
            studantDto.add(converter.convertToSmpDTO(s));
        }
        return studantDto;
    }

    @Override
    public StudantDTO getStudantByEmail(String email) throws ResourceNotFoundException {
        Studant studant = StudantRepository.findByEmail(email);
        if (studant != null) {
            return converter.convertToSmpDTO(studant);
        } else {
            throw new ResourceNotFoundException("Studant", "Email", email);
        }
    }

    @Override
    public StudantDTO assignStudantToDept(int studantId, int deptId) throws ResourceNotFoundException {
        Studant studant = smpRepository.findById(studantId).orElseThrow(
            () -> new ResourceNotFoundException("Studant", "Id", studantId));

        Department dept = deptRepository.findById(deptId).orElseThrow(
            () -> new ResourceNotFoundException("Department", "Id", deptId));

        studant.setDept(dept);

        dept.setTotalSmp(dept.getTotalSmp() + 1);

        smpRepository.save(studant);
        deptRepository.save(dept);

        return converter.convertToSmpDTO(studant);
    }

	@Override
	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		
	}
}


