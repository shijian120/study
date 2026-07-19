package com.sj;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * ClassName: DiscoveryTest
 * Package:
 * Description:  测试服务的发现
 *
 * @Author shijian
 * @Create 2025/2/25 06:08
 * @Version 1.0
 *
 *
 */

@SpringBootTest
public class DiscoveryTest {
	
	/*
	* DiscoveryClient 是 spring提供的
	*
	* NacosDiscoveryClient 这个是 nacos提供的，它是 DiscoveryClient的子接口
	*
	* */
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	NacosDiscoveryClient nacosDiscoveryClient;
	
	
	@Test
	public void test(){
		//class org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClient
		System.out.println(discoveryClient.getClass());
	}
	
	
	// 获取服务（服务发现）
	@Test
	void test01(){
		for (String service : discoveryClient.getServices()) {
			
			System.out.println("------->"+service); // service-order 和 service-product
			
			List<ServiceInstance> instances = discoveryClient.getInstances(service);
			for (ServiceInstance instance : instances) {
				System.out.println("ip="+ instance.getHost()+"\t port="+instance.getPort());
			}
		}
		
 	}
	
	
	@Test
	void nacosDiscoveryClientTest(){
		
		for (String service : nacosDiscoveryClient.getServices()) {
			
			System.out.println("------->"+service); // service-order 和 service-product
			
			List<ServiceInstance> instances = nacosDiscoveryClient.getInstances(service);
			for (ServiceInstance instance : instances) {
				System.out.println("ip="+ instance.getHost()+"\t port="+instance.getPort());
			}
		}
	}
}
