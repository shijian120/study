package com.sj.controller;

import com.sj.Bean.Address;
import com.sj.Bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * ClassName: ResponseTestController
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/15 05:25
 * @Version 1.0
 */


@RestController
public class ResponseTestController {
	
	
	// 响应json数据
	// @ResponseBody   @RestController中已经有了，@ResponseBody, 所以可以省略
	@GetMapping("/resp01")
	public User resp01() {
		User user = new User();
		user.setUsername("shijian");
		user.setAge(15);
		user.setEmail("124@gmal.com");
		Address address = new Address();
		address.setProvince("shandong");
		address.setCity("jinan");
		address.setDetail("山东");
		user.setAddress(address);
		String[] hobbies = {"football", "game"};
		user.setHobbies(hobbies);
		
		return user;
	}
	
	// 文件下载, 文件下载就是告诉浏览器，这个数据不是用来解析的，而是用来下载的
	// 底层是 content-disposition 来控制的
	
	/*
	文件下载的2个问题
	 1. 文件名中文乱码
	 2. 文件太大会出现oom 
	 */
	
	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> download() throws IOException {
		
		// 固定写法
		FileInputStream fis = new FileInputStream("xxx/xxx.jpg");
		
		// 这样做可能会出现 内存溢出
		// byte[] bytes = fis.readAllBytes();
		
		// 这样做不会把数据全部加载到内存中, 不会出现oom
		InputStreamResource resource = new InputStreamResource(fis);
		
		// 解决文件名中文乱码
		String filename = URLEncoder.encode("xxx.jpg", "utf-8");
		
		
		// 固定写法
		return ResponseEntity.ok()
				       .contentType(MediaType.APPLICATION_OCTET_STREAM)
				       .contentLength(fis.available())
				       // 内容处理方式
				       .header("Content-Disposition", "attachment; filename=" + filename)
				       .body(resource);
	}
	
}
