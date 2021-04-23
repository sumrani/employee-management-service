package com.publicissapient.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.publicissapient.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

	@Query(value = "select * from employee inner join department where department.department_id = ?1 and employee.name = ?2", nativeQuery=true)
	public List<Employee> findNameByDepartment(int id, String s);
	
}
