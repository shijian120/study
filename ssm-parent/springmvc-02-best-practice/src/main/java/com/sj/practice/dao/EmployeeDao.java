package com.sj.practice.dao;

import com.sj.practice.entity.Employee;

import java.util.List;

/*
dao层的方法, 起名应该和 sql查询起名类似,这样调用的时候,比较容器

关于返回值
 查询不必多说,直接返回实体类或者集合
 插入、更新、删除返回 int 类型,返回受影响的行数, 但是这不是绝对的
 例如 插入, 也可以返回 生成的主键值, 可以参考文档,或者自行尝试
 更新 也是同理
*
如果返回 主键的值, 可以 使用 nativeQuery = false;  nativeQuery = true;
JdbcTemplate 也可以实现, 但是配置稍微复杂一些
 *

 

 */

public interface EmployeeDao {
	
	/**
	 * 按照id查询员工
	 *
	 * @param id 员工id
	 * @return 员工
	 */
	Employee selectEmployeeById(Integer id);
	
	
	/**
	 * 添加员工
	 *
	 * @param employee 员工
	 * @return 受影响的行数
	 */
	int insertEmployee(Employee employee);
	
	/**
	 * 更新员工 (全量更新)
	 *
	 * @param employee 员工
	 * @return 受影响的行数
	 */
	int updateEmployee(Employee employee);
	
	/**
	 * 删除员工
	 *
	 * @param id 员工id
	 * @return 受影响的行数
	 */
	int deleteEmployeeById(Integer id);
	
	
	/**
	 * 查询所有员工
	 *
	 * @return 员工列表
	 */
	List<Employee> selectAllEmployee();
}
