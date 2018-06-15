package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	RowMapper<Employee> rowMapperEmployee = (rs, row) -> {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setSalary(rs.getFloat(3));
		return e;
	};
	
	void saveAndUpdate(Employee e) throws SQLException {
		save(e);
		
		e.setName("dfsdfsdf");
		e.setSalary(123F);
		update(e);
	}

	public int save(Employee employee) throws SQLException {
		String query = "INSERT INTO employee (id, name, salary) VALUES (?,?,?)";
		int i = jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getSalary());
//		if (System.currentTimeMillis() % 2 == 0)
//			throw new RuntimeException("Runtime exception");
		return i;
	}
	
	public int update(Employee employee) throws SQLException {
		String query = "UPDATE employee SET name=?,salary=? where id=?";
		int i = jdbcTemplate.update(query, employee.getName()
				, employee.getSalary(),employee.getName());
//		if (System.currentTimeMillis() % 2 == 0)
//			throw new RuntimeException("Runtime exception");
		return i;
	}

	public List<Employee> getEmployeeById(int id) {
		String query = "SELECT * FROM employee WHERE id=?";

		Object[] o = new Object[1];
		o[0] = new Integer(id);

		return jdbcTemplate.query(query, o, rowMapperEmployee);
	}
}
