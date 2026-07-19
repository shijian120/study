package com.sj.gateway.predicatesfactory;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: SjRoutePredicateFactory
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/10/13 14:44
 * @Version 1.0
 */
@Component
public class SjRoutePredicateFactory extends AbstractRoutePredicateFactory<SjRoutePredicateFactory.Config> {
	
	

	
	public SjRoutePredicateFactory(){
		super(Config.class);
	}
	
	// 指定短写法时候参数的顺序
	@Override
	public List<String> shortcutFieldOrder() {
		return Arrays.asList("param", "value");
	}
	
	@Override
	public Predicate<ServerWebExchange> apply(Config config) {
		return new GatewayPredicate() {
			@Override
			public boolean test(ServerWebExchange serverWebExchange) {
				
				// 获取配置类中的值,也就是用户书写配置文件传递过来的值
				String param = config.param;  // 参数名  参数名是动态的
				String value = config.value;  // 参数值  参数值也是动态的, 都是从配置文件取出来的
				
				ServerHttpRequest request = serverWebExchange.getRequest();
				
				String first = request.getQueryParams().getFirst(param);
				
				
				return StringUtils.hasText(first) && first.equals(value);
			}
		};
	}
	
	/*
	可以配置的参数
长写法
predicates:
	- name: Sj
	  args:
		param: shijian
		value: hah
		
短写法
predicates:
   - Sj=shijian,hah
		
配置文件中的为什么可以写 param 和value 是因为 SjRoutePredicateFactory类中指定了参数的顺序

	 */
	
	@Validated
	public static class Config {
	
		@NotEmpty
		private String param;
		@NotEmpty
		private String value;
		
		public String getParam() {
			return param;
		}
		
		public void setParam(String param) {
			this.param = param;
		}
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}

		
	}
}
