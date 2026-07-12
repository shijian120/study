package com.sj.aop;

import org.springframework.stereotype.Component;

/**
 * ClassName: Calculator
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 15:24
 * @Version 1.0
 */

@Component
public class CalculatorImpl implements Calculator {
	
	
	public int add(int i, int j){
	
		return i + j;
	}
	
	public int sub(int i, int j){
		
		return i -   j;
	}
	
	@Override
	public int mul(int i, int j) {
		return 0;
	}
	
	
	public int div(int i, int j){
		
		return i / j;
	}
}
