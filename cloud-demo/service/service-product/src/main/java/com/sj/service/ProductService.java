package com.sj.service;

import com.sj.product.bean.Product;

/**
 * ClassName: ProductService
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 06:37
 * @Version 1.0
 */

public interface ProductService {
	// 根据商品id获取商品
	Product getProductId(Long productId);
}
