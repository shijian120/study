package com.sj.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sj.common.R;
import com.sj.order.bean.Order;
import com.sj.properties.OrderProperties;
import com.sj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 13:04
 * @Version 1.0
 */

// 自动刷新功能
@RequestMapping("/api/order")
// @RefreshScope
@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	// @Value("${order.timeout}")
	// String orderTimeout;
	//
	// @Value("${order.auto-confirm}")
	// String autoConfirm;
	
	@Autowired
	OrderProperties orderProperties;
	
	
	// 创建订单
	@GetMapping("/create")
	public Order createOrder(@RequestParam("userId")Long userid,
	                         @RequestParam("productId") Long productId){
		
		return orderService.createOrder(productId, userid);
	}
	
	
	@RequestMapping("/order/config")
	public String config(){
		// return "超时时间:" + orderTimeout +"==="+"autoConfirm:" + autoConfirm;
		return "超时时间:" + orderProperties.getTimeout() +"==="+"autoConfirm:" + orderProperties.getAutoConfirm();
		
	}
	
	@GetMapping("/sj")
	public R helloTest(){
		return R.ok();
	}
}
