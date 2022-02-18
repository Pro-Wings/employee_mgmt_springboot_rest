package com.prowings.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prowings.demo.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{
	
}
