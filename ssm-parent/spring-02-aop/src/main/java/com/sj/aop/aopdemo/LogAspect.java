package com.sj.aop.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * ClassName: CalculatorAspect
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 16:14
 * @Version 1.0
 */

// 切面
@Component
@Aspect
public class LogAspect {
	
	// 告诉 spring
	/*
		何时?
		 @Before
		 @AfterReturning: 方法正常结束执行
		 @AfterThrowing: 方法异常执行
		 @After: 方法执行后执行
		何地?
			切入点表达式  写法
			execution(修饰符 返回值类型 方法名(参数列表))
			execution(public int com.sj.aop.aopdemo.CalculatorImpl.add(int,int))
			execution(* com.sj.aop.aopdemo.*.*(..))
			annotation(org.springframework.stereotype.Component)
	 */
	
	
	
	@Before("execution(public int com.sj.aop.CalculatorImpl.*(int,int))")
	public void logStart(JoinPoint jp) {
		Object[] args = jp.getArgs();
		// 签名/ 就是方法的全部签名, 需要转换成子类才能获取到方法名
		MethodSignature signature = (MethodSignature) jp.getSignature();
		
		Method method = signature.getMethod();
		System.out.println("方法名: " + method.getName());
		System.out.println("参数: " + args[0] + "," + args[1]);
		System.out.println("日志开始");
	
	}
	
	@After("execution(public int com.sj.aop.CalculatorImpl.*(int,int))")
	public void logEnd(){
		System.out.println("日志结束... finally中");
	}
	
	
	// 正常返回
	@AfterReturning("execution(public int com.sj.aop.CalculatorImpl.*(int,int))")
	public void logReturning (){
		
		System.out.println("日志返回");
	}
	
	// 出现异常
	@AfterThrowing("execution(public int com.sj.aop.CalculatorImpl.*(int,int))")
	public void  logException(){
		
		System.out.println("日志异常");
	}
	
	
	// 把切点表达式抽取出来
	@Pointcut("execution(public int com.sj.aop.CalculatorImpl.*(int,int))")
	public void cal(){
	}
	
}
