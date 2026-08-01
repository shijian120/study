package com.sj.mapper;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/*
对结果的封装
 */

// 告诉spring 这个mybatis操作数据库用的接口
@Mapper
public interface EmpReturnValueMapper {


	// 返回基本类型, 直接写
	int countEmp();
	
	
	// 插入数据,返回受影响的行数
	int insertEmp(@Param("emp") Emp emp);
	
	
	// 插入数据,返回插入的id 通过配置  useGeneratedKeys="true" keyProperty="id"
	// mybatis 如果想要 返回 插入这行数据的id, 不能返回 Emp
	// 他的逻辑是, 配置了 useGeneratedKeys="true" keyProperty="id"之后, 我们插入数据中 emp对象中会被封装上id
	void insertEmpReturnId(@Param("emp") Emp emp);
	
	
	// 返回Map
	@MapKey("id")  // 说明, map中的key 是 id, value是 emp
	Map<Integer,Emp> selectMapAll();
	
}
