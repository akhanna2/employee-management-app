package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDTO;
import com.example.exception.DepartmentNotFoundException;
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
	
	private DepartmentDTO mapToDTO(Department department) {
		return this.mapper.map(department, DepartmentDTO.class);
	}
	
	public DepartmentDTO addDepartment(Department department) {
		Department saved = this.repo.save(department);
		return mapToDTO(saved);
	}
	
	public List<DepartmentDTO> allDepartments(){
		return this.repo.findAll().stream().map(this::mapToDTO).toList();
	}
	
	public DepartmentDTO updateDepartment(long id, Department department) {
		Optional<Department> tempDepartment = Optional.of(this.repo.findById(id)).orElseThrow(DepartmentNotFoundException::new);
		Department existingDepartment = tempDepartment.get();
		
		existingDepartment.setDepartmentName(department.getDepartmentName());
		existingDepartment.setHeadOfDepartment(department.getHeadOfDepartment());
		existingDepartment.setDescription(department.getDescription());
		existingDepartment.setEmployees(department.getEmployees());
		
		Department updated = this.repo.save(existingDepartment);
		return mapToDTO(updated);
	}
	
	public boolean deleteDepartment(long id) {
		this.repo.findById(id).orElseThrow(DepartmentNotFoundException::new);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public DepartmentDTO departmentById(long id) {
		Department found = this.repo.findById(id).orElseThrow(DepartmentNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	public List<DepartmentDTO> departmentByName(String name){
		List<Department> found = this.repo.findByDepartmentName(name);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<DepartmentDTO> departmentByHeadOfDepartment(String name){
		List<Department> found = this.repo.findByHeadOfDepartment(name);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public DepartmentDTO updateDepartmentName(long id, Department department) {
		Optional<Department> tempDepartment = Optional.of(this.repo.findById(id)).orElseThrow(DepartmentNotFoundException::new);
		Department existingDepartment = tempDepartment.get();
		
		existingDepartment.setDepartmentName(department.getDepartmentName());
		
		Department updated = this.repo.save(existingDepartment);
		return mapToDTO(updated);
	}
	
	public DepartmentDTO updateHeadOfDepartment(long id, Department department) {
		Optional<Department> tempDepartment = Optional.of(this.repo.findById(id)).orElseThrow(DepartmentNotFoundException::new);
		Department existingDepartment = tempDepartment.get();
		
		existingDepartment.setHeadOfDepartment(department.getHeadOfDepartment());
		
		Department updated = this.repo.save(existingDepartment);
		return mapToDTO(updated);
	}
	
	public DepartmentDTO updateDepartmentDescription(long id, Department department) {
		Optional<Department> tempDepartment = Optional.of(this.repo.findById(id)).orElseThrow(DepartmentNotFoundException::new);
		Department existingDepartment = tempDepartment.get();
		
		existingDepartment.setDescription(department.getDescription());
		
		Department updated = this.repo.save(existingDepartment);
		return mapToDTO(updated);
	}

}
