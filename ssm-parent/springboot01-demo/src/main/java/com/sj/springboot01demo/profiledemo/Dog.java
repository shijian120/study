package com.sj.springboot01demo.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/*
Profile
 @Profile("环境")  用来指定组件生效的环境变量
 spring.profiles.active=dev 激活环境, 不只会激活 @Profile("dev") 组件,
    还会激活 application-dev.properties配置文件
 




 
 激活配置
 spring.profiles.active=dev
 上述配置 会激活 application-dev.properties配置文件,
 同时application-dev.properties配置文件中的配置会覆盖application.properties中的配置
    这句话的意思是:  Profile专属配置文件的优先级高于主配置文件
 
 spring.profiles.active=dev 配置还会激活 @Profile("dev") 注解的组件
 
 
 
 spring:
    config:
        activate:
            on-profile: dev
 这个配置是用在 yaml 配置文件中的 多环境配置的激活方式
 因为yaml 文件可以 通过 --- 分隔多个环境的配置, spring.profiles.active=dev
 
 
 还有一种用法
 spring.profile.include=haha
 他会包含 application-haha.properties 配置文件
 
 
 */


// 当前组件仅在dev环境生效
@Profile("dev")
@Component
public class Dog {
}
