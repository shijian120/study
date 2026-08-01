package com.sj.springboot01demo.propertiesbinding;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/*
@EnableConfigurationProperties(CatProperties.class) 和 @Configuration 一起使用

 */

@Component
@ConfigurationProperties(prefix = "cat")
@Data
public class CatProperties {
	
	private String name;
	private Integer age;
	
}
