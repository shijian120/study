package com.sj.exception;

import lombok.Getter;

/**
项目中的异常处理类
 */

public class BizException extends RuntimeException{
	
	// 和前端约定好返回数据的格式
	@Getter
	private Integer code;
	@Getter
	private String msg;
	
	
	public BizException(Integer code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
	
	public BizException(BizExceptionEnum bizExceptionEnum) {
		
		super(bizExceptionEnum.getMsg());
		this.code = bizExceptionEnum.getCode();
		this.msg = bizExceptionEnum.getMsg();
	}
}
