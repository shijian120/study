package com.sj.mapper.ext;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
以下是测试 MP 的 扩展功能
 */

@Mapper
public interface ExtMapper1 {
	
	// 以及缓存事务级别
	// 测试 二级缓存 底层会序列化
	// 查询员工信息
	Emp selectById(Integer id);
	
	
	
	// MP的拦截器  org.apache.ibatis.plugin.Interceptor 接口
	
	// 分页插件 https://pagehelper.github.io/
	
	// 查询所有员工
	List<Emp> selectAllByPage();
	
}
