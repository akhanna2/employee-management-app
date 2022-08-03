package com.example.dto;

import java.util.Set;

import com.example.model.Employee;

public class DepartmentDTO {
	private Long Id;
	
	private String departmentName;
	
	private String headOfDepartment;
	
	private String description;
	
	private Set<Employee> employees;

	public DepartmentDTO(Long id, String departmentName, String headOfDepartment, String description,
			Set<Employee> employees) {
		super();
		Id = id;
		this.departmentName = departmentName;
		this.headOfDepartment = headOfDepartment;
		this.description = description;
		this.employees = employees;
	}

	public DepartmentDTO() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
