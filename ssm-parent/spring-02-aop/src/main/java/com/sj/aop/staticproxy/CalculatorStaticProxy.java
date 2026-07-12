package com.sj.aop.staticproxy;

import com.sj.aop.Calculator;
import com.sj.aop.CalculatorImpl;

/**
 * ClassName: CalculatorStaticProxy
 * Package:
 * Descript
 *
 * 静态代理,
 *  实现相同的接口, 成员变量是目标对象
 *
 *
 * 静态代理实在编码时接入的
 *
 *
 */

public class CalculatorStaticProxy implements Calculator {
	
	// 被代理的类
	private CalculatorImpl target;
	
	public CalculatorStaticProxy(CalculatorImpl calculator) {
		this.target = calculator;
	}
	
	@Override
	public int add(int i, int j) {
		
		int add = target.add(i, j);
		
		return add;
	}
	
	@Override
	public int sub(int i, int j) {
		
		int sub = target.sub(i, j);
		return sub;
	}
	
	@Override
	public int mul(int i, int j) {
		
		int result = target.mul(i, j);
		return result;
	}
	
	@Override
	public int div(int i, int j) {
		
		int div = target.div(i, j);
		return div;
	}
}
