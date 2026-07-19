package com.sj.service.impl;

import java.math.BigDecimal;
import java.util.List;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sj.feign.ProductFeignClient;
import com.sj.order.bean.Order;
import com.sj.product.bean.Product;
import com.sj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: OrderServiceImpl
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/25 13:13
 * @Version 1.0
 */
@Slf4j
@EnableFeignClients
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	ProductFeignClient productFeignClient;
	
	/*
	  创建订单，不仅要调用本服务的功能，还要进行远程调用
	 */
	@SentinelResource(value = "createOrder" , blockHandler = "createOrderFallback")
	@Override
	public Order createOrder(Long productId, Long userId) {
		System.out.println("productId:="+ productId);
		System.out.println("userId:="+ userId);
		
		// 远程调用
		// Product product = getProductFromRemoteWithLoadBalancerAndLoadBalancer(productId);
		
		Product product  = getProductFromRemoteWithFeign(productId);
		
		Order order = new Order();
		order.setId(1L);
		// TODO 总金额 需要计算，需要根据 productId，去远程查询，商品单价，这里做了简化，没有说明商品数量
		order.setTotalAmount(new BigDecimal(String.valueOf(product.getPrice().multiply(new BigDecimal(product.getNum())))));
		order.setUserId(userId);
		order.setNikeName("帅坚");
		order.setAddress("娄子水");
		// TODO 远程查询
		order.setProductList(List.of(product));
		
		
		return order;
	}
	
	// 兜底 回调 ,
	public Order createOrderFallback(Long productId, Long userId, BlockException e) {
		Order order = new Order();
		order.setId(productId);
		order.setTotalAmount(new BigDecimal("0"));
		order.setUserId(userId);
		order.setNikeName("未知商品111111");
		order.setAddress("未知地址11111");
		order.setProductList(null);
		
		return order;
	}
	
	
	
	/*
	  远程调用第1版
	    下面的方式虽然进行了远程调用但是我们可以看到，每次都获取的第一台实例，没有实现负载均衡
	    
	    通过 discoveryClient 获取 nacos中的 service-product 服务的 ip+port
	    接着做拼接
	    最后通过 restTemplate 做远程调用
	 */
	// 从远程获取Product数据
	private Product getProductFromRemote(Long productId) {
		List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
		ServiceInstance serviceInstance = instances.get(0);
		String host = serviceInstance.getHost();
		int port = serviceInstance.getPort();
		// http://service-product:9000/ product/{id}
		String baseUrl = "http://" + host + ":" + port + "/product/" + productId;
		log.info("baseUrl:{}",baseUrl);
		return restTemplate.getForObject(baseUrl, Product.class);
	}
	
	/*
	远程调用第2版 带有负载均衡
	1. 导入 loadBalancer 依赖
	2 此时ioc 会有一个  loadBalancerClient  组件
	3. 使用 loadBalancerClient 组件获取服务的 ip +端口
	4. loadBalancerClient组件 每次获取,都是负载均衡的获取
	
	*/
	private Product getProductFromRemoteWithLoadBalancer(Long productId) {
		// 通过springCloud的服务发现接口（底层是nacos）从注册中心发现 服务
		ServiceInstance instance = loadBalancerClient.choose("service-product");
		
		String host = instance.getHost();
		int port = instance.getPort();
		// http://service-product:9000/ product/{id}
		String baseUrl = "http://" + host + ":" + port + "/product/" + productId;
		
		log.info("baseUrl:{}",baseUrl);
		// 给远程服务发送请求
		//  RestTemplate 是spring提供的，可以发起远程调用，但是不用每次都new，它是线程安全的，可以放到容器中
		return restTemplate.getForObject(baseUrl, Product.class);
	}
	
	/*
	第3版
	基于注解的负载均衡，只需要知道服务名就可以了
	
	1.也是使用 restTemplate 进行远程调用
	2. restTemplate 上加了 	@LoadBalanced , @Bean 注解
	3. 此时 restTemplate 就带有了负载均衡
	
	*/

	private Product getProductFromRemoteWithLoadBalancerAndLoadBalancer(Long productId) {
		
		
		// service-product 会被动态替换，因为 	restTemplate上面加了 LoadBalanced 注解
		String baseUrl = "http://service-product:9000/product/" + productId;
		
		// 给远程服务发送请求
		//  RestTemplate 是spring提供的，可以发起远程调用，但是不用每次都new，它是线程安全的，可以放到容器中
		return restTemplate.getForObject(baseUrl, Product.class);
	}
	
	// 	feign 实现远程调用
	
	// @SentinelResource("不写监控不到")
	/*
	blockHandler 和 fallback 都是 错误处理
	根据源码 blockHandler 的执行在 fallback 执行之前
	 */
	@SentinelResource(value = "getProductFromRemoteWithFeign", blockHandler = "getProductFromRemoteWithFeignFallback",fallback = "getProductFromRemoteWithFeignFallback")
	private Product getProductFromRemoteWithFeign(Long id){
		
		return productFeignClient.getProduct(id);
	}
	
	public Product getProductFromRemoteWithFeignFallback(Long id){
		Product product = new Product();
		product.setId(id);
		product.setProductName("未知商品");
		product.setNum(0);
		product.setPrice(new BigDecimal("0"));
		return product;
	}
	
	public Product getProductFromRemoteWithFeignFallback(Long id, BlockException e){
		Product product = new Product();
		product.setId(id);
		product.setProductName("未知商品");
		product.setNum(0);
		product.setPrice(new BigDecimal("0"));
		return product;
	}
}
