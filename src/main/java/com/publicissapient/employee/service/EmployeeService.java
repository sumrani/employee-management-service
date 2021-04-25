package com.publicissapient.employee.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.publicissapient.employee.model.Employee;
import com.publicissapient.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	List<Employee> list =  new ArrayList<Employee>();
	
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployee(int id) {
			employeeRepository.deleteById(id);
	}

	public void editEmployee(Employee employee, int id) {
		employeeRepository.save(employee);
	}

	public List<Employee> getEmployee() {
		
		return employeeRepository.findAll();
	}

	public List<Employee> getEmployeeBynameAndDeptId(String name, int dept_id) {
		return employeeRepository.findNameByDepartment(dept_id, name);
		
	}
	
	public List<Employee> getEmployeeBynameAndDeptIdInPage(String name, int dept_id){
		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
		return this.employeeRepository.findNameByDepartment(dept_id, name,pageable).getContent();
	}

}
