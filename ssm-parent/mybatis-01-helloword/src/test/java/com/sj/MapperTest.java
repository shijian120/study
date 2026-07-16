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
		emp.setEmpName("刘德华");
		emp.setAge(18);
		emp.setEmpSalary(1000.01D);
		
		empMapper.insertEmp(emp);
		
		// 获取添加后的员工id, 这里使用了自增id回填机制, 需要在 EmpMapper.xml 配置 keyProperty 属性
		System.out.println(emp.getId());
	}
	
	
	
	//更新员工
	@Test
	public void updateEmp(){
		
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
	
	
	// 查询所有
	@Test
	public void selectAllEmp(){
		empMapper.selectAllEmp().forEach(System.out::println);
	}
	
	
}
