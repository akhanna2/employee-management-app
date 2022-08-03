package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{
	
	@Query("select d from Department d where d.departmentName=?1")
	List<Department> findByDepartmentName(String departmentName);
	
	@Query("select d from Department d where d.headOfDepartment=?1")
	List<Department> findByHeadOfDepartment(String headOfDepartment);

}
