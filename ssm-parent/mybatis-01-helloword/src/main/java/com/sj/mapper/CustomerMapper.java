package com.sj.mapper;

import com.sj.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: Customer
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 00:11
 * @Version 1.0
 */

@Mapper
public interface CustomerMapper {
	
	// 根据id 查询客户信息
	Customer selectById(Long id);
	
	
	//按照id查询客户,以及客户的所有订单
	Customer  selectByIdWithOrders(Long id);
	
}
