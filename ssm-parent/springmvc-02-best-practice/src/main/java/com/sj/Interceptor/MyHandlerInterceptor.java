package com.sj.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
拦截器

拦截还需要告诉 springmvc 这个拦截器要拦截什么请求



多个拦截器的执行顺序
1. preHandle0
2. preHandle1
3. controller
4. postHandle1
5. postHandle0
6. afterCompletion1
7. afterCompletion0
总结: 就是 preHandle -> controller -> postHandle -> afterCompletion 的执行流程
preHandle 正序执行, postHandle 和 afterCompletion 是倒序执行

上述都是 正常的流程,也就是返回 true ,如果返回false 就比较复杂了


拦截器 可以做 权限 , 日志, 数据共享(通过 threadlocal )



 */

@Slf4j
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("匹配路径: " + request.getServletPath());
		
		
		log.info("执行到拦截器preHandle");
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		log.info("执行到postHandle");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
		log.info("执行到afterCompletion");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
