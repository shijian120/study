package com.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: ${NAME}
 * Package: ${Package_name}
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 19:41
 * @Version 1.0
 */



@EnableTransactionManagement
@SpringBootApplication
public class SpringTxApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringTxApp.class, args);
	}
}