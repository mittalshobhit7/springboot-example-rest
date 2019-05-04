package com.springBootExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootExample.model.Employee;
import com.springBootExample.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public Optional<Employee> readEmpData(Long id) {
		return employeeRepository.findById(id);
	}
	
//	public Employee updateEmployee(Long id) {
//		return
//	}
	
	public String deleteEmployeeById(Long id) {
		if(employeeRepository.existsById(id)){
			employeeRepository.deleteById(id);
			return "Employee with id = " + id + " has been successfully deleted";
		}
		else
			return "Employee with id = " + id + " does not exist";
	}
	
	// Using Spring Data JPA Functionalities.
	public List<Employee> findByName(String name) {
		return employeeRepository.findEmployeeByName(name);
	}

	public List<Employee> getParticularEmployees(String name1, String name2) {
		return employeeRepository.getParticularEmployees(name1, name2);
	}
}
