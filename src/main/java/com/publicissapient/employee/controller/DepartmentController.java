package com.publicissapient.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.employee.model.Department;
import com.publicissapient.employee.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/department")
	public void addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
	}
	
	@RequestMapping(value = "/department")
	public List<Department> getDepartment() {
		List<Department> dept = departmentService.getDepartment();
		return dept;
	}

}
