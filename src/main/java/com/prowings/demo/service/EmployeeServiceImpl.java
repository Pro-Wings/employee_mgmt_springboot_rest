package com.prowings.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.demo.dao.EmployeeDao;
import com.prowings.demo.entity.Employee;
import com.prowings.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> fetchedEmployee = employeeDao.findById(id);
		//logic to check if id not present in DB
		if(fetchedEmployee.isPresent())
		{
			return fetchedEmployee.get();			
		}
		else
		{
			throw new EmployeeNotFoundException("Employeee not present of id :"+id);
		}
		
	}

}
