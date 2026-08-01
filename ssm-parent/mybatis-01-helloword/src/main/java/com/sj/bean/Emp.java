package com.sj.bean;

import lombok.Data;


@Data
public class Emp implements java.io.Serializable{
	
	private Integer id;
	private String empName;
	private Integer age;
	private Double empSalary;
	
}
