package com.sj.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Account
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 19:57
 * @Version 1.0
 */

@Data
public class Account {
	
	private Integer id;
	private String username;
	private Integer age;
	private BigDecimal money;
	
}
