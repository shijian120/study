package com.sj;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ClassName: OrderMain
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/24 23:07
 * @Version 1.0
 */

@EnableFeignClients(basePackages = "com.sj.feign" )
@EnableDiscoveryClient
@SpringBootApplication
public class  OrderMainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderMainApplication .class,args);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
		配置文件发生变化，发送邮件进行通知
		
		1. 我们想容器中放一个 ApplicationRunner
		2. ApplicationRunner当容器启动的最后阶段 ApplicationRunner就会运行它的run方法
		3. 这里使用的lambda其实那个 lambda就是 run方法
		4. 容器启动的最后阶段调用了 run 方法
		5. 我们通过 	 @Bean 将 ApplicationRunner放入容器中
		6， 因此spring容器的最后阶段就会调用run（自动调用的）如果有多个，ApplicationRunner可以通过 @Order注解表明顺序
		7. 调用run方法，执行里面的代码
		8 我门通过 nacosConfigManager.getConfigService(); 得到 配置服务 ConfigService
		9. 给服务添加监听器
		10.当 service-order.properties 发生了变化，监听器中的 receiveConfigInfo方法会被调用
		11. 当配置文件发生变化，可以做一些事情，这里就是发送邮件

	    说明：代码看着挺唬人，其实就是 创建了一个 ApplicationRunner的实现类对象
	        因为ApplicationRunner是一个接口，所以相当我们通过匿名内部类的方式创建了一个 ApplicationRunner的对象
	        这个对象的run方法会在spring容器启动的最后阶段被调用。
	        之后我门给服务添加监听器，监听 service-order.properties 配置文件
	 */
	@Bean  // NacosConfigManager 会从容器中找
	ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager){
		
		return args -> {
			System.out.println("applicationRunner！！！！！！！！！！1");
			ConfigService configService = nacosConfigManager.getConfigService();
			configService.addListener("service-order.properties", "DEFAULT_GROUP", new Listener() {
				@Override
				public Executor getExecutor() {
					return Executors.newFixedThreadPool(4);
				}
				
				@Override
				public void receiveConfigInfo(String configInfo) {
					System.out.println("变化的配置信息: "+configInfo);
					System.out.println("邮件通知 ");
				}
			});
		};
	}
	
}
