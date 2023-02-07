package com.jpa.crud.jpaCrud.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.crud.jpaCrud.model.Employee;
import com.jpa.crud.jpaCrud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import com.jpa.crud.jpaCrud.model.Employee;
import com.jpa.crud.jpaCrud.repository.EmployeeRepository;
import com.jpa.crud.jpaCrud.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}
	
	public Employee getEmployee(int id)
	{
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = optional.get();
		return employee;
	}

	public List<Employee> getEmployees()
	{
		return (List<Employee>)employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int id)
	{
		employeeRepository.deleteById(id);
	}

	@Override
	public boolean isEmployeeExist(int id)
	{
		return employeeRepository.existsById(id);
	}

//	@Override
//	public Employee getEmployee() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
