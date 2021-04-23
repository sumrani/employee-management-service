package com.publicissapient.employee.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	

	public List<Employee> getEmplByNameAndDeptId() {
	//	employeeRepository.fin
		return null;
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
	
	public Page<Employee> findPaginatedPage(int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return this.employeeRepository.findAll(pageable);
	}

}
