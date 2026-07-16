package com.sj.practice.service;

import com.sj.practice.entity.Employee;

import java.util.List;

/**
 * ClassName: EmployService
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/15 13:04
 * @Version 1.0
 */

public interface EmployService {
	
	// 根据id获取员工信息
	Employee getById(Integer id);
	
	// 添加员工
	int add(Employee employee);
	
	// 更新员工信息
	int update(Employee employee);
	
	// 根据id删除员工
	int deleteById(Integer id);
	
	
	// 查询搜索员工
	List<Employee> getAll();
}
