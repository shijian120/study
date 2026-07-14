package com.sj.service.impl;

import com.sj.bean.Book;
import com.sj.dao.AccountDao;
import com.sj.dao.BookDao;
import com.sj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * ClassName: UserServiceImpl
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/13 00:42
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public void checkout(String username, Integer bookId, Integer amount) {
		
		// 书的信息
		Book book = bookDao.selectBookById(bookId);
		
		// 价格
		BigDecimal price = book.getPrice();
		
		
		//  单本价格 * amount = 总价格
		BigDecimal totalPrice = price.multiply(new BigDecimal(amount));
		
		
		// 扣减余额
		accountDao.updateAccount(username, totalPrice);
		
		// 扣减库存
		bookDao.updateBookStock(bookId, amount);
	 
		
		/*
		上述是 购买图书的方法, 主要就是2点
		1. 需要扣减余额
		2. 需要扣减库存
		3. 需要生成订单, 这里没有实现
		
		可以看到,单单是一个购买图书的业务, 需要操作多个表, 多个对象, 这种业务, 就叫做 需要 "事务" 的.
		 */
		
	}
	
	/*
	timeout = 3 超过3s 就会回滚
	 */
	@Transactional(rollbackFor = Exception.class, timeout = 3, readOnly = false)  // 1. 必须加事务
	public void checkoutPlus(String username, Integer bookId, Integer amount) throws InterruptedException {
		
		// 2. 检查图书是否存在
		Book book = bookDao.selectBookById(bookId);
		if (book == null) {
			throw new RuntimeException("图书不存在");
		}
		
		// 3. 计算总价（这里用 BigDecimal 没问题）
		BigDecimal totalPrice = book.getPrice().multiply(new BigDecimal(amount));
		
		// 4. 扣减余额（假设 DAO 返回影响行数 int）
		int updateAccount = accountDao.updateAccount(username, totalPrice);
		if (updateAccount != 1) {
			throw new RuntimeException("余额不足，扣减失败");
		}
		
		// 5. 扣减库存（SQL 中必须包含 stock >= amount 的条件）
		int updateStock = bookDao.updateBookStock(bookId, amount);
		if (updateStock != 1) {
			// 这里注意：由于事务回滚，前面扣的余额也会被撤销，不会造成损失
			throw new RuntimeException("库存不足，扣减失败");
		}
		
		
		Thread.sleep(5000);
		
		
		int i = 1 / 0;
	}
}
