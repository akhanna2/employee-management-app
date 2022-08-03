package com.example.dto;

import com.example.model.Department;

public class EmployeeDTO {
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private int age;
	
	private String dateJoined;
	
	private String role;
	
	private Department department;
	
	private String supervisor;
	
	private String currentProject;
	
	private String workType; //full time or part time
	
	private String userName;

	public EmployeeDTO(long id, String firstName, String lastName, String dateOfBirth, int age, String dateJoined,
			String role, Department department, String supervisor, String currentProject, String workType,
			String userName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.dateJoined = dateJoined;
		this.role = role;
		this.department = department;
		this.supervisor = supervisor;
		this.currentProject = currentProject;
		this.workType = workType;
		this.userName = userName;
	}

	public EmployeeDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
