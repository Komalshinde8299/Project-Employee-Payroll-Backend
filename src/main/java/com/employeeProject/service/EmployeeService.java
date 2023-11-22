package com.employeeProject.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeProject.dto.EmployeeDto;
import com.employeeProject.exception.EmployeeException;
import com.employeeProject.model.Employee;
import com.employeeProject.repository.EmployeeRepo;
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	ModelMapper modelMaper;
	

	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		if(empRepo.findByName(employeeDto.getName()) != null) {
			throw new EmployeeException("Employee details already present");
		}
		Employee emp = modelMaper.map(employeeDto, Employee.class);
		empRepo.save(emp);
		
		
		return emp;
	}


	@Override
	public EmployeeDto getName(String name) {
		if(empRepo.findByName(name) == null) {
			throw new EmployeeException("Employee with this name not found");
		}else {
			Employee emp = empRepo.findByName(name);
			
			EmployeeDto empDto = modelMaper.map(emp, EmployeeDto.class);
			return empDto;

		}
	}


	@Override
	public Employee updateEmployee(Employee emp, int id) {
		if(empRepo.findById(id) == null) {
			throw new EmployeeException("Employee with this name not found for update");
		}else {
			emp.setId(id);
			empRepo.save(emp);
			return emp;
//			Employee exestingEmp = empRepo.findByName(name);
//			
//			exestingEmp.setName(exestingEmp.getName());
//			empRepo.save(emp);
			
//			EmployeeDto empDto = modelMaper.map(emp, EmployeeDto.class);
			

		}
		
	}


	@Override
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
		
	}


//	@Override
//	public List<EmployeeDto> getAllEmployee() {
//	List<Employee> list = empRepo.findAll();
//	List<EmployeeDto> listdto = new ArrayList<>();
//	for(Employee emp : list) {
//		EmployeeDto employeeDto = modelMaper.map(emp, EmployeeDto.class);
//		listdto.add(employeeDto);
//		
//	}
//	return listdto;
	
	public List<Employee> getAllEmployee() {
	    List<Employee> list = empRepo.findAll();
	    return list;
	}

	

}
