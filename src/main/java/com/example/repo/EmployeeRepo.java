package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	@Query("select e from Employee e where e.userName = ?1 and e.password = ?2")
	List<Employee> login(String userName, String password);
	
	@Query("select e from Employee e where e.firstName = ?1")
	List<Employee> findByFirstName(String firstName);
	
	@Query("select e from Employee e where e.lastName = ?1")
	List<Employee> findByLastName(String lastName);
	
	@Query("select e from Employee e where e.role = ?1")
	List<Employee> findByRole(String role);
	
	@Query("select e from Employee e where e.supervisor = ?1")
	List<Employee> findBySupervisor(String supervisor);
	
	@Query("select e from Employee e where e.currentProject = ?1")
	List<Employee> findByCurrentProject(String currentProject);
	
	@Query("select e from Employee e where e.workType = ?1")
	List<Employee> findByWorkType(String workType);
	
	@Query("select e from Employee e where e.userName = ?1")
	List<Employee> findByUserName(String userName);
	
}
