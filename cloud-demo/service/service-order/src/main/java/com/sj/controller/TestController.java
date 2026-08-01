package com.sj.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sj.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/5/21 17:10
 * @Version 1.0
 */

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	@Autowired
	TestService testService;
	/*
	 通过 @SentinelResource("read") 明确指定 这个一个资源, read代表资源名称
	 
	 其实 因为 read() 方法 是一个 controller 层的方法,因此 默认他就是一个资源, 不使用注解 他也是一个资源
	 */
	@SentinelResource("read")
	@GetMapping("/read")
	public String read(){
		
		return  "read ...";
	}
	
	@GetMapping("/write")
	public String write(){
		
		return  "write ...";
	}
	
	
	@SentinelResource("中文测试")
	@GetMapping("/test")
	public String test(){
		
		return  "write ...";
	}
	
	@GetMapping("/get/user")
	public String getUser(){
		String user = testService.getUser();
		return  user;
	}
	
	
}
