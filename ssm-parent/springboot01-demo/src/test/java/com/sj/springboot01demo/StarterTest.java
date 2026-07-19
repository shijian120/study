package com.sj.springboot01demo;

/**
自定义starter
 
 步骤
 1. 创建一个项目 , 这个项目要依赖基础的 spring-boot-starter, 和 依赖
 2. 例如叫做  shijian-spring-boot-starter, 但是他没有启动类, 因为他是让别人导入的
 3. 其他项目(例如叫做 A )引入 就可以  shijian-spring-boot-starter
 4. 但是此时 项目A 是启动是, 无法 扫描到 shijian-spring-boot-starter 下的 Bean的
 5. 因为 项目A 只会扫描自己所在的包的下的 配置
 
 6. 此时我们就需要 在  shijian-spring-boot-starter 中 写一个自动配置类
 7. 例如叫做 ShijianAutcConfiguration, 在这个配置类中,  通过 @Bean注解 添加组件(此时是无法添加到容器中的
 8. 项目A 在导入  shijian-spring-boot-starter 后, 可以通过 @Import(ShijianAutcConfiguration.class)
 9. 这样就可以 间接导入 shijian-spring-boot-starter 向容器中注入的bean了
 10 因为 项目A 通过 @Import(ShijianAutcConfiguration.class) 导入了 自动配置类 ShijianAutcConfiguration
 ShijianAutcConfiguration 又在里面通过 @Bean 注解添加了 Bean, 所以可以间接的将 容器中需要的bean添加到项目A的容器中了
 
 11 但是上面的做法是有缺点的, 我们还需要 通过  @Import(ShijianAutcConfiguration.class)
 12 如果是一个 陌生的starter ,我们是不知道要导入什么自动配置类的
 
 13 我们可以顶一个注解 @EnableShijian的注解, 这个注解 上写上 @Import(ShijianAutcConfiguration.class)
 就是这个样子
 
 @@Import(ShijianAutcConfiguration.class)
 public @interface EnableShijian {}
 
 14 此时引入 shijian-spring-boot-starter 的项目,就是通过 @EnableShijian注解来开启功能的
 15 这样 就不用 再写 @Import(ShijianAutcConfiguration.class) 了,因为 由 EnableShijian 来帮我们完成了导入的操作了
 
 这么写,就是 在导入  shijian-spring-boot-starter 后, 还需要在项目A上,添加 @EnableShijian 注解,
 
 
 16 但是像 spring-boot-starter-web ,我们引入这个依赖,其实我们是没有使用 @Enablexxx 注解的, 他就可以自动导入
 
 17, 他的做法就是通过自动配置原理完成
 
 18 我们在 shijian-spring-boot-starter 创建  META-INF/spring/@Autoconfiguration.impors
 19 在这个文件中,我们写上 ShijianAutcConfiguration.的全限定类名
 20 springboot 在启动的时候,就会自动取臊面这个 文件,并且将内容放到容器
 21 此时就不需要使用 @EnableShijian 这个开关注解了, 只要我们引入了 某个starter, 自动配置自然就有了
 
 
 */

public class StarterTest {
}
