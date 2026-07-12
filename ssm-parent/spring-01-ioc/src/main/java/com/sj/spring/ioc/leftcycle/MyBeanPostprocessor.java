package com.sj.spring.ioc.leftcycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ClassName: MyBeanPostprocessor
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 14:12
 * @Version 1.0
 */

public class MyBeanPostprocessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
