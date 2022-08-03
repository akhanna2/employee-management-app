package com.example.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDTO;
import com.example.model.Employee;
import com.example.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private EmployeeRepo repo;
	private ModelMapper mapper;
	
	public EmployeeService(EmployeeRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private EmployeeDTO mapToDTO(Employee employee) {
		return this.mapper.map(employee, EmployeeDTO.class);
	}
	
	public EmployeeDTO addEmployee(Employee employee) {
		Employee saved = this.repo.save(employee);
		return mapToDTO(saved);
	}

}
