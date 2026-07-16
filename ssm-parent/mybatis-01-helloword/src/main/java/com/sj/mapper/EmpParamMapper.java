package com.sj.mapper;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
关于 @Param注解的使用


传参形式                示例                              取值方式
单个参数               getEmploy(Long id)                #{变量名}
单个参数-list类型       getEmploy(List<Long> id)          #{变量名[0]}
单个参数-对象类型       addEmp(Emp emp)                   #{对象中的属性名}
单个参数Map类型         addEmp(Map<String, Object> m)     #{map中的key}
多个参数-无@Param       getEmploy(Long id, String name)     #{变量名}
多个参数-有@Param       getEmploy(@Param("id") Long id, @Param("name") String name)      #{id} or #{name}

扩展
getEmploy(@Param("id") Long id),        #{id}
@Param("ext") Map<String, Object> m     #{ext.key}
@Param("ids") List<Long> ids,            #{ids[0]}
@Param("emp")Employ e                   #{emp.property}

即便单个参数 最好也使用 @Param注解
 */



// 参数测试
@Mapper
public interface EmpParamMapper {
	
	// 根据id查询员工
	Emp selectEmpById(@Param("id") Long id);
	
	
	Emp selectEmpByIds(@Param("ids") List<Long> ids);
	
	// 添加员工
	void insertEmp(@Param("emp") Emp emp);
	
	
	// 更新员工信息
	// public void updateEmpById(Emp emp);
	
	
	// 多个参数,通过 @Param 注解, 此时可以在 mapper xml 通过 指定的参数名, 拿到对应的值
	void aaaEmploy(
			@Param("id") Long id,
			@Param("ext") Map<String, Object> m,
			@Param("ids") List<Long> ids,
			@Param("emp")Emp e
			);
}
