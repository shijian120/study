package com.sj.aop;

import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.TypeUtils;

/*
4 个工具类
 	TypeUtils,ReflectionUtils,AnnotationUtils, ClassUtils


 */

public class TestUtils {

	
	@Test
	public void ClassUtils(){
		
		String packageName = ClassUtils.getPackageName(TestUtils.class);
		System.out.println(packageName); // com.sj.aop
		
		// 获取类的简单名称
		String className = ClassUtils.getShortName(TestUtils.class);
		System.out.println(className); // TestUtils
		
		
		// 判断指定类是否加载
		boolean isPresent = ClassUtils.isPresent("org.springframework.core.annotation.AnnotationUtils", null);
		System.out.println(isPresent); // true
		
	}
}
