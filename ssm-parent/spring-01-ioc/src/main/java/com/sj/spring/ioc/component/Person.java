package com.sj.spring.ioc.component;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: Person
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/10 18:41
 * @Version 1.0
 */

@ToString
@Component
public class Person {
	
	@Autowired
	private User user;
}
