package com.sj.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sj.common.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 web默认的异常处理规则
 public class DefaultBlockExceptionHandler implements BlockExceptionHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, String resourceName, BlockException ex)
	throws Exception {
	response.setStatus(429);
	
	PrintWriter out = response.getWriter();
	out.print("Blocked by Sentinel (flow limiting)");
	out.flush();
	out.close();
	}
}
 上述这个异常就是 在页面打印 Blocked by Sentinel (flow limiting )
 
 
 */

// 这个是解决 web异常的
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void handle(HttpServletRequest request,
	                   HttpServletResponse response,
	                   String resourceName,
	                   BlockException e) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		
		
		
		R error = R.error(resourceName + "被sentinel限制了，原因是：" + e.getMessage());
		
		
		String json = objectMapper.writeValueAsString(error);
		
		PrintWriter writer = response.getWriter();
		
		writer.write(json);
		
		writer.flush();
		writer.close();
	}
}
