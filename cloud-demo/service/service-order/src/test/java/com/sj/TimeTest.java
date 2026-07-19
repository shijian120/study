package com.sj;

import org.junit.jupiter.api.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * ClassName: TimeTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/27 19:46
 * @Version 1.0
 */

public class TimeTest {
	
	
	Object object1 = void.class;
	Object object2;
	
	Object object3 = Void.class;
	Object object4;
	
	@Test
	public void test(){
		
		long millis = SECONDS.toMillis(1);
		System.out.println(millis);
	}
	
	
	@Test
	public void test01(){
		
		System.out.println(void.class); // void
		System.out.println(Void.class); // class java.lang.Void
		
		System.out.println(void.class == void.class); // true
		
		System.out.println(void.class == null);  // false
		System.out.println(Void.class == null);  // false
		System.out.println(void.class.equals("void") ); // false
		
		System.out.println(void.class == void.class); //true
		
		System.out.println(object1 == object2);  // false
		
		System.out.println(object3 == object4); // false
	}
}
