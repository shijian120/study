package com.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: ProductMainApplication
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/24 23:19
 * @Version 1.0
 */

// 开启服务发现的功能
@EnableDiscoveryClient
@SpringBootApplication
public class ProductMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductMainApplication.class, args);
	}
}
