package com.sj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 定制过滤器链
 */

@Configuration
public class SecurityConfig {
	
	/*
	   当我们创建了 SecurityFilterChain 放入容器后, 如果什么都不设置, 此时 会返回10个过滤器
	   如果我们不配置的时候会,默认是有15个过滤器的
	   为什么我们加上了自己的 SecurityFilterChain 就变成了10个呢
	   因为在自动配置中会有 下面代码中的3个操作, 当我们注入了自己的 SecurityFilterChain 后, 就会导致 下面的3行代码没有了
	   
	   这里我们又加上了 这3行代码, 也就是说, 这个过滤器,现在和默认的过滤器是一样的
	   
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		// 排除 /login 登录页的访问权
		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/login").permitAll());
		
		// 拦截范围
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		
		// 下面2中都是基于 用户名密码的登录, 不同之处在于, formLogin是基于的html的表单, httpBasic 是基于 类似alert的方式的
		// 我们浏览一种就可以了
		
		// 展示登陆表单
		http.formLogin(Customizer.withDefaults());
		// 认证方式采用基础的认证方式(用户名+密码)
		// http.httpBasic(Customizer.withDefaults());
		
		// 禁用 csrf
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
	
	/*
	默认情况下, InMemoryUserDetailsManager spring-security 已经提供了, 但是他是加载配置文件中的 用户名密码到内存
	
	我们可以自己指定一个 InMemoryUserDetailsManager, 这样, 默认的就不会被自动配置
	
	因此就不会加载 配置文件中的配置
	
	此时就会用我们的  InMemoryUserDetailsManager
	
	但是我们通过  shijian ,123 登录 会出现下面的错误, "没有密码加密器"
	There is no PasswordEncoder mapped for the id "null"
	
	我们可以在密码前面加上 {noop}, 此时就可以通过用户名,密码访问了
	
	
	
	
	 */
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		
		return new InMemoryUserDetailsManager(
				User.withUsername("shijian")
						.password("{noop}123")
						// 这里不讨论角色问题
						.roles("USER")
						.build());
  
	}
}
