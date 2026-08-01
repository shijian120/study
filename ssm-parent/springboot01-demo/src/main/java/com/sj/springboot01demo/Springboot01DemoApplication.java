package com.sj.springboot01demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.restclient.autoconfigure.RestClientAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot01DemoApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ioc = SpringApplication.run(Springboot01DemoApplication.class, args);
		
		
		// 容器中是否有该组件
		RestClientAutoConfiguration bean = ioc.getBean(RestClientAutoConfiguration.class);
		System.out.println(bean);
		
	}
	
}
