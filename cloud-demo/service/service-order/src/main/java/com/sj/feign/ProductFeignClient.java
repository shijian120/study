package com.sj.feign;

import com.sj.feign.fallback.ProductFeignClientFallback;
import com.sj.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: ProductFeginClient
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/26 20:47
 * @Version 1.0
 */

@FeignClient(
		value = "service-product",
		fallback = ProductFeignClientFallback.class
)
public interface ProductFeignClient {
	
	// 远程调用也使用了gateway
	@GetMapping("/api/product/product/{id}")
	Product getProduct(@PathVariable("id") Long productId);

}
