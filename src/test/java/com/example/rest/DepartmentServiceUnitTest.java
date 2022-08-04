package com.example.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.dto.DepartmentDTO;
import com.example.model.Department;
import com.example.repo.DepartmentRepo;
import com.example.service.DepartmentService;

@SpringBootTest
public class DepartmentServiceUnitTest {
	final private Department TEST_SAVED_DEPARTMENT = new Department(1L, "training","Lee","training dept", null);
	final private DepartmentDTO TEST_SAVED_DEPARTMENTDTO = new DepartmentDTO(1L, "training", "Lee", "training dept");
	final private Department TEST_UPDATED_DEPARTMENT = new Department(1L, "training","Lee","updated training dept", null);
	final private DepartmentDTO TEST_UPDATED_DEPARTMENTDTO = new DepartmentDTO(1L, "training", "Lee", "updated training dept");
	final private Optional<Department> SAVED_OPTIONAL_DEPARTMENT = Optional.of(TEST_SAVED_DEPARTMENT);

	
	final private List<Department> TEST_LIST = new ArrayList<Department>();
	final private List<DepartmentDTO> TEST_LISTDTO = new ArrayList<DepartmentDTO>();

	
	@Autowired
	private DepartmentService service;
	
	@MockBean
	private DepartmentRepo repo;
	
	@Test
	void testAddDepartment() {
		final Department TEST_DEPARTMENT = new Department();
		TEST_DEPARTMENT.setDepartmentName("training");
		TEST_DEPARTMENT.setHeadOfDepartment("Lee");
		TEST_DEPARTMENT.setDescription("training dept");
		TEST_DEPARTMENT.setEmployees(null);
		
		Mockito.when(this.repo.save(TEST_DEPARTMENT)).thenReturn(TEST_SAVED_DEPARTMENT);
		
		Assertions.assertThat(this.service.addDepartment(TEST_DEPARTMENT)).isEqualTo(TEST_SAVED_DEPARTMENTDTO);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_DEPARTMENT);
	}
	
	@Test
	void testAllDepartments() {		
		TEST_LIST.add(TEST_SAVED_DEPARTMENT);		
		TEST_LISTDTO.add(TEST_SAVED_DEPARTMENTDTO);
		
		Mockito.when(this.repo.findAll()).thenReturn(TEST_LIST);
		
		Assertions.assertThat(this.service.allDepartments()).isEqualTo(TEST_LISTDTO);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdateDepartment() {
		final Department TEST_DEPARTMENT = new Department();
		TEST_DEPARTMENT.setId(1L);
		TEST_DEPARTMENT.setDepartmentName("training");
		TEST_DEPARTMENT.setHeadOfDepartment("Lee");
		TEST_DEPARTMENT.setDescription("updated training dept");
		TEST_DEPARTMENT.setEmployees(null);
				
		Mockito.when(this.repo.findById(1L)).thenReturn(SAVED_OPTIONAL_DEPARTMENT);
		final Department TEST_EXISTING_DEPARTMENT = SAVED_OPTIONAL_DEPARTMENT.get();
		Mockito.when(this.repo.save(TEST_EXISTING_DEPARTMENT)).thenReturn(TEST_UPDATED_DEPARTMENT);
		
		Assertions.assertThat(this.service.updateDepartment(1L, TEST_DEPARTMENT)).isEqualTo(TEST_UPDATED_DEPARTMENTDTO);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_DEPARTMENT);
	}
	
	@Test
	void testDeleteDepartment() {
				
		Mockito.when(this.repo.findById(1L)).thenReturn(SAVED_OPTIONAL_DEPARTMENT);
		
		Assertions.assertThat(this.service.deleteDepartment(1L)).isEqualTo(true);
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		
	}
	
	@Test
	void testDepartmentById() {
				
		Mockito.when(this.repo.findById(1L)).thenReturn(SAVED_OPTIONAL_DEPARTMENT);
		
		Assertions.assertThat(this.service.departmentById(1L)).isEqualTo(TEST_SAVED_DEPARTMENTDTO);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}
}
