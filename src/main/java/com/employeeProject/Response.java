package com.employeeProject;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Response {
	String msg;
	Object obj;

}
