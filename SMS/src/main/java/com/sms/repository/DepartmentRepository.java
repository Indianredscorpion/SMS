package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
