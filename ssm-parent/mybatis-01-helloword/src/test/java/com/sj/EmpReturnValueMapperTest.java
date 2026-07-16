package com.sj;

import com.sj.bean.Emp;
import com.sj.mapper.EmpReturnValueMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * ClassName: EmpReturnValueMapperTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/16 20:39
 * @Version 1.0
 */

@SpringBootTest
public class EmpReturnValueMapperTest {
	@Autowired
	EmpReturnValueMapper empReturnValueMapper;
	
	
	@Test
	void testCountEmp() {
		int count = empReturnValueMapper.countEmp();
		System.out.println(count);
	}
	
	
	@Test
	public void testInsert(){
		Emp emp = new Emp();
		emp.setEmpName("张学友");
		emp.setAge(23);
		int i = empReturnValueMapper.insertEmp(emp);
		
		System.out.println("受影响的行数" + i);
	}
	
	
	@Test
	public void testInsertReturnId(){
		Emp emp = new Emp();
		emp.setEmpName("张智尧123");
		emp.setAge(23);
		 empReturnValueMapper.insertEmpReturnId(emp);
		 
		
		System.out.println("插入返回 插入这条数据的id" + emp.getId());
	}
	
	
	@Test
	public void testMap(){
		
		
		Map<Integer, Emp> integerEmpMap = empReturnValueMapper.selectMapAll();
		
		System.out.println(integerEmpMap);
		
		for (Map.Entry<Integer, Emp> entry : integerEmpMap.entrySet()) {
			System.out.println(entry.getKey() + "===" + entry.getValue());
		}
	}
	
	
}
