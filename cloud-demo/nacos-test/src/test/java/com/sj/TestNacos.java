package com.sj;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * ClassName: TestNacos
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/5/19 01:02
 * @Version 1.0
 */

public class TestNacos {
	
	
	/*
	从 nacos  拉取配置
	
	ConfigService 是一个接口, 他可以
	- 发布配置  获取配置
	- 发布监听 获取监听
	 */
	@Test
	public void test() throws NacosException, InterruptedException, IOException {
		
		try {
			String serverAddr = "localhost:8848";
			String dataId = "test";
			String group = "DEFAULT_GROUP";
			
			Properties properties = new Properties();
			properties.put("serverAddr", serverAddr);
			properties.put("username","nacos");
			properties.put("password","nacos");
			ConfigService configService = NacosFactory.createConfigService(properties);
			String content = configService.getConfig(dataId, group, 5000);
			System.out.println(content);
			
			
			
			
			// 监听配置, 当配置被修改,可以监听到
			configService.addListener(dataId, group, new Listener() {
				@Override
				public Executor getExecutor() {
					System.out.println("getExecutor....");
					return null;
				}
				
				@Override
				public void receiveConfigInfo(String configInfo) {
					System.out.println(configInfo);
				}
			});
			
		} catch (NacosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.in.read();
		
		
	}
}
