package com.sj.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: AspectDemoTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 16:27
 * @Version 1.0
 */


@SpringBootTest
public class AspectDemoTest {
	
	@Autowired
	Calculator calculator;

	
	@Test
	void test() {
		
		int add = calculator.div(1, 0 );
		System.out.println("结果是: " + add);
	}
}

