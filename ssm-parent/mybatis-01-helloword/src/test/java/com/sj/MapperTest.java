package com.sj;

import com.sj.bean.Emp;
import com.sj.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: MapperTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/16 15:41
 * @Version 1.0
 */
@SpringBootTest
public class MapperTest {
	
	// 虽然爆红可以用
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void testEmpMapper() {
		
		Emp emp = empMapper.selectById(1);
		
		System.out.println(emp);
		
	}
	
	// 测试增删改查
	
	
	// 添加员工
	@Test
	public void addEmp(){
		Emp emp = new Emp();
		emp.setEmpName("周杰伦");
		emp.setAge(040);
		emp.setEmpSalary(1000.01D);
		
		empMapper.insertEmp(emp);
	}
	
	
	// 更新员工
	@Test
	public void updateEmp(){
		Emp emp = new Emp();
		emp.setId(1);
		emp.setEmpName("周杰伦");
		emp.setAge(040);
		emp.setEmpSalary(1000.01D);
		
		empMapper.updateEmpById(emp);
	}
	
	//更新员工
	@Test
	public void updateEmp2(){
		
		// 先查询,在更新
		Emp emp = empMapper.selectById(4);
		
		emp.setEmpName("周润发");
		
		
		empMapper.updateEmpById(emp);
	}
	
	// 删除员工
	@Test
	public void deleteEmp(){
		empMapper.deleteEmpById(4);
	}
	
	
}
