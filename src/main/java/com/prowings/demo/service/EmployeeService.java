package com.prowings.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prowings.demo.entity.Employee;

public interface EmployeeService {
	
	public Employee save(Employee employee);
	
	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(long id);
}
