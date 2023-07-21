package com.sms.service;

import java.util.List;

import com.sms.entity.Studant;
import com.sms.model.StudantDTO;

public interface StudantService {

    //this method is used to save student details
    StudantDTO saveStudant(Studant studant);
    //method used to fetch student details using student id
    StudantDTO getStudantById(int studantId);
    //method used to fetch all student details
    List<StudantDTO> getAllStudantDetails();
    //method used to update student details using student id
    StudantDTO updateStudantById(int studantId, Studant studant);
    //method used to delete student details using student id
    void deleteStudantById(int studantId);
    //method used to delete all student details
    void deleteAllStudents();
    //method used to fetch student details using student name
    List<StudantDTO> getStudantUsingName(String name);
    //method used to fetch student detail using email
    StudantDTO getStudantByEmail(String email);
    //method to assign a student to a department
    StudantDTO assignStudantToDept(int studantId, int deptId);
	void deleteAllStudants();

}
