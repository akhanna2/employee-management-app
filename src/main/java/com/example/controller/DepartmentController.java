package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DepartmentDTO;
import com.example.model.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private DepartmentService service;

	public DepartmentController(DepartmentService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/addDepartment")
	public DepartmentDTO addDepartment(@RequestBody Department department) {
		return this.service.addDepartment(department);
	}
	
	@GetMapping("/allDepartments")
	public List<DepartmentDTO> allDepartments(){
		return this.service.allDepartments();
	}
	
	@PutMapping("/updateDepartment/{id}")
	public DepartmentDTO updateDepartment(@PathVariable long id, @RequestBody Department department) {
		return this.service.updateDepartment(id, department);
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	public boolean deleteDepartment(@PathVariable long id) {
		return this.service.deleteDepartment(id);
	}
	
	@GetMapping("/departmentById/{id}")
	public DepartmentDTO departmentById(@PathVariable long id) {
		return this.service.departmentById(id);
	}
	
	@GetMapping("/departmentByName/{name}")
	public List<DepartmentDTO> departmentByName(@PathVariable String name) {
		return this.service.departmentByName(name);
	}
	
	@GetMapping("/departmentByHeadOfDepartment/{name}")
	public List<DepartmentDTO> departmentByHeadOfDepartment(@PathVariable String name) {
		return this.service.departmentByHeadOfDepartment(name);
	}
	
	@PutMapping("/updateDepartmentName/{id}")
	public DepartmentDTO updateDepartmentName(@PathVariable long id, @RequestBody Department department) {
		return this.service.updateDepartmentName(id, department);
	}
	
	@PutMapping("/updateHeadOfDepartment/{id}")
	public DepartmentDTO updateHeadOfDepartment(@PathVariable long id, @RequestBody Department department) {
		return this.service.updateHeadOfDepartment(id, department);
	}
	
	@PutMapping("/updateDepartmentDescription/{id}")
	public DepartmentDTO updateDepartmentDescription(@PathVariable long id, @RequestBody Department department) {
		return this.service.updateDepartmentDescription(id, department);
	}

}
