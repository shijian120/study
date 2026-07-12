package com.sj.aop.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/*

aop常用的使用场景
1. 日志
2. 权限校验
3. 事务
4. 缓存
5. 性能监控
6. 异常处理

aop 其实就是 动态代理, 也就是或 代理某个类的某个方法, 相当于拦截器, 当拦截了这个方法,我们可以在
这个方法 之前,之后,做一些我们要做的事情


 
 
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
	
	
	/*
	环绕通知有固定写法, 必须有返回值 object, 必须放最后, 他类似于我们手写的动态代理
	
	注意, 环绕通知 应该有一个单独的切面, 而不是写在这里
	 */
	@Around("cal()")
	public Object logAround(ProceedingJoinPoint pjp){
		// 获取目标方法的参数
		Object[] args = pjp.getArgs();
		
		// 前置
		System.out.println("环绕-前置通知,参数" + Arrays.toString(args));
		
		Object proceed = null;
		
		try {
			
			proceed = pjp.proceed(args);// 执行目标方法
			System.out.println("环绕-返回通知");
		} catch (Throwable e) {
			// 异常必须抛出!!!!!, 因为如果有多个 切面, 环绕通知将异常捕获了,没有抛出,后面的切面是感知不到异常的
			// 这么导致会面的代码会认为 程序没问题
			throw new RuntimeException(e);
		}finally {
			// 后置
			System.out.println("环绕-后置通知");
		}
		
		
		System.out.println("环绕开始");
		return proceed;
	}
	
	
	
	// 把切点表达式抽取出来
	@Pointcut("execution(public int com.sj.aop.CalculatorImpl.*(int,int))")
	public void cal(){
	}
	
}
