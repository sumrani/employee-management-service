package com.publicissapient.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicissapient.employee.model.Department;
import com.publicissapient.employee.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	public void addDepartment(Department department) {
		
		departmentRepository.save(department);
	}


	public List<Department> getDepartment() {
		return departmentRepository.findAll();
		
	}

}
