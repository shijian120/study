package com.sj.springboot01demo;

import com.sj.springboot01demo.propertiesbinding.CatProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01DemoApplicationTests {
	
	@Autowired
	CatProperties catProperties;
	
	
	@Test
	void testPropertiesBind() {
		
		System.out.println(catProperties);
	}
	
}
