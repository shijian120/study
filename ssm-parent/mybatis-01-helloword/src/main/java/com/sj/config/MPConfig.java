package com.sj.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * ClassName: MPConfig
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 20:33
 * @Version 1.0
 */

@MapperScan("com.sj.mapper")
@Configuration
public class MPConfig {
	
	// 配置分页插件
	@Bean
	PageInterceptor pageInterceptor(){
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("helperDialect","mysql");
		// 分页合理化, 如果查询超过最大页会查询最后一页, 如果小于第一页,会查询第一页
		properties.setProperty("reasonable","true");
		pageInterceptor.setProperties(properties);
		return pageInterceptor;
	}
}
