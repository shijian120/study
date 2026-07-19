package com.sj.common;

import lombok.Data;

/**
 * ClassName: R
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/28 06:49
 * @Version 1.0
 */
@Data
public class R {
	
	private Integer code;
	private String msg;
	private Object data;
	
	
	public static R ok() {
		R r = new R();
		r.setCode(200);
		r.setMsg("成功");
		
		return r;
	}
	
	public static R ok(Object data) {
		R r = new R();
		r.setCode(200);
		r.setMsg("成功");
		r.setData(data);
		return r;
	}
	
	public static R error() {
		R r = new R();
		r.setCode(500);
		r.setMsg("失败");
		return r;
	}
	
	
	public static R error(String msg){
		R r = new R();
		r.setCode(500);
		r.setMsg(msg);
		
		return r;
	}
}
