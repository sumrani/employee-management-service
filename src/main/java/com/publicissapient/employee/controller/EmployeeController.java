package com.publicissapient.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.employee.exception.ResourceNotFoundException;
import com.publicissapient.employee.model.Employee;
import com.publicissapient.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(method = RequestMethod.POST, value="/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		
		service.createEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.CREATED);
	}
	
	@RequestMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee() {
		List<Employee> employee= service.getEmployee();
		if(!employee.isEmpty())
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
		
		service.deleteEmployee( id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "employee/{id}")
	public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable int id) {
		if(service.getEmployeeById(id).get()!=null)
		service.editEmployee(employee,id);
		else
		 new ResourceNotFoundException("Not found ");
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/employee/{name}/department/{dept_id}")
	public ResponseEntity<List<Employee>> getEmployee(@PathVariable String name, @PathVariable int dept_id) {
		
		 return new ResponseEntity<>(
				 service.getEmployeeBynameAndDeptId(name, dept_id), HttpStatus.OK);
		 
	}
	
	@RequestMapping("/employee/{name}/department/{dept_id}/page")
	public ResponseEntity<List<Employee>> getEmployeeInPage(@PathVariable String name, @PathVariable int dept_id) {
		
		 return  new ResponseEntity<>(
				 service.getEmployeeBynameAndDeptIdInPage(name, dept_id),HttpStatus.OK);
		 
	}
	
}
