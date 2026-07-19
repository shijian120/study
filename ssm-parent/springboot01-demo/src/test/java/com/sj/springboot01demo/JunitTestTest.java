package com.sj.springboot01demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
单元测试进行测试
 */

@Slf4j
@SpringBootTest
public class JunitTestTest {
	//每个测试方法执行之前,都会执行这个方法
	@BeforeEach
	public void beforeEach(){
		log.info("测试开始!!!!1");
	}
	
	// 每个单元测试执行之后, 都会执行这个方法
	@AfterEach
	public void afterEach(){
		log.info("测试结束!!!!1");
	}
	
	
	// 所有测试执行之后,都会执行这个方法
	@AfterAll
	public static void afterAll(){
		log.info("所有测试结束!!!!!!!!");
	}
	
	
	
	@DisplayName("给单元测试起一个名字")
	@Test
	public void test(){
		log.info("测试方法");
	}
}
