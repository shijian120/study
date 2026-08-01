package com.sj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: IndexController
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/31 17:44
 * @Version 1.0
 */

@RestController
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "hello security";
	}
}
