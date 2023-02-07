package com.jpa.crud.jpaCrud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jpa.crud.jpaCrud.exception.EmployeeNotfoundException;
import com.jpa.crud.jpaCrud.model.Employee;
import com.jpa.crud.jpaCrud.service.EmployeeService;

@RestController
public class EmployeeServiceController
{
	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/employees")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee)
	{
		employee = employeeService.createEmployee(employee);
		return new ResponseEntity<>("Employee is created successfully with id = " +employee.getId(), HttpStatus.CREATED);
	}

	@PutMapping( "/employees/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id,
			@RequestBody Employee employee)
	{
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			employee.setId(id);
			employeeService.updateEmployee(employee);
			return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}

	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			Employee employee = employeeService.getEmployee(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}

	}

	

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}

	}

}
