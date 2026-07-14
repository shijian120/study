package com.sj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller  // 代表这是一个控制器, 处理请求额组件
public class HelloController {
	
	
	@ResponseBody  // 包返回值放在响应体中
	@RequestMapping("/hello")
	public String handle01() {
		return "hello spring mvc, 你好好 shijian";
	}
	
	
	/*
	 @RequestMapping:
	    1. 路径位置的通配符  ?
	    匹配一个字符(只能匹配一个)
	    2. 路径位置的通配符  *
	    匹配多个字符(0-n)
	    3. 路径位置的通配符  **
	    匹配多层目录
	 */
	
	@ResponseBody
	@RequestMapping("/hell?")
	public String handle02(){
		return "handle02";
	}
	
	
	
	
	
	
	
	
	
}
