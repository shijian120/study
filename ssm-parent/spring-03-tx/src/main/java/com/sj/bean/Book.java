package com.sj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ClassName: Book
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 19:59
 * @Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
	
	private Integer id;
	private String bookName;
	private Integer stock;
	private BigDecimal price;
	
}
