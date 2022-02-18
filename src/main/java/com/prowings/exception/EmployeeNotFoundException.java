package com.prowings.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeNotFoundException extends RuntimeException{
	
	String message;

	public EmployeeNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
