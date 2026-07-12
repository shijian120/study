package com.sj.spring.ioc.profiledemo;

import lombok.Data;

import javax.sql.DataSource;

/**
 * ClassName: MyDataSource
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 15:12
 * @Version 1.0
 */

@Data
public class MyDataSource {
	
	private String url;
	private String username;
	private String password;
}
