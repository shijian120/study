package com.sj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * ClassName: AccountDao
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 20:00
 * @Version 1.0
 */

@Component
public class AccountDao {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	/**
	 *  按照username 扣减账户余额
	 * @param username  用户名
	 * @param money   扣减的金额
	 */
	public int updateAccount(String username, BigDecimal money){
		String sql = "update account set balance = balance - ? where username = ?";
		return jdbcTemplate.update(sql,money,username);
	}

}
