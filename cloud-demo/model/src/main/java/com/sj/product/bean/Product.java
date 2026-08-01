 package com.sj.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Product
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 06:34
 * @Version 1.0
 */

@Data
public class Product {
	
	private  Long id;
	private BigDecimal price;
	private String productName;
	private int num;
}
