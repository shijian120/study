package com.sj.springboot01demo;

/*
spring boot 的声明周期

声明周期流程, 3大阶段
1. 引导
    1. 启动
    2. 准备环境变量信息
2. 启动
    1. 创建ioc容器
    2. 初始化ioc容器
    3. ioc容器 刷新, 就是添加组件
    4. runner 调用
3. 运行

spring 对上述很多步骤,进行了暴露, 我们可以通过实现 不同的监听器,来感知不同的阶段

这里有一个 SpringApplicationRunListener , 他就暴露的很多阶段, 看 我们自己的写的监听器


配置监听器
1. 监听器不能像 普通的组件一样,直接放入的ioc容器中
2. 主要是因为, 太早了, 容器都还没有启动

spring其实提供了很多的监听器, 我们可以在不同的阶段, 实现不同的监听器

监听器一般要配置在 META-INF/spring.factories 文件中
因为他 加载的时机过早,导致传统的组件注入方式,无法使用
当然,这不是绝对的, 例如 ApplicationRunner, 和 CommandLineRunner , 他们是可以放入容器中的.
他们2个监听的是容器启动后的阶段


这里给我们一个提示, 如果一个项目下, 有  META-INF/spring.factories  文件,
那么就代表, 这个项目 会监听 容器启动之前的某个时候,这样可以增加项目的可见性和增加新的 "扩展 "

详细看 当前项目下的 监听器.png 文件



 */

public class SpringbootLifeTest {
}
