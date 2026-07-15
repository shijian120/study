package com.sj.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Employee
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/15 12:57
 * @Version 1.0
 */

@Data
public class Employee {
	
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	private String gender;
	private String address;
	private BigDecimal salary;
}
