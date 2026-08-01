package com.sj.mapper;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
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

// 告诉spring 这个mybatis操作数据库用的接口
@Mapper
public interface EmpMapper {
	// 根据id查询员工
	Emp selectById(Integer id);
	// 更新员工信息
	void updateEmpById(Emp emp);

	// 添加员工信息
	void insertEmp(Emp emp);
	
	// 删除员工信息
	void deleteEmpById(Integer id);
	
	// 查询所有员工信息
	List<Emp> selectAllEmp();
}
