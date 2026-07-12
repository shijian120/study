package com.sj.spring.ioc.factory;

import com.sj.spring.ioc.component.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**

 */

// @Component
public class CarFactory  implements FactoryBean<Car> {
	@Override
	public Car getObject() throws Exception {
		return new Car();
	}
	
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}
	
	@Override
	public boolean isSingleton() {
		return FactoryBean.super.isSingleton();
	}
}
