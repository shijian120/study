package com.sj;

import com.sj.bean.Customer;
import com.sj.bean.Order;
import com.sj.mapper.CustomerMapper;
import com.sj.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: MultiTableMapper
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 00:29
 * @Version 1.0
 */

@SpringBootTest
public class MultiTableMapperTest {
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	CustomerMapper customerMapper;
	
	
	@Test
	public void testSelectByIdWithCustomer() {
		Order order = orderMapper.selectByIdWithCustomer(1L);
		System.out.println("order = " + order);
	}
	
	
	@Test
	public void testSelectByIdWithOrders() {
		Customer customer = customerMapper.selectByIdWithOrders(1L);
		System.out.println("customer = " + customer);
	}
	
}
