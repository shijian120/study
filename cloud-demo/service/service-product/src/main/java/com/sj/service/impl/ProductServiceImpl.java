package com.sj.service.impl;
import java.math.BigDecimal;

import com.sj.product.bean.Product;
import com.sj.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * ClassName: ProductServiceImpl
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 06:39
 * @Version 1.0
 */

@Service
public class ProductServiceImpl implements ProductService {
	@Override
	public Product getProductId(Long productId) {
		Product product = new Product();
		product.setId(productId);
		product.setPrice(new BigDecimal("10000"));
		product.setProductName("BMW-宝马");
		product.setNum(1);
		
		return product;
	}
}
