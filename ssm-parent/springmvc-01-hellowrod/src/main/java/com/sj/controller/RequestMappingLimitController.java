package com.sj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
了解
 @ResponseBody
 @Controller
 @RestController = @Controller + @ResponseBody
 
 请求方式
 params
 headers
 consumes
 produces
 
 */

// @ResponseBody
// @Controller
// @RestController  // 2个注解的组合
public class RequestMappingLimitController {
	
	
	/*
	 value 方法的路径
	 method 请求的方式
	 
	 页面只能发送 get post
	 但是代码层面可以发送 put delete 等方式，但是需要使用 Postman 工具
	 */
	@RequestMapping(value = "/test01", method = RequestMethod.POST)
	public String handle01() {
		
		return "handle01 你好啊!!!";
	}
	
	
	// 参数必须 包含username
	@RequestMapping(
			value = "/test02",
			method = {RequestMethod.POST, RequestMethod.GET},
			params = {"username", "age=18"}
	)
	public String handle02() {
		
		return "参数必须包含username";
	}
	
	
	// 请求头必须携带 haha
	@RequestMapping(
			value = "/test03",
			method = RequestMethod.GET,
			headers = "haha"
	)
	public String handle03() {
		
		return "sss";
	}
	
	
	// 浏览器 必须携带 json的数据
	@RequestMapping(
			value = "/test04",
			consumes = "application/json"  // 浏览器必须携带 json 格式的数据
	)
	public String handle04() {
		
		return "sss";
	}
	
	// produces代表 浏览器只能以 json 的方式接收数据
	@RequestMapping(
			value = "/test05",
			produces = "application/json"
	)
	public String handle05() {
		
		return "sss";
	}
}
