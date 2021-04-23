package com.publicissapient.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.employee.model.Employee;
import com.publicissapient.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(method = RequestMethod.POST, value="/employee")
	public void createEmployee(@RequestBody Employee employee) {
		
		service.createEmployee(employee);
	}
	
	@RequestMapping("/employee")
	public List<Employee> getEmployee() {
		
		return service.getEmployee();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		
		service.deleteEmployee( id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "employee/{id}")
	public void editEmployee(@RequestBody Employee employee, @PathVariable int id) {
		
		service.editEmployee(employee,id);
	}
	
	@RequestMapping("/employee/{name}/department/{dept_id}")
	public List<Employee> getEmployee(@PathVariable String name, @PathVariable int dept_id) {
		
		 return service.getEmployeeBynameAndDeptId(name, dept_id);
		 
	}
	
}
