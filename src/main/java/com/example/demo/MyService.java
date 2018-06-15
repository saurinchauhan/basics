package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(noRollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW,isolation=Isolation.SERIALIZABLE)
	void saveAndUpdate(Employee e) throws SQLException {
		employeeDao.save(e);
		employeeDao.update(e);
//		employeeDao.saveAndUpdate(e);
	}
	
}
