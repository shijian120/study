package com.sj.service;

/*
购买图书的的业务
1. 任何业务其实都是 crud
2. 对于购买图书来说, 就是 更新库存, 更新账户余额, 创建订单
3. 本事都是对表的数据进行修改


 */

public interface UserService {

	/*
	购买图书的完整方法
	1. 要选择 买什么书
	2. 要扣减库存,要扣减余额
	 */
	
	/**
	 * 购买图书的方法
	 * @param username  那个用户
	 * @param bookId   书的id (那本书)
	 * @param amount   买了几本
	 */
	void checkout(String username, Integer bookId, Integer amount);
	
	/**
	 * checkout方法的,事务版本
	 * @param username
	 * @param bookId
	 * @param amount
	 */
	void checkoutPlus(String username, Integer bookId, Integer amount) throws InterruptedException;
}
