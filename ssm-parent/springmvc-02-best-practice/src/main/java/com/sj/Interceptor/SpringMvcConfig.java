package com.sj.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
这里最重要的是 WebMvcConfigurer 他是对 springmvc做配置的
 */

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	MyHandlerInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器
		// /error路径一定要加上, 因为, 当我们访问 /user/login 路径时, 服务器没有,
		// 此时springmvc 会重定向到 /error, 因此如果不排除/error, 此时拦截器会拦截
		registry.addInterceptor(interceptor)
				        .addPathPatterns("/**")
						.excludePathPatterns("/index", "/", "/user/login", "/error");
	}
}
