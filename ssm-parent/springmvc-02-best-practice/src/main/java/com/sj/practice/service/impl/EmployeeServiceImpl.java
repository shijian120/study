package com.sj.practice.service.impl;

import com.sj.practice.dao.EmployeeDao;
import com.sj.practice.entity.Employee;
import com.sj.exception.BizException;
import com.sj.exception.BizExceptionEnum;
import com.sj.practice.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * ClassName: EmployeeImpl
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/15 13:04
 * @Version 1.0
 */

@Service
public class EmployeeServiceImpl implements EmployService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee getById(Integer id) {
		
		Employee employee = employeeDao.selectEmployeeById(id);
		
		return employee;
	}
	
	@Override
	public int add(Employee employee) {
		
		int i = employeeDao.insertEmployee(employee);
		
		
		return i;
	}
	
	@Override
	public int update(Employee employee) {
		
		// 非空判断
		if (employee.getId() == null) {
			throw new BizException(BizExceptionEnum.PRODUCT_NOT_FOUND_BY_ID);
		}
		
		// 数据库中的员工信息
		Employee emp = employeeDao.selectEmployeeById(employee.getId());
		
		
		
		// 判断前端是否传递了 对应的值, 如果没有传递, 那么应该保留数据库中原来的值
		if (StringUtils.hasText(employee.getName())) {
			emp.setName(employee.getName());
		}
		if (employee.getAge() != null) {
			emp.setAge(employee.getAge());
		}
		if (StringUtils.hasText(employee.getEmail())) {
			emp.setEmail(employee.getEmail());
		}
		if (StringUtils.hasText(employee.getGender())) {
			emp.setGender(employee.getGender());
		}
		if (StringUtils.hasText(employee.getAddress())) {
			emp.setAddress(employee.getAddress());
		}
		if (employee.getSalary() != null) {
			emp.setSalary(employee.getSalary());
		}
		
		
		int i = employeeDao.updateEmployee(emp);
		
		return i;
	}
	
	@Override
	public int deleteById(Integer id) {
		
		int i = employeeDao.deleteEmployeeById(id);
		
		return i;
	}
	
	@Override
	public List<Employee> getAll() {
		
		List<Employee> all = employeeDao.selectAllEmployee();
		
		return all;
	}
}
