package com.sj.springboot01demo.service;

/**
 * ClassName: HelloService
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/19 01:04
 * @Version 1.0
 */

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String hello() {
		return "hello";
	}
}
