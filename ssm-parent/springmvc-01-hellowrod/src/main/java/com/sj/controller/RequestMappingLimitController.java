package com.sj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: RequestMappingLimitController
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/14 19:33
 * @Version 1.0
 */

// @ResponseBody
// @Controller
@RestController  // 2个注解的组合
public class RequestMappingLimitController {
	
	
	/*
	 value 方法的路径
	 method 请求的方式
	 
	 页面只能发送 get post
	 但是代码层面可以发送 put delete 等方式，但是需要使用 Postman 工具
	 */
	@RequestMapping(value = "/test01", method = RequestMethod.POST)
	public String  handle01(){
		
		return "handle01 你好啊!!!";
	}
}
