package com.sj.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * 自定义过滤器, 和全局过滤器比, 他可以只在一些 路由上生效,而不是全局生效
 */

@Component
public class OnceTokenGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
	
	
	@Override
	public GatewayFilter apply(NameValueConfig config) {
		return new GatewayFilter() {
			@Override
			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
				// 每次响应之前，添加一个一次性令牌，支持 uuid，jwt等各种格式
				return chain.filter(exchange).then(Mono.fromRunnable(() -> {
					ServerHttpResponse response = exchange.getResponse();
					HttpHeaders headers = response.getHeaders();
					String value = config.getValue();
					if ("uuid".equalsIgnoreCase(value)) {
						value = UUID.randomUUID().toString();
					}
					
					if ("jwt".equalsIgnoreCase(value)) {
						value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Ikp";
					}
					
					headers.add(config.getName(), value);
				}));
			}
		};
	}
	
}
