# 事务相关说明

##  步骤流程
1. 首先要引入 transaction 依赖 以及mysql的依赖
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>com.mysql</group   Id>
            <artifactId>mysql-connector-j</artifactId>
        </dependency>

```

2. 要开启事务注解，需要在配置类上添加 @EnableTransactionManagement
其实这个注解不写也行, 如果是spring boot项目, 这个注解不写也是可以的,但是写上好习惯.
而且可以使用 aspectj 方式来实现事务管理, 这种方式比较适合已经写好切面的情况. 默认的是 jdkDynamicProxy 方式来实

3. 通过在方法上添加 @Transactional 注解来实现事务管理


## @Transactional 的属性说明


###  TransactionManager 事务管理器
1. TransactionManager 用来控制事务的提交回滚
2. TransactionInterceptor 事务的拦截器(他其实是一个切面), 控制事务何时提交,何时回滚

如果事务正常 TransactionInterceptor 就调用 TransactionManager 提交
如果事务异常 TransactionInterceptor 就调用 TransactionManager 的回滚


### propagation 传播行为
事务方法A 和事务 方法B
此时 A 方法调用了 B方法, 那么B方法的事务,是A方法事务的子事务. 他们之间的关系就是传播行为


propagation的可选值
- REQUIRED: 如果当前没有事务,就新建一个事务.如果当前有事务,就加入这个事务(默认)
  -  a b 2个方法, a方法调用b方法, a方法有事务, b方法REQUIRED, 那么b方法就加入到a方法的事务中
  -  a b 2个方法, a方法调用b方法, a方法无事务, b方法REQUIRED, 那么b方法就新建一个事务
- SUPPORTS: 如果当前有事务,就加入这个事务,如果当前没有事务,就以非事务方式执行
- MANDATORY: 加入当前事务,当前没有事务就抛出异常
- REQUIRES_NEW: 创建一个新事务,如果当前有事务,就挂起当前事务
- NOT_SUPPORTED: 以非事务方式执行,如果当前有事务,就挂起当前事务
- NEVER: 以非事务方式执行,如果当前有事务,就抛出异常
- ASPECTJ_REQUIRES_NEW: 


 







### isolation 隔离界别

- 隔离级别
1. 读未提交: 事务可以读取到其他事务未提交的数据
2. 读已提交: 事务只能读取到其他事务已经提交的数据(默认)
3. 可重复读RR(快好读): 事务在整个执行期间,都能读取到相同的数据(mysql 默认)
4. 串行化: 最高的隔离级别,完全服从ACID的隔离级别.事务完全串行执行,最高隔离级别,最低性能

隔离级别是用来解决 脏读/不可重复读/幻读的问题的

默认 mysql是 RR,  Oracle 是 Read COMMITTED 读已提交

一般,就是在上述2个隔离级别中选择一个就行








### timeout  超时时间 秒为秒

小细节: 超时说的是 方法开始到,最后一次数据库的操作时间, 如果后面还有业务,但是没有操作数据库,那么不算在超时时间里


### readOnly 
true: 事务只读, 用来提示优化, 事务一定是读操作, 能提高效率
false: 事务可读可写 (默认)


### rollbackFor / RollbackForClassName 
因为什么异常才回滚 !!!!
rollbackFor 可以指定那些异常回滚

注意: 默认情况下, 不是所有异常都回滚!!!! 

异常分为2大类:
- 运行时异常(unchecked exception):  这种异常才回滚
- 编译时异常(受检异常):  这种异常不回滚


回滚的异常  RuntimeException + 指定的异常


### noRollbackFor
因为什么异常不回滚!!!!!

注意: 编译时异常(受检异常) 默认就不回滚


