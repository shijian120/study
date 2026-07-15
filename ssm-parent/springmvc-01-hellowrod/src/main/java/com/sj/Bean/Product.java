package com.sj.Bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 {
 "id": 1001,
 "name": "Product A",
 "price": 299.99
 }
 */

@Data
public class Product {
	
	private int id;
	private String name;
	private BigDecimal price;
	
}
