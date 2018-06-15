package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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

	public int save(Employee employee) throws SQLException {
		String query = "INSERT INTO employee (id, name, salary) VALUES (?,?,?)";
		return jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getSalary());
	}

	public List<Employee> getEmployeeById(int id) {
		String query = "SELECT * FROM employee WHERE id=?";

		Object[] o = new Object[1];
		o[0] = new Integer(id);

		return jdbcTemplate.query(query, o, rowMapperEmployee);
	}
}
