package com.sj.bean;

import lombok.Data;

import java.util.List;

/**
 * ClassName: Customer
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 00:06
 * @Version 1.0
 */

@Data
public class Customer {
	private Long id;
	private String customerName;
	private String phone;
	
	// 客户度的订单
	List<Order> orders;
}
