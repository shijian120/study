package com.sj;

import com.sj.dao.AccountDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * ClassName: AccountDaoTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 20:38
 * @Version 1.0
 */

@SpringBootTest
public class AccountDaoTest {
	
	@Autowired
	AccountDao accountDao;
	
	
	// 扣减账户余额
	
	@Test
	public void testUpdateAccount(){
		accountDao.updateAccount("zhangsan",new BigDecimal(100));
	}
	
}
