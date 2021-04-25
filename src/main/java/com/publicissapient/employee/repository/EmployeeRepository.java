package com.publicissapient.employee.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.publicissapient.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

	@Query(value = "select * from employee inner join department where department.department_id = ?1 and employee.name = ?2", nativeQuery=true)
	public List<Employee> findNameByDepartment(int id, String s);
	
	@Query(value = "select * from employee e inner join department d where d.department_id = ?1 and e.name = ?2", nativeQuery=true)
	public Page<Employee> findNameByDepartment(int id, String s, Pageable pageable);
	
}
