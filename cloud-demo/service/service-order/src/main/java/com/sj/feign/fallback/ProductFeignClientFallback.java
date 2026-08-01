package com.sj.feign.fallback;
import java.math.BigDecimal;

import com.sj.feign.ProductFeignClient;
import com.sj.product.bean.Product;
import org.springframework.stereotype.Component;

/**
 * ClassName: ProductFeignClientFallback
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/27 20:17
 * @Version 1.0
 */
/*
兜底回调
1. feign 发起远程调用其他服务, 如果 出现了超时,或者其他服务的宕机的
2. 此时 feign 是拿不到数据的
3. 因此 当超时后, 我们可以 返回一个默认的数据
这么做的好处就是, 能够让业务流程 继续执行

如果没有兜底回调, 发起远程调用, 此时会出现错误的!!!!
出现错误,后面的代码不执行, 业务就断了, 也无法给前端返回

只有远程调用失败,才会出发兜底回调



 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient{
	@Override
	 public Product getProduct(Long id) {
		// 兜底回调
		Product product = new Product();
		product.setId(0L);
		product.setPrice(new BigDecimal("0"));
		product.setProductName("未知商品");
		product.setNum(0);
		// 返回默认数据
		return product;
	}
}
