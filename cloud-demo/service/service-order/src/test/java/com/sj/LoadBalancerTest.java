package com.sj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ClassName: LoadBalancerTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 20:24
 * @Version 1.0
 */
@SpringBootTest
public class LoadBalancerTest {
	
	// 用来做负载均衡
	@Autowired
	LoadBalancerClient loadBalancerClient;
	@Autowired
	DiscoveryClient discoveryClient;
	
	@LoadBalanced
	@Autowired
	RestTemplate restTemplate;
	
	
	@Test
	public void test111(){
		// class org.springframework.web.client.RestTemplate
		
		System.out.println(restTemplate.getClass());
	}
	
	
	@Test
	public void test(){
		// class org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient
		System.out.println(loadBalancerClient.getClass());
	}
	
	// 测试负载均衡
	@Test
	void loadBalancerTest(){
		
		// 这个方法是获取某个服务的所有实例，如果想实现负载均衡，需要自己写算法
		List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
		
		// 下面调用了2个choose方法，都是去找服务 service-product
		// 此时会发现 baseUrl 的值不同
		// 因为 它会负载均衡的调用
		ServiceInstance choose = loadBalancerClient.choose("service-product");
		String baseUrl = choose.getHost() +":" + choose.getPort();
		System.out.println(baseUrl);
		
		ServiceInstance choose1 = loadBalancerClient.choose("service-product");
		String baseUrl1 = choose1.getHost() +":" + choose1.getPort();
		System.out.println(baseUrl1);
		
	}
	
}
