package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@Size(max=10)
	private String dateOfBirth;
	
	@Min(18)
	private int age;
	
	@NotNull
	@Size(max=10)
	private String dateJoined;
	
	@NotNull
	private String role;
	
	@NotNull
	@ManyToOne
	private Department department;
	
	private String supervisor;
	
	private String currentProject;
	
	private String workType; //full time or part time
	
	private double hourlyWage;
	
	@Column(unique = true)
	@NotNull
	@Size(min=3, max=12)
	private String userName;
	
	@Size(min=8)
	private String password;

	public Employee(long id, @NotNull String firstName, @NotNull String lastName, @Size(max = 10) String dateOfBirth,
			@Min(18) int age, @NotNull @Size(max = 10) String dateJoined, @NotNull String role,
			@NotNull Department department, String supervisor, String currentProject, String workType,
			double hourlyWage, @NotNull @Size(min = 3, max = 12) String userName, @Size(min = 8) String password) {
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
		this.hourlyWage = hourlyWage;
		this.userName = userName;
		this.password = password;
	}

	public Employee() {
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

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
