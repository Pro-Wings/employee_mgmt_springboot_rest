package com.prowings.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.demo.entity.Employee;
import com.prowings.demo.service.EmployeeService;
import com.prowings.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee employee)
	{
		Employee emp = employeeService.save(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity getEmployeeById(@PathVariable("id") long id)
	{
		try {
			
			Employee emp = employeeService.getEmployeeById(id);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		catch (EmployeeNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
