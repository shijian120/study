package com.sj.springboot01demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: LogTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/18 23:01
 * @Version 1.0
 */

@SpringBootTest
public class LogTest {

	@Test
	public void test(){
		//  都是 org.slf4j 包下的
		Logger log = LoggerFactory.getLogger(LogTest.class);
		
		log.atTrace().log("trace");
		log.atDebug().log("debug");
		
		// 默认是 info 级别, 因此 上面2个不会打印
		log.atInfo().log("info");
		log.atWarn().log("warn");
		log.atError().log("error");
		
	}


}
