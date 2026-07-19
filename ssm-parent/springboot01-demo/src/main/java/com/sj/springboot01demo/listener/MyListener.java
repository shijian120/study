package com.sj.springboot01demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.bootstrap.ConfigurableBootstrapContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/*
SpringApplicationRunListener 其实就是给我暴露的回调钩子

这个MyListener能够运行 需要配置在 META-INF/spring.factories 文件中
这个说明, 他启动的时间很早, 没有ioc容器,因此无法 将他放入ioc容器

这里我想到以前 加载 nacos 的配置, 其实就是配置在 spring.factories 文件中



 */

@Slf4j
public class MyListener implements SpringApplicationRunListener  {
	
	
	
	// 这个方法最早, 早到日志框架还没加载, 只能使用 System.out.println() 打印内容
	@Override
	public void starting(ConfigurableBootstrapContext bootstrapContext) {
		System.out.println("application starting...");
		
		
		// log.info("application starting...");
		SpringApplicationRunListener.super.starting(bootstrapContext);
	}
	@Override
	public void started(ConfigurableApplicationContext context, @Nullable Duration timeTaken) {
		
		log.info("application started...");
		
		SpringApplicationRunListener.super.started(context, timeTaken);
	}
	
	@Override
	public void ready(ConfigurableApplicationContext context, @Nullable Duration timeTaken) {
		// 最后, ioc 已经 准本好
		log.info("application ready...");
		SpringApplicationRunListener.super.ready(context, timeTaken);
	}
	
	@Override
	public void failed(@Nullable ConfigurableApplicationContext context, Throwable exception) {
		log.info("application failed...");
		SpringApplicationRunListener.super.failed(context, exception);
	}
	
	@Override
	public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
		//1  这个方法执行的最早, 在 banner打印 之前执行的
		log.info("application environmentPrepared...");
		SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
	}
	
	
	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		
		// 3  这个方法第三个个执行
		log.info("application contextLoaded...");
		SpringApplicationRunListener.super.contextLoaded(context);
	}
	
	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		// 2 这个方法第二个执行,在banner之后
		log.info("application contextPrepared...");
		SpringApplicationRunListener.super.contextPrepared(context);
	}
}
