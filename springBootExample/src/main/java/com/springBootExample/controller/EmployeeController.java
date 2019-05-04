package com.springBootExample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBootExample.model.Employee;
import com.springBootExample.model.Status;
import com.springBootExample.service.EmployeeService;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Status status;
	
	/* To create a new employee */
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> create(@RequestBody Employee emp) {		// Note - In POST, use @RequestBody  
															// Having a <> for ResponseEntity is optional, see "deleteEmployeeById" 
		Employee result = employeeService.createEmployee(emp);
		return new ResponseEntity<Employee>(result, HttpStatus.OK);
	}
	
	/* To read an employee data */
	@RequestMapping(value = "/readEmployeeData" , method = RequestMethod.GET)
	public ResponseEntity<Optional<Employee>> readEmployee (@RequestParam("id") Long id) {	// Note - In GET, use @RequestParam
		Optional<Employee> result = employeeService.readEmpData(id);
		return new ResponseEntity<Optional<Employee>>(result, HttpStatus.OK);
	}
	
	/* To update an employee */
	
	
	/* To delete an employee by id */
	/* Duh, it does not make sense to delete the employee accepting the entire entity - it will increase payload unnecessarily*/
	@RequestMapping(value = "/deleteEmployeeById/{id}", method = RequestMethod.GET)
	public ResponseEntity deleteEmployeeById(@PathVariable("id") Long id) {
																			// duh, @RequestParam can also be used -  
																			// But the way of invoking API will be different
		String response = employeeService.deleteEmployeeById(id);
		status.setResponseMsg(response);
		return new ResponseEntity(status, HttpStatus.OK);
	}
	
	// Using Spring Data JPA Functionalities.
	
	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	public ResponseEntity findEmployeesOrderedByName(@RequestParam("name") String name) {
		List<Employee> listOfEmp = employeeService.findByName(name);
		return new ResponseEntity(listOfEmp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getParticularEmployees", method = RequestMethod.GET)
	public ResponseEntity getParticularEmployees(@RequestParam("name1") String name1, @RequestParam("name2") String name2) {
		List<Employee> list = employeeService.getParticularEmployees(name1, name2);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
}
