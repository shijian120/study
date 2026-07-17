package com.sj.ext;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sj.bean.Emp;
import com.sj.mapper.ext.ExtMapper1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: ExtMapper01Test
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/17 18:11
 * @Version 1.0
 */

@SpringBootTest
public class ExtMapper01Test {
	
	@Autowired
	ExtMapper1 extMapper;
	
	
	@Test
	public void testCache(){
		// 默认情况, 调用几次,就会查询几次数据库, 可以使用 cache 标签完成 1级缓存
		// 注意: 开启一级缓存需要实现序列化接口
		// 此时就 只会查询一次数据库, 第二次会从缓存中获取
		Emp emp = extMapper.selectById(1);
		Emp emp1 = extMapper.selectById(1);
		
		System.out.println(emp);
		System.out.println(emp1);
	}
	
	/*
	
	2026-07-17T18:14:45.003+08:00 DEBUG 91485 --- [           main] com.sj.mapper.ext.ExtMapper1             : Cache Hit Ratio [com.sj.mapper.ext.ExtMapper1]: 0.0
2026-07-17T18:14:45.006+08:00 DEBUG 91485 --- [           main] c.sj.mapper.ext.ExtMapper1.selectById    : ==>  Preparing: select id,emp_name,age from t_emp where id = ?
2026-07-17T18:14:45.022+08:00 DEBUG 91485 --- [           main] c.sj.mapper.ext.ExtMapper1.selectById    : ==> Parameters: 1(Integer)
2026-07-17T18:14:45.035+08:00 DEBUG 91485 --- [           main] c.sj.mapper.ext.ExtMapper1.selectById    : <==      Total: 1
2026-07-17T18:14:45.039+08:00  WARN 91485 --- [           main] o.apache.ibatis.io.SerialFilterChecker   : As you are using functionality that deserializes object streams, it is recommended to define the JEP-290 serial filter. Please refer to https://docs.oracle.com/pls/topic/lookup?ctx=javase15&id=GUID-8296D8E8-2B93-4B9A-856E-0A65AF9B8C66
2026-07-17T18:14:45.040+08:00 DEBUG 91485 --- [           main] com.sj.mapper.ext.ExtMapper1             : Cache Hit Ratio [com.sj.mapper.ext.ExtMapper1]: 0.5
	 */
	
	
	/*
	MP的分页插件 底层用的是 threadlocal
	
	 */
	@Test
	public void testPage(){
		PageHelper.startPage(2,3);
		List<Emp> emps = extMapper.selectAllByPage();
		for (Emp emp : emps) {
			
			System.out.println(emp);
			
		}
		
		// 配合前端
		PageInfo<Emp> pageInfo = new PageInfo<>(emps);
		//
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getPageSize());
		System.out.println(pageInfo.getStartRow());
		System.out.println(pageInfo.getEndRow());
		System.out.println(pageInfo.getList());
		System.out.println(pageInfo.getNavigatePages());
		System.out.println(pageInfo.getNavigateFirstPage());
		
		// System.out.println(pageInfo);
	}
	
}
