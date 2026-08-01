package com.sj.mapper;

import com.sj.bean.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrderMapper
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 00:13
 * @Version 1.0
 */

@Mapper
public interface OrderMapper {
	
	
	//根据订单id 查询订单信息
	Order selectById(Long id);
	
	
	/**
	* 按照id查询订单,以及下单的客户信息
	*/
	Order selectByIdWithCustomer(Long id);
	
}
