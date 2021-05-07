package com.publicissapient.employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.publicissapient.employee.EmployeeManagementServiceApplication;
import com.publicissapient.employee.model.Department;
import com.publicissapient.employee.model.Employee;
import com.publicissapient.employee.service.EmployeeService;


@SpringBootTest(classes = EmployeeManagementServiceApplication.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@MockBean
	EmployeeService employeeSeriveMock;
	
	@Autowired
	EmployeeController employeeController;
	
	@Test
	public void tesGetEmployee() {
		List<Employee> list = new ArrayList<>();
		Department department = new Department(1, "HR");
		Employee emp = new Employee(1, "Suman", 5.0, "Banglore", 1094, department);
		list.add(emp);
		when(employeeSeriveMock.getEmployee()).thenReturn(list);
		
		ResponseEntity<List<Employee>> response = employeeController.getEmployee();
		assertEquals(200, response.getStatusCodeValue());
	}
	
	/*
	 * IntegrationTest Cases
	 */
	
	@Test
	public void testGetEmployeeById() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/employee/Amit/department/1"),
				HttpMethod.GET, entity, String.class);
	assertNotNull(response.getBody());
		
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	
	//@Test
	public void addEmployee() {
		Department department = new Department(1,"Hr");
		Employee emp = new Employee(15, "Sumit", 10000, "Delhi", 53852, department);
		 ResponseEntity<String> responseEntity = this.restTemplate
		            .postForEntity("http://localhost:" + port + "/employees", emp, String.class);
		        assertEquals(201, responseEntity.getStatusCodeValue());
	}
}
