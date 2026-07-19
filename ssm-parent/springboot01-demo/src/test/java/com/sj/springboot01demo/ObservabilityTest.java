package com.sj.springboot01demo;

import org.springframework.boot.test.context.SpringBootTest;
/*
Observability 可观测性
Spring Boot Actuator 提供了很多监控和诊断应用的端点

1. 导入 依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        
2. 看配置 actuator.properties

3. 访问 http://localhost:端口号/actuator
会返回 一个json格式的监控数据



 */
@SpringBootTest
public class ObservabilityTest {
}
