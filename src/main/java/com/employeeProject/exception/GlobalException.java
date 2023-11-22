package com.employeeProject.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employeeProject.Response;

@RestControllerAdvice
public class GlobalException {
	@Autowired
	Response response;

	@ExceptionHandler(value = EmployeeException.class)
	public Response getExcption(EmployeeException empException) {
		response.setMsg(empException.getMessage());
		return response;
	}
}
