package com.sj.controller;

import com.sj.product.bean.Product;
import com.sj.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProductController
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 06:32
 * @Version 1.0
 */
@RequestMapping("/api/product")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//根据商品id获取商品信息
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id") Long productId){
		System.out.println("谁调用了！！！");
		return productService.getProductId(productId);
	}
	
}
