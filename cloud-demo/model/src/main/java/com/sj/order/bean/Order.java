package com.sj.order.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: Order
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 13:06
 * @Version 1.0
 */
// 订单
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	private Long id;
	// 订单总金额
	private BigDecimal totalAmount;
	private Long userId;
	private String nikeName;
	// 派送地址
	private String address;
	// 用户订单中的产品，其实应该是product类型的，但是现在product被定义在了 service-product中
	// 导致这里无法引入
	private List<Object> productList;
}
