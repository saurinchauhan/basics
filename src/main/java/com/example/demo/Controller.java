package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	MyService myService;
	
	
	int save(Employee employee) throws SQLException {
		return myService.save(employee);
	}
	
	List<Employee> getEmployeeById(int id) {
		return myService.getEmployeeById(id);
	}
	
}
