package com.sj.Bean;

import lombok.Data;

/**
 * ClassName: User
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/14 21:50
 * @Version 1.0
 */

@Data
public class User {
    private String username;
    private int age;
    private String email;
	
	private Address address;
	
	private String[] hobbies;
}
