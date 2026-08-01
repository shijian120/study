package com.sj.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Order
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 00:06
 * @Version 1.0
 */

@Data
public class Order {

	private Long id;
	private String address;
	private BigDecimal amount;
	
	// 客户表和订单表存在一对多的关系, 关联关系存储在多的一方
	private Long customerId;
	
	// 这个属性就是订单对应客户的信息
	private Customer customer;
	
}
