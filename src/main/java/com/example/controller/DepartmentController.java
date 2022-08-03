package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DepartmentDTO;
import com.example.model.Department;
import com.example.service.DepartmentService;

@RestController
public class DepartmentController {

	private DepartmentService service;

	public DepartmentController(DepartmentService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("addDepartment")
	public DepartmentDTO addDepartment(@RequestBody Department department) {
		return this.service.addDepartment(department);
	}
	
}
