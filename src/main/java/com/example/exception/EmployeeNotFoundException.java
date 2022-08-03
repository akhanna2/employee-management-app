package com.example.exception;

import javax.persistence.EntityNotFoundException;

public class EmployeeNotFoundException extends EntityNotFoundException{
	public EmployeeNotFoundException() {}
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
