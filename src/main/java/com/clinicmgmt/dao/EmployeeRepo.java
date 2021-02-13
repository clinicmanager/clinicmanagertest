package com.clinicmgmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.clinicmgmt.model.Employee;

@Component
public interface EmployeeRepo extends JpaRepository<Employee, String> {

	List<Employee> findByUsername(String username);
	
	
}
