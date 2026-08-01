package com.sj.service;

import com.sj.order.bean.Order;

/**
 * ClassName: OrderService
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 13:10
 * @Version 1.0
 */

public interface OrderService {
	
	// 创建订单，需要购买的商品，那个用户购买的
	Order createOrder(Long productId,Long userId);
}
