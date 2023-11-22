package com.employeeProject.service;

import java.util.List;

import com.employeeProject.dto.EmployeeDto;
import com.employeeProject.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(EmployeeDto employeeDto);
	public EmployeeDto getName(String name);
	public Employee updateEmployee(Employee emp, int id);
	public void deleteEmployee(int id);
	public List<Employee> getAllEmployee();


	
	

}
