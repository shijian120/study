package com.sj.controller;

import com.sj.common.R;
import com.sj.entity.Employee;
import com.sj.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 restful的 crud
 
 */
// 跨域
@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class EmployeeRestController {

	
	@Autowired
	private EmployService employeeService;

	@GetMapping("/employee/{id}")
	public R<Employee> employee(@PathVariable("id") Integer id){
		
		Employee byId = employeeService.getById(id);
		
		return R.success(byId);
	}
	
	// 删除员工
	@DeleteMapping("/employee/{id}")
	public R<Void> delete(@PathVariable("id") Integer id){
		
		int i = employeeService.deleteById(id);
		
		return R.success();
	}
	
	// 修改员工, 修改员工必须携带id
	@PutMapping("/employee")
	public R<Void> update(Employee employee){
		int update = employeeService.update(employee);
		
		return R.success();
	}
	
	// 添加员工
	@PostMapping("/employee")
	public R<Void> add(Employee employee){
		int add = employeeService.add(employee);
		
		return R.success();
	}
	
	
	// 查询所有
	@GetMapping("/employees")
	public R<List<Employee>> all(){
		
		List<Employee> employees = employeeService.getAll();
		
		return R.success(employees);
	}
	
}
