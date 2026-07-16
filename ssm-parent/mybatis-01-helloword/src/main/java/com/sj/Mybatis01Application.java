package com.sj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
步骤
1. 导入mybatis依赖
2. 配置数据源信息
3. 编写一个javaBean 对应数据库一个表模型
4. 告诉mybatis 去哪里找这个映射文件; mybatis.mapper-locations=classpath:mapper/*.xml
5. 编写单元测试
 */

@MapperScan("com.sj.mapper")
@SpringBootApplication
public class Mybatis01Application {
	public static void main(String[] args) {
		SpringApplication.run(Mybatis01Application.class, args);
	}
}