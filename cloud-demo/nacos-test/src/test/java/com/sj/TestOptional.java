package com.sj;

/*

Optional 是 Java 8 推出的，专门用来 解决空指针异常（NullPointerException） 的工具类。

一、Optional 是什么？
	可以把它理解成一个盒子：
	盒子里可能有对象
	盒子里可能是空的
	你不能直接拿到里面的值，必须通过正确的方法打开盒子。
	这样就不会出现 null.xxx () 空指针！

 */

import org.junit.Test;

import java.util.Optional;

public class TestOptional {
	
	Object obj;
	
	
	
	
	
	/*
Optional 的三种创建方式
	之二: 		Optional<Object> empty = Optional.empty();

 */
	@Test
	public void test02 () {
		
		
		// 2. 创建一个 有值 的 Optional（不能传 null）
		Optional<String> hello = Optional.of("hello");
		
		
		System.out.println(hello); // Optional[hello]
		System.out.println(hello.get());  // hello
		
		
		// 3. 创建一个 可能有值、可能 null 的 Optional（最常用）
		System.out.println(Optional.ofNullable(hello));
		
	}
	/*
	Optional 的三种创建方式
		之一: 		Optional<Object> empty = Optional.empty();

	 */
	@Test
	public void test01 () {
		
		// 1. 创建一个 空 的 Optional（最常用）
		Optional<Object> empty = Optional.empty();
		
		System.out.println(empty); // Optional.empty
		
		// 不会打印 null 而是出现异常
		// Object o = empty.get();  // java.util.NoSuchElementException: No value present
		
		
		boolean empty1 = empty.isEmpty();
		
		
		System.out.println(empty1);  // empty1
		
		// 因为 empty没有存储元素
		// 所以从 empty中获取的的 对象其实应该是 null
		// null 调用 hashCode() 方法应该出现 空指针异常
		// 但是这里确实出现了 NoSuchElementException 异常
		// 相当于 他帮我们 做了 非空判断
		int i = empty.get().hashCode();  //java.util.NoSuchElementException: No value present
		
		
		
		// 3. 创建一个 可能有值、可能 null 的 Optional（最常用）
		// Optional.ofNullable(obj);
		
	}
}
