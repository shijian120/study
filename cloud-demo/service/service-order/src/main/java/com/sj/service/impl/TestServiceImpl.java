package com.sj.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sj.service.TestService;
import org.springframework.stereotype.Service;

/**
 * ClassName: TestServiceImpl
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/5/21 18:01
 * @Version 1.0
 */

@Service
public class TestServiceImpl implements TestService {
	
	
	@SentinelResource("service层的getUser方法")
	@Override
	public String getUser() {
		return "时间!!!!";
	}
}
