package com.sj.exception;

import lombok.Getter;

/**

 */

public enum BizExceptionEnum {
	
	USER_NOT_FOUND(10000, "用户不存在"),
	USER_NOT_FOUND_BY_ID(10001, "根据id找不到用户"),
	USER_NOT_FOUND_BY_NAME(10002, "根据姓名找不到用户"),
	USER_NOT_FOUND_BY_EMAIL(10003, "根据邮箱找不到用户"),
	USER_NOT_FOUND_BY_PHONE(10004, "根据电话找不到用户"),
	
	PRODUCT_NOT_FOUND(20000, "产品不存在"),
	PRODUCT_NOT_FOUND_BY_ID(20001, "商品id不存在"),
	PRODUCT_NOT_FOUND_BY_NAME(20002, "根据名称找不到产品"),
	PRODUCT_NOT_FOUND_BY_SKU(20003, "根据sku找不到产品");
	
	
	
	
	@Getter
	private Integer code;
	@Getter
	private String msg;
	
	
	BizExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
