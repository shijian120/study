package com.sj.spring.ioc.profiledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * ClassName: DatasourceConfig
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 15:13
 * @Version 1.0
 */

public class DatasourceConfig {
	
	/*
	通过 @Profile 定义环境
	在配置文件中, 激活相应的环境 spring.profiles.active=dev
	
	@Profile注解,底层 @Conditional 
	
	
	
	 */
	
	
	@Profile({"dev,default"})
	@Bean
	public MyDataSource dev(){
		
		MyDataSource myDataSource = new MyDataSource();
		myDataSource.setUrl("default");
		
		return myDataSource;
	}
	
	
	@Profile("test")
	@Bean
	public MyDataSource test(){
		
		MyDataSource myDataSource = new MyDataSource();
		myDataSource.setUrl("test");
		
		return myDataSource;
	}
}
