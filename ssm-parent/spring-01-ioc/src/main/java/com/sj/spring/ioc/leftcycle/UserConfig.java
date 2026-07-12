package com.sj.spring.ioc.leftcycle;

import com.sj.spring.ioc.component.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: UserConfig
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 13:42
 * @Version 1.0
 */

@Configuration
public class UserConfig {
	
	
	/*
	  执行顺序
	  1. 构造器
	    自动注入 @autowired
	    postProcessBeforeInitialization
	    @PostConstruct
	    InitializingBean接口的 afterPropertiesSet 方法
	  2. initUser
	    postProcessAfterInitialization
	    @PreDestroy
	    DisposableBean 接口的 destroy方法
	  3. destroyUser
	 */
	@Bean(initMethod = "initUser", destroyMethod = "destroyUser")
	public User user(){
		return new User();
	}
	
	
	@Bean
	public Car car(){
		return new Car();
	}
	
	
}
