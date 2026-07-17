package com.sj;

import com.sj.bean.Emp;
import com.sj.mapper.EmpDynamicSqlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: DynamicSqlTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 15:14
 * @Version 1.0
 */

@SpringBootTest
public class DynamicSqlTest {
	
	@Autowired
	EmpDynamicSqlMapper empDynamicSqlMapper;
	
	
	
	@Test
	public void testWhereLable(){
		// 分别测试  empName 是 null 和 empSalary 是null 的问题
		
		List<Emp> emps1 = empDynamicSqlMapper.selectByEmpNameAndSalary(null, null);
		
		List<Emp> emps2 = empDynamicSqlMapper.selectByEmpNameAndSalary("张三", null);
		
		List<Emp> emps3 = empDynamicSqlMapper.selectByEmpNameAndSalary(null, 5000.0);
		
	}
	
	
	@Test
	public void testUpdaeSetLable(){
		Emp emp = new Emp();
		// 传了一个 null 的对象,结果更新失败!
		// 这种写法就不应该存在, 如果你要做更新, 那么必须要传递id和 至少一个要更新的字段
		empDynamicSqlMapper.updateEmp(emp);
	}
	
	
	
	// Trim 可以 替代 where 和 set
	@Test
	public void testTrimLable(){
	 
		empDynamicSqlMapper.selectByEmpNameAndSalaryByTrimLable("张三", 5000.0);
	}
	
	// choose when otherwise 标签
	
	// forEach 标签  做批量插入
	
}
