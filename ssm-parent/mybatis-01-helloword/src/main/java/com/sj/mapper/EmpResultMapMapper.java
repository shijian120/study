package com.sj.mapper;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
自定义结果集
 */
@Mapper
public interface EmpResultMapMapper {
	
	// 按照id查询
	Emp selectEmpById(@Param("id") Integer id);
	
}
