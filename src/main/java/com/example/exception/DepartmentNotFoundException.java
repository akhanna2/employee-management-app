package com.example.exception;

import javax.persistence.EntityNotFoundException;

public class DepartmentNotFoundException extends EntityNotFoundException{
	
	public DepartmentNotFoundException() {}
	public DepartmentNotFoundException(String msg) {
		super(msg);
	}

}
