package com.sj.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * ClassName: RTGlobalFilter
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/5/24 15:58
 * @Version 1.0
 */

@Slf4j
@Component
public class RTGlobalFilter implements GlobalFilter, Ordered {
	
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		
		String path = request.getURI().toString();
		
		LocalDateTime start = LocalDateTime.now();
		
		log.info("请求路径:{},请求开始时间:{},", path, start);
		
		// 这里是异步的, 按理说 ,过滤器之后的逻辑 应该写在 chain.filter() 之后
		// 但是因为是 异步的, 因此 需要通过回调来执行后续的逻辑
		// 如果写在过滤器之后, 就不是过滤器之后的执行逻辑了
		Mono<Void> filter = chain.filter(exchange).doFinally((r) -> {
			
			LocalDateTime end = LocalDateTime.now();
			log.info("请求结束时间:{}, 总共用时:{}", end, Duration.between(start,end).getNano());
			
		});
		// 放行
		
		
		return filter;
	}
	
	@Override
	public int getOrder() {
		return 0;
	}
}
