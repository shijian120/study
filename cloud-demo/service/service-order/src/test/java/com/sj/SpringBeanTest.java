package com.sj;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: SpringBeanTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/5/21 21:15
 * @Version 1.0
 */

@SpringBootTest
public class SpringBeanTest {
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@Test
	public void test(){
		
		System.out.println(objectMapper);
	 
	}
}
