package com.sj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: GatewayApplication
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/3/5 20:31
 * @Version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class,args);
	}
}
