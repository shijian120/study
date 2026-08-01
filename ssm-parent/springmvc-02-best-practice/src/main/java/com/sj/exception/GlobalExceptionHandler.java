package com.sj.exception;

/*
全局异常处理类


异常处理的逻辑
1. 必须有业务异常类 BizException
2. 必须有业务异常枚举类 BizExceptionEnum
3.编写业务代码,只写正确的逻辑, 如果出现预期错误,抛出异常 中断逻辑并通知上层
4. 全局异常处理类,捕获业务异常, 并返回统一的格式

# 流程
当业务出现了异常, 我们抛出 我们定义的异常, 异常的原因,通过枚举类中定义,并传给业务异常类
抛出的异常,被全局异常处理器捕获, 获取到 枚举类中的原因 返回给前端
前端根据状态码,就知道什么原因了




 */

import com.sj.common.R;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 这个就是 全体Controller的切面
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(BizException.class)
	public R<Void> handlerException(BizException ex){
		return R.error(ex.getCode(), ex.getMsg());
	}
	
	
	@ExceptionHandler(Throwable.class)
	public R<Void> handlerException(Throwable ex){
		return R.error(500, "执行异常" + ex.getCause());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  R  method (MethodArgumentNotValidException ex){
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		
		Map<String, String> map = new HashMap<>();
		for (FieldError fieldError : fieldErrors) {
			String field = fieldError.getField();
			String defaultMessage = fieldError.getDefaultMessage();
			map.put(field, defaultMessage);
		}
		
		return R.error(400, "参数校验失败", map);
	}
}
