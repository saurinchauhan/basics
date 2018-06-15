package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	EmployeeDao employeeDao;
	
	
	public int save(Employee employee) throws SQLException {
		return employeeDao.save(employee);
	}
	
	List<Employee> getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}
}
