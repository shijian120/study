package com.sj.dao;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: EmpDao
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/16 14:30
 * @Version 1.0
 */

// 告诉spring 这个mybatis操作数据库用的接口
@Mapper
public interface EmpMapper {
	
	Emp selectById(Integer id);
	
}
