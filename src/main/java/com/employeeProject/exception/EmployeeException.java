package com.employeeProject.exception;

public class EmployeeException extends RuntimeException{
	private String msg;

	public EmployeeException(String massage) {
		super(massage);
		
	}
	

}
