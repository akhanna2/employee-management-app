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

import com.example.dto.EmployeeDTO;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/addEmployee")
	public EmployeeDTO addEmployee(@RequestBody Employee employee) {
		return this.service.addEmployee(employee);
	}
	
	@GetMapping("/allEmployees")
	public List<EmployeeDTO> allEmployees(){
		return this.service.allEmployees();
	}
	
	@PutMapping("/updateEmployee/{id}")
	public EmployeeDTO updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public boolean deleteEmployee(@PathVariable long id) {
		return this.service.deleteEmployee(id);
	}
	
	@GetMapping("/login/{userName}/{password}")
	public boolean login(@PathVariable String userName, @PathVariable String password) {
		return this.service.checkCredentials(userName, password);
	}
	
	@GetMapping("/employeeById/{id}")
	public EmployeeDTO employeeById(@PathVariable long id) {
		return this.service.employeeById(id);
	}
	
	@GetMapping("/employeeByFirstName/{firstName}")
	public List<EmployeeDTO> employeeByFirstName(@PathVariable String firstName) {
		return this.service.employeeByFirstName(firstName);
	}
	
	@GetMapping("/employeeByLastName/{lastName}")
	public List<EmployeeDTO> employeeByLastName(@PathVariable String lastName) {
		return this.service.employeeByLastName(lastName);
	}
	
	@GetMapping("/employeeByRole/{role}")
	public List<EmployeeDTO> employeeByRole(@PathVariable String role) {
		return this.service.employeeByRole(role);
	}
	
	@GetMapping("/employeeBySupervisor/{supervisor}")
	public List<EmployeeDTO> employeeBySupervisor(@PathVariable String supervisor) {
		return this.service.employeeBySupervisor(supervisor);
	}
	
	@GetMapping("/employeeByCurrentProject/{currentProject}")
	public List<EmployeeDTO> employeeCurrentProject(@PathVariable String currentProject) {
		return this.service.employeeByCurrentProject(currentProject);
	}
	
	@GetMapping("/employeeByWorkType/{workType}")
	public List<EmployeeDTO> employeeByWorkType(@PathVariable String workType) {
		return this.service.employeeByWorkType(workType);
	}
	
	@GetMapping("/employeeByUserName/{userName}")
	public List<EmployeeDTO> employeeByUserName(@PathVariable String userName) {
		return this.service.employeeByUserName(userName);
	}
	
	@PutMapping("updateEmployeeAge/{id}")
	public EmployeeDTO updateEmployeeAge(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeAge(id, employee);
	}
	
	@PutMapping("updateEmployeeRole/{id}")
	public EmployeeDTO updateEmployeeRole(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeRole(id, employee);
	}
	
	@PutMapping("updateEmployeeDepartment/{id}")
	public EmployeeDTO updateEmployeeDepartment(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeDepartment(id, employee);
	}

	@PutMapping("updateEmployeeSupervisor/{id}")
	public EmployeeDTO updateEmployeeSupervisor(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeSupervisor(id, employee);
	}
	
	@PutMapping("updateEmployeeCurrentProject/{id}")
	public EmployeeDTO updateEmployeeCurrentProject(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeCurrentProject(id, employee);
	}
	
	@PutMapping("updateEmployeeWorkType/{id}")
	public EmployeeDTO updateEmployeeWorkType(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeWorkType(id, employee);
	}
	
	@PutMapping("updateEmployeeHourlyWage/{id}")
	public EmployeeDTO updateEmployeeHourlyWage(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeHourlyWage(id, employee);
	}
	
	@PutMapping("updateEmployeeUserName/{id}")
	public EmployeeDTO updateEmployeeUserName(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeeUserName(id, employee);
	}
	
	@PutMapping("updateEmployeePassword/{id}")
	public EmployeeDTO updateEmployeePassword(@PathVariable long id, @RequestBody Employee employee) {
		return this.service.updateEmployeePassword(id, employee);
	}
}
