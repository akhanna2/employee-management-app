package com.example.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDTO;
import com.example.model.Department;
import com.example.repo.DepartmentRepo;

@Service
public class DepartmentService {
	
	private DepartmentRepo repo;
	private ModelMapper mapper;
	
	public DepartmentService(DepartmentRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private DepartmentDTO mapToDto(Department department) {
		return this.mapper.map(department, DepartmentDTO.class);
	}
	
	public DepartmentDTO addDepartment(Department department) {
		Department saved = this.repo.save(department);
		return mapToDto(saved);
	}

}
