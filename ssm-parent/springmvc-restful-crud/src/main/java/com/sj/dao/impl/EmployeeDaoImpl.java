package com.sj.dao.impl;

import com.sj.dao.EmployeeDao;
import com.sj.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 */

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Employee selectEmployeeById(Integer id) {
		
		String sql = "select * from employee where id = ?";
		Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
		return employee;
	}
	
	@Override
	public int insertEmployee(Employee employee) {
		
		String sql = "insert into employee( name, age, email, gender, address, salary) values (?, ?, ?, ?, ?, ?)";
		int row = jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getEmail(), employee.getGender(), employee.getAddress(), employee.getSalary());
		
		
		return row;
	}
	
	@Override
	public int updateEmployee(Employee employee) {
		
		// String sql  = "update employee name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ? where id = ?";
		String sql = "update employee SET name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ? where id = ?";
		
		int row = jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getEmail(), employee.getGender(), employee.getAddress(), employee.getSalary(), employee.getId());
		
		
		return row;
	}
	
	@Override
	public int deleteEmployeeById(Integer id) {
		String sql = "delete from employee where id = ?";
		
		int row = jdbcTemplate.update(sql, id);
		
		return row;
	}
	
	@Override
	public List<Employee> selectAllEmployee() {
		String sql = "select * from employee";
		List<Employee> all = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
		
		
		// 这种写法不对, 这种写法 底层使用的 单列的 RowMapper 因此如果只查询一列可以
		// List<Employee> all = jdbcTemplate.queryForList(sql, Employee.class);
		
		return all;
	}
}
