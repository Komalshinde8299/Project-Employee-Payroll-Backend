package com.employeeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeProject.dto.EmployeeDto;
import com.employeeProject.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	public Employee findByName(String name);
//	public void deleteByName(String name);

}
