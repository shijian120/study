package com.sj.spring.ioc.leftcycle;

import com.sj.spring.ioc.component.Car;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ClassName: User
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 13:39
 * @Version 1.0
 */

public class User implements InitializingBean, DisposableBean /*BeanPostProcessor*/ {
	
	
	Car car;
	
	@Autowired
	public void setCar(Car car) {
		System.out.println("自动注入 car");
		this.car = car;
	}
	
	public User() {
		System.out.println("构造器");
	}
	
	public void initUser() {
		System.out.println("自定义初始化方法 initUser");
	}
	
	
	public void destroyUser() {
		System.out.println("自定义销毁方法 destroyUser");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean 接口的 destroy方法");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("InitializingBean结构的 afterPropertiesSet 方法");
	}
	
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstruct....");
	}
	
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("PreDestroy....");
	}
	
	// @Override
	// public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	//
	//
	//
	// 	return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	// }
	//
	// @Override
	// public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	// 	return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	// }
}