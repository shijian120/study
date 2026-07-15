package com.sj;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * ClassName: TestBigDecimal
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/15 04:38
 * @Version 1.0
 */

public class TestBigDecimal {
	
	
	
	@Test
	public void test(){
		BigDecimal bigDecimal = new BigDecimal("123.45");
		
		// 打印结果是 123.45 , 说明 BigDecimal 重写了 toString 方法
		System.out.println(bigDecimal); // 123.45
		
		
	}
}
