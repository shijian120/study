package com.sj.aop.dynamic;

import java.lang.reflect.Proxy;

/**
 * ClassName: DynamicDemo
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 15:58
 * @Version 1.0
 */

public class DynamicProxy {
	
	private Object target;
	
	public DynamicProxy(Object target) {
		this.target = target;
	}
	
	 Object proxyMethod() {
		
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				(proxy, method, args) -> {
					
					
					method.invoke(proxy,args);
					
					return proxy;
				}
		);
		
		
	}
	
	
}
