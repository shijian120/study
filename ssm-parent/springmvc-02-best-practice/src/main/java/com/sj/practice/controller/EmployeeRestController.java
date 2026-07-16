package com.sj.practice.controller;

import com.sj.common.R;
import com.sj.practice.entity.Employee;
import com.sj.practice.service.EmployService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * restful的 crud
 */
// 跨域
@Tag(name = "员工管理")
@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class EmployeeRestController {
	
	
	@Autowired
	private EmployService employeeService;
	
	
	// 描述方法
	@Operation(summary = "按照id查询员工信息")
	@Parameter(name = "id",description = "员工id",in = ParameterIn.PATH)
	@GetMapping("/employee/{id}")
	public R<Employee> employee(@PathVariable("id") Integer id) {
		
		Employee byId = employeeService.getById(id);
		
		return R.success(byId);
	}
	
	// 删除员工
	@Operation(summary = "按照id删除员工信息")
	
	@DeleteMapping("/employee/{id}")
	public R<Void> delete(@PathVariable("id") Integer id) {
		
		int i = employeeService.deleteById(id);
		
		return R.success();
	}
	
	// 修改员工, 修改员工必须携带id
	
	@Operation(summary = "修改员工信息")
	@PutMapping("/employee")
	public R<Void> update(Employee employee) {
		int update = employeeService.update(employee);
		
		return R.success();
	}
	
	// 添加员工
	@Operation(summary = "添加员工信息")
	@PostMapping("/employee")
	public R<Void> add(Employee employee) {
		int add = employeeService.add(employee);
		
		return R.success();
	}
	
	
	// 查询所有
	@GetMapping("/employees")
	public R<List<Employee>> all() {
		
		List<Employee> employees = employeeService.getAll();
		
		return R.success(employees);
	}
	
}
