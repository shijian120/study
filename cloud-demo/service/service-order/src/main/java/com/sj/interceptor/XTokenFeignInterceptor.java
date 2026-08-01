package com.sj.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * ClassName: XTokenFeignInterceptor
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/27 19:53
 * @Version 1.0
 */

@Component
public class XTokenFeignInterceptor implements RequestInterceptor {
	
	/*
	RequestTemplate 封装了这次请求的 所有的数据，都保存在 RequestTemplate中
	
	我们可以修改 RequestTemplate中的数据，或者添加一些数据
	 
	 */
	@Override
	public void apply(RequestTemplate template) {
		
		System.out.println("请求拦截器被调用了");
	// 例如像请求头中添加token信息
		template.header("XToken", "sssssss");
	}
}
