package com.publicissapient.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.publicissapient.employee.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
