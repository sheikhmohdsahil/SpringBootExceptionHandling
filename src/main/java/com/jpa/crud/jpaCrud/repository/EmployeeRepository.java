package com.jpa.crud.jpaCrud.repository;



import org.springframework.data.repository.CrudRepository;

import com.jpa.crud.jpaCrud.model.Employee;


public interface EmployeeRepository   extends CrudRepository<Employee, Integer>{
	
	

}
