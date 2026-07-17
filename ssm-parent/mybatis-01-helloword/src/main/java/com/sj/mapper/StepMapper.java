package com.sj.mapper;

import com.sj.bean.Customer;
import com.sj.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分步查询
 */

@Mapper
public interface StepMapper {

	/*
	 	需求: 按照id查询客户,以及客户的所有订单
	 	
	 	方式1  原生分步的方式
	 	    1. 先查询客户
	 	    2. 在根据客户端id 去查询订单
	 	方式2:
	 	   通过连表查询, 也就是 CustomerMapper接口汇中的实现
	 	   
	 	方式3:
	 	    通过MP的分步查询
	 	
	 */
	
	
	// 方式1
	// 按照id查询客户信息
	Customer selectCustomerById(Long id);
	
	// 按照客户id查询订单信息, 可以在service层对数据进行整合, 这里在测试类中进行整合
	List<Order> selectOrdersByCustId(@Param("custId") Long custId);
	
	// 方式2 根据客户id 查询到客户,以即客户的所有订单
	Customer selectCustomerAndOrders(long id);
	
	
	// 按照 id 查询订单,以及下订单的客户
	Order selectOrderAndCustomer(Long id);
}
