package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDTO;
import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	@Autowired
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
	
	public List<EmployeeDTO> allEmployees(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public EmployeeDTO updateEmployee(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setDateOfBirth(employee.getDateOfBirth());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setDateJoined(employee.getDateJoined());
		existingEmployee.setRole(employee.getRole());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setSupervisor(employee.getSupervisor());
		existingEmployee.setCurrentProject(employee.getCurrentProject());
		existingEmployee.setWorkType(employee.getWorkType());
		existingEmployee.setHourlyWage(employee.getHourlyWage());
		existingEmployee.setUserName(employee.getUserName());
		existingEmployee.setPassword(employee.getPassword());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteEmployee(long id) {
		this.repo.findById(id).orElseThrow(EmployeeNotFoundException::new);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

	public boolean checkCredentials(String userName, String password) {
		boolean flag = false;
		
		if(!repo.login(userName, password).isEmpty()) {
			flag = true;
			return flag;
		} return flag;
	}
	
	public EmployeeDTO employeeById(long id){
		Employee found = this.repo.findById(id).orElseThrow(EmployeeNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	public List<EmployeeDTO> employeeByFirstName(String firstName){
		List<Employee> found = this.repo.findByFirstName(firstName);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<EmployeeDTO> employeeByLastName(String lastName){
		List<Employee> found = this.repo.findByLastName(lastName);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<EmployeeDTO> employeeByRole(String role){
		List<Employee> found = this.repo.findByRole(role);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<EmployeeDTO> employeeBySupervisor(String supervisor){
		List<Employee> found = this.repo.findBySupervisor(supervisor);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<EmployeeDTO> employeeByCurrentProject(String currentProject){
		List<Employee> found = this.repo.findByCurrentProject(currentProject);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<EmployeeDTO> employeeByWorkType(String workType){
		List<Employee> found = this.repo.findByWorkType(workType);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<EmployeeDTO> employeeByUserName(String userName){
		List<Employee> found = this.repo.findByUserName(userName);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public EmployeeDTO updateEmployeeAge(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setAge(employee.getAge());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeeRole(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setRole(employee.getRole());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeeDepartment(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setDepartment(employee.getDepartment());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeeSupervisor(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setSupervisor(employee.getSupervisor());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeeCurrentProject(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setCurrentProject(employee.getCurrentProject());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeeWorkType(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setWorkType(employee.getWorkType());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeeHourlyWage(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setHourlyWage(employee.getHourlyWage());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeeUserName(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setUserName(employee.getUserName());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
	
	public EmployeeDTO updateEmployeePassword(long id, Employee employee) {
		Optional<Employee> tempEmployee = Optional.of(this.repo.findById(id)).orElseThrow(EmployeeNotFoundException::new);
		Employee existingEmployee = tempEmployee.get();
		
		existingEmployee.setPassword(employee.getPassword());
		
		Employee updated = this.repo.save(existingEmployee);
		return this.mapToDTO(updated);
	}
}
