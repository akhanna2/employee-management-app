package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable=false)
	private String projectName;
	
	private String projectSupervisor;
	
	private int noOfPeopleInvolved;
	
	@Column(nullable=false)
	private double budget;
	
	@Size(max=10)
	private String startDate;
	
	@Size(max=10)
	private String deadline;
	
	@Column(nullable=false)
	private boolean completed;

	public Project(Long id, String projectName, String projectSupervisor, int noOfPeopleInvolved, double budget,
			@Size(max = 10) String startDate, @Size(max = 10) String deadline, boolean completed) {
		super();
		Id = id;
		this.projectName = projectName;
		this.projectSupervisor = projectSupervisor;
		this.noOfPeopleInvolved = noOfPeopleInvolved;
		this.budget = budget;
		this.startDate = startDate;
		this.deadline = deadline;
		this.completed = completed;
	}

	public Project() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectSupervisor() {
		return projectSupervisor;
	}

	public void setProjectSupervisor(String projectSupervisor) {
		this.projectSupervisor = projectSupervisor;
	}

	public int getNoOfPeopleInvolved() {
		return noOfPeopleInvolved;
	}

	public void setNoOfPeopleInvolved(int noOfPeopleInvolved) {
		this.noOfPeopleInvolved = noOfPeopleInvolved;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
