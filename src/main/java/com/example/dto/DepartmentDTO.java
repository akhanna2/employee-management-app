package com.example.dto;

import java.util.List;

import com.example.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {
	private long Id;
	
	private String departmentName;
	
	private String headOfDepartment;
	
	private String description;
	
	private List<Employee> employees;
}
