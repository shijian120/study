package com.sj.exception;

import com.sj.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: Exception01Controller
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/16 03:11
 * @Version 1.0
 */

@RestController
public class Exception01Controller {
	
	
	/*
	编程式异常处理 -- 运行时异常
	这种处理异常的方式,最不好的地方在于, 所有的方法都需要 使用 try catch 来处理
	
	 */
	
	@GetMapping("/hello")
	public R hello() {
		
		try {
			int i = 10 / 0;
			return R.success();
			
		} catch (Exception e) {
			e.printStackTrace();
			return R.error(500, "执行异常" + e.getMessage());
		}
		
	}
	
	
	@GetMapping("/hello2")
	public R hello2(@RequestParam(value = "i", defaultValue = "0") Integer i)  {
		
		int result = 10 / i;
		
		return R.success(result);
		
	}
	
	/*
	专门处理算术异常
	
	如果本类中的 Controller 出现了ArithmeticException异常
	此时就会执行handlerException方法
	 */
	@ExceptionHandler(ArithmeticException.class)
	public  R handlerException(ArithmeticException ex){
		return R.error(500, "执行异常" + ex.getCause());
	}
	

}
