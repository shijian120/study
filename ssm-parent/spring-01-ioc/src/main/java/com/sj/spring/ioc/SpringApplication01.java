package com.sj.spring.ioc;

import com.sj.spring.ioc.component.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: SpringApplicaion01
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/10 00:03
 * @Version 1.0
 */

@ComponentScan("com.sj.spring.ioc")
@SpringBootApplication
public class SpringApplication01 {
	
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ioc = SpringApplication.run(SpringApplication01.class, args);
		
		ioc.close();
		
	}
	
	public static void main1(String[] args) {
		
		// ApplicationContext 就是 ioc 容器
		ConfigurableApplicationContext ioc = SpringApplication.run(SpringApplication01.class, args);
		
		
		// class org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
		System.out.println(ioc.getClass());
		
		
		// 容器中bean的个数
		int beanCount = ioc.getBeanDefinitionCount();
		System.out.println(beanCount);
		
		
		System.out.println("""
				-----------------------------------------------------------------
				""");
		
		// 获取组件的名字
		// spring 启动会有很多的默认的组件
		String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		
		
	}
	
	
	// 给容器中放入组件
	// 方式1
	/*
	组件的名字: 方法名
 	
	 */
	@Bean
	public User user03(){
		User user = new User();
		user.setUsername("shijian");
		user.setAge(18);
		return user;
	}
	
	
	//  组件名是方法名, 姿势就做user01
	// @Bean
	public User user01(){
		User user = new User();
		user.setUsername("shijian01");
		user.setAge(18);
		return user;
	}
	
	// @Bean("user02")
	public User user02(){
		User user = new User();
		user.setUsername("shijian02");
		user.setAge(18);
		return user;
	}
}
