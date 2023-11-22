package com.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.employeeProject.Response;
import com.employeeProject.dto.EmployeeDto;
import com.employeeProject.model.Employee;
import com.employeeProject.service.EmployeeService;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController

@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@Autowired
	Response response;
	
	@PostMapping("/add")
	public ResponseEntity<Response> getEmployee(@RequestBody EmployeeDto employeeDto){
		empService.addEmployee(employeeDto);
		response.setMsg("Details added");
		response.setObj(employeeDto);
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
		
		}
	@GetMapping("/getByName")
	public ResponseEntity<Response> getName(@RequestParam String name) {
		EmployeeDto employeedto = empService.getName(name);
		response.setMsg("Recored by Name");
		response.setObj(employeedto);
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Response>  getUpdate(@RequestBody Employee emp, @RequestParam int id) {
		Employee employee = empService.updateEmployee(emp, id);
		response.setMsg("Record updated");
		response.setObj(employee);
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam int id) {
		empService.deleteEmployee(id);
		return"deleted ";
	}
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAllEmployee() {
		List<Employee> list = empService.getAllEmployee();
		response.setMsg("All Employee details");
		response.setObj(list);
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
		
	}
	

	
	

}
