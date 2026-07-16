package com.sj.common;

import lombok.Data;

/**
 * 成功 就是操作成功, 状态吗 200
 * 但是对于失败来说, 就比较麻烦了, 因为 失败的原因有很多, 例如 余额不足, 密码错误, 参数非法, 没有权限, 数据库连接失败,
 * 因此成功的 千篇一律, 失败的 就要千变万化, 所以状态码+消息, 就可以一一致化管理
 */
@Data
public class R<T> {
	private Integer code;
	private String msg;
	private T data;
	
	// 构造函数私有化，用静态方法创建
	private R(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	private R(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	// 成功响应
	public static <T> R<T> success(T data) {
		return new R<>(200, "操作成功", data);
	}
	
	public static R<Void> success() {
		return new R<>(200, "操作成功");
	}
	
	// 失败响应（业务异常）
	public static <T> R<T>  error(Integer code, String msg) {
		return new R<>(code, msg, null);
	}
	public static <T> R<T>  error(Integer code, String msg, T data) {
		return new R<>(code, msg, data);
	}
	// getter/setter 省略（实际代码要加上）
}
