package com.sj;

import com.sj.bean.Customer;
import com.sj.bean.Order;
import com.sj.mapper.StepMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: StepMapperTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 09:57
 * @Version 1.0
 */


@SpringBootTest
public class StepMapperTest {
	
	@Autowired
	StepMapper stepMapper;
	
	
	// 按照id查询客户,以及客户的所有订单
	// 原生分步的方式
	@Test
	public void test01() {
		// 第一步,先查询客户
		Customer customer = stepMapper.selectCustomerById(1L);
		
		// 第二步,在查询订单
		List<Order> orders = stepMapper.selectOrdersByCustId(customer.getId());
		
		// 整合到一起
		customer.setOrders(orders);
		
		System.out.println("customer = " + customer);
		
	}
	
	// MP的自动分步查询
	@Test
	public void test02() {
		Customer customer = stepMapper.selectCustomerAndOrders(1L);
		System.out.println("customer = " + customer);
	}
	
	
	// 查询订单,以及下订单的客户
	@Test
	public void test03() {
		Order order = stepMapper.selectOrderAndCustomer(1L);
		System.out.println("order = " + order);
	}
	
	
	// 延迟加载
	/*
	
	mybatis.configuration.lazy-loading-enabled=true
	mybatis.configuration.aggressive-lazy-loading=false
	 */
	@Test
	public void test04() throws InterruptedException {
		
		
		Customer customer = stepMapper.selectCustomerAndOrders(1);
		// 值获取了 客户的名字, 没用获取客户的订单信息,此时不会发送分步查询的第二步
		System.out.println(customer.getCustomerName());
		
		TimeUnit.SECONDS.sleep(3);
		
		// 只有用到了才会加载,才会执行分步查询的第二步
		System.out.println(customer.getOrders());
		
		
		
	}
}
