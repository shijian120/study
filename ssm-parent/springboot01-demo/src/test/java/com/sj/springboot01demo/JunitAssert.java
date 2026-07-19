package com.sj.springboot01demo;

import com.sj.springboot01demo.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: JunitAssert
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/19 01:04
 * @Version 1.0
 */

@SpringBootTest
public class JunitAssert {
	
	
	@Autowired
	private HelloService helloService;
	
	@Test
	public void testAssert(){
		
		String str = helloService.hello();
		Assertions.assertEquals("hello",str);
		
	}
	
	
	@Test
	public void testAssert1(){
		// 断言比较的是元素值是否相等, 不是比较的地址
		Assertions.assertArrayEquals(new int[]{1,2,4}, new int[]{1,2,3});
		
	}
}
